package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.DetalleFactura;
import com.example.demo.interfaces.DetalleFacturaService;
import com.example.demo.repository.DetalleFacturaRepository;

@Service
public class DetalleFacturaServiceImpl implements DetalleFacturaService{
   @Autowired
   private DetalleFacturaRepository detalle;
	@Override
	public DetalleFactura save(DetalleFactura detallefacturas) {
		// TODO Auto-generated method stub
		return detalle.save(detallefacturas);
	}

	@Override
	public List<DetalleFactura> findAll() {
		// TODO Auto-generated method stub
		return (List<DetalleFactura>) detalle.findAll();
	}

	@Override
	public DetalleFactura update(DetalleFactura detallefacturas) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DetalleFactura findById(Long id) {
		// TODO Auto-generated method stub
		return detalle.findById(id).get();
	}

}
