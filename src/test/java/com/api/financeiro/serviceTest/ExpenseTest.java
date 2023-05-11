package com.api.financeiro.serviceTest;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.Ignore;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.api.financeiro.models.BoxOpeningModel;
import com.api.financeiro.models.BranchModel;
import com.api.financeiro.models.EmphoyeeModel;
import com.api.financeiro.models.ExpenseModel;
import com.api.financeiro.models.ExpenseTypeModel;
import com.api.financeiro.services.ExpenseService;

@SpringBootTest
@RunWith(SpringRunner.class)
@WebAppConfiguration
public class ExpenseTest {
	
	@Autowired
	ExpenseService expenseService;
	
	
	
	//@Test
	@Ignore
	public void save() {
		var expense01 = new ExpenseModel();
		
		var emphoyee01 = new EmphoyeeModel();
		emphoyee01.setId(1L);
		
		var branche01 = new BranchModel();
		branche01.setId(1L);
		
		var box = new BoxOpeningModel();
		box.setId(1L);
		box.setValueOpening(1000.0);
		box.setDate_first(LocalDateTime.of(2023, 05, 10, 7, 30, 00));
		box.setValue(0.0);
		
		
		//for(int pos = 0; pos < 1; pos ++) {
			
			var expenseType01 = new ExpenseTypeModel();
			expenseType01.setName("Almoço casa");
			expenseType01.setValue(30.0);
			
			var expenseType02 = new ExpenseTypeModel();
			expenseType02.setName("Almoço terceiro");
			expenseType02.setValue(25.0);
			
			//}
			
		expense01.setBranche(branche01);
		expense01.setEmphoyee(emphoyee01);
		expense01.setBoxOpening(box);
		expense01.setValueDelivered(150.0);
		expense01.getExpensesTypes().add(expenseType01);
		expense01.getExpensesTypes().add(expenseType02);
		expense01.setValueTotExpenseType(expense01.getValueTotExpenseType());
		expense01.setValueReturn(expense01.getValueReturn());
		
		System.out.println("=======================================");
		System.out.println();
		System.out.println(expense01);
		System.out.println();
		System.out.println("Total de lançamentos: " + expense01.getValueTotExpenseType());
		System.out.println("Troco: "+ expense01.getValueReturn());
		System.out.println();
		System.out.println("=======================================");
		
		
		
		
	}

}
