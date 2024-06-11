package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Client;


@Repository
public interface ClientRepository extends CrudRepository<Client, Long> {

}
