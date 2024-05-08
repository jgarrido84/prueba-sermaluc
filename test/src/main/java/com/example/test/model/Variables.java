package com.example.test.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "variables")
public class Variables {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_variables")
    private Long idVariables;
	
	@Column(name = "id_asoc_comuna", nullable = false)
	private Integer idAsocComuna;
	
	@Column(name = "componente", nullable = false)
	private String componente;
	
	@Column(name = "valor", nullable = false)
	private Double valor;	
	
	public Integer getIdAsocComuna() {
		return idAsocComuna;
	}

	public void setIdAsocComuna(Integer idAsocComuna) {
		this.idAsocComuna = idAsocComuna;
	}

	public Long getIdVariables() {
		return idVariables;
	}

	public void setIdVariables(Long idVariables) {
		this.idVariables = idVariables;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public String getComponente() {
		return componente;
	}

	public void setComponente(String componente) {
		this.componente = componente;
	}

}
