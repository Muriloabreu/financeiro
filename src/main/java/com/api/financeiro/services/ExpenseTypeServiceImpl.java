package com.api.financeiro.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.financeiro.models.ExpenseTypeModel;
import com.api.financeiro.repositories.ExpenseTypeRepository;

import jakarta.transaction.Transactional;

@Service
public class ExpenseTypeServiceImpl implements ExpenseTypeService{
	
	@Autowired
	ExpenseTypeRepository expenseTypeRepository;

	@Override
	public List<ExpenseTypeModel> findAll() {
		
		return expenseTypeRepository.findAll();
	}

	@Override
	public Optional<ExpenseTypeModel> findById(Long id) {
		
		return expenseTypeRepository.findById(id);
	}

	@Override
	@Transactional
	public ExpenseTypeModel save(ExpenseTypeModel expenseType) {
		
		return expenseTypeRepository.save(expenseType);
	}

	@Override
	@Transactional
	public void delete(ExpenseTypeModel expenseType) {
		
		expenseTypeRepository.delete(expenseType);
		
	}

	@Override
	public boolean existsByName(String name) {
		
		return expenseTypeRepository.existsByName(name);
	}

}
