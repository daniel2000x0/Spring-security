package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Factura;
import com.example.demo.interfaces.FacturaClientService;
import com.example.demo.repository.FacturaRepository;

@Service
public class FacturaServiceImpl implements FacturaClientService {
	@Autowired
	private FacturaRepository factura;

	@Override
	public Factura save(Factura facturas) {
		// TODO Auto-generated method stub
		return factura.save(facturas);
	}

	@Override
	public List<Factura> findAll() {
		// TODO Auto-generated method stub
		return (List<Factura>) factura.findAll();
	}

	@Override
	public Factura update(Factura facturas) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Factura findById(Long id) {
		// TODO Auto-generated method stub
		return factura.findById(id).get();
	}

}
