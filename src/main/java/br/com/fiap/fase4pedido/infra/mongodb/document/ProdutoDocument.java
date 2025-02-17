package br.com.fiap.fase4pedido.infra.mongodb.document;

import lombok.Builder;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@Builder
@Document(collection = "produto")
public class ProdutoDocument {
    private String id;
    private String nomeProduto;
    private BigDecimal preco;
    private int quantidade;

    public ProdutoDocument(String id, String nomeProduto, BigDecimal preco, int quantidade) {
        this.id = id;
        this.nomeProduto = nomeProduto;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    public String getId() { return id; }
    public String getNomeProduto() { return nomeProduto; }
    public BigDecimal getPreco() { return preco; }
    public int getQuantidade() { return quantidade; }

    protected void setId(String id) { this.id = id; }
    protected void setNomeProduto(String nomeProduto) { this.nomeProduto = nomeProduto; }
    protected void setPreco(BigDecimal preco) { this.preco = preco; }
    protected void setQuantidade(int quantidade) { this.quantidade = quantidade; }
}
