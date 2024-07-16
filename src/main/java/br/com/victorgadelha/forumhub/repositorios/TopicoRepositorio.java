package br.com.victorgadelha.forumhub.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.victorgadelha.forumhub.modelos.Topico;

@Repository
public interface TopicoRepositorio extends JpaRepository<Topico, Long> {

}