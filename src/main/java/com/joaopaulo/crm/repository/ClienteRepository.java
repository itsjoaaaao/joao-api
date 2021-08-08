package com.joaopaulo.crm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.joaopaulo.crm.model.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long>{
	

}
