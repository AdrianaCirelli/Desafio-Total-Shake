package br.com.desafio.totalshake.controller;

import br.com.desafio.totalshake.dtoRequest.AtualizaItemPedidoRequest;
import br.com.desafio.totalshake.dtoResponse.ItemPedidoDtoResponse;
import br.com.desafio.totalshake.dtoRequest.ItemPedidoRequest;
import br.com.desafio.totalshake.model.ItemPedido;
import br.com.desafio.totalshake.repository.PedidoRepository;
import br.com.desafio.totalshake.service.ItemPedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/itens")
public class ItemPedidoController {

    @Autowired
    private ItemPedidoService service;

    @Autowired
    private PedidoRepository pedidoRepository;

    @GetMapping(value = "/{id}")
    public ResponseEntity<ItemPedidoDtoResponse> findById (@PathVariable Long id) {
        ItemPedidoDtoResponse dto = service.findById(id);
        return ResponseEntity.ok().body(dto);
    }

    @PostMapping
    public ItemPedido insert (@RequestBody @Valid ItemPedidoRequest itemPedidoForm){
        ItemPedido itemPedido =  itemPedidoForm.convert(pedidoRepository);
        return service.insert(itemPedido);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<ItemPedidoDtoResponse> update(@PathVariable Long id, @RequestBody AtualizaItemPedidoRequest dto){

        return service.update(id, dto);
    }
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<ItemPedidoDtoResponse> delete(@PathVariable Long id){
        service.delete(id);

        return ResponseEntity.noContent().build();
    }
}
