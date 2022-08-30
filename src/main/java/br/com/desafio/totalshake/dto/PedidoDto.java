package br.com.desafio.totalshake.dto;


import br.com.desafio.totalshake.model.Pedido;
import br.com.desafio.totalshake.model.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.util.Optional;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class PedidoDto {

    private Long id;
    @NotBlank
    private LocalDateTime dataHora;
    @NotBlank
    private Status status;

    public void PedidoDto(){

    }
    public PedidoDto (Pedido entity) {
        this.id = entity.getId();
        this.dataHora= entity.getDataHora();
        this.status = entity.getStatus();
    }

}
