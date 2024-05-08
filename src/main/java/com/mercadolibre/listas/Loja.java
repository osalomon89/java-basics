package com.mercadolibre.listas;

import com.mercadolibre.heranca.Funcionario;

import java.util.ArrayList;
import java.util.List;

public class Loja {
    public static void main(String[] args){

        List<Produtos> produto = new ArrayList<>();
       Produtos chocolate = new Produtos(01, "chocolate", 7.00);
        Produtos bala = new Produtos(02, "bala", 0.10);
        Produtos chiclete = new Produtos(03, "chiclete", 0.20);

        produto.add(chiclete);
        produto.add(chocolate);
        produto.add(bala);

        produto.forEach();




    }
}
