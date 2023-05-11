package com.api.financeiro.models;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "TB_EXPENSETYPE")
public class ExpenseTypeModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(nullable = false)
	private String name;
	@Column(nullable = false)
	private double value;
	
	
	
	
	/* Constructor */
	
	public ExpenseTypeModel() {
		
	}
		
	public ExpenseTypeModel(Long id, String name, double value) {
		super();
		this.id = id;
		this.name = name;
		this.value = value;
		
	}


	/* Accessor Methods */
		
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getValue() {
		return value;
	}
	public void setValue(double value) {
		this.value = value;
	}
	
	
	
	
	
	
	
	
	

}
