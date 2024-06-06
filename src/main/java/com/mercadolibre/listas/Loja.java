package com.mercadolibre.listas;

import java.util.ArrayList;
import java.util.List;

public class Loja {
    public static void main(String[] args){

        List<Produto> produtos = new ArrayList<>();

        Produto chocolate = new Produto("chocolate", 7.00);
        Produto bala = new Produto("bala", 0.10);
        Produto chiclete = new Produto("chiclete", 0.20);

        produtos.add(chiclete);
        produtos.add(chocolate);
        produtos.add(bala);

        double valorMinimo = 0.15;

//        for (int i = 0; i < produtos.size(); i++) {
//            Produto elemento = produtos.get(i);
//            if (elemento.getPreco() >= valorMinimo){
//                System.out.println(elemento.getNome());
//            }
//        }

        for (Produto produto : produtos) {
            System.out.println(produto.getNome());
        }

        System.out.println("++++++++++++++++++++++++++");

        for (int i = 0; i < produtos.size(); i++) {
            if (produtos.get(i).getPreco() < valorMinimo){
                produtos.remove(i);
            }
        }

        for (int i = 0; i < produtos.size(); i++) {
            System.out.println(produtos.get(i).getNome());
        }

        System.out.println("---------Fin");

    }
}

