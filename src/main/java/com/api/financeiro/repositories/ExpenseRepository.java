package com.api.financeiro.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.financeiro.models.ExpenseModel;

public interface ExpenseRepository extends JpaRepository<ExpenseModel, Long> {
	
	
}
