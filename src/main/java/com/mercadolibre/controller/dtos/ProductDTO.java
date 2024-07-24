package com.mercadolibre.controller.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductDTO {
	@NotNull
	@NotEmpty
	private String code;

	@NotNull
	@NotEmpty
	@Size(min = 5, max = 50)
	private String description;

	@NotNull
	@NotEmpty
	private String type;

	@NotNull
	@JsonProperty("provider_id")
	private int providerId;

	@NotNull
	private double price;

	private int stock;
}



