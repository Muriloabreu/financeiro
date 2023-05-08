package com.api.financeiro.serviceTest;

import org.junit.Ignore;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.api.financeiro.models.ExpenseTypeModel;
import com.api.financeiro.services.ExpenseTypeService;

@SpringBootTest
@RunWith(SpringRunner.class)
@WebAppConfiguration
public class ExpenseTypeTest {
	
	@Autowired
	ExpenseTypeService expenseTypeService;
	
	//@Test
	@Ignore
	public void save() {
		
		var expenseType01 = new ExpenseTypeModel();
		expenseType01.setName("Café Manhã - Terceiro");
		expenseType01.setValue(18.0);
		
		expenseTypeService.save(expenseType01);
		
	}

}
