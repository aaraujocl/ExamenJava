package com.ganaste.app.usuarios.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ganaste.app.usuarios.entity.Usuario;

@Repository
public class IUsuarioTemplateRepository implements  IUsuarioTemplate {

	 @Autowired
	 private JdbcTemplate jdbcTemplate;
	 
	@Override
	public List<Usuario> findAll() {
		// TODO Auto-generated method stub
		return jdbcTemplate.query(
	            "SELECT * FROM usuario",
	            BeanPropertyRowMapper.newInstance(Usuario.class)
	    );
	}

}
