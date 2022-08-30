package br.com.desafio.totalshake.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import javax.persistence.*;

@Entity
@Table(name = "item_pedido")
@Data
@AllArgsConstructor
public class ItemPedido {
    @ManyToOne
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


}