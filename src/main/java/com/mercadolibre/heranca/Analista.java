package com.mercadolibre.heranca;

public class Analista extends Funcionario{
    public String projeto;

    public Analista(String nome, double salario, String projeto) {
        super(nome, salario);
        this.projeto = projeto;
    }

    public String getProjeto() {
        return projeto;
    }

    public void setProjeto(String projeto) {
        this.projeto = projeto;
    }
}
