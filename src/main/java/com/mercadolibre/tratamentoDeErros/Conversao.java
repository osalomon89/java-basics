package com.mercadolibre.tratamentoDeErros;

import java.util.Scanner;

public class Conversao {
        public void main(String[] args) {
            try (Scanner scanner = new Scanner(System.in)) {
                System.out.print("Digite um número inteiro: ");
                String entrada = scanner.nextLine();

                try {
                    double numero = Double.parseDouble(entrada);
                    System.out.println("Número decimal digitado: " + numero);
                } catch (NumberFormatException e) {
                    System.out.println("Erro: Entrada inválida. Por favor, insira um número válido.");
                }
            }
        }
    }
