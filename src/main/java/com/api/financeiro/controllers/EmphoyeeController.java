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


import com.api.financeiro.dtos.EmphoyeeDtos;
import com.api.financeiro.models.EmphoyeeModel;
import com.api.financeiro.services.EmphoyeeService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("financeiro/emphoyee")
public class EmphoyeeController {
	
	@Autowired
	EmphoyeeService emphoyeeService;
	
	
	@PostMapping
	public ResponseEntity<Object> saveEmphoyee(@RequestBody @Valid EmphoyeeDtos emphoyeeDtos){
		
		
		if(emphoyeeService.existsByCpf(emphoyeeDtos.getCpf())) {
			
			return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflict: CPF is already in use!"); 
		}
				
		var emphoyeeModel = new EmphoyeeModel();
		BeanUtils.copyProperties(emphoyeeDtos, emphoyeeModel);
		
		
		return ResponseEntity.status(HttpStatus.OK).body(emphoyeeService.save(emphoyeeModel));		
		
	}
	
	@GetMapping
	public ResponseEntity<List<EmphoyeeModel>> getAllEmphoyee(){
		
		return ResponseEntity.status(HttpStatus.OK).body(emphoyeeService.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Object> getOneEmphoyee(@PathVariable(value = "id") Long id){
		
		Optional<EmphoyeeModel> emphoyeeOptional = emphoyeeService.findById(id);
		if (!emphoyeeOptional.isPresent()) {
			
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Emphoyee not found. ");
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(emphoyeeService.findById(id));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteEmphoyee(@PathVariable(value = "id") Long id) {

		Optional<EmphoyeeModel> emphoyeeOptional = emphoyeeService.findById(id);
		if (!emphoyeeOptional.isPresent()) {
			
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Emphoyee not found. ");
		}

		emphoyeeService.delete(emphoyeeOptional.get());
		return ResponseEntity.status(HttpStatus.OK).body("Branch deleted successfully. ");

	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Object> updateEmphoyee(@PathVariable(value = "id") Long id,
			                                        @RequestBody @Valid EmphoyeeDtos emphoyeeDtos) {

		Optional<EmphoyeeModel> emphoyeeOptional = emphoyeeService.findById(id);
		if (!emphoyeeOptional.isPresent()) {
			
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Emphoyee not found. ");
		}
		
		var emphoyeeModel = emphoyeeOptional.get();
		emphoyeeModel.setFirst_name(emphoyeeDtos.getFirst_name());
		emphoyeeModel.setLast_name(emphoyeeDtos.getLast_name());
		emphoyeeModel.setCpf(emphoyeeDtos.getCpf());
		emphoyeeModel.setBranch(emphoyeeDtos.getBranch());
				
		return ResponseEntity.status(HttpStatus.OK).body(emphoyeeService.save(emphoyeeModel));
	

	}

}
