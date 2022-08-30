package br.com.desafio.totalshake.controller;


import br.com.desafio.totalshake.dto.PedidoDto;
import br.com.desafio.totalshake.form.AtualizacaoPedidoForm;
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
    public ResponseEntity<PedidoDto> findById (@PathVariable Long id) {
       PedidoDto dto = service.findById(id);
        return ResponseEntity.ok().body(dto);
    }
    @PostMapping
    public ResponseEntity<PedidoDto> insert ( @RequestBody PedidoDto dto){
        dto = service.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @PutMapping(value = "/{id}")
    public PedidoDto update(@PathVariable Long id, @RequestBody AtualizacaoPedidoForm form){

        return service.update(id, form);
    }
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<PedidoDto> delete( @PathVariable Long id){
        service.delete(id);

        return ResponseEntity.noContent().build(); //204 - corpo da resp vazio
    }
}



