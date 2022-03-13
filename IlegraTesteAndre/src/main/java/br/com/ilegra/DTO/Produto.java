package br.com.ilegra.DTO;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Produto {

    private Long itemId;
    private Long itemQuantity;
    private BigDecimal itemPrice;
}
