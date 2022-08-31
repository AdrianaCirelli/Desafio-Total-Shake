package br.com.desafio.totalshake.dtoRequest;

import br.com.desafio.totalshake.model.ItemPedido;
import br.com.desafio.totalshake.model.Pedido;
import br.com.desafio.totalshake.repository.ItemPedidoRepository;
import br.com.desafio.totalshake.repository.PedidoRepository;
import lombok.Data;
import javax.validation.constraints.NotNull;
import java.util.Optional;
@Data
public class AtualizaItemPedidoRequest {

    @NotNull
    private Integer quantidade;
    @NotNull
    private String descricao;


    public ItemPedido atualizar(Long id, ItemPedidoRepository repository) {
        ItemPedido itemPedido = repository.getReferenceById(id);
        itemPedido.setQuantidade(this.quantidade);
        itemPedido.setDescricao(this.descricao);
        return itemPedido;
    }
}

