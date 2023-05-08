package com.api.financeiro.services;

import java.util.List;
import java.util.Optional;

import com.api.financeiro.models.BoxOpeningModel;

public interface BoxOpeningService {
	
	List<BoxOpeningModel> findAll();
	Optional<BoxOpeningModel> findById(Long id);
	BoxOpeningModel save(BoxOpeningModel box);
	void delete(BoxOpeningModel box);
	boolean existsByBoxOpen(boolean open);

}
