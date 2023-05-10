package com.api.financeiro.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.financeiro.models.BoxOpeningModel;

public interface BoxOpeningRepository extends JpaRepository<BoxOpeningModel, Long> {
	
}
