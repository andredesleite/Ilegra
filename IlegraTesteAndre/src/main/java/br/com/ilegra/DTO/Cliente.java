package br.com.ilegra.DTO;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Cliente {

    private String cnpj;
    private String name;
    private String bussinessArea;

}
