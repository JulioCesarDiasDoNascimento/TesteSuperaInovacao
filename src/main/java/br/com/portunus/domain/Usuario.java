package br.com.portunus.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;


@Getter
@Setter
@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @NotNull
    private String nome;

    @NotNull
    @Column(unique = true , nullable = false)
    private String email;

    @NotNull
    private String senha;

    @Enumerated(EnumType.STRING)
    private Departamento departamento;

    @NotNull
    @Column(name = "validade_modulo")
    private LocalDate validadeModulo;

    public boolean expirarValidadeModuloAtivo() { // Futuramente vou trocar de lugar
        if (validadeModulo == null) {
            return false;
        }
        return validadeModulo.isBefore(LocalDate.now());
    }

}
