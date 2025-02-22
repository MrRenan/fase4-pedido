package br.com.fiap.fase4pedido.features.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pedido {

    private String id;
    private Cliente cliente;
    private List<Produto> produtos;
    private LocalDate dataCriacao;
    private Status status;
    private BigDecimal total;

}
