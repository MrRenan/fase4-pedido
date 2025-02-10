package br.com.fiap.fase4pedido.domain.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "pedidos")
public class PedidoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "data_pedido")
    private LocalDateTime dataPedidoEntity;

    @Enumerated(EnumType.STRING)
    private StatusPedido status;

    @OneToMany(mappedBy = "pedidoEntity", cascade = CascadeType.ALL) // mappedBy: pedidoEntity (verifique a consistência!)
    private List<ItemPedidoEntity> itens;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

//    public ClienteEntity getClienteEntity() {
//        return clienteEntity;
//    }
//
//    public void setClienteEntity(ClienteEntity clienteEntity) {
//        this.clienteEntity = clienteEntity;
//    }

    public LocalDateTime getDataPedidoEntity() {
        return dataPedidoEntity;
    }

    public void setDataPedidoEntity(LocalDateTime dataPedidoEntity) {
        this.dataPedidoEntity = dataPedidoEntity;
    }

    public StatusPedido getStatus() {
        return status;
    }

    public void setStatus(StatusPedido status) {
        this.status = status;
    }

    public List<ItemPedidoEntity> getItens() {
        return itens;
    }

    public void setItens(List<ItemPedidoEntity> itens) {
        this.itens = itens;
    }
}
