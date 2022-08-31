package br.com.desafio.totalshake.service;

import br.com.desafio.totalshake.dtoResponse.PedidoDtoResponse;
import br.com.desafio.totalshake.dtoRequest.PedidoRequest;
import br.com.desafio.totalshake.model.ItemPedido;
import br.com.desafio.totalshake.model.Pedido;
import br.com.desafio.totalshake.repository.PedidoRepository;
import br.com.desafio.totalshake.service.exeception.DataBaseExeception;
import br.com.desafio.totalshake.service.exeception.ResourceNotFoundExeception;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository repository;


    @Transactional
    public PedidoDtoResponse findById(Long id) {
        Optional<Pedido> obj = repository.findById(id);
        Pedido entity = obj.orElseThrow(() -> new ResourceNotFoundExeception("Entity not found"));
        return new PedidoDtoResponse(entity);
    }

    @Transactional
    public PedidoDtoResponse insert(PedidoDtoResponse dto) {
        Pedido entity = new Pedido(); //colocar na mesma linha
        entity = repository.save(Pedido.convert(dto));
        return new PedidoDtoResponse(entity);
    }
 //update e delete sempre chamar o findById pra conferir no banco
    //pode diferenciar o metodo do service e do repository ex getById
    @Transactional  //JPA já cuida da transação
    public PedidoDtoResponse update(Long id, PedidoRequest form) {
        //objeto como mesmo id salva atualizado já
        //respository.save(objAtualizado) pode usar save pro update se passa o id entende como up date
        try {
            Optional<Pedido> optional = repository.findById(id);
            if (optional.isPresent()) {
                Pedido pedido = form.atualizar(id, repository);
                return new PedidoDtoResponse(pedido);
            }

        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundExeception("id not found" + id);
        }

        return null;
    }

    public void delete(Long id) {
        //chamar o findByid , se nao encontrar ja cai na execessão
        //throwException
        try {
            repository.deleteById(id);

        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundExeception("id not found" + id);
        }
        catch (DataIntegrityViolationException e){
            throw new DataBaseExeception("Integrity Violetion");

        }
    }

}
