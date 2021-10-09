package com.example.supera.api.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.supera.api.exception.TratativaException;
import com.example.supera.api.model.Product;
import com.example.supera.api.productRepository.ProductRepository;

@Service
public class ProdutoService {
	
	@PersistenceContext
	private EntityManager em;
	
	@Autowired
	private ProductRepository productRepository;

	/*
	public List<Product> buscarTodos() throws TratativaException {
		try {
			List<Product> lstProduto = new ArrayList<Product>();
			Iterable<Product> it = productRepository.findAll();
			for (Product produto : it) {
				lstProduto.add(produto);
			}
			if (lstProduto.isEmpty()) {
				throw new TratativaException("Produto nenhum Encontrado", null);
			}
			return lstProduto;
		} catch (TratativaException e) {
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			throw new TratativaException("Produto nenhum encontrado", null);
		}

	}
	*/
	
	public List<Product> buscarTodos() throws TratativaException{
			return em.createQuery("SELECT e FROM Product e").getResultList();
	}
	
	public List<Product> OrdenarBuscaPornome() throws TratativaException{
		return em.createQuery("SELECT e FROM Product e  ORDER BY e.name").getResultList();
	}
	
	public List<Product> ordenarPorScore() throws TratativaException{
		return em.createQuery("SELECT e FROM Product e  ORDER BY e.score").getResultList();
	}
	
	public Product buscarProdutoPorId(Long id) throws TratativaException {

		try {

			Optional<Product> produto = productRepository.findById(id);
			if (produto.isPresent()) {
				return produto.get();
			} else {
				throw new TratativaException("Produto Não Encontrado", null);
			}
		} catch (TratativaException e) {
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			throw new TratativaException("Produto Erro COnsulta", null);
		}
	}

	
	public List<Product> ordenandoPorPreco() throws TratativaException {

		List<Product> produtosOrdemAlfabetica = new ArrayList<Product>();
		Iterable<Product> it = productRepository.findAll();
		for (Product produto : it) {
			produtosOrdemAlfabetica.add(produto);
		}
	
		Collections.sort(produtosOrdemAlfabetica);

		return produtosOrdemAlfabetica;
	}

}
