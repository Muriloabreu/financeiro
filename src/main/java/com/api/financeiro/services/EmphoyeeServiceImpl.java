package com.api.financeiro.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.financeiro.models.EmphoyeeModel;
import com.api.financeiro.repositories.EmphoyeeRepository;

import jakarta.transaction.Transactional;

@Service
public class EmphoyeeServiceImpl implements EmphoyeeService{
	
	@Autowired
	EmphoyeeRepository emphoyeeRepository;

	@Override
	public List<EmphoyeeModel> findAll() {
		
		return emphoyeeRepository.findAll();
	}

	@Override
	public Optional<EmphoyeeModel> findById(Long id) {
		
		return emphoyeeRepository.findById(id);
	}

	@Override
	@Transactional
	public EmphoyeeModel save(EmphoyeeModel emphoyee) {
		
		return emphoyeeRepository.save(emphoyee);
	}

	@Override
	@Transactional
	public void delete(EmphoyeeModel emphoyee) {
		
		emphoyeeRepository.delete(emphoyee);
		
	}

	@Override
	public boolean existsByCpf(String cpf) {
		
		return emphoyeeRepository.existsByCpf(cpf);
	}

}
