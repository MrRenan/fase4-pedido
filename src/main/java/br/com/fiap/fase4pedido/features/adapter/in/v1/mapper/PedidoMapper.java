package br.com.fiap.fase4pedido.features.adapter.in.v1.mapper;

import br.com.fiap.fase4pedido.features.domain.entity.Cliente;
import br.com.fiap.fase4pedido.features.domain.entity.Pedido;
import br.com.fiap.fase4pedido.features.domain.entity.Produto;
import br.com.fiap.fase4pedido.infra.restapi.v1.model.PedidoRequest;
import br.com.fiap.fase4pedido.infra.restapi.v1.model.PedidoResponse;
import br.com.fiap.fase4pedido.infra.mongodb.document.PedidoDocument;
import br.com.fiap.fase4pedido.infra.mongodb.document.ProdutoDocument;
import br.com.fiap.fase4pedido.infra.restclient.cliente.entity.ClienteEntity;
import br.com.fiap.fase4pedido.infra.restclient.produto.entity.ProdutoEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component("pedidoInputMapper")
public interface PedidoMapper {

    @Mapping(target = "status", expression = "java(pedido.getStatus().name())")
    PedidoDocument paraPedidoDocument(Pedido pedido);

    @Mapping(target = "status", expression = "java(Status.valueOf(pedidoDocument.getStatus()))")
    Pedido paraPedido(PedidoDocument pedidoDocument);

    @Mapping(target = "cliente.id", source = "clienteId")
    @Mapping(target = "produtos", source = "produtos")
    @Mapping(target = "dataCriacao", ignore = true)  // Ignorando dataCriacao, pois não está presente no PedidoRequest
    @Mapping(target = "total", ignore = true)        // Ignorando total, pois não está presente no PedidoRequest
    @Mapping(target = "status", source = "status")
    Pedido paraPedido(PedidoRequest pedidoRequest);

    Cliente paraCliente(ClienteEntity clienteEntity);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "nomeProduto", source = "nomeProduto")
    @Mapping(target = "preco", source = "preco")
    @Mapping(target = "quantidade", source = "quantidade")
    Produto paraProduto(ProdutoEntity produtoEntity);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "nomeProduto", source = "nomeProduto")
    @Mapping(target = "preco", source = "preco")
    @Mapping(target = "quantidade", source = "quantidade")
    ProdutoEntity paraProdutoEntity(Produto produto);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "nomeProduto", source = "nomeProduto")
    @Mapping(target = "preco", source = "preco")
    @Mapping(target = "quantidade", source = "quantidade")
    ProdutoDocument paraProdutoDocument(Produto produto);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "nomeProduto", source = "nomeProduto")
    @Mapping(target = "preco", source = "preco")
    @Mapping(target = "quantidade", source = "quantidade")
    Produto paraProduto(ProdutoDocument produtoDocument);

    @Mapping(target = "cliente.id", source = "cliente.id")
    @Mapping(target = "cliente.nome", source = "cliente.nome")
    @Mapping(target = "produtos", source = "produtos")
    @Mapping(target = "dataCriacao", source = "dataCriacao")
    @Mapping(target = "total", source = "total")
    @Mapping(target = "status", source = "status")
    PedidoResponse paraPedidoResponse(Pedido pedido);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "nome", source = "nome")
    PedidoResponse.Cliente paraClienteResponse(Cliente cliente);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "nomeProduto", source = "nomeProduto")
    @Mapping(target = "preco", source = "preco")
    @Mapping(target = "quantidade", source = "quantidade")
    PedidoResponse.Produto paraProdutoResponse(Produto produto);
}
