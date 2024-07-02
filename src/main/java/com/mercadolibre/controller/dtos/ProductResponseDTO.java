package com.mercadolibre.controller.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductResponseDTO {
	private Integer id;
	private String code;
	private String description;
	private String type;

	@JsonProperty("provider_id")
	private int providerId;

	private int stock;

	@JsonProperty("created_at")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "UTC")
	private Date createdAt;

	@JsonProperty("updated_at")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "UTC")
	private Date updatedAt;
}



