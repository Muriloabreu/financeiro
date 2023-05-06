package com.api.financeiro.services;

import java.util.List;
import java.util.Optional;

import com.api.financeiro.models.BranchModel;

public interface BranchService {
	
	List<BranchModel> findAll();
	Optional<BranchModel> findById(Long id);
	BranchModel save(BranchModel branch);
	void delete (BranchModel brance);
	boolean findByName(String name);
	boolean findByCnpj(String cnpj);

}
