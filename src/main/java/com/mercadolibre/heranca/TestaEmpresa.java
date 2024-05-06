package com.mercadolibre.heranca;

import java.util.ArrayList;
import java.util.List;

public class TestaEmpresa {
    public static void main(String[] args){
        List<Funcionario> funcionarios = new ArrayList<>();
        Funcionario funcionario = new Funcionario("joão", 500.00);
        Gerente gerente = new Gerente("TI");
        Analista analista = new Analista("Novo site");
        funcionarios.add(gerente);
        funcionarios.add(analista);
        funcionarios.add(funcionario);
        

        System.out.println(funcionarios);
    }
}
