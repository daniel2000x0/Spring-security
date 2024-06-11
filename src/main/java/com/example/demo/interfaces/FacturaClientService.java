package com.example.demo.interfaces;

import java.util.List;

import com.example.demo.entity.Factura;
import com.example.demo.entity.Product;

public interface FacturaClientService {
	public Factura save(Factura facturas);
	public List<Factura> findAll();
	public Factura update(Factura facturas);
	public Factura findById(Long id);
}
