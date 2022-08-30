package br.com.desafio.totalshake.dtoRequest;

import br.com.desafio.totalshake.model.Pedido;
import br.com.desafio.totalshake.model.Status;
import br.com.desafio.totalshake.repository.PedidoRepository;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.validator.constraints.Length;


@Data
@EqualsAndHashCode
public class PedidoRequest {


    @Length(min = 10)
    private  String status;

    public Pedido atualizar (Long id, PedidoRepository pedidoRepository) {
        Status statusEnum = Status.valueOf(status);
        Pedido pedido = pedidoRepository.getReferenceById(id);
        pedido.setStatus(statusEnum);

        return pedido;
    }

}

