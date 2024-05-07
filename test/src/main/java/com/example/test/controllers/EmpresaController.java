package com.example.test.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.test.model.Empresa;
import com.example.test.repository.EmpresaRepository;

@RestController
@RequestMapping("/empresa")
public class EmpresaController {
	
	@Autowired
	private EmpresaRepository repo;
	
	@PostMapping("/crear")
	public ResponseEntity<Empresa> createEmpresa(@RequestParam(required = true) String name) {
		try {
			Empresa _empresa = repo.save(new Empresa(name));
			return new ResponseEntity<>(_empresa, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/empresas")
	public ResponseEntity<List<Empresa>> obtenerEmpresas(@RequestParam(required = false) Long idEmpresa) {
		try {
			List<Empresa> empresas = new ArrayList<Empresa>();

			if (idEmpresa == null) {
				repo.findAll().forEach(empresas::add);
			}else {
				empresas.add(repo.findById(idEmpresa).get());
			}
			if (empresas.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(empresas, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
