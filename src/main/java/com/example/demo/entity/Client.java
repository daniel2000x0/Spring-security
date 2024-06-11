package com.example.demo.entity;

import java.util.Date;
import java.util.List;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.*;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "client")
public class Client {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id_client;

	    @Column(name = "name")
	    private String name;
	    @Column(name = "lastname")
	    private String lastname;
	    @Column(name = "address")
	    private String address;
	    @Column(name = "birth date")
        private Date birthdate;
	    
	    @Column(name = "phone")
	    private Long phone;
	    
	    @Column(name = "email")
	    private String email;
	
	    @Column(name = "client_No_Locked")
	    private boolean clientNoLocked;
	    
	    //@OneToMany(targetEntity=Factura.class,fetch=FetchType.LAZY)
	   //private  List<Factura> facturas;
       @OneToOne(targetEntity=UserEntity.class,fetch=FetchType.LAZY)
        private UserEntity user_id;
} 
