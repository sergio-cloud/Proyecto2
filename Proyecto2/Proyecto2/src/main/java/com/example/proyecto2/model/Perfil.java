package com.example.proyecto2.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
//import javax.validation.constraints.NotEmpty;
//import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author Sergio
 * @version 02/06/2020
 *
 */

@Entity
public class Perfil implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "nickname")
	@Size(min = 3, max = 40)
	private String nickName;

	@Size(min = 3, max = 30)
	private String password;
	
	private String genero;
	private int edad;

	private String descripcion;
	@ManyToOne()
	@JoinColumn(name = "idpoblacion")
	private Poblacion poblacion;
	private String foto;
	
	
	@OneToMany(mappedBy = "nickname1")
	private List<Contacto> listaContacto1;
	
	@OneToMany(mappedBy = "nickname2")
	private List<Contacto> listaContacto2;

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

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
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

	public Perfil(String nickName, String password, String genero, int edad, String descripcion, Poblacion poblacion,
			String foto) {
		super();
		this.nickName = nickName;
		this.password = password;
		this.genero = genero;
		this.edad = edad;
		this.descripcion = descripcion;
		this.poblacion = poblacion;
		this.foto = foto;
	}

	@Override
	public String toString() {
		return "Perfil [nickName=" + nickName + ", password=" + password + ", genero=" + genero + ", edad=" + edad
				+ ", descripcion=" + descripcion + ", poblacion=" + poblacion + ", foto=" + foto + "]";
	}
}
