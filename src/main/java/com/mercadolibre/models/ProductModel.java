package com.mercadolibre.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "TB-PRODUCTS")


public class ProductModel extends RepresentationModel<ProductModel> implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter
    @Setter
    private UUID idProduto;
    private String nome;
    private BigDecimal valor;
    private int quantidade;
    private String descricao;

}
