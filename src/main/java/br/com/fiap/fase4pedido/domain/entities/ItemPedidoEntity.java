package br.com.fiap.fase4pedido.domain.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "itens_pedido")
public class ItemPedidoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "pedido_id", nullable = false)
    private PedidoEntity pedidoEntity; // Nome do atributo: pedidoEntity (verifique a consistência!)

//    @ManyToOne
//    @JoinColumn(name = "produto_id", nullable = false)
    //private ProdutoEntity produtoEntity;

//    private Integer quantidade;
//
//Getters e Setters
    public Long getId() {
       return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PedidoEntity getPedido() {
        return pedidoEntity;
    }

    public void setPedido(PedidoEntity pedidoEntity) {
        this.pedidoEntity = pedidoEntity;
    }

//    public Produto getProduto() {
//        return produto;
//    }

//    public void setProduto(Produto produto) {
//        this.produto = produto;
//    }

//    public Integer getQuantidade() {
//        return quantidade;
//    }

//    public void setQuantidade(Integer quantidade) {
//        this.quantidade = quantidade;
//    }
}
