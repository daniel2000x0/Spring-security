package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Factura;
@Repository
public interface FacturaRepository extends CrudRepository<Factura,Long> {

}
