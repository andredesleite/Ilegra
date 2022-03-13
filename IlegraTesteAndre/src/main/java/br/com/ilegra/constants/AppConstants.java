package br.com.ilegra.constants;

import java.time.LocalDateTime;

public interface AppConstants {
    String DIRETORIO_HOME = System.getProperty("user.home");
    String DIRETORIO_PADRAO_LEITURA = "\\data\\in";
    String DIRETORIO_PADRAO_ESCRITA = "\\data\\out\\";
    String NOME_FILE_OUTPUT = "saida_"+LocalDateTime.now().getMonthValue() +"_" + LocalDateTime.now().getDayOfMonth() + ".dat";

    String VENDEDOR_CODE = "001";
    String CLIENTE_CODE = "002";
    String VENDA_CODE = "003";
}
