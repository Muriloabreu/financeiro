package com.api.financeiro.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.financeiro.models.ExpenseModel;
import com.api.financeiro.repositories.ExpenseRepository;

import jakarta.transaction.Transactional;

@Service
public class ExpenseServiceImpl implements ExpenseService{
	
	@Autowired
	ExpenseRepository expenseRepository;

	@Override
	public List<ExpenseModel> findAll() {
		
		return expenseRepository.findAll();
	}

	@Override
	public Optional<ExpenseModel> findById(Long id) {
		
		return expenseRepository.findById(id);
	}

	@Override
	@Transactional
	public ExpenseModel save(ExpenseModel expense) {
		
		return expenseRepository.save(expense);
	}

	@Override
	@Transactional
	public void delete(ExpenseModel expense) {
		
		expenseRepository.delete(expense);
		
	}

}
