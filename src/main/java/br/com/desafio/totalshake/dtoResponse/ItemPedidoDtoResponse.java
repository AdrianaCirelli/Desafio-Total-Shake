package br.com.desafio.totalshake.dtoResponse;


import br.com.desafio.totalshake.model.ItemPedido;
import br.com.desafio.totalshake.model.Pedido;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
public class ItemPedidoDtoResponse {

    @NotNull
    private Integer quantidade;
    @NotNull
    private String descricao;

     public ItemPedidoDtoResponse(){

     }
    public ItemPedidoDtoResponse(ItemPedido entity) {
        this.quantidade = entity.getQuantidade();
        this.descricao = entity.getDescricao();

    }

}
