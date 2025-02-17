package br.com.fiap.fase4pedido.features.domain.entity;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Data
@RequiredArgsConstructor
public class Pedido {

    private Cliente cliente;
    private List<Produto> produtos;
    LocalDate dataCriacao;
    Status status;
    BigDecimal total;

}