package br.com.ilegra.controller;

import br.com.ilegra.DTO.AnaliseDados;
import br.com.ilegra.DTO.Produto;
import br.com.ilegra.DTO.Venda;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LerVendas {
    private static final String SEPARADOR_PRODUTO = ",";

    public Venda lerVendas(String[] linhaSplited, AnaliseDados analiseDados){
        
        Venda venda = Venda.builder()
                .saleId(linhaSplited[1])
                .produtos(lerProdutos(Arrays.asList(linhaSplited[2].split(SEPARADOR_PRODUTO))))
                .salesmanName(linhaSplited[3])
                .build();
        
        
        
        return venda;

    }
    
    public List<Produto> lerProdutos(List<String> produtos){
        
        List<Produto> listaProdutos = new ArrayList<Produto>();

        produtos.stream().forEach((value) -> {
            List<String> produtoSplited = Arrays.asList(value.split("-"));
            listaProdutos.add(
                    Produto.builder()
                            .itemId(Long.parseLong(produtoSplited.get(0).replace("[", "")))
                            .itemQuantity(Long.parseLong(produtoSplited.get(1)))
                            .itemPrice(BigDecimal.valueOf(Double.valueOf(produtoSplited.get(2).replace("]", ""))))
                            .build()
            );
        });

        return listaProdutos;
    }
}
