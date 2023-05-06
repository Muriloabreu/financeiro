package com.api.financeiro.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.financeiro.models.BranchModel;

public interface BranchRepository extends JpaRepository<BranchModel, Long>{
	
	boolean existsByName(String name);
	boolean existsByCnpj(String cnpj);

}
