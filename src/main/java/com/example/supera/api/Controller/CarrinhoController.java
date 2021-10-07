package com.example.supera.api.Controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.supera.api.ProductModel.Product;
import com.example.supera.api.ProductRepository.ProductRepository;
import com.example.supera.api.Resposta.Resposta;


@RestController
@RequestMapping("/CarrinhoController")
public class CarrinhoController {

	@Autowired
	private ProductRepository productRepository;

	List<Product> carrinho = new ArrayList<>();

	@PostMapping
	ResponseEntity<Product> adicionandoProdutoCarrinho(@RequestBody Product product, HttpServletResponse response) {

		Long id = product.getId();

		if (id == null || id == 0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		} else {
			carrinho.add(product);
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(product);
		}

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
	public void listarCarrinho(){
		
		for(Product p : carrinho) {
			p.getName().toString();
		}
		
	}

}
