package com.api.financeiro.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "TB_EXPENSE")
public class ExpenseModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@ManyToOne
	@JoinColumn(nullable = false)
	private BranchModel branche;
	@ManyToOne
	@JoinColumn(nullable = false)
	private EmphoyeeModel emphoyee;
	@Column(nullable = false)
	private Double value;
	@OneToOne
	@JoinColumn(name = "id_box_opening", referencedColumnName = "id")
	private BoxOpeningModel boxOpening;
	@OneToMany
	@JoinColumn(name = "id_expense")
	private List<ExpenseModel> expenses = new ArrayList<>();
	@Column(nullable = true)
	private double valueTotExpense;
	@Column(nullable = true)
	private double valueDelivered;
	@Column(nullable = true)
	private double valueReturn;
	
	
	/* Constructor */
	
	public ExpenseModel() {
		super();
	}

	public ExpenseModel(Long id, BranchModel branche, EmphoyeeModel emphoyee, Double value, BoxOpeningModel boxOpening,
			List<ExpenseModel> expenses, double valueTotExpense, double valueDelivered, double valueReturn) {
		super();
		this.id = id;
		this.branche = branche;
		this.emphoyee = emphoyee;
		this.value = value;
		this.boxOpening = boxOpening;
		this.expenses = expenses;
		this.valueTotExpense = valueTotExpense;
		this.valueDelivered = valueDelivered;
		this.valueReturn = valueReturn;
	}




	/* Accessor Methods */

	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public BranchModel getBranche() {
		return branche;
	}


	public void setBranche(BranchModel branche) {
		this.branche = branche;
	}


	public EmphoyeeModel getEmphoyee() {
		return emphoyee;
	}


	public void setEmphoyee(EmphoyeeModel emphoyee) {
		this.emphoyee = emphoyee;
	}


	public Double getValue() {
		return value;
	}


	public void setValue(Double value) {
		this.value = value;
	}


	public List<ExpenseModel> getExpenses() {
		return expenses;
	}


	public void setExpenses(List<ExpenseModel> expenses) {
		this.expenses = expenses;
	}


	public double getValueTotExpense() {
		return valueTotExpense;
	}


	public void setValueTotExpense(double valueTotExpense) {
		this.valueTotExpense = valueTotExpense;
	}


	public double getValueDelivered() {
		return valueDelivered;
	}


	public void setValueDelivered(double valueDelivered) {
		this.valueDelivered = valueDelivered;
	}


	public double getValueReturn() {
		return valueReturn;
	}


	public void setValueReturn(double valueReturn) {
		this.valueReturn = valueReturn;
	}
	
	public BoxOpeningModel getBoxOpening() {
		return boxOpening;
	}
	public void setBoxOpening(BoxOpeningModel boxOpening) {
		this.boxOpening = boxOpening;
	}


	@Override
	public String toString() {
		return "ExpenseModel [id=" + id + ", branche=" + branche + ", emphoyee=" + emphoyee + ", value=" + value
				+ ", expenses=" + expenses + ", valueTotExpense=" + valueTotExpense + ", valueDelivered="
				+ valueDelivered + ", valueReturn=" + valueReturn + "]";
	}


	@Override
	public int hashCode() {
		return Objects.hash(expenses, id, value, valueDelivered, valueReturn, valueTotExpense);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ExpenseModel other = (ExpenseModel) obj;
		return Objects.equals(expenses, other.expenses) && Objects.equals(id, other.id)
				&& Objects.equals(value, other.value)
				&& Double.doubleToLongBits(valueDelivered) == Double.doubleToLongBits(other.valueDelivered)
				&& Double.doubleToLongBits(valueReturn) == Double.doubleToLongBits(other.valueReturn)
				&& Double.doubleToLongBits(valueTotExpense) == Double.doubleToLongBits(other.valueTotExpense);
	}
	
	
	
	
	

}
