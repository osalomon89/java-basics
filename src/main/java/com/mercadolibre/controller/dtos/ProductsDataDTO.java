package com.mercadolibre.controller.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@Setter
@Getter
public class ProductsDataDTO {
    @JsonProperty("id_list")
    private List<Integer> idList;
    private double value;
}
