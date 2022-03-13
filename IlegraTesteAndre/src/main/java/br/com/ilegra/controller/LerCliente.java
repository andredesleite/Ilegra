package br.com.ilegra.controller;

import br.com.ilegra.DTO.AnaliseDados;
import br.com.ilegra.DTO.Cliente;

import java.math.BigDecimal;

public class LerCliente {

    public Cliente lerCliente(String[] linhaSplited, AnaliseDados analiseDados){

        Cliente cliente = Cliente.builder()
                .cnpj(linhaSplited[1])
                .name(linhaSplited[2])
                .bussinessArea(linhaSplited[3])
                .build();

        return cliente;

    }
}


