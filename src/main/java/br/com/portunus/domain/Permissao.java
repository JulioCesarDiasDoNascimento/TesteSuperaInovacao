package br.com.portunus.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Permissao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @Enumerated(EnumType.STRING)
    @JoinColumn(name = "departamento_fk")
    private Departamento departamento;

    @ManyToOne
    @JoinColumn(name = "modulo_fk")
    private Modulo modulo;

}
