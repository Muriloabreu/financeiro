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

import com.api.financeiro.dtos.ExpenseTypeDtos;
import com.api.financeiro.models.ExpenseTypeModel;
import com.api.financeiro.services.ExpenseTypeService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("financeiro/expense-type")
public class ExpenseTypeController {
	
	
	@Autowired
	ExpenseTypeService expenseTypeService;
	
	
	@PostMapping
	public ResponseEntity<Object> saveExpenseType(@RequestBody @Valid ExpenseTypeDtos expenseTypeDtos){
		
		if(expenseTypeService.existsByName(expenseTypeDtos.getName())) {
			
			return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflict: Name Expense Type is already in use!"); 
		}
		
				
		var expenseTypeModel = new ExpenseTypeModel();
		BeanUtils.copyProperties(expenseTypeDtos, expenseTypeModel);
		
		
		return ResponseEntity.status(HttpStatus.OK).body(expenseTypeService.save(expenseTypeModel));		
		
	}
	
	@GetMapping
	public ResponseEntity<List<ExpenseTypeModel>> getAllExpenseType(){
		
		return ResponseEntity.status(HttpStatus.OK).body(expenseTypeService.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Object> getOneBranchy(@PathVariable(value = "id") Long id){
		
		Optional<ExpenseTypeModel> expenseTypeOptional = expenseTypeService.findById(id);
		if (!expenseTypeOptional.isPresent()) {
			
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Expense Type not found. ");
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(expenseTypeService.findById(id));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteBranch(@PathVariable(value = "id") Long id) {

		Optional<ExpenseTypeModel> expenseTypeOptional = expenseTypeService.findById(id);
		if (!expenseTypeOptional.isPresent()) {
			
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Expense Type not found. ");
		}

		expenseTypeService.delete(expenseTypeOptional.get());
		return ResponseEntity.status(HttpStatus.OK).body("Expense Type deleted successfully. ");

	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Object> updateCompany(@PathVariable(value = "id") Long id,
			                                        @RequestBody @Valid ExpenseTypeDtos expenseTypeDtos) {

		Optional<ExpenseTypeModel> expenseTypeOptional = expenseTypeService.findById(id);
		if (!expenseTypeOptional.isPresent()) {
			
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Expense Type not found. ");
		}
		
		var expenseTypeModel = expenseTypeOptional.get();
		expenseTypeModel.setName(expenseTypeDtos.getName());
		expenseTypeModel.setValue(expenseTypeDtos.getValue());
		
		
				
		return ResponseEntity.status(HttpStatus.OK).body(expenseTypeService.save(expenseTypeModel));
	

	}

}
