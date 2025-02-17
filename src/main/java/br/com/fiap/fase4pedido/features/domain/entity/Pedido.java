package br.com.fiap.fase4pedido.features.domain.entity;

import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@RequiredArgsConstructor
public class Pedido {
    private Cliente cliente;
    private List<Produto> produtos;
    private LocalDate dataCriacao;
    private Status status;
    private BigDecimal total;

    public Pedido(Cliente cliente, List<Produto> produtos, LocalDate dataCriacao, Status status, BigDecimal total) {
        this.cliente = cliente;
        this.produtos = produtos;
        this.dataCriacao = dataCriacao;
        this.status = status;
        this.total = total;
    }

    public Cliente getCliente() { return cliente; }
    public List<Produto> getProdutos() { return produtos; }
    public LocalDate getDataCriacao() { return dataCriacao; }
    public Status getStatus() { return status; }
    public BigDecimal getTotal() { return total; }

    public void setCliente(Cliente cliente) { this.cliente = cliente; }
    public void setProdutos(List<Produto> produtos) { this.produtos = produtos; }
    public void setDataCriacao(LocalDate dataCriacao) { this.dataCriacao = dataCriacao; }
    public void setStatus(Status status) { this.status = status; }
    public void setTotal(BigDecimal total) { this.total = total; }
}
