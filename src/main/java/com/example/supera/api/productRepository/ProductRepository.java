package com.example.supera.api.productRepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.supera.api.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{


	
	
	
}
