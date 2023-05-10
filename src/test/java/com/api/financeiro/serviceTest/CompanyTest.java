package com.api.financeiro.serviceTest;

import java.util.List;
import java.util.Optional;

import org.junit.Ignore;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.api.financeiro.models.CompanyModel;
import com.api.financeiro.services.CompanyService;

@SpringBootTest
@RunWith(SpringRunner.class)
@WebAppConfiguration
public class CompanyTest {

	@Autowired
	CompanyService companyService;

	//@Test
	@Ignore
	public void saveCompany() {

		var company01 = new CompanyModel();
		company01.setCorporate_name("Company 02 EIRELI");
		company01.setfantasy_name("Padaria PÂO MASSA");
		company01.setCnpj("001.001.00001-01");

		companyService.save(company01);

	}

	// @Test
	@Ignore
	public void getAllCompanyTes() {

		List<CompanyModel> companys = companyService.findAll();

		for (CompanyModel companyModel : companys) {
			System.out.println("==============================================================");
			System.out.println(" Corporate_name: " + companyModel.getCorporate_name());
			System.out.println(" Fantasy_name: " + companyModel.getfantasy_name());
			System.out.println(" CNPJ: " + companyModel.getCnpj());

			System.out.println();

		}

	}
	
	
	//@Test
	@Ignore
	public void getOneCompanyTest() {
		Long id = 2L;
		
		
		Optional<CompanyModel> company = companyService.findById(id);
		
		System.out.println("==============================================================");
		System.out.println(" Corporate_name: " + company.toString());
		
		System.out.println();
		
		
		
		
		
	}

}
