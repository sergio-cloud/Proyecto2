package com.example.proyecto2.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;


import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author Sergio
 * @version 02/06/2020
 *
 */

@Entity
public class Perfil implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	//Nino Revisar mañana
	@Size(min=3, max=40) 
	private String nickName;
	
	@Size(min=3, max=30)
	private String password;
	
	@NotEmpty
	private boolean isHombre;
	
	@NotEmpty
	private int edad;
	
	@NotNull 
	private String descripcion;
	
	@NotEmpty
	private Poblacion poblacion;
	
	private String foto;

	public Perfil() {
		super();
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isHombre() {
		return isHombre;
	}

	public void setHombre(boolean isHombre) {
		this.isHombre = isHombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Poblacion getPoblacion() {
		return poblacion;
	}

	public void setPoblacion(Poblacion poblacion) {
		this.poblacion = poblacion;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Perfil(String nickName, String password, boolean isHombre, int edad, String descripcion, Poblacion poblacion,
			String foto) {
		super();
		this.nickName = nickName;
		this.password = password;
		this.isHombre = isHombre;
		this.edad = edad;
		this.descripcion = descripcion;
		this.poblacion = poblacion;
		this.foto = foto;
	}

}
