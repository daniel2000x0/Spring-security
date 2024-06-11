package com.example.demo.entity;

import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.*;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Detallefactura")

public class DetalleFactura {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long num_detalle;

	    @Column(name = "cantidad")
	    private Integer cantidad;
	    
	    @Column(name="precio")
	    private double  precio;
	    
	    @OneToOne(targetEntity = Factura.class,cascade = CascadeType.PERSIST)
	    @JoinColumn(name="id_factura")
	    private Factura factura;
	    @OneToMany(targetEntity=Product.class,fetch= FetchType.LAZY)
	    @JoinColumn(name="products")
	    private List<Product> products;
	    
	    
}


