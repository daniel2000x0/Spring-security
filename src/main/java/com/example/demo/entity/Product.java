package com.example.demo.entity;

import java.util.Date;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "products")
public class Product {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_product;

    @Column(name = "name")
    private String name;
    @Column(name = "stock")
    private Long stock;
    @Column(name = "precio")
    private double price;
	private String description;
	private Date createdAt;
	private String imageFileName;
	@OneToOne(targetEntity = Category.class,cascade = CascadeType.PERSIST)
	@JoinColumn(name="id_category")
	private Category category;
//@ManyToOne(targetEntity=DetalleFactura.class)
//	private DetalleFactura detalle;
}
