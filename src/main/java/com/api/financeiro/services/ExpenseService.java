package com.api.financeiro.services;

import java.util.List;
import java.util.Optional;

import com.api.financeiro.models.BoxOpeningModel;
import com.api.financeiro.models.ExpenseModel;



public interface ExpenseService {
	
	List<ExpenseModel> findAll();
	Optional<ExpenseModel> findById(Long id);
	Optional<BoxOpeningModel>findByIdBox(Long id);
	ExpenseModel save(ExpenseModel expense);
	void delete(ExpenseModel expense);

}
