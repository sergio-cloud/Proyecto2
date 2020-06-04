package com.example.proyecto2.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * @author Sergio
 * @version 02/06/2020
 *
 */

@Entity
public class Poblacion implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "idpoblacion")
	private int idPoblacion;
	@Column(name = "nombre")
	private String nombrePoblacion;
	@OneToMany(mappedBy = "poblacion")
	private List<Perfil> ListaPerfil2;

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
