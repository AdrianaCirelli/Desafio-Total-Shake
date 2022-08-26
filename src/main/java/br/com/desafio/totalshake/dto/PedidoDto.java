package br.com.desafio.totalshake.dto;


import br.com.desafio.totalshake.model.Pedido;
import br.com.desafio.totalshake.model.Status;
import lombok.Data;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;


@Data
public class PedidoDto {


    private Long id;
    @NotBlank
    private LocalDateTime dataHora;
    @NotBlank
    private Status status;
    public void PedidoDto(){

    }
    public PedidoDto(Long id,  Status status) {
        this.id = id;
        this.status = status;
    }

    public PedidoDto (Pedido entity) {
        this.id = entity.getId();
        this.dataHora= entity.getDataHora();
        this.status = entity.getStatus();
    }

}
