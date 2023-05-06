package com.api.financeiro.services;

import java.util.List;
import java.util.Optional;

import com.api.financeiro.models.EmphoyeeModel;

public interface EmphoyeeService {
	
	List<EmphoyeeModel> findAll();
	Optional<EmphoyeeModel> findById(Long id);
	EmphoyeeModel save(EmphoyeeModel emphoyee);
	void delete(EmphoyeeModel emphoyee);
	boolean existsByCpf(String cpf);
}
