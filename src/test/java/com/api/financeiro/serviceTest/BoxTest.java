package com.api.financeiro.serviceTest;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.api.financeiro.models.BoxOpeningModel;
import com.api.financeiro.models.EmphoyeeModel;
import com.api.financeiro.services.BoxOpeningService;

@SpringBootTest
@RunWith(SpringRunner.class)
@WebAppConfiguration
public class BoxTest {
	
	@Autowired
	BoxOpeningService boxOpeningService;
	
	@Test
	public void save() {
		var emphoyee01 = new EmphoyeeModel();
		emphoyee01.setId(1L);
		
		var box01 = new BoxOpeningModel();
		box01.setDate_first(LocalDateTime.of(2023, 05, 9, 9, 04, 00));
		box01.setValueOpening(1000.00);
		box01.setEmphoyee(emphoyee01);
		box01.setValue(0.0);
		
		boxOpeningService.save(box01);
		
		
		
	}
	

}
