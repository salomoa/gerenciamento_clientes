package com.cliente.demo.controllers;


import com.cliente.demo.model.ClienteModel;
import com.cliente.demo.services.ClienteServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = {"/clientes","/clientes/"})
public class ClienteController {

    @Autowired
    private ClienteServices clienteServices;

    @GetMapping
        public ResponseEntity<List<ClienteModel> > findAll(){
        List<ClienteModel> clientes = clienteServices.findAll();
        return ResponseEntity.ok(clienteServices.findAll());
    }

    @PostMapping
        public ResponseEntity<ClienteModel> criarFornecedor(@RequestBody ClienteModel fornecedor){
            ClienteModel fmodel = clienteServices.criarFornecedor(fornecedor);
            URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                    .path("/{id}")
                    .buildAndExpand(fmodel.getId())
                    .toUri();
            return ResponseEntity.created(uri).body(fmodel);
        }

    @DeleteMapping
        public ResponseEntity<ClienteModel> deletar(@RequestParam Long id){
        clienteServices.deletar(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
        public Optional<ClienteModel> buscarId(@PathVariable Long id){
        return clienteServices.buscarPeloId(id);

    }

    @PutMapping("/{id}")
        public ResponseEntity<ClienteModel> atualizar(@PathVariable Long id, @RequestBody ClienteModel fornecedor){
        ClienteModel clienteModel = clienteServices.atualizar(id, fornecedor);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri()
                .path("/{id}")
                .buildAndExpand(clienteModel.getId())
                .toUri();
        return ResponseEntity.created(uri).body(clienteModel);

    }

}
