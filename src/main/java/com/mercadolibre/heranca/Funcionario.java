package com.mercadolibre.heranca;

public class Funcionario {
    public String nome;
    public double salario;

    public Funcionario (String nome, double salario) {
        this.nome = nome;
        this.salario = salario;
    }

    public void aumentarSalario(double percentual){
        salario = salario + ((percentual/100)*salario);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
}
