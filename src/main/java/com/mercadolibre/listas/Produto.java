package com.mercadolibre.listas;

public class Produto {
        private static int quat = 0;
        private int id;
        private String nome;
        private double preco;


        public Produto(String nome, double preco) {
            this.quat++;
            this.id = quat;
            this.nome = nome;
            this.preco = preco;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        public double getPreco() {
            return preco;
        }

        public void setPreco(double preco) {
            this.preco = preco;
        }
    }

