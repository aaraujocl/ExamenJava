package com.ganaste.app.usuarios.service.implementation;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ganaste.app.usuarios.entity.Cliente;
import com.ganaste.app.usuarios.repository.IClienteRepository;
import com.ganaste.app.usuarios.service.IClienteService;

@Service
public class ClienteService implements IClienteService {

	@Autowired
	private IClienteRepository ClienteRepository;
	
	@Override
	@Transactional
	public void trasnferencia(Long cliente1, Long cliente2, Double importe) {
		// TODO Auto-generated method stub
		Cliente Cliente1 = ClienteRepository.findById(cliente1).orElse(null);
		Double importetotal1 = Cliente1.getImporte() - importe;
		Cliente1.setImporte(importetotal1);		
		ClienteRepository.save(Cliente1);
		
		Cliente Cliente2 = ClienteRepository.findById(cliente2).orElse(null);
		Cliente2.setId(cliente2);
		Double importetotal2 = Cliente2.getImporte() + importe;
		Cliente2.setImporte(importetotal2);		
		ClienteRepository.save(Cliente2);	
		

	}

}
