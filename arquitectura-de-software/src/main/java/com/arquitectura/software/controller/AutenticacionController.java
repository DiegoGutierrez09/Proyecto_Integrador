package com.arquitectura.software.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.arquitectura.software.dto.ActualizarUsuario;
import com.arquitectura.software.dto.DevolverUsuarios;
import com.arquitectura.software.dto.UsuarioModel;
import com.arquitectura.software.dto.UsuarioResponse;
import com.arquitectura.software.entity.UsuariosEntity;
import com.arquitectura.software.repository.UsuarioRepository;

@RestController
public class AutenticacionController {
	@Autowired	
	private UsuarioRepository usuarioRepository;
	
    private static final Logger LOGGER = LoggerFactory.getLogger(AutenticacionController.class);

	
	@RequestMapping(path = "registrar", method = RequestMethod.POST)
	
	public ResponseEntity<Void> crear(@RequestBody UsuarioResponse usuarioNuevo) {
		
		UsuariosEntity minuevoUsuario = new UsuariosEntity();
		
		minuevoUsuario.setApellido(usuarioNuevo.getApellido());
		minuevoUsuario.setNombre(usuarioNuevo.getNombre());
		minuevoUsuario.setCorreo(usuarioNuevo.getCorreo());
		minuevoUsuario.setCorreo2(usuarioNuevo.getCorreo2());
		minuevoUsuario.setCedula(usuarioNuevo.getCedula());
		minuevoUsuario.setRol(usuarioNuevo.getRol());
		minuevoUsuario.setContraseña(usuarioNuevo.getContraseña());
		minuevoUsuario.setGenero(usuarioNuevo.getGenero());
		minuevoUsuario.setFecha_nacimiento(usuarioNuevo.getFecha_nacimiento());
		usuarioRepository.save(minuevoUsuario);
		
		return ResponseEntity.ok().body(null);
	}
	
	@RequestMapping(path = "mostrar", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<DevolverUsuarios> listar() {
		
		DevolverUsuarios capturarUsuarios = new DevolverUsuarios();
		
		List<UsuarioModel> listaDeUsuarios = new ArrayList<>();
		
		for(UsuariosEntity data: usuarioRepository.findAll()) {
			
			UsuarioModel usuario = new UsuarioModel();
			usuario.setApellido(data.getApellido());
			usuario.setCedula(data.getCedula());
			usuario.setId(data.getId());
			usuario.setCorreo(data.getCorreo());
			listaDeUsuarios.add(usuario);
		}
	
		capturarUsuarios.setCorreo(listaDeUsuarios);
		
		return ResponseEntity.ok().body(capturarUsuarios);
		
		
	}
	
	@RequestMapping(path = "eliminar/{nombre}", method = RequestMethod.GET)
	
	public ResponseEntity<Void> crear(@PathVariable String nombre) {
				
		UsuariosEntity usuarioEncontrado = usuarioRepository.findByNombre(nombre);
		usuarioRepository.delete(usuarioEncontrado);
		return ResponseEntity.ok().body(null);
	}
	
	@RequestMapping(path = "actualizar", method = RequestMethod.GET)
	
	public ResponseEntity<Void> crear(@RequestBody ActualizarUsuario nombreUsuario) {
				
		UsuariosEntity usuarioEncontrado = usuarioRepository.findByid(nombreUsuario.getId());
		usuarioEncontrado.setNombre(nombreUsuario.getNombre());
		usuarioEncontrado.setApellido(nombreUsuario.getApellido());
		usuarioEncontrado.setCorreo(nombreUsuario.getCorreo());
		usuarioEncontrado.setCorreo2(nombreUsuario.getCorreo2());
		usuarioEncontrado.setCedula(nombreUsuario.getCedula());
		usuarioEncontrado.setRol(nombreUsuario.getRol());
		usuarioEncontrado.setContraseña(nombreUsuario.getContraseña());
		usuarioEncontrado.setGenero(nombreUsuario.getGenero());
		usuarioEncontrado.setFecha_nacimiento(nombreUsuario.getFecha_nacimiento());
		usuarioRepository.save(usuarioEncontrado);
		return ResponseEntity.ok().body(null);
	}
	
}
