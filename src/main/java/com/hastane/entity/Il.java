package com.hastane.entity;

// Generated May 21, 2014 12:11:11 PM by Hibernate Tools 4.0.0

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Il generated by hbm2java
 */
@Entity
@Table(name = "il", catalog = "hastaneadmin")
public class Il implements java.io.Serializable {

	private Integer sehirId;
	private String adi;
	private Set<Ilce> ilces = new HashSet<Ilce>(0);
	private Set<Hasta> hastas = new HashSet<Hasta>(0);

	public Il() {
	}

	public Il(String adi) {
		this.adi = adi;
	}

	public Il(String adi, Set<Ilce> ilces, Set<Hasta> hastas) {
		this.adi = adi;
		this.ilces = ilces;
		this.hastas = hastas;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "sehirId", unique = true, nullable = false)
	public Integer getSehirId() {
		return this.sehirId;
	}

	public void setSehirId(Integer sehirId) {
		this.sehirId = sehirId;
	}

	@Column(name = "adi", nullable = false, length = 20)
	public String getAdi() {
		return this.adi;
	}

	public void setAdi(String adi) {
		this.adi = adi;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "il")
	public Set<Ilce> getIlces() {
		return this.ilces;
	}

	public void setIlces(Set<Ilce> ilces) {
		this.ilces = ilces;
	}
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "il")
	public Set<Hasta> getHastas() {
		return this.hastas;
	}

	public void setHastas(Set<Hasta> hastas) {
		this.hastas = hastas;
	}
}
