package com.api.financeiro.services;

import java.util.List;
import java.util.Optional;

import com.api.financeiro.models.CompanyModel;

public interface CompanyService {

	List<CompanyModel> findAll();
	Optional<CompanyModel> findById(Long id);
	CompanyModel save(CompanyModel company);
	void delete (CompanyModel company);
	boolean existsByName(String name);
	boolean existsByCnpj(String name);
}
