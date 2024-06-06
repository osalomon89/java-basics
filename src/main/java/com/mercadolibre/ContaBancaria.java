package com.mercadolibre;

public class ContaBancaria {
    private int numeroConta;
    private double saldo;
    private String titular;

    public void depositar(double valor){

        saldo = saldo + valor;
    }
    public void sacar(double valor){

        saldo = saldo - valor;
    }
    public double verificarSaldo(){

        return saldo;
    }

    public ContaBancaria (int numeroDaConta, String nome, double saldoInicial){
         numeroConta = numeroDaConta;
         titular = nome;
         saldo = saldoInicial;
    }

    public int getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(int numeroConta) {
        this.numeroConta = numeroConta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }
}
