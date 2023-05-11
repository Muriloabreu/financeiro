package com.api.financeiro.models;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "TB_EMPHOYEE")
public class EmphoyeeModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(nullable = false)
	private String first_name;
	@Column(nullable = false)
	private String last_name;
	@Column(nullable = false, unique = true, length = 15)
	private String cpf;
	@ManyToOne
	@JoinColumn(nullable = false)
	private BranchModel branch;
	@Column(nullable = false)
	private String department;
	
	
	
	/* Constructor */
	
	
	public EmphoyeeModel() {
		
	}

	public EmphoyeeModel(Long id, String first_name, String last_name, String cpf, BranchModel branch,
			String department) {
		super();
		this.id = id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.cpf = cpf;
		this.branch = branch;
		this.department = department;
	}


	/* Accessor Methods */
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
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
	public BranchModel getBranch() {
		return branch;
	}
	public void setBranch(BranchModel branch) {
		this.branch = branch;
	}
	
	public String getCpf() {
		return cpf;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return "EmphoyeeModel [id=" + id + ", first_name=" + first_name + ", last_name=" + last_name + ", cpf=" + cpf
				+ ", branch=" + branch + ", department=" + department + "]";
	}

	
	
	
	
	
	
	

}
