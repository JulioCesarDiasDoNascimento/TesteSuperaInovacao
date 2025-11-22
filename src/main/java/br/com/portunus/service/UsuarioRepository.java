package br.com.portunus.service;

import br.com.portunus.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    @Query("from Usuario u where upper(u.email) = upper(:email) and u.senha = :senha")
    Optional<Usuario> findByEmailESenha(String email, String senha);
}

