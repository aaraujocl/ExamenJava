package com.ganaste.app.usuarios.repository;


import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import com.ganaste.app.usuarios.entity.Usuario;

@Repository
public interface IUsuarioRepository extends PagingAndSortingRepository<Usuario, Long> {

	Usuario findByNombreusuarioAndPassword(String nombreusuario, String password);	
	
}
