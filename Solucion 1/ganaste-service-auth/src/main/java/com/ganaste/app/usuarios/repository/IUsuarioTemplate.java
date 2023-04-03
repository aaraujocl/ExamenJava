package com.ganaste.app.usuarios.repository;

import java.util.List;

import com.ganaste.app.usuarios.entity.Usuario;

public interface IUsuarioTemplate {
	public List<Usuario> findAll();
}
