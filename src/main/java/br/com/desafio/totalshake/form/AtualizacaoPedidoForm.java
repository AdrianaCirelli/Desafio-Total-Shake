package br.com.desafio.totalshake.form;

import br.com.desafio.totalshake.model.Pedido;
import br.com.desafio.totalshake.model.Status;
import br.com.desafio.totalshake.repository.PedidoRepository;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.validator.constraints.Length;


@Data
@EqualsAndHashCode
public class AtualizacaoPedidoForm {


    @Length(min = 10)
    private  String status;

    public Pedido atualizar (Long id, PedidoRepository pedidoRepository) {
        Pedido pedido = pedidoRepository.getReferenceById(id);
        pedido.setStatus(buscaEnum(status));

        return pedido;
    }

    public Status buscaEnum(String status) {

        if (status.equals("REALIZADO")) {
            return Status.REALIZADO;
        }

        if (status.equals("CANCELADO")) {
            return Status.CANCELADO;
        }

        if (status.equals("PAGO")) {
            return Status.PAGO;
        }


        if (status.equals("NAO_AUTORIZADO")) {
            return Status.NAO_AUTORIZADO;
        }

        if (status.equals("CONFIRMADO")) {
            return Status.CONFIRMADO;
        }


        if (status.equals("PRONTO")) {
            return Status.PRONTO;
        }

        if (status.equals("SAIU_PARA_ENTREGA")) {
            return Status.SAIU_PARA_ENTREGA;

        }

        if (status.equals("ENTREGUE")) {
            return Status.ENTREGUE;

        } else {
            throw new IllegalArgumentException("Status nao existe");
        }
    }
}

