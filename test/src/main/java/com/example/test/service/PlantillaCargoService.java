package com.example.test.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.example.test.model.PlantillaCargo;
import com.example.test.model.Variables;
import com.example.test.repository.PlantillaCargoRepository;
import com.example.test.repository.VariablesRepository;

@Service
public class PlantillaCargoService{
	
	@Autowired
	PlantillaCargoRepository repoPlantillaCargo;
	
	@Autowired
	VariablesRepository repoVariables;
	
	public void replaceFormula(List<PlantillaCargo> list) {
		
		List<Variables> variables = new ArrayList<>();
		
		for (PlantillaCargo pc : list) {
			Variables varExample = new Variables();
			varExample.setIdAsocComuna(pc.getIdAsocComuna());
			Example<Variables> example = Example.of(varExample); 
			variables = repoVariables.findAll(example);
			String formulaActual = null;
			
			for (Variables var : variables) {
				if(pc.getFormulaReplace() == null) {
					formulaActual =pc.getFormula();
				}else {
					formulaActual =pc.getFormulaReplace();
				}
				if(formulaActual.contains(var.getComponente())) {
					pc.setFormulaReplace(formulaActual.replaceAll(var.getComponente(), var.getValor().toString()));
				}					
			}			
		}
		
		repoPlantillaCargo.saveAll(list);
	}

}
