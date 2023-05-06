package com.api.financeiro.models;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "TB_COMPANY")
public class CompanyModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(nullable = false)
	private String corporate_name;
	@Column(nullable = false)
	private String Fantasy_name;
	@Column(nullable = false)
	private String cnpf;
	
	/* Construtor */
	public CompanyModel() {
		super();
	}

	public CompanyModel(Long id, String corporate_name, String fantasy_name, String cnpf) {
		super();
		this.id = id;
		this.corporate_name = corporate_name;
		Fantasy_name = fantasy_name;
		this.cnpf = cnpf;
	}
	
	/* Métodos Acessores */

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	@Override
	public String toString() {
		return "Company [id=" + id + ", corporate_name=" + corporate_name + ", Fantasy_name=" + Fantasy_name + ", cnpf="
				+ cnpf + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(Fantasy_name, cnpf, corporate_name, id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CompanyModel other = (CompanyModel) obj;
		return Objects.equals(Fantasy_name, other.Fantasy_name) && Objects.equals(cnpf, other.cnpf)
				&& Objects.equals(corporate_name, other.corporate_name) && Objects.equals(id, other.id);
	}
	
	
	

}