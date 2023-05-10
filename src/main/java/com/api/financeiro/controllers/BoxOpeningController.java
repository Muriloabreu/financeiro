package com.api.financeiro.controllers;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.financeiro.dtos.BoxOpeningDtos;
import com.api.financeiro.models.BoxOpeningModel;
import com.api.financeiro.services.BoxOpeningService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("financeiro/box")
public class BoxOpeningController {
	
	@Autowired
	BoxOpeningService boxOpeningService;
	
	
	@PostMapping
	public ResponseEntity<Object> saveBoxOpening(@RequestBody @Valid BoxOpeningDtos boxOpeningDtos){
		
		
				
		var boxOpeningModel = new BoxOpeningModel();
		BeanUtils.copyProperties(boxOpeningDtos, boxOpeningModel);
		boxOpeningModel.setValue(0.0);
		boxOpeningModel.setDate_last(null);
		
		return ResponseEntity.status(HttpStatus.OK).body(boxOpeningService.save(boxOpeningModel));		
		
	}
	
	@GetMapping
	public ResponseEntity<List<BoxOpeningModel>> getAllBoxOpening(){
		
		return ResponseEntity.status(HttpStatus.OK).body(boxOpeningService.findAll());
	}

}
