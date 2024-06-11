package com.example.demo.interfaces;

import java.util.List;

import com.example.demo.entity.DetalleFactura;
import com.example.demo.entity.Product;

public interface DetalleFacturaService {
	public DetalleFactura save(DetalleFactura detallefacturas);
	public List<DetalleFactura> findAll();
	public DetalleFactura update(DetalleFactura  detallefacturas);
	public DetalleFactura findById(Long id);
}
