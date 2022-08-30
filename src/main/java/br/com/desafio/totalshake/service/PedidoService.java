package br.com.desafio.totalshake.service;

import br.com.desafio.totalshake.dto.PedidoDto;
import br.com.desafio.totalshake.form.AtualizacaoPedidoForm;
import br.com.desafio.totalshake.model.Pedido;
import br.com.desafio.totalshake.repository.PedidoRepository;
import br.com.desafio.totalshake.service.exeception.DataBaseExeception;
import br.com.desafio.totalshake.service.exeception.ResourceNotFoundExeception;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.Optional;


@Service
public class PedidoService {

    @Autowired
    private PedidoRepository repository;


    @Transactional
    public PedidoDto findById(Long id) {
        Optional<Pedido> obj = repository.findById(id);
        Pedido entity = obj.orElseThrow(() -> new ResourceNotFoundExeception("Entity not found"));
        return new PedidoDto(entity);
    }

    @Transactional
    public PedidoDto insert(PedidoDto dto) {
        Pedido entity = new Pedido();
        entity = repository.save(Pedido.convert(dto));
        return new PedidoDto(entity);
    }

    @Transactional
    public PedidoDto update(Long id, AtualizacaoPedidoForm form) {
        try {
            Optional<Pedido> optional = repository.findById(id);
            if (optional.isPresent()) {
                Pedido pedido = form.atualizar(id, repository);
                return new PedidoDto(pedido);
            }

        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundExeception("id not found" + id);
        }

        return null;
    }

    public void delete(Long id) {
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
