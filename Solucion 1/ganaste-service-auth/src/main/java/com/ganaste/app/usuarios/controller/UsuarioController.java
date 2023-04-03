package com.ganaste.app.usuarios.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ganaste.app.usuarios.entity.Usuario;
import com.ganaste.app.usuarios.model.Login;
import com.ganaste.app.usuarios.repository.IUsuarioTemplate;
import com.ganaste.app.usuarios.service.IUsuarioService;


@RestController
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE })
public class UsuarioController {

	@Autowired
	private IUsuarioService Usuarioservice;	
	
	@PostMapping("auth")
	public ResponseEntity<?> Login(@RequestBody final Login login){
		
		Usuario user = Usuarioservice.findByLogin(login.getUser(), login.getPassword());	
		if(user != null) 
			
			return new ResponseEntity<>(user, HttpStatus.OK);
			
		else 
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
	}
	
	@GetMapping("api/usuarios")
	public ResponseEntity<?> ListarUsuarios() {
		List<Usuario> LstUsuarios = Usuarioservice.findAll();
		if (LstUsuarios != null) {		
			return new ResponseEntity<>(LstUsuarios, HttpStatus.OK);			
		} 
		else 
			return new ResponseEntity<>(new ArrayList<Usuario>(), HttpStatus.OK);
	}

}
