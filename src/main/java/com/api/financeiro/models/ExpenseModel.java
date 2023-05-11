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
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
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
	@OneToOne
	@JoinColumn(name = "id_box_opening", referencedColumnName = "id")
	private BoxOpeningModel boxOpening;
	@OneToMany
	@JoinColumn(name = "id_expense")
	private List<ExpenseTypeModel> expensesTypes = new ArrayList<>();
	@Column(nullable = false)
	private double valueTotExpenseType;
	@Column(nullable = false)
	private double valueDelivered;
	@Column(nullable = false)
	private double valueReturn;
	@Column(nullable = false)
	private boolean statusValueReturn;
	
	
	/* Constructor */
	
	public ExpenseModel() {
		
	}

	public ExpenseModel(Long id, BranchModel branche, EmphoyeeModel emphoyee, BoxOpeningModel boxOpening,
			List<ExpenseTypeModel> expensesTypes, double valueTotExpenseType, double valueDelivered, double valueReturn,
			boolean statusValueReturn) {
		super();
		this.id = id;
		this.branche = branche;
		this.emphoyee = emphoyee;
		this.boxOpening = boxOpening;
		this.expensesTypes = expensesTypes;
		this.valueTotExpenseType = valueTotExpenseType;
		this.valueDelivered = valueDelivered;
		this.valueReturn = valueReturn;
		this.statusValueReturn = statusValueReturn;
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
	public List<ExpenseTypeModel> getExpensesTypes() {
		return expensesTypes;
	}

	public void setExpensesTypes(List<ExpenseTypeModel> expensesTypes) {
		this.expensesTypes = expensesTypes;
	}

	public double getValueTotExpenseType() {
		
		double TotExpenseTypes = 0.0;

		for (ExpenseTypeModel expenseType : expensesTypes) {

			TotExpenseTypes += expenseType.getValue();
		}
		
		return TotExpenseTypes;
	}

	public void setValueTotExpenseType(double valueTotExpenseType) {
		this.valueTotExpenseType = valueTotExpenseType;
	}

	public double getValueDelivered() {
		return valueDelivered;
	}

	public void setValueDelivered(double valueDelivered) {
		this.valueDelivered = valueDelivered;
	}

	public double getValueReturn() {
		
		double totValueReturn = 0.0;
		
		if(getValueDelivered() > 0 ) {
			
			if(getValueTotExpenseType() < getValueDelivered()) {
				
				totValueReturn = getValueDelivered() - getValueTotExpenseType();
			}			
		}
				
		
		return totValueReturn;
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

	public boolean isStatusValueReturn() {
		return statusValueReturn;
	}

	public void setStatusValueReturn(boolean statusValueReturn) {
		this.statusValueReturn = statusValueReturn;
	}

	@Override
	public String toString() {
		return "ExpenseModel [id=" + id + ", branche=" + branche + ", emphoyee=" + emphoyee + ", boxOpening="
				+ boxOpening + ", expensesTypes=" + expensesTypes + ", valueTotExpenseType=" + valueTotExpenseType
				+ ", valueDelivered=" + valueDelivered + ", valueReturn=" + valueReturn + ", statusValueReturn="
				+ statusValueReturn + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(boxOpening, branche, emphoyee, expensesTypes, id, statusValueReturn, valueDelivered,
				valueReturn, valueTotExpenseType);
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
		return Objects.equals(boxOpening, other.boxOpening) && Objects.equals(branche, other.branche)
				&& Objects.equals(emphoyee, other.emphoyee) && Objects.equals(expensesTypes, other.expensesTypes)
				&& Objects.equals(id, other.id) && statusValueReturn == other.statusValueReturn
				&& Double.doubleToLongBits(valueDelivered) == Double.doubleToLongBits(other.valueDelivered)
				&& Double.doubleToLongBits(valueReturn) == Double.doubleToLongBits(other.valueReturn)
				&& Double.doubleToLongBits(valueTotExpenseType) == Double.doubleToLongBits(other.valueTotExpenseType);
	}

	
	

	

	
	


	
	
	
	
	
	

}
