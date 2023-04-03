package com.ganaste.app.usuarios.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ganaste.app.usuarios.entity.Usuario;
import com.ganaste.app.usuarios.repository.IUsuarioRepository;
import com.ganaste.app.usuarios.repository.IUsuarioTemplateRepository;
import com.ganaste.app.usuarios.service.IUsuarioService;

@Service
public class UsuarioService implements IUsuarioService {

	@Autowired
	private IUsuarioRepository UsuarioRepository;
	
	@Autowired
	private IUsuarioTemplateRepository UsuarioTemplateRepository;
	
	@Override
	public Usuario findByLogin(String Login, String Password) {
		// TODO Auto-generated method stub
		return UsuarioRepository.findByNombreusuarioAndPassword(Login, Password);
	}
	@Override
	public List<Usuario> findAll() {
		// TODO Auto-generated method stub
		return UsuarioTemplateRepository.findAll();
	}

}
