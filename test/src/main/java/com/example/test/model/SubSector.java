package com.example.test.model;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "sub_sector")
public class SubSector {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_sub_sector")
    private Integer idSubSector;
	
	@Column(name = "nombre_sub_sector")
    private String nombreSubSector;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "id_comuna", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Comuna comuna;
    
	public String getNombreSubSector() {
		return nombreSubSector;
	}
	public void setNombreSubSector(String nombreSubSector) {
		this.nombreSubSector = nombreSubSector;
	}
	public Integer getIdSubSector() {
		return idSubSector;
	}
	public void setIdSubSector(Integer idSubSector) {
		this.idSubSector = idSubSector;
	}
	public Comuna getComuna() {
		return comuna;
	}
	public void setComuna(Comuna comuna) {
		this.comuna = comuna;
	}

}
