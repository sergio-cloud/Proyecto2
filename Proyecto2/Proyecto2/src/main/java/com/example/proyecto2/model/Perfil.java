package com.example.proyecto2.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author Sergio
 * @version 02/06/2020
 *
 */

@Entity
public class Perfil implements Serializable{
	
	@Id
	private String nickNae;
	private boolean isHombre;
	private int edad;
	private String descripcion;
	private Poblacion poblacion;
	
	public Perfil() {
		super();
	}

	public String getNickNae() {
		return nickNae;
	}

	public void setNickNae(String nickNae) {
		this.nickNae = nickNae;
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

	@Override
	public String toString() {
		return "Perfil [nickNae=" + nickNae + ", isHombre=" + isHombre + ", edad=" + edad + ", descripcion="
				+ descripcion + ", poblacion=" + poblacion + "]";
	}
}
