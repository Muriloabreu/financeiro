package com.api.financeiro.dtos;

import java.time.LocalDateTime;
import com.api.financeiro.models.EmphoyeeModel;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;



public class BoxOpeningDtos {
	
	
	@NotNull
	private LocalDateTime date_first;
	@NotNull
	private Double valueOpening;
	@NotNull
	private EmphoyeeModel emphoyee;
	
	public BoxOpeningDtos() {
		
	}

	public BoxOpeningDtos(@NotNull LocalDateTime date_first, @NotNull Double valueOpening,
			@NotNull EmphoyeeModel emphoyee) {
		super();
		this.date_first = date_first;
		this.valueOpening = valueOpening;
		this.emphoyee = emphoyee;
	}

	public LocalDateTime getDate_first() {
		return date_first;
	}

	public void setDate_first(LocalDateTime date_first) {
		this.date_first = date_first;
	}

	public Double getValueOpening() {
		return valueOpening;
	}

	public void setValueOpening(Double valueOpening) {
		this.valueOpening = valueOpening;
	}

	public EmphoyeeModel getEmphoyee() {
		return emphoyee;
	}

	public void setEmphoyee(EmphoyeeModel emphoyee) {
		this.emphoyee = emphoyee;
	}
	
	

}
