package model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "cargo")
public class Cargo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_cargo")
    private Integer idCargo;
	
	@Column(name = "id_opcion_tarifaria")
    private Integer idOpcionTarifaria;
	
	@Column(name = "descripcion_corta")
    private String descripcionCorta;
	
	@Column(name = "descripcion_larga")
    private String descripcionLarga;
		
	@Column(name = "formula")
    private String formula;
    
    
	public Integer getIdOpcionTarifaria() {
		return idOpcionTarifaria;
	}
	public void setIdOpcionTarifaria(Integer idOpcionTarifaria) {
		this.idOpcionTarifaria = idOpcionTarifaria;
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

}
