package br.com.fiap.fase4pedido.infra.restapi.v1.model;

import java.math.BigDecimal;
import java.util.List;

public class PedidoRequest {
    private String clienteId;
    private List<ProdutoRequest> produtos;
    private String status;

    public PedidoRequest() {}

    public PedidoRequest(String clienteId, List<ProdutoRequest> produtos, String status) {
        this.clienteId = clienteId;
        this.produtos = produtos;
        this.status = status;
    }

    public String getClienteId() { return clienteId; }
    public List<ProdutoRequest> getProdutos() { return produtos; }
    public String getStatus() { return status; }

    public void setClienteId(String clienteId) { this.clienteId = clienteId; }
    public void setProdutos(List<ProdutoRequest> produtos) { this.produtos = produtos; }
    public void setStatus(String status) { this.status = status; }

    public static class ProdutoRequest {
        private String id;
        private String nomeProduto;
        private BigDecimal preco;
        private int quantidade;

        public ProdutoRequest() {}

        public ProdutoRequest(String id, String nomeProduto, BigDecimal preco, int quantidade) {
            this.id = id;
            this.nomeProduto = nomeProduto;
            this.preco = preco;
            this.quantidade = quantidade;
        }

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
