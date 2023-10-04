package com.atacado.presentes.mg.api.controller;

import com.atacado.presentes.mg.api.model.Cliente;
import com.atacado.presentes.mg.api.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/clientes")
public class ClienteController {
    @Autowired
    private ClienteRepository clienteRepository;

    @PostMapping
    public Cliente cadastrarCliente(@RequestBody Cliente idCliente){
        return clienteRepository.save(idCliente);
    }

    @PutMapping("/{id}")
    public Cliente updateCliente(@PathVariable("id") Long idCliente, @RequestBody Cliente cliente){
        Optional<Cliente> clienteExistente = clienteRepository.findById(idCliente);

        if(clienteExistente.isPresent()){
            Cliente clienteObj = clienteExistente.get();

            clienteObj.setName(cliente.getName());
            clienteObj.setLastname(cliente.getLastname());
            clienteObj.setBirthday(cliente.getBirthday());

            return clienteRepository.save(clienteObj);
        }
        return null;
    }

    @GetMapping
    public List<Cliente> listarClientes(){
        return clienteRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Cliente> obterClientePeloId(@PathVariable("id") Long idCliente){
        return clienteRepository.findById(idCliente);
    }

    @GetMapping("/name/{name}")
    public Optional<Cliente> obterClientePeloNome(@PathVariable("name") String name){
        return clienteRepository.findByName(name);
    }

//    @GetMapping("/lastname/{lastname}")
//    public Optional<Cliente> obterClientePeloSobrenome(@PathVariable("lastname") String lastname){
//        return clienteRepository.findByLastname(lastname);
//    }
}
