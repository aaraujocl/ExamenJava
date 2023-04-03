package com.ganaste.app.usuarios.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.ganaste.app.usuarios.entity.Cliente;

public interface IClienteRepository extends PagingAndSortingRepository<Cliente, Long>{

}
