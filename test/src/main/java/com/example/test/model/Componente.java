package com.example.test.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "componente")
public class Componente {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_componente")
    private Long idComponente;
	
	@Column(name = "id_asoc_comuna", nullable = false)
	private Integer idAsocComuna;
	
	@Column(name = "descripcion", nullable = false)
	private String descripcion;
	
	@Column(name = "valor", nullable = false)
	private Double valor;	
	

	public Integer getIdAsocComuna() {
		return idAsocComuna;
	}

	public void setIdAsocComuna(Integer idAsocComuna) {
		this.idAsocComuna = idAsocComuna;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


}
