package com.api.financeiro.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.financeiro.models.EmphoyeeModel;

public interface EmphoyeeRepository extends JpaRepository<EmphoyeeModel, Long>{
	
	boolean existsByCpf(String cpf);

}
