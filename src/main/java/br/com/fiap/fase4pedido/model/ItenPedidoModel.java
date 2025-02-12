package br.com.fiap.fase4pedido.model;

import jakarta.persistence.*;
import org.hibernate.annotations.ColumnTransformer;

import java.math.BigDecimal;
import java.util.UUID; // Import UUID if you're using it as the ID type

@Entity
@Table(name = "itens_pedido") // Good practice to specify table name
public class ItenPedidoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // Or GenerationType.UUID if you prefer
    private Long id;

    private Long idProduct; // Use UUID if your product IDs are UUIDs

    private BigDecimal quantidade;

    @ManyToOne
    @JoinColumn(name = "pedido_id")

    private PedidoModel pedido; // This is the correct placement for the @ManyToOne

    public ItenPedidoModel() {
        super();
    }

    public ItenPedidoModel(Long idProduct, BigDecimal quantidade) { // Use UUID for idProduct if it's a UUID
        this.idProduct = idProduct;
        this.quantidade = quantidade;


    }
    @ColumnTransformer(read = "id_product::bigint", write = "?::bigint") // Adicione isso
    @Column(name = "id_product") // Certifique-se que o nome da coluna está correto.
    private Long id_product; // Ou o tipo correto para id_product

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public Long getIdProduct() {  // Corrected getter name and return type
        return idProduct;
    }

    public void setIdProduct(Long idProduct) {
        this.idProduct = idProduct;
    }

    public BigDecimal getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(BigDecimal quantidade) {
        this.quantidade = quantidade;
    }

    public PedidoModel getPedido() { // Added getter for pedido
        return pedido;
    }

    public void setPedido(PedidoModel pedido) { // Added setter for pedido
        this.pedido = pedido;
    }
}