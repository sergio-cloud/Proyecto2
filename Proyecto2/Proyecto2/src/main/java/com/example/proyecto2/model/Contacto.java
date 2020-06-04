package com.example.proyecto2.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Contacto {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	private int id;
	
	@OneToMany()
	@JoinColumn(name= "nickname")
	private String nickname1;
	
	@OneToMany()
	@JoinColumn(name= "nickname")
	private String nickname2;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNickname1() {
		return nickname1;
	}

	public void setNickname1(String nickname1) {
		this.nickname1 = nickname1;
	}

	public String getNickname2() {
		return nickname2;
	}

	public void setNickname2(String nickname2) {
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
