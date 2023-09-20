package com.atacado.presentes.mg.api.controller;

import com.atacado.presentes.mg.api.model.Usuario;
import com.atacado.presentes.mg.api.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioController {

    @PostMapping
    public Usuario cadastrarUsuario(@RequestBody Usuario idUsuario) {
        return usuarioRepository.save(idUsuario);
    }

    @PutMapping("/{id}")
    public Usuario atualizarUsuario(@PathVariable("id") Long idUsuario, @RequestBody Usuario usuario) {
        Optional<Usuario> usuarioExistente = usuarioRepository.findById(idUsuario);

        if (usuarioExistente.isPresent()) {
            Usuario usuarioObj = usuarioExistente.get();

            usuarioObj.setEmail(usuario.getEmail());
            usuarioObj.setSenha(usuario.getSenha());
            usuarioObj.setPerfil(usuario.getPerfil());
            usuarioObj.setTelefone(usuario.getTelefone());

            return usuarioRepository.save(usuarioObj);
        }

        return null;
    }

    @GetMapping
    public List<Usuario> listarUsuarios() {
        return usuarioRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Usuario> obterUsuarioPeloId(@PathVariable("id") Long idUsuario) {
        return usuarioRepository.findById(idUsuario);
    }

    @DeleteMapping("/{id}")
    public void deletarUsuarioPeloId(@PathVariable("id") Long idUsuario) {
        usuarioRepository.deleteById(idUsuario);
    }

    @GetMapping("/email/{email}")
    public Optional<Usuario> obterUsuarioPeloEmail(@PathVariable("email") String email) {
        return usuarioRepository.findByEmail(email);
    }

    @GetMapping("/tel/{telefone}")
    public Optional<Usuario> obterUsuarioPeloTelefone(@PathVariable("telefone") String telefone) {
        return usuarioRepository.findByTelefone(telefone);
    }
    // Ponto de injeção
    @Autowired
    private UsuarioRepository usuarioRepository;
}
