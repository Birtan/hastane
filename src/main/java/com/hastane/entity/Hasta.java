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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Hasta generated by hbm2java
 */
@Entity
@Table(name = "hasta", catalog = "hastaneadmin")
public class Hasta implements java.io.Serializable {

	private Integer hastaId;
	private Il il;
	private String adi;
	private String soyadi;
	private String tcNo;
	private int telefonNo;
	private Set<Randevu> randevus;

	public Hasta() {
		il=new Il();
		randevus = new HashSet<Randevu>(0);
	}

	public Hasta(Il il, String adi, String soyadi, String tcNo, int telefonNo) {
		this.il = il;
		this.adi = adi;
		this.soyadi = soyadi;
		this.tcNo = tcNo;
		this.telefonNo = telefonNo;
	}

	public Hasta(Il il, String adi, String soyadi, String tcNo, int telefonNo,
			Set<Randevu> randevus) {
		this.il = il;
		this.adi = adi;
		this.soyadi = soyadi;
		this.tcNo = tcNo;
		this.telefonNo = telefonNo;
		this.randevus = randevus;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "hastaId", unique = true, nullable = false)
	public Integer getHastaId() {
		return this.hastaId;
	}

	public void setHastaId(Integer hastaId) {
		this.hastaId = hastaId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "sehirId", nullable = false)
	public Il getIl() {
		return this.il;
	}

	public void setIl(Il il) {
		this.il = il;
	}

	@Column(name = "adi", nullable = false, length = 50)
	public String getAdi() {
		return this.adi;
	}

	public void setAdi(String adi) {
		this.adi = adi;
	}

	@Column(name = "soyadi", nullable = false, length = 50)
	public String getSoyadi() {
		return this.soyadi;
	}

	public void setSoyadi(String soyadi) {
		this.soyadi = soyadi;
	}

	@Column(name = "tcNo", nullable = false, length = 11)
	public String getTcNo() {
		return this.tcNo;
	}

	public void setTcNo(String tcNo) {
		this.tcNo = tcNo;
	}

	@Column(name = "telefonNo", nullable = false)
	public int getTelefonNo() {
		return this.telefonNo;
	}

	public void setTelefonNo(int telefonNo) {
		this.telefonNo = telefonNo;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "hasta")
	public Set<Randevu> getRandevus() {
		return this.randevus;
	}

	public void setRandevus(Set<Randevu> randevus) {
		this.randevus = randevus;
	}

}