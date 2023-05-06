package com.api.financeiro.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.financeiro.models.CompanyModel;

public interface CompanyRepository extends JpaRepository<CompanyModel, Long> {
	
	boolean existsByName(String corporate_name );
	boolean existsByCnpj(String cnpj);

}
