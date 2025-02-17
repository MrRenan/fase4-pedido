package br.com.fiap.fase4pedido.infra.restclient.cliente;

import br.com.fiap.fase4pedido.infra.restclient.cliente.entity.ClienteEntity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "cliente", url = "${cliente.service.url}")
public interface ClienteClient {

    @GetMapping("/{id}")
    ClienteEntity obterCliente(@PathVariable String id);
}
