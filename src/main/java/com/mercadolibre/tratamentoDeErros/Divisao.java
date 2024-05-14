package com.mercadolibre.tratamentoDeErros;

import java.util.Scanner;

public class Divisao {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            System.out.print("Digite dividendo: ");
            int numero1 = scanner.nextInt();

            System.out.print("Digite o divisor: ");
            int numero2 = scanner.nextInt();

            DivisaoPorZero divisaoPorZero = new DivisaoPorZero();

            divisaoPorZero.realizarDivisao(numero1, numero2);

            scanner.close();
        }
    }

