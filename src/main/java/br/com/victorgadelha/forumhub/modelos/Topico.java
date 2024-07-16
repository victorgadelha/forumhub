package br.com.victorgadelha.forumhub.modelos;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "topicos")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank(message = "O título é obrigatório.")
    @Column(unique = true)
    private String titulo;

    @NotBlank(message = "A mensagem é obrigatória.")
    @Column(unique = true)
    private String mensagem;

    @Enumerated(EnumType.STRING)
    @Column(name = "estado_topico")
    private EstadoTopico estado = EstadoTopico.ABERTO;

    @NotBlank(message = "O autor é obrigatório.")
    private String autor;

    @Column(name = "data_criacao")
    private LocalDateTime dataCriacao;

    @NotBlank(message = "O curso é obrigatório.")
    private String curso;

    public enum EstadoTopico {
        ABERTO,
        FECHADO,
        ARQUIVADO
    }

    @PrePersist
    private void beforePersist() {
        this.dataCriacao = LocalDateTime.now();
    }

}
