package com.api.financeiro.models;


import java.time.LocalDateTime;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "TB_BOX_OPENING")
public class BoxOpeningModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(nullable = false)
	private LocalDateTime date_first;
	@Column(nullable = true)
	private LocalDateTime date_last;
	@Column(nullable = false)
	private Double valueOpening;
	@Column(nullable = false)
	private Double value;
	@ManyToOne
	@JoinColumn(nullable = false)
	private EmphoyeeModel emphoyee;
	
	/* Constructor */
	
	public BoxOpeningModel() {
		
	}

	public BoxOpeningModel(Long id, LocalDateTime date_first, LocalDateTime date_last, Double valueOpening,
			Double value, EmphoyeeModel emphoyee) {
		super();
		this.id = id;
		this.date_first = date_first;
		this.date_last = date_last;
		this.valueOpening = valueOpening;
		this.value = value;
		this.emphoyee = emphoyee;
	}

	/* Accessor Methods */
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime getDate_first() {
		return date_first;
	}

	public void setDate_first(LocalDateTime date_first) {
		this.date_first = date_first;
	}

	public LocalDateTime getDate_last() {
		return date_last;
	}

	public void setDate_last(LocalDateTime date_last) {
		this.date_last = date_last;
	}

	public Double getValueOpening() {
		return valueOpening;
	}

	public void setValueOpening(Double valueOpening) {
		this.valueOpening = valueOpening;
	}

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}

	public EmphoyeeModel getEmphoyee() {
		return emphoyee;
	}
	
	public void setEmphoyee(EmphoyeeModel emphoyee) {
		this.emphoyee = emphoyee;
	}

	@Override
	public String toString() {
		return "BoxOpeningModel [id=" + id + ", date_first=" + date_first + ", date_last=" + date_last
				+ ", valueOpening=" + valueOpening + ", value=" + value + ", emphoyee=" + emphoyee + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(date_first, date_last, id, value, valueOpening);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BoxOpeningModel other = (BoxOpeningModel) obj;
		return Objects.equals(date_first, other.date_first) && Objects.equals(date_last, other.date_last)
				&& Objects.equals(id, other.id) && Objects.equals(value, other.value)
				&& Objects.equals(valueOpening, other.valueOpening);
	}

	
	
	

	
	
	
	
	
	
	

}
