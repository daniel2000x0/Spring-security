package com.example.demo.entity;
import java.util.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
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
@Table(name = "mode_payment")
public class mode_payment {
	
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long num_pago;

	 @Column(name = "name")
	    @Enumerated(EnumType.STRING)
	    private ModePayment name;
	    @Column(name = "other_details")
	    private String other_details;
	  //  @ManyToOne(targetEntity = Factura.class,fetch=FetchType.LAZY)
	  //  private List<Factura>facturas;
	 
	
	
	
	

}
