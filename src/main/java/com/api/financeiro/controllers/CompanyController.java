package com.api.financeiro.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.financeiro.dtos.CompanyDtos;
import com.api.financeiro.models.CompanyModel;
import com.api.financeiro.services.CompanyService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/financeiro/company")
public class CompanyController {
	
	@Autowired
	CompanyService companyService;
	
	
	@PostMapping
	public ResponseEntity<Object> saveCompany(@RequestBody @Valid CompanyDtos companyDtos){
		
		if(companyService.existsByName(companyDtos.getCorporate_name())) {
			
			return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflict: Name company is already in use!"); 
		}
		if(companyService.existsByCnpj(companyDtos.getCnpj())) {
			
			return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflict: CNPJ is already in use!"); 
		}
				
		var companyModel = new CompanyModel();
		BeanUtils.copyProperties(companyDtos, companyModel);
		
		
		return ResponseEntity.status(HttpStatus.OK).body(companyService.save(companyModel));		
		
	}
	
	@GetMapping
	public ResponseEntity<List<CompanyModel>> getAllCompany(){
		
		return ResponseEntity.status(HttpStatus.OK).body(companyService.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Object> getOneompany(@PathVariable(value = "id") Long id){
		
		Optional<CompanyModel> companyOptional = companyService.findById(id);
		if (!companyOptional.isPresent()) {
			
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Company not found. ");
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(companyService.findById(id));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteCompany(@PathVariable(value = "id") Long id) {

		Optional<CompanyModel> companyOptional = companyService.findById(id);
		if (!companyOptional.isPresent()) {
			
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Company not found. ");
		}

		companyService.delete(companyOptional.get());
		return ResponseEntity.status(HttpStatus.OK).body("Company deleted successfully. ");

	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Object> updateCompany(@PathVariable(value = "id") Long id,
			                                        @RequestBody @Valid CompanyDtos companyDtos) {

		Optional<CompanyModel> companyOptional = companyService.findById(id);
		if (!companyOptional.isPresent()) {
			
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Company not found. ");
		}
		
		var companyModel = companyOptional.get();
		companyModel.setCorporate_name(companyDtos.getCorporate_name());
		companyModel.setFantasy_name(companyDtos.getFantasy_name());
		companyModel.setCnpj(companyDtos.getCnpj());
		
				
		return ResponseEntity.status(HttpStatus.OK).body(companyService.save(companyModel));
	

	}
	
	
	

}
