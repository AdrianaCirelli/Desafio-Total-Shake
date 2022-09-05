package br.com.desafio.totalshake.dtoRequest;

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

