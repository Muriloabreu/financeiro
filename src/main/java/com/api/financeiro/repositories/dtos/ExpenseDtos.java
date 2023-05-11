package com.api.financeiro.dtos;

import java.util.List;

import com.api.financeiro.models.BoxOpeningModel;
import com.api.financeiro.models.BranchModel;
import com.api.financeiro.models.EmphoyeeModel;
import com.api.financeiro.models.ExpenseModel;

import jakarta.validation.constraints.NotNull;

public class ExpenseDtos {
	
	@NotNull
	private BranchModel branche;
	@NotNull
	private EmphoyeeModel emphoyee;
	@NotNull
	private List<ExpenseTypeDtos> expensesTypes;
	@NotNull
	private BoxOpeningModel boxOpening;
	
	private double valueDelivered;

	public ExpenseDtos() {
		
	}

	public ExpenseDtos(@NotNull BranchModel branche, @NotNull EmphoyeeModel emphoyee,
			@NotNull List<ExpenseTypeDtos> expensesTypes,BoxOpeningModel boxOpening, double valueDelivered) {
		super();
		this.branche = branche;
		this.emphoyee = emphoyee;
		this.expensesTypes = expensesTypes;
		this.boxOpening = boxOpening;
		this.valueDelivered = valueDelivered;
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

	public List<ExpenseTypeDtos> getExpensesTypes() {
		return expensesTypes;
	}
	public void setExpensesTypes(List<ExpenseTypeDtos> expensesTypes) {
		this.expensesTypes = expensesTypes;
	}

	public double getValueDelivered() {
		return valueDelivered;
	}

	public void setValueDelivered(double valueDelivered) {
		this.valueDelivered = valueDelivered;
	}
	
	public BoxOpeningModel getBoxOpening() {
		return boxOpening;
	}
	
	public void setBoxOpening(BoxOpeningModel boxOpening) {
		this.boxOpening = boxOpening;
	}
	

}
