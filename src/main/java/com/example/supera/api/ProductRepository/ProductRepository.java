package com.example.supera.api.ProductRepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.supera.api.ProductModel.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

}
