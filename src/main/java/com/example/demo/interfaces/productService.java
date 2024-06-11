package com.example.demo.interfaces;

import java.util.List;

import com.example.demo.entity.Product;



public interface productService {
	public Product save(Product products);
	public List<Product> findAll();
	public Product update(Product produts);
	public Product findById(Long id);

}
