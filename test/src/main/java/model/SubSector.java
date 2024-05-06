package model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
    
	public String getNombreSubSector() {
		return nombreSubSector;
	}
	public void setNombreSubSector(String nombreSubSector) {
		this.nombreSubSector = nombreSubSector;
	}

}
