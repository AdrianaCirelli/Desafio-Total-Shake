package br.com.desafio.totalshake.dto;

import br.com.desafio.totalshake.model.Pedido;

public class PedidoDto {

    private Long id;

    public void PedidoDto(){

    }
    public PedidoDto (Pedido entity){

        this.id = entity.getId();
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
