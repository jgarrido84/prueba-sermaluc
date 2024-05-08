package com.example.test.controllers;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
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

import com.example.test.model.Variables;
import com.example.test.repository.VariablesRepository;
import com.example.test.utilidades.UtilsExcel;

@RestController
@RequestMapping("/variables")
public class VariablesControllers {
	
	@Autowired
	VariablesRepository repo;
	
	private static final Logger logger = LoggerFactory.getLogger(PlantillaCargoController.class);
	
	private static final String CSV_FILE_LOCATION = "C:/Users/Javier Garrido/Documents/prueba.xlsx";
	
	@GetMapping("cargarPlantilla")
	public @ResponseBody List<Variables> readCSV(){
		List<Variables> listResul = new ArrayList<>();
		Workbook workbook =null;
		try {
			workbook = WorkbookFactory.create(new File(CSV_FILE_LOCATION));
			
			Sheet sheet = workbook.getSheet("variables");
			Iterator<Row> rowIterator = sheet.iterator();
			boolean notFirst = false;

			while (rowIterator.hasNext()) {
				DataFormatter dataFormatter = new DataFormatter();
				Variables _variable = new Variables();
				
				Row row = (Row) rowIterator.next();
				
				if (notFirst) {
					
					Cell cellidAsocComuna = row.getCell(0);
					Cell cellComponente = row.getCell(1);
					Cell cellValor = row.getCell(2);
					
					_variable.setIdAsocComuna(Integer.parseInt(dataFormatter.formatCellValue(cellidAsocComuna)));
					_variable.setComponente(UtilsExcel.returnStringValue(cellComponente));
					_variable.setValor(Double.parseDouble(UtilsExcel.returnStringValue(cellValor)));
					listResul.add(_variable);
				}else {
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
	
		if(listResul.isEmpty()) {
			return listResul;
		}else {
			return repo.saveAll(listResul);
		}
	}

	@GetMapping("/lista")
	public ResponseEntity<List<Variables>> obtenerVariables(@RequestParam(required = false) Long idVariables) {
		try {
			List<Variables> list = new ArrayList<Variables>();

			if (idVariables == null) {
				repo.findAll().forEach(list::add);
			}else {
				list.add(repo.findById(idVariables).get());
			}
			if (list.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(list, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
