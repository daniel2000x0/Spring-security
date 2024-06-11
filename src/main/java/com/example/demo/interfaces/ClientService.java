package com.example.demo.interfaces;

import java.util.List;

import com.example.demo.entity.Client;
import com.example.demo.entity.Product;

public interface ClientService {
	public Client save(Client clients);
	public List<Client> findAll();
	public Client update(Client clients);
	public Client findById(Long id);
}
