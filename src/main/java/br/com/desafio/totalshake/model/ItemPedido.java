package br.com.desafio.totalshake.model;

import javax.persistence.*;

@Entity
@Table(name = "item_pedido")
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

    public ItemPedido(Pedido pedido, Long id, Integer quantidade, String descricao) {
        this.pedido = pedido;
        this.id = id;
        this.quantidade = quantidade;
        this.descricao = descricao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Pedido getPedido() {

        return pedido;
    }

    public void setPedido(Pedido pedido) {

        this.pedido = pedido;
    }
}