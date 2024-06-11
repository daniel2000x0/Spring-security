package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Product;
import com.example.demo.interfaces.productService;
import com.example.demo.repository.ProductRepository;
@Service
public class ProductServiceImpl implements productService {
	@Autowired
	private ProductRepository productdao;
	@Override
	public Product save(Product products) {
		// TODO Auto-generated method stub
		return productdao.save(products);
	}

	@Override
	public List<Product> findAll() {
		// TODO Auto-generated method stub
          return  (List<Product>) productdao.findAll();
	}

	@Override
	public Product update(Product produts) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Product findById(Long id) {
		// TODO Auto-generated method stub
		return productdao.findById(id).get();
	}

}
