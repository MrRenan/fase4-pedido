package br.com.fiap.fase4pedido.infra.restapi.v1.model;

import lombok.Builder;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Builder
public class PedidoResponse {

    private Cliente cliente;
    private List<Produto> produtos;
    private LocalDate dataCriacao;
    private Status status;
    private BigDecimal total;

    // Construtores
    public PedidoResponse() {}

    public PedidoResponse(Cliente cliente, List<Produto> produtos, LocalDate dataCriacao, Status status, BigDecimal total) {
        this.cliente = cliente;
        this.produtos = produtos;
        this.dataCriacao = dataCriacao;
        this.status = status;
        this.total = total;
    }

    // Getters e Setters
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

    // Classe Cliente
    public static class Cliente {
        private String id;
        private String nome;

        // Construtores
        public Cliente() {}

        public Cliente(String id, String nome) {
            this.id = id;
            this.nome = nome;
        }

        // Getters e Setters
        public String getId() { return id; }
        public String getNome() { return nome; }

        public void setId(String id) { this.id = id; }
        public void setNome(String nome) { this.nome = nome; }
    }

    // Classe Produto
    public static class Produto {
        private String id;
        private String nomeProduto;
        private BigDecimal preco;
        private int quantidade;

        // Construtores
        public Produto() {}

        public Produto(String id, String nomeProduto, BigDecimal preco, int quantidade) {
            this.id = id;
            this.nomeProduto = nomeProduto;
            this.preco = preco;
            this.quantidade = quantidade;
        }

        // Getters e Setters
        public String getId() { return id; }
        public String getNomeProduto() { return nomeProduto; }
        public BigDecimal getPreco() { return preco; }
        public int getQuantidade() { return quantidade; }

        public void setId(String id) { this.id = id; }
        public void setNomeProduto(String nomeProduto) { this.nomeProduto = nomeProduto; }
        public void setPreco(BigDecimal preco) { this.preco = preco; }
        public void setQuantidade(int quantidade) { this.quantidade = quantidade; }
    }
}
