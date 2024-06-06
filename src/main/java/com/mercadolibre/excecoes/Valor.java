package com.mercadolibre.excecoes;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Valor {
    public static void main (String [] args ) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Digite um numero: ");
            int numero = scanner.nextInt();

            if (numero < 0) {
                throw new ValorNegativoException("erro, numero negativo");
            } else {
                System.out.println(numero);
            }
            scanner.close();
        }finally {

        }
    }
}
