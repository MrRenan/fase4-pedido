package br.com.fiap.fase4pedido.infra.restclient.cliente.entity;

public class ClienteEntity {
    private String id;
    private String nome;

    public ClienteEntity() {}

    public ClienteEntity(String id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
