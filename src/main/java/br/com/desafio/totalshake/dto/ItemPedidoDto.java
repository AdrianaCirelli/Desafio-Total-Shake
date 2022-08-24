package br.com.desafio.totalshake.dto;

import br.com.desafio.totalshake.model.ItemPedido;
import br.com.desafio.totalshake.model.Pedido;
import javax.validation.constraints.NotBlank;


public class ItemPedidoDto {
    private Pedido pedido;
    private Long id;
    @NotBlank
    private Integer quantidade;
    @NotBlank
    private String descricao;

     public ItemPedidoDto(){

     }

    public ItemPedidoDto(Pedido pedido, Long id, Integer quantidade, String descricao) {
        this.pedido = pedido;
        this.id = id;
        this.quantidade = quantidade;
        this.descricao = descricao;
    }

    public ItemPedidoDto (ItemPedido entity) {
        this.pedido = entity.getPedido();
        this.id = entity.getId();
        this.quantidade = entity.getQuantidade();
        this.descricao = entity.getDescricao();

    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
