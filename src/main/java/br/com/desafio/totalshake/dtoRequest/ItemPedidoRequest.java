package br.com.desafio.totalshake.dtoRequest;

import br.com.desafio.totalshake.model.ItemPedido;
import br.com.desafio.totalshake.model.Pedido;
import br.com.desafio.totalshake.repository.ItemPedidoRepository;
import br.com.desafio.totalshake.repository.PedidoRepository;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Optional;

@Data
public class ItemPedidoRequest {

   @NotNull
    private Integer quantidade;
    @NotNull
    @Size(min =3 )//ver regra completa )
    private String descricao;
    private Long pedido_id;

    public ItemPedido convert (PedidoRepository pedidoRepository)  {
        Optional<Pedido> optional = pedidoRepository.findById(pedido_id);
        return optional.map(value -> new ItemPedido (quantidade, descricao, value))
                .orElse(null);
    }

}
