package com.atacado.presentes.mg.api.repository;

import com.atacado.presentes.mg.api.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Optional<Usuario> findByEmail(String email);
    Optional<List<Usuario>> findByPerfil(String perfil);
}
