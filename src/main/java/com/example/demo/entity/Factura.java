package com.example.demo.entity;

import java.util.Date;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
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
@Table(name = "factura")
public class Factura {
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long num_factura;
	 
	   

	    @Column(name = "date")
	    private Date  date;
	    
	    @OneToOne(targetEntity = Client.class,cascade = CascadeType.PERSIST)
	    @JoinColumn(name="id_client")
		   private Client client;
	    @JoinColumn(name="id_modepayment")
	    @OneToOne(targetEntity = mode_payment.class,cascade = CascadeType.PERSIST)
		   private mode_payment payment;
	    
}
