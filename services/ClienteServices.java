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

    public List<ClienteModel> findAll() {
        return clienteRepository.findAll();
    }

    public ClienteModel criarFornecedor(ClienteModel cliente) { return clienteRepository.save(cliente); }

    public Optional<ClienteModel> buscarPeloId(Long id) { return clienteRepository.findById(id); }

    public ClienteModel atualizar(Long id, ClienteModel cliente) {
        ClienteModel fmodel = clienteRepository.findById(id).get();
        fmodel.setNome(cliente.getNome());
        fmodel.setEmail(cliente.getEmail());
        fmodel.setTelefone(cliente.getTelefone());
        return clienteRepository.save(fmodel);
    }

    public void deletar(Long id) {
        clienteRepository.deleteById(id);
    }

}
