package com.cliente.demo.services;

import com.cliente.demo.model.ClienteModel;
import com.cliente.demo.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteServices {

    @Autowired
    private ClienteRepository clienteRepository;

    public List<ClienteModel> buscarTodosClientes() {
        return clienteRepository.findAll();
    }

    public ClienteModel criarClientes(ClienteModel cliente) { return clienteRepository.save(cliente); }

    public Optional<ClienteModel> buscarClienteId(Long id) { return clienteRepository.findById(id); }

    public ClienteModel atualizarClientes(Long id, ClienteModel cliente) {
        ClienteModel fmodel = clienteRepository.findById(id).get();
        fmodel.setNome(cliente.getNome());
        fmodel.setEmail(cliente.getEmail());
        fmodel.setTelefone(cliente.getTelefone());
        return clienteRepository.save(fmodel);
    }

    public void deletarClientes(Long id) {
        clienteRepository.deleteById(id);
    }

}
