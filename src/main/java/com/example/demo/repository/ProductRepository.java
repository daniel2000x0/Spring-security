package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Product;
import com.example.demo.entity.RoleEntity;
@Repository
public interface ProductRepository extends CrudRepository<Product, Long>  {
//Optional<Product> finProductByProductname(String username);

}
