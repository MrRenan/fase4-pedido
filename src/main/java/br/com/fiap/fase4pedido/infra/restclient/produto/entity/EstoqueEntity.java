package br.com.fiap.fase4pedido.infra.restclient.produto.entity;

import java.util.List;

public class EstoqueEntity {

    private List<ProdutoEstoque> produtos;

    public List<ProdutoEstoque> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<ProdutoEstoque> produtos) {
        this.produtos = produtos;
    }

    public EstoqueEntity(List<ProdutoEstoque> produtos) {
        this.produtos = produtos;
    }
}
