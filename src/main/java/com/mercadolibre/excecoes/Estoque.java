package com.mercadolibre.excecoes;

import java.util.HashMap;
public class Estoque {
    private HashMap<String, HashMap<String, Object>> produtos;

    public Estoque() {
        produtos = new HashMap<>();
    }
    public void adicionarProduto(String nome, int quantidade, double precoUnitario) throws ProdutoInvalidoException {
        if (nome == null || nome.trim().isEmpty() || quantidade < 0 || precoUnitario < 0) {
            throw new ProdutoInvalidoException("Produto inválido.");
        } else {
            HashMap<String, Object> produto = new HashMap<>();
            produto.put("quantidade", quantidade);
            produto.put("preco_unitario", precoUnitario);
            produtos.put(nome, produto);
            System.out.println("Produto '" + nome + "' adicionado ao estoque.");
        }
    }
}
