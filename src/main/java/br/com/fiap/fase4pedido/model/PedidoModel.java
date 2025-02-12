package br.com.fiap.fase4pedido.model;

import jakarta.persistence.*;
import org.hibernate.annotations.ColumnTransformer;
import org.hibernate.cache.spi.support.AbstractReadWriteAccess;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

import jakarta.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "pedidos")
public class PedidoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long clienteId;

    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ItenPedidoModel> itens;

    public PedidoModel() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) { // Added setter for id
        this.id = id;
    }


    public Long getClienteId() {
        return clienteId;
    }

    public void setClienteId(Long clienteId) { // Added setter for clienteId
        this.clienteId = clienteId;
    }

    public List<ItenPedidoModel> getItens() {
        return itens;
    }

    public void setItens(List<ItenPedidoModel> itens) { // Added setter for itens
        this.itens = itens;
    }
}


