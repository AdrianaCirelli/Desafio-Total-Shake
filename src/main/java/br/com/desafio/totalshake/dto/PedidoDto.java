package br.com.desafio.totalshake.dto;


import br.com.desafio.totalshake.model.Pedido;
import br.com.desafio.totalshake.model.Status;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;


@Data
public class PedidoDto {

    private Long id;
    @NotBlank
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
    private LocalDateTime dataHora;
    @NotBlank
    private Status status;
    public void PedidoDto(){

    }
    public PedidoDto(Long id, LocalDateTime dataHora, Status status) {
        this.id = id;
        this.dataHora = dataHora;
        this.status = status;
    }

    public PedidoDto (Pedido entity) {
        this.id = entity.getId();
        this.dataHora = entity.getDataHora();
        this.status = entity.getStatus();
    }

}
