package br.com.desafio.totalshake.model;


import br.com.desafio.totalshake.dtoResponse.PedidoDtoResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;


@Entity
@Table(name = "tb_pedido")
@Data
@AllArgsConstructor
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime dataHora;

    @Enumerated (EnumType.STRING)
    private Status status;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "pedido", cascade = CascadeType.ALL)
    private List<ItemPedido> itensPedidoList = new java.util.ArrayList<>();

    @PrePersist
    void prePersist(){
        this.dataHora = LocalDateTime.now();
    }

    public static Pedido convert(PedidoDtoResponse pedidoDto){
        Pedido pedido = new Pedido();
        pedido.setStatus(pedidoDto.getStatus());
        return pedido;
    }
    //necessário para o hibernate identificar a classe
    @Deprecated
    public Pedido(){

    }

}
