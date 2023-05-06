package com.api.financeiro.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.financeiro.models.EmphoyeeModel;

import jakarta.transaction.Transactional;

@Service
public class EmphoyeeServiceImpl implements EmphoyeeService{
	
	@Autowired
	EmphoyeeService emphoyeeService;

	@Override
	public List<EmphoyeeModel> findAll() {
		
		return emphoyeeService.findAll();
	}

	@Override
	public Optional<EmphoyeeModel> findById(Long id) {
		
		return emphoyeeService.findById(id);
	}

	@Override
	@Transactional
	public EmphoyeeModel save(EmphoyeeModel emphoyee) {
		
		return emphoyeeService.save(emphoyee);
	}

	@Override
	@Transactional
	public void delete(EmphoyeeModel emphoyee) {
		
		emphoyeeService.delete(emphoyee);
		
	}

	@Override
	public boolean existsByCpf(String cpf) {
		
		return emphoyeeService.existsByCpf(cpf);
	}

}
