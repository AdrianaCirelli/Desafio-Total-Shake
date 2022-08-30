package br.com.desafio.totalshake.controller;


import br.com.desafio.totalshake.dtoResponse.PedidoDtoResponse;
import br.com.desafio.totalshake.dtoRequest.PedidoRequest;
import br.com.desafio.totalshake.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import java.net.URI;

@RestController
@RequestMapping(value = "/pedidos")
public class PedidoController {

    @Autowired
    private PedidoService service;
    @GetMapping(value = "/findAll")
    public ResponseEntity<String> findAll(){

        return ResponseEntity.ok().body("olá, deu certo!");
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<PedidoDtoResponse> findById (@PathVariable Long id) {
       PedidoDtoResponse dto = service.findById(id);
        return ResponseEntity.ok().body(dto);
    }
    @PostMapping
    public ResponseEntity<PedidoDtoResponse> insert (@RequestBody PedidoDtoResponse dto){
        dto = service.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @PutMapping(value = "/{id}")
    public PedidoDtoResponse update(@PathVariable Long id, @RequestBody PedidoRequest form){

        return service.update(id, form);
    }
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<PedidoDtoResponse> delete(@PathVariable Long id){
        service.delete(id);

        return ResponseEntity.noContent().build(); //204 - corpo da resp vazio
    }
}



