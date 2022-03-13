package br.com.ilegra.controller;

import br.com.ilegra.DTO.AnaliseDados;
import br.com.ilegra.constants.AppConstants;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Objects;
import java.util.stream.Stream;

public class LendoArquivos {
    private static final String SEPARADOR = "ç";

    public void obeterArquivosDoDiretorio(){
        EscreverArquivo escreverArquivo = new EscreverArquivo();

        String diretorio = AppConstants.DIRETORIO_HOME.concat(AppConstants.DIRETORIO_PADRAO_LEITURA);
        AnaliseDados analiseDados = new AnaliseDados();


        try(Stream<Path> paths = Files.walk(Paths.get(diretorio))){

            paths.filter(Files::isRegularFile)
                    .forEach(file -> {
                        try {
                            if(!file.endsWith(".dat")){
                                lerArquivo(file, analiseDados);
                                escreverArquivo.escreverArquivo(analiseDados);
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    });

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void lerArquivo(Path file, AnaliseDados analiseDados) throws IOException {
        BufferedReader buffRead = new BufferedReader(new FileReader(file.toString()));
        try (Stream<String> stream = Files.lines(Paths.get(String.valueOf(file)))) {
            stream.forEach( linha ->
            analiseCode(linha, analiseDados));
        }  catch (IOException e) {
            e.printStackTrace();
        }
        buffRead.close();

    }

    private void analiseCode (String linha, AnaliseDados analiseDados){
        LerVendedor lerVendedor = new LerVendedor();
        LerCliente lerCliente = new LerCliente();
        LerVendas lerVendas = new LerVendas();
        String[] linhaSplited = linha.split(SEPARADOR);

        switch (linhaSplited[0]) {
            case AppConstants.VENDEDOR_CODE:
                analiseDados.getVendedor()
                        .add(lerVendedor.lerVendedor(linhaSplited, analiseDados));
                break;
            case AppConstants.CLIENTE_CODE:
                analiseDados.getClientes()
                        .add(lerCliente.lerCliente(linhaSplited, analiseDados));
                break;
            case AppConstants.VENDA_CODE:
                analiseDados.getVendas()
                        .add(lerVendas.lerVendas(linhaSplited, analiseDados));
                break;
        }

    }


}
