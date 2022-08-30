package br.com.desafio.totalshake.service;

import br.com.desafio.totalshake.dtoResponse.ItemPedidoDtoResponse;
import br.com.desafio.totalshake.model.ItemPedido;

import br.com.desafio.totalshake.repository.ItemPedidoRepository;

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
public class ItemPedidoService {

    @Autowired
    private ItemPedidoRepository repository;


    @Transactional
    public ItemPedidoDtoResponse findById(Long id) {
        Optional<ItemPedido> obj = repository.findById(id);
        ItemPedido entity = obj.orElseThrow(() -> new ResourceNotFoundExeception("Entity not found"));
        return new ItemPedidoDtoResponse(entity);
    }

    @Transactional
    public ItemPedido insert (ItemPedido itemPedido) {
        return repository.save(itemPedido);
    }

    @Transactional
    public ItemPedidoDtoResponse update(Long id, ItemPedidoDtoResponse dto) {
        try {
            ItemPedido entity = repository.getOne(id);
            entity = repository.save(entity);
            return new ItemPedidoDtoResponse(entity);

        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundExeception("id not found" + id);
        }

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
