package com.example.proyecto2.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Contacto implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "idcontacto")
	private int id;
	
    @JoinColumn(name = "nickname1", referencedColumnName = "nickname")
	@ManyToOne(optional = false)
	private Perfil nickname1;
	
    @JoinColumn(name = "nickname2", referencedColumnName = "nickname")
    @ManyToOne
   	private Perfil nickname2;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Perfil getNickname1() {
		return nickname1;
	}

	public void setNickname1(Perfil nickname1) {
		this.nickname1 = nickname1;
	}

	public Perfil getNickname2() {
		return nickname2;
	}

	public void setNickname2(Perfil nickname2) {
		this.nickname2 = nickname2;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Contacto [id=" + id + ", nickname1=" + nickname1 + ", nickname2=" + nickname2 + "]";
	}
}
