package com.atacado.presentes.mg.api.controller;

import com.atacado.presentes.mg.api.model.Usuario;
import com.atacado.presentes.mg.api.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioController {

    @GetMapping
    public List<Usuario> listarUsuarios() {
        return usuarioRepository.findAll();
    }

    // Ponto de injeção
    @Autowired
    private UsuarioRepository usuarioRepository;
}
