package com.example.supera.api.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.supera.api.Exception.TratativaException;
import com.example.supera.api.ProductModel.Product;
import com.example.supera.api.ProductRepository.ProductRepository;

@Service
public class ProdutoService {

	@Autowired
	private ProductRepository productRepository;

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
}
