package com.api.financeiro.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.financeiro.models.CompanyModel;
import com.api.financeiro.repositories.CompanyRepository;

import jakarta.transaction.Transactional;

@Service
public class CompanyServiceImpl implements CompanyService {

	@Autowired
	CompanyRepository companyRepository;
	
	
	@Override
	public List<CompanyModel> findAll() {
		
		return companyRepository.findAll();
	}

	@Override
	public Optional<CompanyModel> findById(Long id) {
		
		return companyRepository.findById(id);
	}

	@Override
	@Transactional
	public CompanyModel save(CompanyModel company) {
		
		return companyRepository.save(company);
	}

	@Override
	@Transactional
	public void delete(CompanyModel company) {
		
		companyRepository.delete(company);
		
	}

	@Override
	public boolean existsByName(String name) {
		
		return companyRepository.existsByName(name);
	}

	@Override
	public boolean existsByCnpj(String cnpj) {
		
		return companyRepository.existsByCnpj(cnpj);
	}

}
