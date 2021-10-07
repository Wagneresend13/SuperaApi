package com.example.supera.api.Controller;

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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.supera.api.ProductModel.Product;
import com.example.supera.api.ProductRepository.ProductRepository;

@RestController
@RequestMapping("/produtos")
public class ControllerProduct {

	@Autowired
	private ProductRepository productRepository;

	// Request para buscar todos os produtos do Banco
	@GetMapping
	public List<Product> listarProdutos() {
		return productRepository.findAll();
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

}
