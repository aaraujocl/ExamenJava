package com.ganaste.app.usuarios.service;

import java.util.List;

import com.ganaste.app.usuarios.entity.Usuario;

public interface IUsuarioService {
	public Usuario findByLogin(String Login, String Password);
	public List<Usuario> findAll();
}
