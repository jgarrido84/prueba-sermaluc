package com.example.test.utilidades;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;

public class UtilsExcel {
	
	public static final String returnStringValue(Cell cell) {
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
