package com.arquitectura.software.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity(name= "rol")
public class RolEntity implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(
					strategy = GenerationType.AUTO, 
					generator = "rol_seq_generator")
	@SequenceGenerator(
					name ="rol_seq_generator",
					sequenceName = "rol_id_seq", 
					allocationSize = 1)
	private long id;
	@Column(name= "nombre")
	private String nombre;
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
    @OneToMany(
            cascade = CascadeType.ALL,
            mappedBy = "rolId",
            fetch = FetchType.LAZY)
    private List<UsuariosEntity> userList;


	public List<UsuariosEntity> getUserList() {
		return userList;
	}
	public void setUserList(List<UsuariosEntity> userList) {
		this.userList = userList;
	}
	@Override
	public String toString() {
		return "RolEntity [id=" + id + ", nombre=" + nombre + "]";
	}
	
}
