package com.arquitectura.software.dto;

import java.util.List;


public class DevolverUsuarios {
	
	
	private List<UsuarioModel> usuarios;
	
	public List <UsuarioModel> getUsuarios(){
		return usuarios;
	}
	
	public void setUsuarios(List<UsuarioModel> usuarios) {
		this.usuarios = usuarios;
	}
	
	public List <UsuarioModel> getCorreo(){
		return usuarios;
	}
	
	public void setCorreo(List<UsuarioModel> usuarios) {
		this.usuarios = usuarios;
	}

	@Override
	public String toString() {
		return "DevolverUsuarios [usuarios=" + usuarios + "]";
	}
	
	
	
}
