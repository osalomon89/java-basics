package com.mercadolibre.excecoes;

// Main.java
public class Main {
    public static void main(String[] args) {
        Estoque estoque = new Estoque();
        try {
            estoque.adicionarProduto("Maçã", 50, 2.5);
            estoque.adicionarProduto("Banana", 30, 1.8);
        } catch (ProdutoInvalidoException e) {
            System.out.println("Erro ao adicionar produto: " + e.getMessage());
        }

        try {
            estoque.adicionarProduto(null, 30, 1.8);
        } catch (ProdutoInvalidoException e) {
            System.out.println("Erro ao adicionar produto: " + e.getMessage());
        }
        try {
            estoque.adicionarProduto("Laranja", -10, 1.5);
        } catch (ProdutoInvalidoException e) {
            System.out.println("Erro ao adicionar produto: " + e.getMessage());
        }
    }
}

