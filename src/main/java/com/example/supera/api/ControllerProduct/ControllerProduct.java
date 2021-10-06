package com.example.supera.api.ControllerProduct;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.supera.api.ProductModel.Product;
import com.example.supera.api.ProductRepository.ProductRepository;


@RestController
@RequestMapping("/produtos")
public class ControllerProduct {

	
	
	@Autowired
	ProductRepository productRepository;

	// Request para buscar todos os produtos do Banco
	@GetMapping
	public List<Product> listarProdutos() {
		return productRepository.findAll();
	}

	// Request para buscar os produtos por ID
	@GetMapping(path = { "/{id}" })
	ResponseEntity<Product> buscarProdutoPeloId(@PathVariable Long id) {

		return productRepository.findById(id).map(record -> ResponseEntity.ok().body(record))
				.orElse(ResponseEntity.notFound().build());
	}
}
