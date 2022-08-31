package br.com.desafio.totalshake.dtoResponse;


import br.com.desafio.totalshake.model.Pedido;
import br.com.desafio.totalshake.model.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class PedidoDtoResponse {

 //Response é oque vamos mandar para o usuario - Resposta
    @NotBlank
    private LocalDateTime dataHora;
    @NotBlank
    private Status status;

    public void PedidoDto(){

    }
    public PedidoDtoResponse(Pedido entity) {
        this.dataHora= entity.getDataHora();
        this.status = entity.getStatus();
    }

}
