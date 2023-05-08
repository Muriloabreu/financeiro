package com.api.financeiro.models;

import java.time.LocalDate;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "TB_BOX_OPENING")
public class BoxOpeningModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(nullable = false, unique = true)
	private LocalDate date_first;
	@Column(nullable = false, unique = true)
	private LocalDate date_last;
	@Column(nullable = false)
	private Double valueOpening;
	@Column(nullable = false)
	private Double value;
	@Column(nullable = false)
	private boolean boxOpening;
	
	public BoxOpeningModel() {
		
	}

	public BoxOpeningModel(Long id, LocalDate date_first, LocalDate date_last, Double valueOpening, Double value,
			boolean boxOpening) {
		super();
		this.id = id;
		this.date_first = date_first;
		this.date_last = date_last;
		this.valueOpening = valueOpening;
		this.value = value;
		this.boxOpening = boxOpening;
	}
	
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getDate_first() {
		return date_first;
	}

	public void setDate_first(LocalDate date_first) {
		this.date_first = date_first;
	}

	public LocalDate getDate_last() {
		return date_last;
	}

	public void setDate_last(LocalDate date_last) {
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

	public boolean isBoxOpening() {
		return boxOpening;
	}

	public void setBoxOpening(boolean boxOpening) {
		this.boxOpening = boxOpening;
	}

	@Override
	public String toString() {
		return "BoxOpeningModel [id=" + id + ", date_first=" + date_first + ", date_last=" + date_last
				+ ", valueOpening=" + valueOpening + ", value=" + value + ", boxOpening=" + boxOpening + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(boxOpening, date_first, date_last, id, value, valueOpening);
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
		return boxOpening == other.boxOpening && Objects.equals(date_first, other.date_first)
				&& Objects.equals(date_last, other.date_last) && Objects.equals(id, other.id)
				&& Objects.equals(value, other.value) && Objects.equals(valueOpening, other.valueOpening);
	}
	
	
	
	
	
	

}
