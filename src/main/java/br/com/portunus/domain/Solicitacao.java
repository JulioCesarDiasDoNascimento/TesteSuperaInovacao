package br.com.portunus.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Solicitacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "usuario_fk")
    private Usuario solicitante;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "modulo_fk")
    private Modulo modulo;

    @NotNull
    @Column(name = "dataHora_solicitado")
    private LocalDateTime dataHoraSolicitado;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private Status status;
}
