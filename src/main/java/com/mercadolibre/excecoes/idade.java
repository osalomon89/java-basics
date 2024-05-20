package com.mercadolibre.excecoes;

import java.util.InputMismatchException;
import java.util.Scanner;

public class idade {
    public static void main (String [] args ){
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Digite su idade: ");
            int idade = scanner.nextInt();

            if (idade < 0 || idade > 120){
                throw new IdadeInvalidaException("error, idade invalida");
            }
        } catch (InputMismatchException e){
            System.out.println("valor invalido");
        } catch (IdadeInvalidaException e) {
            System.out.println(e.getMessage());
        }


        System.out.println("Fim");

        scanner.close();
    }
}
