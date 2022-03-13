package br.com.ilegra.DTO;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Vendedor {

    private String cpf;
    private String name;
    private BigDecimal salary;

}
