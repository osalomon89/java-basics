package com.mercadolibre.tratamentoDeErros;

public class Indice {
    public class IndiceForaDosLimites {
        public static void main(String[] args) {
            try {
                int[] array = new int[]{2, 3, 7, 9, 8};
                System.out.println(array[6]);
            } catch (ArrayIndexOutOfBoundsException e){
                System.out.println("exceção de índice fora dos limites");
            }
        }
    }
}
