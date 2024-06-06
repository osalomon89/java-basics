package com.mercadolibre.tratamentoDeErros;

public class DivisaoPorZero {
    public void realizarDivisao(int dividendo, int divisor) {
        if (divisor == 0) {
            throw new ArithmeticException("Divisão por zero!");
        }

        double resultado = dividendo / divisor;
        System.out.println("Resultado da divisão: " + resultado);
    }

}
