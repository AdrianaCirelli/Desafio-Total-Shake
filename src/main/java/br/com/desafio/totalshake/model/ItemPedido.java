package br.com.desafio.totalshake.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import javax.persistence.*;

@Entity
@Table(name = "item_pedido")
@Data
@AllArgsConstructor
public class ItemPedido {
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "pedido_id")
    private Pedido pedido;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer quantidade;
    private String descricao;

    @Deprecated
    public ItemPedido() {
    }


    public ItemPedido(Integer quantidade, String descricao, Pedido value) {
        this.quantidade = quantidade;
        this.descricao = descricao;
        this.pedido = value;
    }



}