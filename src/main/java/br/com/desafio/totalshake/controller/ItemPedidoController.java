package br.com.desafio.totalshake.controller;

import br.com.desafio.totalshake.dto.ItemPedidoDto;
import br.com.desafio.totalshake.service.ItemPedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import java.net.URI;

@RestController
@RequestMapping(value = "/itens")
public class ItemPedidoController {

    @Autowired
    private ItemPedidoService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<ItemPedidoDto> findById (@PathVariable Long id) {
        ItemPedidoDto dto = service.findById(id);
        return ResponseEntity.ok().body(dto);
    }

    @PostMapping
    public ResponseEntity<ItemPedidoDto> insert ( @RequestBody ItemPedidoDto dto){
        dto = service.insert(dto);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();

        return ResponseEntity.created(uri).body(dto);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<ItemPedidoDto> update( @PathVariable Long id, @RequestBody ItemPedidoDto dto){
        dto = service.update(id, dto);

        return ResponseEntity.ok().body(dto);
    }
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<ItemPedidoDto> delete( @PathVariable Long id){
        service.delete(id);

        return ResponseEntity.noContent().build();
    }
}
