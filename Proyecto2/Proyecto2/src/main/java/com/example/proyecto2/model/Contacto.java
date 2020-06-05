package com.example.proyecto2.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Contacto implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	private int id;
	
	//@ManyToOne()
	@JoinColumn(name= "nickname")
	private Perfil perfil1;
	
	//@ManyToOne()
	@JoinColumn(name= "nickname")
	private Perfil perfil2;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Perfil getPerfil1() {
		return perfil1;
	}

	public void setPerfil1(Perfil perfil1) {
		this.perfil1 = perfil1;
	}

	public Perfil getPerfil2() {
		return perfil2;
	}

	public void setPerfil2(Perfil perfil2) {
		this.perfil2 = perfil2;
	}

	@Override
	public String toString() {
		return "Contacto [id=" + id + ", perfil1=" + perfil1 + ", perfil2=" + perfil2 + "]";
	}			

}
