package com.api.financeiro.services;

import java.util.List;
import java.util.Optional;

import com.api.financeiro.models.ExpenseTypeModel;

public interface ExpenseTypeService {
	
	
	List<ExpenseTypeModel> findAll();
	Optional<ExpenseTypeModel> findById(Long id);
	ExpenseTypeModel save(ExpenseTypeModel expenseType);
	void delete(ExpenseTypeModel expenseType);
	boolean existsByName(String name);

}
