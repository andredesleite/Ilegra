package br.com.ilegra.constants;

public enum CodeDados {

    VENDEDOR_CODE("001"),
    CLIENTE_CODE("002"),
    VENDA_CODE("003");


    private String code;

    CodeDados(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
