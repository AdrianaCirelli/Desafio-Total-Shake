package br.com.desafio.totalshake.dto;

import br.com.desafio.totalshake.model.Pedido;
import br.com.desafio.totalshake.model.Status;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

public class PedidoDto {

    private Long id;
    @NotBlank
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
