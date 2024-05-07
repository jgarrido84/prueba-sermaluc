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
	
//	@OneToOne(fetch = FetchType.EAGER, optional = false)
//	@JoinColumn(name = "id_empresa")
//    private Empresa empresa;
	@Column(name="nombre_empresa")
	private String nombreEmpresa;
	
	@Column(name = "id_asoc_comuna")
    private Integer idAsocComuna;
	
//	@OneToOne(fetch = FetchType.EAGER, optional = false)
//	@JoinColumn(name = "id_comuna")
//    private Comuna comuna;
	
	@Column(name="nombre_comuna")
	private String nombreComuna;
//	
//	@OneToOne(fetch = FetchType.EAGER, optional = false)
//	@JoinColumn(name = "id_sub_sector")
//    private SubSector subSector;
	@Column(name="nombre_sub_sector")
	private String nombreSubSector;
//	
//	@OneToOne(fetch = FetchType.EAGER, optional = false)
//	@JoinColumn(name = "id_cargo")
//    private Cargo cargo;
	
	@Column(name="id_tarifaria")
	private Integer idTarifaria;
	
	@Column(name="opc_tarifaria_nombre")
	private String opcTarifariaNombre;
	
	@Column(name="formula", length = 500)
	private String formula;
	
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

}
