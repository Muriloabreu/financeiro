package com.api.financeiro.dtos;

import com.api.financeiro.models.CompanyModel;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class BranchDtos {
	
	
	@NotBlank
	private String name;
	@NotBlank
	private String cnpf;
	@NotNull
	private CompanyModel company;
	
	/* Constructor */
	
	public BranchDtos() {
		super();
	}
	public BranchDtos(@NotBlank String name, @NotBlank String cnpf, @NotNull CompanyModel company) {
		super();
		this.name = name;
		this.cnpf = cnpf;
		this.company = company;
	}
	
	/* Accessor Methods */
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCnpf() {
		return cnpf;
	}
	public void setCnpf(String cnpf) {
		this.cnpf = cnpf;
	}
	public CompanyModel getCompany() {
		return company;
	}
	public void setCompany(CompanyModel company) {
		this.company = company;
	}
	
	

}
