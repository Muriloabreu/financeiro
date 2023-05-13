package com.api.financeiro.services;

import java.util.List;
import java.util.Optional;

import com.api.financeiro.models.BranchModel;
import com.api.financeiro.models.CompanyModel;

public interface BranchService {
	
	List<BranchModel> findAll();
	Optional<BranchModel> findById(Long id);
	Optional<CompanyModel>findByIdCompany(Long id);
	BranchModel save(BranchModel branch);
	void delete (BranchModel brance);
	boolean existsByName(String name);
	boolean existsByCnpj(String cnpj);

}
