package com.arquitectura.software.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import com.arquitectura.software.entity.UsuariosEntity;

public interface UsuarioRepository extends CrudRepository<UsuariosEntity, Long>{
	@Override
	public List<UsuariosEntity> findAll();
	
	public UsuariosEntity findByNombre(String nombre);
	
	public UsuariosEntity findByid(long id);
	
		
	//@Query("SELECT * FROM  UsuariosEntity where telefono =: telefono")
	//public void findByTelefono(@Param("telefono") String telefono);
}
 