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

    public PedidoRequest() {
    }
}

