package com.ganaste.app.usuarios.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ganaste.app.usuarios.entity.Usuario;
import com.ganaste.app.usuarios.model.ClienteMovimiento;
import com.ganaste.app.usuarios.model.Login;
import com.ganaste.app.usuarios.service.IClienteService;

@RestController
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE })

public class ClienteTransaccionController {

	@Autowired
	private IClienteService Clienteservice;	
	
	@PostMapping("transaccion")
	public ResponseEntity<?> Transaccion(@RequestBody final ClienteMovimiento cliente){
		
		try {
			Clienteservice.trasnferencia(cliente.getCliente1(), cliente.getCliente2(),cliente.getImporte());	
			return new ResponseEntity<>(HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
			
	
		
	}
}
