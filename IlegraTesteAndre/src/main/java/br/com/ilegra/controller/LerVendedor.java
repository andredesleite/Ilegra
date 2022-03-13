package br.com.ilegra.controller;

import br.com.ilegra.DTO.AnaliseDados;
import br.com.ilegra.DTO.Vendedor;

import java.math.BigDecimal;

public class LerVendedor {

    public Vendedor lerVendedor(String[] linhaSplited, AnaliseDados analiseDados){

        Vendedor vendedor = Vendedor.builder()
                .cpf(linhaSplited[1])
                .name(linhaSplited[2])
                .salary(BigDecimal.valueOf(Double.valueOf(linhaSplited[3])))
                .build();

        return vendedor;

    }

}
