package br.com.desafio.totalshake.dto;


import br.com.desafio.totalshake.model.ItemPedido;
import br.com.desafio.totalshake.model.Pedido;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class ItemPedidoDto {
    private Pedido pedido;
    private Long id;
    @NotBlank
    private Integer quantidade;
    @NotBlank
    private String descricao;

     public ItemPedidoDto(){

     }
    public ItemPedidoDto (ItemPedido entity) {
        this.pedido = entity.getPedido();
        this.id = entity.getId();
        this.quantidade = entity.getQuantidade();
        this.descricao = entity.getDescricao();

    }

}
