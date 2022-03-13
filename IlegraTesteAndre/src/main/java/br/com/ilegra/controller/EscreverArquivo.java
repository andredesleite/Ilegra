package br.com.ilegra.controller;

import br.com.ilegra.DTO.AnaliseDados;
import br.com.ilegra.DTO.Produto;
import br.com.ilegra.constants.AppConstants;

import java.io.*;
import java.util.Objects;

public class EscreverArquivo {

    public void escreverArquivo(AnaliseDados analiseDados) throws IOException {

        String diretorio = AppConstants.DIRETORIO_HOME.concat(AppConstants.DIRETORIO_PADRAO_ESCRITA).concat(AppConstants.NOME_FILE_OUTPUT);
        BufferedWriter writer = new BufferedWriter(new FileWriter(diretorio));

        if(Objects.nonNull(analiseDados.getClientes())){
            escrever(writer, quantidadeClientes(analiseDados));
        }
        if (analiseDados.getVendedor().size() > 0){
            escrever(writer, quantidadeVendedor(analiseDados));
        }
        if (analiseDados.getVendas().size() > 0){
            escrever(writer, idVendaMaisCara(analiseDados));
            escrever(writer, nomePiorVendedor(analiseDados));
        }
        writer.close();


    }

    public void escrever(BufferedWriter writer, String text) throws IOException {
        writer.write(text);
        writer.newLine();

    }

    public String quantidadeClientes (AnaliseDados analiseDados){
        return "Quantidade de clientes no arquivo de entrada: " + analiseDados.getClientes().stream().count();
    }

    public String quantidadeVendedor (AnaliseDados analiseDados){
        return "Quantidade de vendedor no arquivo de entrada: " + analiseDados.getClientes().stream().count();
    }

    public String idVendaMaisCara (AnaliseDados analiseDados){
        final String[] saleId = {""};
        final int[] valorTotal = {0};


        analiseDados.getVendas().stream().forEach(venda -> {
            int valorTotalTemp = 0;
            for (Produto produto : venda.getProdutos()) {
                valorTotalTemp = valorTotalTemp + produto.getItemPrice().intValue();

            }
            if(valorTotalTemp > valorTotal[0]){
                valorTotal[0] = valorTotalTemp;
                saleId[0] = venda.getSaleId();
            }
        });

        return "Quantidade de vendedor no arquivo de entrada: " + saleId[0];
    }

    public String nomePiorVendedor (AnaliseDados analiseDados){
        final String[] nome = {""};
        final int[] valorTotal = {0};

        analiseDados.getVendas().stream().forEach(venda -> {
            int valorTotalTemp = 0;
            for (Produto produto : venda.getProdutos()) {
                valorTotalTemp = valorTotalTemp + produto.getItemPrice().intValue();


            }
            if(valorTotal[0] == 0){
                valorTotal[0] = valorTotalTemp;
                nome[0] = venda.getSalesmanName();
            } else if(valorTotal[0] != 0 && valorTotalTemp < valorTotal[0]){
                valorTotal[0] = valorTotalTemp;
                nome[0] = venda.getSalesmanName();
            }
        });

        return "O pior vendedor: " + nome[0];
    }

}
