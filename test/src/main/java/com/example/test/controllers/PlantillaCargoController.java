package com.example.test.controllers;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.test.model.PlantillaCargo;
import com.example.test.repository.PlantillaCargoRepository;

@RestController
@RequestMapping("/plantilla")
public class PlantillaCargoController {
	
	@Autowired
	private PlantillaCargoRepository repo;
	
	private static final Logger logger = LoggerFactory.getLogger(PlantillaCargoController.class);
	
	private static final String CSV_FILE_LOCATION = "C:/Users/Javier Garrido/Documents/prueba.xlsx";
	
	@GetMapping("cargarPlantilla")
	public @ResponseBody List<PlantillaCargo> readCSV(){
		List<PlantillaCargo> listaResul = new ArrayList<>();
		Workbook workbook =null;
		try {
			workbook = WorkbookFactory.create(new File(CSV_FILE_LOCATION));
			
			Sheet sheet = workbook.getSheet("Formula");
			Iterator<Row> rowIterator = sheet.iterator();
			boolean notFirst = false;

			while (rowIterator.hasNext()) {
				DataFormatter dataFormatter = new DataFormatter();
				PlantillaCargo plantillaCargo = new PlantillaCargo();
				Row row = (Row) rowIterator.next();
				
				if (notFirst) {
					
					Cell cellIdAsocComuna = row.getCell(0);
					Cell cellNombreEmpresa = row.getCell(1);
					Cell cellNombreComuna = row.getCell(2);					
					Cell cellSubNombreSec = row.getCell(3);
					Cell cellIdOpcTarifaria = row.getCell(4);
					Cell cellOpcTarifariaNombre = row.getCell(5);
					Cell cellFormula = row.getCell(6);
					Cell cellDescCargo = row.getCell(7);
					
					plantillaCargo.setIdAsocComuna((Integer.parseInt(dataFormatter.formatCellValue(cellIdAsocComuna))));
					plantillaCargo.setNombreEmpresa(returnStringValue(cellNombreEmpresa));
					plantillaCargo.setNombreComuna(returnStringValue(cellNombreComuna));
					plantillaCargo.setNombreSubSector(returnStringValue(cellSubNombreSec));
					plantillaCargo.setIdTarifaria((Integer.parseInt(dataFormatter.formatCellValue(cellIdOpcTarifaria))));
					plantillaCargo.setOpcTarifariaNombre(returnStringValue(cellOpcTarifariaNombre));
					plantillaCargo.setFormula(returnStringValue(cellFormula));
					plantillaCargo.setDescCargo(returnStringValue(cellDescCargo));	
					listaResul.add(plantillaCargo);
					
				} else {
					notFirst = true;
				}
			}
		} catch (EncryptedDocumentException | IOException e) {
			logger.error(e.getMessage(), e);
		}finally {
			try {
				if(workbook != null) workbook.close();
			} catch (IOException e) {
				logger.error(e.getMessage(), e);
			}
		}
		
		if(listaResul.isEmpty()) {
			return listaResul;
		}else {
			return repo.saveAll(listaResul);
		}
	}
	
	@GetMapping("/lista")
	public ResponseEntity<List<PlantillaCargo>> obtenerPlantillaCargo(@RequestParam(required = false) Long idPlantillaCargo) {
		try {
			List<PlantillaCargo> list = new ArrayList<PlantillaCargo>();

			if (idPlantillaCargo == null) {
				repo.findAll().forEach(list::add);
			}else {
				list.add(repo.findById(idPlantillaCargo).get());
			}
			if (list.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(list, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	private static String returnStringValue(Cell cell) {
	    CellType cellType = cell.getCellType();

	    switch (cellType) {
	        case NUMERIC -> {
	            double doubleVal = cell.getNumericCellValue();
	            if (doubleVal == (int) doubleVal) {
	                int value = Double.valueOf(doubleVal).intValue();
	                return String.valueOf(value);
	            } else {
	                return String.valueOf(doubleVal);
	            }
	        }
	        case STRING -> {
	            return cell.getStringCellValue();
	        }
	        case ERROR -> {
	            return String.valueOf(cell.getErrorCellValue());
	        }
	        case BLANK -> {
	            return "";
	        }
	        case FORMULA -> {
	            return cell.getCellFormula();
	        }
	        case BOOLEAN -> {
	            return String.valueOf(cell.getBooleanCellValue());
	        }
	    }
	    return "error decoding string value of the cell";

	}

}
