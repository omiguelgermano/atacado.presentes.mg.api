package com.atacado.presentes.mg.api.repository;

import com.atacado.presentes.mg.api.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.Optional;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    Optional<Cliente> findByName(String name);
    Optional<Cliente> findByLastname(String lastname);
    Optional<Cliente> findBybirthday(Date birthday);
}
