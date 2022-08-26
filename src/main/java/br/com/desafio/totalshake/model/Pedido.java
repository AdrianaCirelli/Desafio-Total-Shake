package br.com.desafio.totalshake.model;


import br.com.desafio.totalshake.dto.PedidoDto;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;


@Entity
@Table(name = "tb_pedido")
@Getter
@Setter
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime dataHora;
    @Enumerated (EnumType.STRING)
    private Status status;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "pedido")
    private List<ItemPedido> itensPedidoList = new java.util.ArrayList<>();

    @PrePersist
    void prePersist(){
        this.dataHora = LocalDateTime.now();
    }


    public static Pedido convert(PedidoDto pedidoDto){
        Pedido pedido = new Pedido();
        pedido.setStatus(pedidoDto.getStatus());
        return pedido;
    }

    //necessário para o hibernate identificar a classe
    @Deprecated
    public Pedido(){

    }

    public Pedido(Long id, LocalDateTime dataHora, Status status, List<ItemPedido> itensPedidoList) {
        this.id = id;
        this.dataHora = dataHora;
        this.status = status;
        this.itensPedidoList = itensPedidoList;
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

    public List<ItemPedido> getItensPedidoList() {
        return itensPedidoList;
    }

    public void setItensPedidoList(List<ItemPedido> itensPedidoList) {
        this.itensPedidoList = itensPedidoList;
    }
}
