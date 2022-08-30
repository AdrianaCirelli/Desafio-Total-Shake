package br.com.desafio.totalshake.dtoResponse;


import br.com.desafio.totalshake.model.ItemPedido;
import br.com.desafio.totalshake.model.Pedido;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
public class ItemPedidoDtoResponse {
    private Pedido pedido;
    private Long id;
    @NotBlank
    private Integer quantidade;
    @NotBlank
    private String descricao;

     public ItemPedidoDtoResponse(){

     }
    public ItemPedidoDtoResponse(ItemPedido entity) {
        this.pedido = entity.getPedido();
        this.id = entity.getId();
        this.quantidade = entity.getQuantidade();
        this.descricao = entity.getDescricao();

    }

}
