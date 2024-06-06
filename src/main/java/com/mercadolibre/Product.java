package com.mercadolibre;

public class Product {
    private int id;
    private String name;
    private double price;
    public int stock;

    public static double pi = 3.1415;

    public Product(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public static double calcularImpuestoEstatico(double precio, double tasaImpuesto) {
        return precio * (tasaImpuesto / 100.0);
    }

    public double calcularPrecioTotal(double tasaImpuesto) {
        double impuesto = price * (tasaImpuesto / 100.0);
        return price + impuesto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price < 0){

        }
        this.price = price;
    }
}
