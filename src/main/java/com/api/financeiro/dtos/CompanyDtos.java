package com.api.financeiro.dtos;

import jakarta.validation.constraints.NotBlank;

public class CompanyDtos {
	
	@NotBlank
	private String corporate_name;
	@NotBlank
	private String Fantasy_name;
	@NotBlank
	private String cnpf;
	
	/* Constructor */
	
	public CompanyDtos() {
		super();
	}

	public CompanyDtos(@NotBlank String corporate_name, @NotBlank String fantasy_name, @NotBlank String cnpf) {
		super();
		this.corporate_name = corporate_name;
		Fantasy_name = fantasy_name;
		this.cnpf = cnpf;
	}
	
	/* Accessor Methods */

	public String getCorporate_name() {
		return corporate_name;
	}

	public void setCorporate_name(String corporate_name) {
		this.corporate_name = corporate_name;
	}

	public String getFantasy_name() {
		return Fantasy_name;
	}

	public void setFantasy_name(String fantasy_name) {
		Fantasy_name = fantasy_name;
	}

	public String getCnpf() {
		return cnpf;
	}

	public void setCnpf(String cnpf) {
		this.cnpf = cnpf;
	}

	
	
	
	
}
