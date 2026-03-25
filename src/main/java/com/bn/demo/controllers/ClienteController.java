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
        public ResponseEntity<List<ClienteModel> > buscarTodosOsClientes(){
        List<ClienteModel> clientes = clienteServices.buscarTodosClientes();
        return ResponseEntity.ok(clienteServices.buscarTodosClientes());
    }

    @PostMapping
        public ResponseEntity<ClienteModel> criarCliente(@RequestBody ClienteModel fornecedor){
            ClienteModel fmodel = clienteServices.criarClientes(fornecedor);
            URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                    .path("/{id}")
                    .buildAndExpand(fmodel.getId())
                    .toUri();
            return ResponseEntity.created(uri).body(fmodel);
        }

    @DeleteMapping
        public ResponseEntity<ClienteModel> deletarCliente(@RequestParam Long id){
        clienteServices.deletarClientes(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
        public Optional<ClienteModel> buscarClientePeloId(@PathVariable Long id){
        return clienteServices.buscarClienteId(id);

    }

    @PutMapping("/{id}")
        public ResponseEntity<ClienteModel> atualizarCliente(@PathVariable Long id, @RequestBody ClienteModel fornecedor){
        ClienteModel clienteModel = clienteServices.atualizarClientes(id, fornecedor);
        return ResponseEntity.ok().body(clienteModel);

    }

}
