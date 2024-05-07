package com.example.test.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name ="opcion_tarifaria")
public class OpcionTarifaria {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_opcion_tarifaria")
    private Long idOpcionTarifaria;
	
	@Column(name = "nombre_opcion_tarifaria", nullable = false)
    private String nombreOpcionTarifaria;
    
	public String getNombreOpcionTarifaria() {
		return nombreOpcionTarifaria;
	}
	public void setNombreOpcionTarifaria(String nombreOpcionTarifaria) {
		this.nombreOpcionTarifaria = nombreOpcionTarifaria;
	}
	public Long getIdOpcionTarifaria() {
		return idOpcionTarifaria;
	}
	public void setIdOpcionTarifaria(Long idOpcionTarifaria) {
		this.idOpcionTarifaria = idOpcionTarifaria;
	}
}
