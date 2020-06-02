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
public class Poblacion implements Serializable{
	
	@Id
	private int idPoblacion;
	private String nombrePoblacion;
	public Poblacion() {
		super();
	}
	public int getIdPoblacion() {
		return idPoblacion;
	}
	public void setIdPoblacion(int idPoblacion) {
		this.idPoblacion = idPoblacion;
	}
	public String getNombrePoblacion() {
		return nombrePoblacion;
	}
	public void setNombrePoblacion(String nombrePoblacion) {
		this.nombrePoblacion = nombrePoblacion;
	}
	@Override
	public String toString() {
		return "Poblacion [idPoblacion=" + idPoblacion + ", nombrePoblacion=" + nombrePoblacion + "]";
	}	
}


