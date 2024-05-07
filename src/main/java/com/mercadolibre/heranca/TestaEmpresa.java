package com.mercadolibre.heranca;

import java.util.ArrayList;
import java.util.List;

public class TestaEmpresa {
    public static void main(String[] args){
        List<Funcionario> funcionarios = new ArrayList<>();
        Gerente gerente = new Gerente("João",500.00,"TI");
        Analista analista = new Analista("josé", 200.00,"novo site");
        funcionarios.add(gerente);
        funcionarios.add(analista);

        analista.aumentarSalario(10);
        gerente.aumentarSalario(10);

        for (int i = 0; i<funcionarios.size(); i++){
            var funcionario = funcionarios.get(i);
            System.out.println(funcionario.getNome() + " " + funcionario.getSalario());
        }

       // System.out.println(analista.getNome() +" "+ analista.getSalario()+" "+ analista.getProjeto());
     // System.out.println(gerente.getNome() +" "+ gerente.getSalario()+" "+ gerente.getDepartamento());
    }
}
