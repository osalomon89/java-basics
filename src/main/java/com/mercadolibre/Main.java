package com.mercadolibre;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

// @SpringBootApplication
public class Main {
    public static void main(String[] args) {
        List<Product> items = new ArrayList<>();

        Product chocolate = new Product(1, "chocolate", 7.00);
        Product bala = new Product(2, "bala", 0.10);
        Product chiclete = new Product(3, "chiclete", 0.20);

        items.add(chiclete);
        items.add(chocolate);
        items.add(bala);

//        for (int i = 0; i < produtos.size(); i++) {
//            Produto elemento = produtos.get(i);
//            if (elemento.getPreco() >= valorMinimo){
//                System.out.println(elemento.getNome());
//            }
//        }

//        for (Product produto : produtos) {
//            System.out.println(produto.getName());
//        }

        System.out.println("++++++++++++++++++++++++++");

        System.out.println("---------Fin");
    }
}