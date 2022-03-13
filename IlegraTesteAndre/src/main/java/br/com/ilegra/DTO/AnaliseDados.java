package br.com.ilegra.DTO;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AnaliseDados {

    private List<Cliente> clientes = new ArrayList<>();
    private List<Venda> vendas = new ArrayList<>();
    private List<Vendedor> vendedor = new ArrayList<>();

}
