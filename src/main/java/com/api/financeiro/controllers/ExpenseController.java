package com.api.financeiro.controllers;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.financeiro.dtos.ExpenseDtos;
import com.api.financeiro.models.ExpenseModel;
import com.api.financeiro.services.ExpenseService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("financeiro/expense")
public class ExpenseController {
	
	@Autowired
	ExpenseService expenseService;
	
	
	@PostMapping
	public ResponseEntity<Object> saveBranch(@RequestBody @Valid ExpenseDtos expenseDtos){
		
			if(expenseDtos.getBranche() == null) {
			
			return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflict: There is no branch in use!"); 
			
			    }
			
			if(expenseDtos.getEmphoyee() == null) {
				
				return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflict: There is no Emphoyee in use!"); 
				
				}
		
				
		var expenseModel = new ExpenseModel();
		BeanUtils.copyProperties(expenseDtos, expenseModel);
		
		
		return ResponseEntity.status(HttpStatus.OK).body(expenseService.save(expenseModel));		
		
	}
	
	@GetMapping
	public ResponseEntity<List<ExpenseModel>> getAllBranch(){
		
		return ResponseEntity.status(HttpStatus.OK).body(expenseService.findAll());
	}

}
