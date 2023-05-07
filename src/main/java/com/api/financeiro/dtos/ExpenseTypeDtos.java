package com.api.financeiro.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class ExpenseTypeDtos {
	
	@NotBlank
	private String name;
	@NotNull
	private Double value;
		
	/* Constructor */
	
	public ExpenseTypeDtos() {
		
	}
	
	public ExpenseTypeDtos(@NotBlank String name, @NotNull Double value) {
		super();
		this.name = name;
		this.value = value;
	}
	
	/* Accessor Methods */
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}
	
	
	
	
	
	

}
