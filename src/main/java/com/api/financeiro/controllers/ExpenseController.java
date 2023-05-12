package com.api.financeiro.controllers;

import java.util.List;
import java.util.Optional;

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
import com.api.financeiro.models.BoxOpeningModel;
import com.api.financeiro.models.ExpenseModel;
import com.api.financeiro.services.ExpenseService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("financeiro/expense")
public class ExpenseController {
	
	@Autowired
	ExpenseService expenseService;
	
	
	@PostMapping
	public ResponseEntity<Object> saveExpense(@RequestBody @Valid ExpenseDtos expenseDtos){
		
			if(expenseDtos.getBranche() == null) {
			
			return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflict: There is no branch in use!"); 
			
			    }
			
			if(expenseDtos.getEmphoyee() == null) {
				
				return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflict: There is no Emphoyee in use!"); 
				
				}		
				
		var expenseModel = new ExpenseModel();
		BeanUtils.copyProperties(expenseDtos, expenseModel);
		
		expenseModel.setValueTotExpenseType(expenseModel.getValueTotExpenseType());
		expenseModel.setValueReturn(expenseModel.getValueReturn());
		
		Optional<BoxOpeningModel> boxOptinal = expenseService.findByIdBox(expenseModel.getBoxOpening().getId());
		var boxModel = boxOptinal.get();
		
		/* Quando for o primeiro Expense o campo "Value" da tabela BoxOpening inicia 0 */
		if(boxModel.getValue() == null || boxModel.getValue() == 0){
			
			boxModel.setValue(expenseModel.getValueTotExpenseType() - boxModel.getValueOpening());
			
			return ResponseEntity.status(HttpStatus.CREATED).body(expenseService.save(expenseModel));
		}
		/* O campo Value da tabela BoxOpening se estiver negativo (-) */
		if (boxModel.getValue() < 0) {	
			
			boxModel.setValue(boxModel.getValue() * (-1) );	
			
			
			boxModel.setValue(boxModel.getValue() - expenseModel.getValueTotExpenseType());
			
			return ResponseEntity.status(HttpStatus.CREATED).body(expenseService.save(expenseModel));
			
				}else if(boxModel.getValue() > 0) {			
			
			boxModel.setValue(boxModel.getValue() - expenseModel.getValueTotExpenseType());			
			
			return ResponseEntity.status(HttpStatus.CREATED).body(expenseService.save(expenseModel));
			
		}
		
		return ResponseEntity.status(HttpStatus.CONFLICT).body("There is no balance!");		
		
	}
	
	@GetMapping
	public ResponseEntity<List<ExpenseModel>> getAllBranch(){
		
		return ResponseEntity.status(HttpStatus.OK).body(expenseService.findAll());
	}

}
