package com.arquitectura.software.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity(name = "usuario")
public class UsuariosEntity implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "usuario_seq_generator")
	@SequenceGenerator(name = "usuario_seq_generator", sequenceName = "usuario_id_seq", allocationSize = 1)
	private long id;
	@Column(name = "nombre")
	private String nombre;
	@Column(name = "apellido")
	private String apellido;
	@Column(name = "correo")
	private String correo;
	@Column(name = "correo2")
	private String correo2;
	@Column(name = "cedula")
	private String cedula;
	@Column(name = "rol")
	private String rol;
	@Column(name = "contraseña")
	private String contraseña;
	@Column(name = "genero")
	private String genero;
	@Column(name = "fecha_nacimiento")
	private String fecha_nacimiento;
	@JoinColumn(name = "rol_id", referencedColumnName = "id")
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private RolEntity rolId;

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

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getCorreo2() {
		return correo2;
	}

	public void setCorreo2(String correo2) {
		this.correo2 = correo2;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getFecha_nacimiento() {
		return fecha_nacimiento;
	}

	public void setFecha_nacimiento(String fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
	}

	public RolEntity getRolId() {
		return rolId;
	}

	public void setRolId(RolEntity rolId) {
		this.rolId = rolId;
	}

	@Override
	public String toString() {
		return "UsuariosEntity [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", correo=" + correo
				+ ", correo2=" + correo2 + ", cedula=" + cedula + ", rol=" + rol + ", contraseña=" + contraseña
				+ ", genero=" + genero + ", fecha_nacimiento=" + fecha_nacimiento + ", rolId=" + rolId + "]";
	}

}
