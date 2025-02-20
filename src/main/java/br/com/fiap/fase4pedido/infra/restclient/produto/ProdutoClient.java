package br.com.fiap.fase4pedido.infra.restclient.produto;

import br.com.fiap.fase4pedido.infra.restclient.produto.entity.EstoqueEntity;
import br.com.fiap.fase4pedido.infra.restclient.produto.entity.ProdutoEntity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "produto", url = "${produto.service.url}")
public interface ProdutoClient {

    @GetMapping("/{id}")
    ProdutoEntity obterProduto(@PathVariable String id);

    @PutMapping("/estoque")
    ProdutoEntity atualizarEstoque(@RequestBody EstoqueEntity estoqueEntity);
}

