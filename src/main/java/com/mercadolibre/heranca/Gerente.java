package com.mercadolibre.heranca;

public class Gerente extends Funcionario{
public String departamento;
    public Gerente(String departamento){
        super();
        this.departamento = departamento;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }
}
