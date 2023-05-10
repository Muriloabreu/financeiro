package com.api.financeiro.serviceTest;



import org.junit.Ignore;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.api.financeiro.models.BoxOpeningModel;
import com.api.financeiro.services.BoxOpeningService;

@SpringBootTest
@RunWith(SpringRunner.class)
@WebAppConfiguration
public class BoxOpeningTest {
	
	@Autowired
	BoxOpeningService boxOpeningService;
	
	//@Test
	@Ignore
	public void save() {
		
		var box01 = new BoxOpeningModel();
		//box01.setDate_first(LocalDate.of(2023, 5, 1));
		//box01.setDate_last(LocalDate.of(2023, 5, 10));
		box01.setValueOpening(10000.00);
		box01.setValue(0.0);
		
		
		boxOpeningService.save(box01);		
		
	}
	
	public void getAllBox() {
		
		
	}

}
