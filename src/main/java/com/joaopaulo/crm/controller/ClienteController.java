package com.joaopaulo.crm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.joaopaulo.crm.model.Cliente;
import com.joaopaulo.crm.repository.ClienteRepository;


@RestController
@RequestMapping("/clientes")
public class ClienteController {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@GetMapping
	public List<Cliente> listar() {
		return clienteRepository.findAll();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Cliente adicionar(@RequestBody Cliente cliente) {
		return clienteRepository.save(cliente);
	}
	
	@DeleteMapping("/{id}")
	public void deletar(@PathVariable Long id) {
		this.clienteRepository.deleteById(id);
	}
	
	@GetMapping("/{id}")
	public Cliente procurarPor(@PathVariable Long id) {
		return this.clienteRepository.findById(id).get();
	}
	
	@PutMapping("/{id}")
	public Cliente atualizar(@PathVariable Long id, @RequestBody Cliente cliente) {
		cliente.setId(id);
		return this.clienteRepository.save(cliente);
	}
	
	
	
}