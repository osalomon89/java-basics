package com.mercadolibre;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

// @SpringBootApplication
public class Main {
    public static void main(String[] args) {
        System.out.println("Starting..........");

        Product chocolate = new Product(1, "chocolate", 7.00);
        Product ball = new Product(2, "bola", 0.10);
        Product tv = new Product(3, "tv", 0.20);

        double result = ball.calcularPrecioTotal(12);

        Product.calcularImpuestoEstatico(10, 5);

        System.out.println(chocolate.getPrice());
        chocolate.setPrice(9);
        chocolate.stock = 15;
        System.out.println(chocolate.getPrice());

        System.out.println("---------Fin");
    }
}