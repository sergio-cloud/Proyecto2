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
	private String nickName;
	private boolean isHombre;
	private int edad;
	private String descripcion;
	private Poblacion poblacion;
	
	public Perfil() {
		super();
	}

	public String getnickName() {
		return nickName;
	}

	public void setnickName(String nickName) {
		this.nickName = nickName;
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
		return "Perfil [nickName=" + nickName + ", isHombre=" + isHombre + ", edad=" + edad + ", descripcion="
				+ descripcion + ", poblacion=" + poblacion + "]";
	}
}
