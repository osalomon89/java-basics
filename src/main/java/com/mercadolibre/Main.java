package com.mercadolibre;

public class Main {
    public static void main(String[] args) {
        Pessoa rafa = new Pessoa("Rafa", 26, "Rafaela@rafa.com");
        System.out.println("titular " + rafa.getNome());
        System.out.println("idade " + rafa.getIdade());
        System.out.println("email " + rafa.getEmail());

        ContaBancaria c1 = new ContaBancaria(1, "Rafa", 1.50);
        System.out.println("saldo inicial "+ c1.verificarSaldo());
        c1.sacar(1);
        c1.depositar(3.75);
        System.out.println("saldo final "+ c1.verificarSaldo());
    }
}