package br.com.fiap.fase4pedido.infra.mongodb.document;

import lombok.Builder;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Builder
@Document(collection = "pedido")
public class PedidoDocument {
    private ClienteDocument cliente;
    private List<ProdutoDocument> produtos;
    private LocalDate dataCriacao;
    private String status;
    private BigDecimal total;

    public PedidoDocument(ClienteDocument cliente, List<ProdutoDocument> produtos, LocalDate dataCriacao, String status, BigDecimal total) {
        this.cliente = cliente;
        this.produtos = produtos;
        this.dataCriacao = dataCriacao;
        this.status = status;
        this.total = total;
    }

    public ClienteDocument getCliente() { return cliente; }
    public List<ProdutoDocument> getProdutos() { return produtos; }
    public LocalDate getDataCriacao() { return dataCriacao; }
    public String getStatus() { return status; }
    public BigDecimal getTotal() { return total; }

    protected void setCliente(ClienteDocument cliente) { this.cliente = cliente; }
    protected void setProdutos(List<ProdutoDocument> produtos) { this.produtos = produtos; }
    protected void setDataCriacao(LocalDate dataCriacao) { this.dataCriacao = dataCriacao; }
    protected void setStatus(String status) { this.status = status; }
    protected void setTotal(BigDecimal total) { this.total = total; }

    public static class ClienteDocument {
        private String id;
        private String nome;

        public ClienteDocument(String id, String nome) {
            this.id = id;
            this.nome = nome;
        }

        public String getId() { return id; }
        public String getNome() { return nome; }

        protected void setId(String id) { this.id = id; }
        protected void setNome(String nome) { this.nome = nome; }
    }
}
