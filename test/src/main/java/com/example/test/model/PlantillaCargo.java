package com.example.test.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "plantilla_cargo")
public class PlantillaCargo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_plantilla_cargo")
    private Long idPlantillaCargo;
	
	@Column(name="nombre_empresa")
	private String nombreEmpresa;
	
	@Column(name = "id_asoc_comuna")
    private Integer idAsocComuna;
	
	@Column(name="nombre_comuna")
	private String nombreComuna;

	@Column(name="nombre_sub_sector")
	private String nombreSubSector;
	
	@Column(name="id_tarifaria")
	private Integer idTarifaria;
	
	@Column(name="opc_tarifaria_nombre")
	private String opcTarifariaNombre;
	
	@Column(name="formula", length = 500)
	private String formula;
	
	@Column(name="formula_replace", length = 800)
	private String formulaReplace;
	
	@Column(name="desc_cargo")
	private String descCargo;

	public Long getIdPlantillaCargo() {
		return idPlantillaCargo;
	}

	public void setIdPlantillaCargo(Long idPlantillaCargo) {
		this.idPlantillaCargo = idPlantillaCargo;
	}

	public String getNombreEmpresa() {
		return nombreEmpresa;
	}

	public void setNombreEmpresa(String nombreEmpresa) {
		this.nombreEmpresa = nombreEmpresa;
	}

	public Integer getIdAsocComuna() {
		return idAsocComuna;
	}

	public void setIdAsocComuna(Integer idAsocComuna) {
		this.idAsocComuna = idAsocComuna;
	}

	public String getNombreComuna() {
		return nombreComuna;
	}

	public void setNombreComuna(String nombreComuna) {
		this.nombreComuna = nombreComuna;
	}

	public String getNombreSubSector() {
		return nombreSubSector;
	}

	public void setNombreSubSector(String nombreSubSector) {
		this.nombreSubSector = nombreSubSector;
	}

	public Integer getIdTarifaria() {
		return idTarifaria;
	}

	public void setIdTarifaria(Integer idTarifaria) {
		this.idTarifaria = idTarifaria;
	}

	public String getOpcTarifariaNombre() {
		return opcTarifariaNombre;
	}

	public void setOpcTarifariaNombre(String opcTarifariaNombre) {
		this.opcTarifariaNombre = opcTarifariaNombre;
	}

	public String getFormula() {
		return formula;
	}

	public void setFormula(String formula) {
		this.formula = formula;
	}

	public String getDescCargo() {
		return descCargo;
	}

	public void setDescCargo(String descCargo) {
		this.descCargo = descCargo;
	}

	public String getFormulaReplace() {
		return formulaReplace;
	}

	public void setFormulaReplace(String formulaReplace) {
		this.formulaReplace = formulaReplace;
	}

}
