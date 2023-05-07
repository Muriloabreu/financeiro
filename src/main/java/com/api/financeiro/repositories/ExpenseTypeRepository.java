package com.api.financeiro.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.financeiro.models.ExpenseTypeModel;

public interface ExpenseTypeRepository extends JpaRepository<ExpenseTypeModel, Long>{
	
	boolean existsByName(String name);
}
