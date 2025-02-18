package br.com.fiap.fase4pedido.features.adapter.out.mapper;

import br.com.fiap.fase4pedido.features.domain.entity.Cliente;
import br.com.fiap.fase4pedido.features.domain.entity.Pedido;
import br.com.fiap.fase4pedido.features.domain.entity.Produto;
import br.com.fiap.fase4pedido.infra.mongodb.document.PedidoDocument;
import br.com.fiap.fase4pedido.infra.restclient.cliente.entity.ClienteEntity;
import br.com.fiap.fase4pedido.infra.restclient.produto.entity.ProdutoEntity;
import org.mapstruct.AnnotateWith;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@AnnotateWith(
        value = Component.class,
        elements = @AnnotateWith.Element(strings = "featuresAdapterOutMapperPedidoMapperImpl")
)
public interface PedidoMapper {

    Cliente paraCliente(ClienteEntity clienteEntity);

    Produto paraProduto(ProdutoEntity produtoEntity);

    PedidoDocument paraPedidoDocument(Pedido novoPedido);

    Pedido paraPedido(PedidoDocument pedidoDocument);

}