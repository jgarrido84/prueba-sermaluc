package model;

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
    private Integer idPlantillaCargo;
	
	@Column(name = "id_empresa")
    private Integer idEmpresa;
	
	@Column(name = "id_asoc_comuna")
    private Integer idAsocComuna;
	
	@Column(name = "id_comuna")
    private Integer idComuna;
	
	@Column(name = "id_sub_sector")
    private Integer idSubSector;
	
	@Column(name = "id_cargo")
    private Integer idCargo;
    
    public Integer getIdPlantillaCargo() {
		return idPlantillaCargo;
	}
	public void setIdPlantillaCargo(Integer idPlantillaCargo) {
		this.idPlantillaCargo = idPlantillaCargo;
	}
	public Integer getIdEmpresa() {
		return idEmpresa;
	}
	public void setIdEmpresa(Integer idEmpresa) {
		this.idEmpresa = idEmpresa;
	}
	public Integer getIdAsocComuna() {
		return idAsocComuna;
	}
	public void setIdAsocComuna(Integer idAsocComuna) {
		this.idAsocComuna = idAsocComuna;
	}
	public Integer getIdComuna() {
		return idComuna;
	}
	public void setIdComuna(Integer idComuna) {
		this.idComuna = idComuna;
	}
	public Integer getIdSubSector() {
		return idSubSector;
	}
	public void setIdSubSector(Integer idSubSector) {
		this.idSubSector = idSubSector;
	}
	public Integer getIdCargo() {
		return idCargo;
	}
	public void setIdCargo(Integer idCargo) {
		this.idCargo = idCargo;
	}
	private String descripcionLarga;
	public String getDescripcionLarga() {
		return descripcionLarga;
	}
	public void setDescripcionLarga(String descripcionLarga) {
		this.descripcionLarga = descripcionLarga;
	}

}
