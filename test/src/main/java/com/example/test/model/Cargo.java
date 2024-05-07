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
@Table(name = "cargo")
public class Cargo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_cargo")
    private Long idCargo;
	
	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "id_opcion_tarifaria", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
    private OpcionTarifaria opcionTarifaria;
	
	@Column(name = "descripcion_corta")
    private String descripcionCorta;
	
	@Column(name = "descripcion_larga")
    private String descripcionLarga;
		
	@Column(name = "formula")
    private String formula;
    
    
	public Long getIdCargo() {
		return idCargo;
	}
	public void setIdCargo(Long idCargo) {
		this.idCargo = idCargo;
	}

	public String getDescripcionLarga() {
		return descripcionLarga;
	}
	public void setDescripcionLarga(String descripcionLarga) {
		this.descripcionLarga = descripcionLarga;
	}
	public String getDescripcionCorta() {
		return descripcionCorta;
	}
	public void setDescripcionCorta(String descripcionCorta) {
		this.descripcionCorta = descripcionCorta;
	}
	public String getFormula() {
		return formula;
	}
	public void setFormula(String formula) {
		this.formula = formula;
	}
	public OpcionTarifaria getOpcionTarifaria() {
		return opcionTarifaria;
	}
	public void setOpcionTarifaria(OpcionTarifaria opcionTarifaria) {
		this.opcionTarifaria = opcionTarifaria;
	}

}
