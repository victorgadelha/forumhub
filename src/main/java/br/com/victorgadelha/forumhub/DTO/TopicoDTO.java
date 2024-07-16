package br.com.victorgadelha.forumhub.DTO;

import br.com.victorgadelha.forumhub.modelos.Topico.EstadoTopico;

public record TopicoDTO(Long id, String titulo, String mensagem, EstadoTopico estado, String autor, String curso) {

}
