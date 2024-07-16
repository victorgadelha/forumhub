package br.com.victorgadelha.forumhub.modelos;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "Usuario")
@Table(name = "usuarios")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Email(message = "O email deve ser válido.")
    @NotBlank(message = "O e-mail é obrigatório.")
    @Column(unique = true)
    private String login;

    @NotBlank(message = "A senha é obrigatória.")
    @Column(unique = true)
    private String senha;

    @Column(name = "data_criacao")
    private LocalDateTime dataCriacao;

    @PrePersist
    private void beforePersist() {
        this.dataCriacao = LocalDateTime.now();
    }

}
