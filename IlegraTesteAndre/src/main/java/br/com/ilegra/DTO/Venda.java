package br.com.ilegra.DTO;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Venda {

    private String saleId;
    private List<Produto> produtos;
    private String salesmanName;

}
