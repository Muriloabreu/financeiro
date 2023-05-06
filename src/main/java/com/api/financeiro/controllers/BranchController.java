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

import com.api.financeiro.dtos.BranchDtos;
import com.api.financeiro.models.BranchModel;
import com.api.financeiro.services.BranchService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("financeiro-branch")
public class BranchController {

	@Autowired
	BranchService branchService;
	
	
	@PostMapping
	public ResponseEntity<Object> saveBranch(@RequestBody @Valid BranchDtos branchDtos){
		
		if(branchService.existsByName(branchDtos.getName())) {
			
			return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflict: Name branch is already in use!"); 
		}
		if(branchService.existsByCnpj(branchDtos.getCnpf())) {
			
			return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflict: CNPJ is already in use!"); 
		}
				
		var branchModel = new BranchModel();
		BeanUtils.copyProperties(branchDtos, branchModel);
		
		
		return ResponseEntity.status(HttpStatus.OK).body(branchService.save(branchModel));		
		
	}
	
	@GetMapping
	public ResponseEntity<List<BranchModel>> getAllBranch(){
		
		return ResponseEntity.status(HttpStatus.OK).body(branchService.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Object> getOneBranchy(@PathVariable(value = "id") Long id){
		
		Optional<BranchModel> branchOptional = branchService.findById(id);
		if (!branchOptional.isPresent()) {
			
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Branch not found. ");
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(branchService.findById(id));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteBranch(@PathVariable(value = "id") Long id) {

		Optional<BranchModel> branchOptional = branchService.findById(id);
		if (!branchOptional.isPresent()) {
			
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Branch not found. ");
		}

		branchService.delete(branchOptional.get());
		return ResponseEntity.status(HttpStatus.OK).body("Branch deleted successfully. ");

	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Object> updateCompany(@PathVariable(value = "id") Long id,
			                                        @RequestBody @Valid BranchDtos branchDtos) {

		Optional<BranchModel> branchOptional = branchService.findById(id);
		if (!branchOptional.isPresent()) {
			
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Branch not found. ");
		}
		
		var branchModel = branchOptional.get();
		branchModel.setName(branchDtos.getName());
		branchModel.setCnpj(branchDtos.getCnpf());
		branchModel.setCompany(branchDtos.getCompany());
		
				
		return ResponseEntity.status(HttpStatus.OK).body(branchService.save(branchModel));
	

	}
	
	
}
