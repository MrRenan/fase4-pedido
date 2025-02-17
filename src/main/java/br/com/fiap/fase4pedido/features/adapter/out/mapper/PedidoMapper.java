package br.com.fiap.fase4pedido.features.adapter.out.mapper;

import br.com.fiap.fase4pedido.features.domain.entity.Cliente;
import br.com.fiap.fase4pedido.features.domain.entity.Pedido;
import br.com.fiap.fase4pedido.features.domain.entity.Produto;
import br.com.fiap.fase4pedido.infra.mongodb.document.PedidoDocument;
import br.com.fiap.fase4pedido.infra.restclient.cliente.entity.ClienteEntity;
import br.com.fiap.fase4pedido.infra.restclient.produto.entity.ProdutoEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component("pedidoOutputMapper")
public interface PedidoMapper {

    @Mapping(target = "status", expression = "java(pedido.getStatus().name())")
    @Mapping(target = "produtos", source = "pedido.produtos") // Mapeamento da lista de produtos
    PedidoDocument paraPedidoDocument(Pedido pedido);

    @Mapping(target = "status", expression = "java(Status.valueOf(pedidoDocument.getStatus()))")
    @Mapping(target = "produtos", source = "pedidoDocument.produtos") // Mapeamento da lista de produtos
    Pedido paraPedido(PedidoDocument pedidoDocument);

    Cliente paraCliente(ClienteEntity clienteEntity);

    @Mapping(target = "id", source = "id") // Mapeamento explícito do campo id
    @Mapping(target = "nomeProduto", source = "nomeProduto")
    @Mapping(target = "preco", source = "preco")
    @Mapping(target = "quantidade", source = "quantidade")
    Produto paraProduto(ProdutoEntity produtoEntity);

    @Mapping(target = "id", source = "id") // Mapeamento explícito do campo id
    @Mapping(target = "nomeProduto", source = "nomeProduto")
    @Mapping(target = "preco", source = "preco")
    @Mapping(target = "quantidade", source = "quantidade")
    ProdutoEntity paraProdutoEntity(Produto produto);
}
