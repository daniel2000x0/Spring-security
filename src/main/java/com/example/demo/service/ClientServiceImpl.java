package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Client;
import com.example.demo.entity.Product;
import com.example.demo.interfaces.ClientService;
import com.example.demo.repository.ClientRepository;

@Service
public class ClientServiceImpl implements ClientService{
	@Autowired
	private ClientRepository cliente;
	@Override
	public Client save(Client clients) {
		// TODO Auto-generated method stub
		return cliente.save(clients);
	}

	@Override
	public List<Client> findAll() {
		// TODO Auto-generated method stub
		return  (List<Client>)  cliente.findAll();
	}

	@Override
	public Client update(Client clients) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Client findById(Long id) {
		// TODO Auto-generated method stub
		return cliente.findById(id).get();
	}

}
