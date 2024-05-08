package com.example.test.controllers;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.test.model.PlantillaCargo;
import com.example.test.model.Variables;
import com.example.test.repository.PlantillaCargoRepository;
import com.example.test.repository.VariablesRepository;

@RestController
@RequestMapping("/reporte")
public class ReportController {
	
	@Autowired
	VariablesRepository variablesRepo;
	
	@Autowired
	PlantillaCargoRepository plantillaCargoRepo;
	
	@GetMapping("/generarExcel")
	public void generarExcel() {
		generarFormulaExcel();
	}
	
	private void generarFormulaExcel() {
		
		String CSV_FILE_LOCATION = "C:/Users/Javier Garrido/Documents/test.xlsx";
		Workbook workbook = new XSSFWorkbook();
	
		Sheet sheet = workbook.createSheet("Formula");
		sheet.setColumnWidth(0, 6000);
		sheet.setColumnWidth(1, 4000);
	
		Row header = sheet.createRow(0);
	
		CellStyle headerStyle = workbook.createCellStyle();
	
		XSSFFont font = ((XSSFWorkbook) workbook).createFont();
		font.setFontName("Arial");
		font.setFontHeightInPoints((short) 16);
		font.setBold(false);
		headerStyle.setFont(font);
		
		Cell headerCell = header.createCell(0);
		headerCell.setCellValue("aco_id_asociacion_comuna");
		headerCell.setCellStyle(headerStyle);
	
		headerCell = header.createCell(1);
		headerCell.setCellValue("emp_nom_empresa");
		headerCell.setCellStyle(headerStyle);
		
		headerCell = header.createCell(2);
		headerCell.setCellValue("com_nom_comuna");
		headerCell.setCellStyle(headerStyle);
		
		headerCell = header.createCell(3);
		headerCell.setCellValue("sub_nombre_sec");
		headerCell.setCellStyle(headerStyle);
		
		headerCell = header.createCell(4);
		headerCell.setCellValue("opc_tarifaria_id");
		headerCell.setCellStyle(headerStyle);
		
		headerCell = header.createCell(5);
		headerCell.setCellValue("opc_tarifaria_nombre");
		headerCell.setCellStyle(headerStyle);
		
		headerCell = header.createCell(6);
		headerCell.setCellValue("aca_for_formula_descompuesta");
		headerCell.setCellStyle(headerStyle);
		
		headerCell = header.createCell(7);
		headerCell.setCellValue("car_desc_cargo");
		headerCell.setCellStyle(headerStyle);
		
		headerCell = header.createCell(8);
		headerCell.setCellValue("Resultado_formula");
		headerCell.setCellStyle(headerStyle);
	
		CellStyle style = workbook.createCellStyle();
		style.setWrapText(true);
		
		List<PlantillaCargo> list = plantillaCargoRepo.findAll();
		int rownum = 1;
		
		for (PlantillaCargo pc : list) {
			Row row = sheet.createRow(rownum++);
			Cell cell = row.createCell(0);
			cell.setCellValue(pc.getIdAsocComuna());
			cell.setCellStyle(style);
		
			cell = row.createCell(1);
			cell.setCellValue(pc.getNombreEmpresa());
			cell.setCellStyle(style);
			
			cell = row.createCell(2);
			cell.setCellValue(pc.getNombreComuna());
			cell.setCellStyle(style);
			
			cell = row.createCell(3);
			cell.setCellValue(pc.getNombreSubSector());
			cell.setCellStyle(style);
			
			cell = row.createCell(4);
			cell.setCellValue(pc.getIdTarifaria());
			cell.setCellStyle(style);
			
			cell = row.createCell(5);
			cell.setCellValue(pc.getOpcTarifariaNombre());
			cell.setCellStyle(style);
			
			cell = row.createCell(6);
			cell.setCellValue(pc.getFormula());
			cell.setCellStyle(style);
			
			cell = row.createCell(7);
			cell.setCellValue(pc.getDescCargo());
			cell.setCellStyle(style);
			
			cell = row.createCell(8);
			cell.setCellValue(pc.getFormulaReplace());
			cell.setCellStyle(style);
		}

		FileOutputStream outputStream;
		try {
			outputStream = new FileOutputStream(CSV_FILE_LOCATION);
			workbook.write(outputStream);
			workbook.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void generateVariablesExcel() {
		String CSV_FILE_LOCATION = "C:/Users/Javier Garrido/Documents/test.xlsx";
		Workbook workbook = new XSSFWorkbook();
	
		Sheet sheet = workbook.createSheet("variables");
		sheet.setColumnWidth(0, 6000);
		sheet.setColumnWidth(1, 4000);
	
		Row header = sheet.createRow(0);
	
		CellStyle headerStyle = workbook.createCellStyle();
	
		XSSFFont font = ((XSSFWorkbook) workbook).createFont();
		font.setFontName("Arial");
		font.setFontHeightInPoints((short) 16);
		font.setBold(false);
		headerStyle.setFont(font);
		
		Cell headerCell = header.createCell(0);
		headerCell.setCellValue("aco_id_asociacion_comuna");
		headerCell.setCellStyle(headerStyle);
	
		headerCell = header.createCell(1);
		headerCell.setCellValue("componente");
		headerCell.setCellStyle(headerStyle);
		
		headerCell = header.createCell(2);
		headerCell.setCellValue("valor");
		headerCell.setCellStyle(headerStyle);
	
		CellStyle style = workbook.createCellStyle();
		style.setWrapText(true);
		
		List<Variables> list = variablesRepo.findAll();
		int rownum = 1;
		
		for (Variables var : list) {
			Row row = sheet.createRow(rownum++);
			Cell cell = row.createCell(0);
			cell.setCellValue(var.getIdAsocComuna());
			cell.setCellStyle(style);
		
			cell = row.createCell(1);
			cell.setCellValue(var.getComponente());
			cell.setCellStyle(style);
			
			cell = row.createCell(2);
			cell.setCellValue(var.getValor());
			cell.setCellStyle(style);
		}

		FileOutputStream outputStream;
		try {
			outputStream = new FileOutputStream(CSV_FILE_LOCATION);
			workbook.write(outputStream);
			workbook.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
