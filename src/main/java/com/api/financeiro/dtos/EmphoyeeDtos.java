package com.api.financeiro.dtos;

import com.api.financeiro.models.BranchModel;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class EmphoyeeDtos {
	
	
	@NotBlank
	private String first_name;
	@NotBlank
	private String last_name;
	@NotBlank
	private String cpf;
	@NotNull
	private BranchModel branch;
	@NotBlank
	private String department;
	
	/* Constructor */
	
	public EmphoyeeDtos() {
		super();
	}


	public EmphoyeeDtos(@NotBlank String first_name, @NotBlank String last_name, @NotBlank String cpf,
			@NotNull BranchModel branch, @NotNull String department ) {
		super();
		this.first_name = first_name;
		this.last_name = last_name;
		this.cpf = cpf;
		this.branch = branch;
		this.department = department;
	}




	/* Accessor Methods */

	public String getFirst_name() {
		return first_name;
	}


	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}


	public String getLast_name() {
		return last_name;
	}


	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}


	public String getCpf() {
		return cpf;
	}


	public void setCpf(String cpf) {
		this.cpf = cpf;
	}


	public BranchModel getBranch() {
		return branch;
	}
	
	public void setBranch(BranchModel branch) {
		this.branch = branch;
	}
	
	public String getDepartment() {
		return department;
	}
	
	public void setDepartment(String department) {
		this.department = department;
	}
	
	
	

}
