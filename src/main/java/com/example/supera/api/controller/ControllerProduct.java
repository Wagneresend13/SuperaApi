package com.example.supera.api.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.supera.api.constants.Constantes;
import com.example.supera.api.exception.TratativaException;
import com.example.supera.api.model.Product;
import com.example.supera.api.productRepository.ProductRepository;
import com.example.supera.api.resposta.Resposta;
import com.example.supera.api.service.ProdutoService;

@RestController
@RequestMapping("/produtos")
public class ControllerProduct {

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private ProdutoService produtoService;

	// Request para buscar todos os produtos do Banco
	@GetMapping
	public @ResponseBody Resposta consultarTodos() {
		Resposta resposta = new Resposta();
		try {
			resposta.setCodigo(Constantes.Status.CÓDIGO_SUCESSO);
			resposta.setResposta(produtoService.buscarTodos());
		} catch (TratativaException e) {
			resposta.setCodigo(Constantes.Status.CÓDIGO_ERRO);
			resposta.setMensagem(e.getMensagem());
		}
		return resposta;
	}

	// Request para buscar os produtos por ID
	@GetMapping("/{id}")
	ResponseEntity<Product> buscarProdutoPeloId(@PathVariable Long id) {

		return productRepository.findById(id).map(record -> ResponseEntity.ok().body(record))
				.orElse(ResponseEntity.notFound().build());
	}

	@PostMapping
	public ResponseEntity<Product> cadastrandoProduto(@RequestBody Product product, HttpServletResponse response) {
		Product productSave = productRepository.save(product);

		return ResponseEntity.status(HttpStatus.CREATED).body(product);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void removerProduto(@PathVariable Long id) {
		productRepository.deleteById(id);
	}
	
	@GetMapping("/ordemPrice/{OrdemPrice}")
	public @ResponseBody Resposta ordemporPreco() {
		Resposta resposta = new Resposta();
		try {
			resposta.setCodigo(Constantes.Status.CÓDIGO_SUCESSO);
			resposta.setResposta(produtoService.ordenandoPorPreco());
		} catch (TratativaException e) {
			resposta.setCodigo(Constantes.Status.CÓDIGO_ERRO);
			resposta.setMensagem(e.getMensagem());
		}
		return resposta;
	}
	
	@GetMapping("/ordemAlfabetica/{ordemAlfabetica}")
	public @ResponseBody Resposta ordenarBuscaPornome() {
		Resposta resposta = new Resposta();
		try {
			resposta.setCodigo(Constantes.Status.CÓDIGO_SUCESSO);
			resposta.setResposta(produtoService.OrdenarBuscaPornome());
		} catch (TratativaException e) {
			resposta.setCodigo(Constantes.Status.CÓDIGO_ERRO);
			resposta.setMensagem(e.getMensagem());
		}
		return resposta;
	}
	
	@GetMapping("/ordemScore/{ordemScore}")
	public @ResponseBody Resposta ordenarPorScore() {
		Resposta resposta = new Resposta();
		try {
			resposta.setCodigo(Constantes.Status.CÓDIGO_SUCESSO);
			resposta.setResposta(produtoService.ordenarPorScore());
		} catch (TratativaException e) {
			resposta.setCodigo(Constantes.Status.CÓDIGO_ERRO);
			resposta.setMensagem(e.getMensagem());
		}
		return resposta;
	}

}
