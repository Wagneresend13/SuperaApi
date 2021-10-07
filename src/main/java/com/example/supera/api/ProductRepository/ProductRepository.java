package com.example.supera.api.ProductRepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.supera.api.ProductModel.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

	
	
	
//	public List<Product> buscarTodosOsProdutos();
	
}
