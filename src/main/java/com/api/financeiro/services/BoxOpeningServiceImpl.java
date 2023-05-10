package com.api.financeiro.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.financeiro.models.BoxOpeningModel;
import com.api.financeiro.repositories.BoxOpeningRepository;

import jakarta.transaction.Transactional;

@Service
public class BoxOpeningServiceImpl implements BoxOpeningService{
	
	@Autowired
	BoxOpeningRepository boxOpeningRepository;

	@Override
	public List<BoxOpeningModel> findAll() {
		
		return boxOpeningRepository.findAll();
	}

	@Override
	public Optional<BoxOpeningModel> findById(Long id) {
		
		return boxOpeningRepository.findById(id);
	}

	@Override
	@Transactional
	public BoxOpeningModel save(BoxOpeningModel box) {
		
		return boxOpeningRepository.save(box);
	}

	@Override
	@Transactional
	public void delete(BoxOpeningModel box) {
		
		boxOpeningRepository.delete(box);
	}

	

}
