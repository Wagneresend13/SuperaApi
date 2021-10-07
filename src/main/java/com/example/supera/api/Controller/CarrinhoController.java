package com.example.supera.api.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.supera.api.Constantes.Constantes;
import com.example.supera.api.Exception.TratativaException;
import com.example.supera.api.ProductModel.Product;
import com.example.supera.api.ProductRepository.ProductRepository;
import com.example.supera.api.Resposta.Resposta;
import com.example.supera.api.Service.ProdutoService;

@RestController
@RequestMapping("/CarrinhoController")
public class CarrinhoController {

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private ProdutoService produtoService;

	List<Product> carrinho = new ArrayList<>();

	@PostMapping
	public @ResponseBody Resposta adicionarProduto(@RequestBody Product product) {

		Resposta resposta = new Resposta();

		try {
			
			Long id = product.getId();

			if (id == null || id == 0) {
				resposta.setCodigo(Constantes.Status.CÓDIGO_ERRO);
				resposta.setMensagem("Obrigatório informar o ID do produto");
			} else {

				Product produtoAdicionado = null;
				for (Product p : carrinho) {
					if (p.getId() == id) {
						produtoAdicionado = p;
						break;
					}
				}

				if (produtoAdicionado == null) {

					Product produtoSalvo = produtoService.buscarProdutoPorId(id);

					carrinho.add(produtoSalvo);
					resposta.setResposta(carrinho);
					resposta.setCodigo(Constantes.Status.CÓDIGO_SUCESSO);
					resposta.setMensagem("Adicionado Produto no Carrinho");
				} else {
					resposta.setCodigo(Constantes.Status.CÓDIGO_ERRO);
					resposta.setMensagem("Carrinho erro produto já adicionado");
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
			resposta.setCodigo(Constantes.Status.CÓDIGO_ERRO);
		}

		return resposta;
	}

	@RequestMapping("/{id}")
	public Resposta removerProdutoCarrinho(@PathVariable Long id) {
		Resposta resposta = new Resposta();
		Product produtoSelecionado = null;

		for (Product p : carrinho) {
			if (p.getId() == id) {
				produtoSelecionado = p;
				break;
			}
		}

		if (produtoSelecionado != null) {
			carrinho.remove(produtoSelecionado);
		}

		return resposta;
	}

	@GetMapping
	public @ResponseBody Resposta consultaTodos() {

		Resposta resposta = new Resposta();

		if (carrinho.isEmpty()) {
			resposta.setCodigo(Constantes.Status.CÓDIGO_ERRO);
			resposta.setMensagem("Carrinho Vazio");
		} else {
			resposta.setCodigo(Constantes.Status.CÓDIGO_SUCESSO);
			resposta.setResposta(carrinho);
			for (Product p : carrinho) {
				p.toString();
			}
		}

		return resposta;
	}
	
	@GetMapping("/{limparCarrinho}")
	public @ResponseBody Resposta limparCarrinho() {
	
		Resposta resposta = new Resposta();
		carrinho.clear();
		
		return resposta;
	}


}
