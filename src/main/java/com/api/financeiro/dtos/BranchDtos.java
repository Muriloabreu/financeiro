package com.api.financeiro.dtos;

import com.api.financeiro.models.CompanyModel;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class BranchDtos {
	
	
	@NotBlank
	private String name;
	@NotBlank
	private String cnpj;
	@NotNull
	private CompanyModel company;
	
	/* Constructor */
	
	public BranchDtos() {
		super();
	}
	public BranchDtos(@NotBlank String name, @NotBlank String cnpj, @NotNull CompanyModel company) {
		super();
		this.name = name;
		this.cnpj = cnpj;
		this.company = company;
	}
	
	/* Accessor Methods */
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpf(String cnpj) {
		this.cnpj = cnpj;
	}
	public CompanyModel getCompany() {
		return company;
	}
	public void setCompany(CompanyModel company) {
		this.company = company;
	}
	
	

}
