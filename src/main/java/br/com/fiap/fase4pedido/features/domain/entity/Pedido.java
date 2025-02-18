package br.com.fiap.fase4pedido.features.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@RequiredArgsConstructor
@Data
@AllArgsConstructor
public class Pedido {

    private Cliente cliente;
    private List<Produto> produtos;
    private LocalDate dataCriacao;
    private Status status;
    private BigDecimal total;

}
