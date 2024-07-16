package br.com.victorgadelha.forumhub.servicos;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.victorgadelha.forumhub.DTO.TopicoDTO;
import br.com.victorgadelha.forumhub.modelos.Topico;
import br.com.victorgadelha.forumhub.repositorios.TopicoRepositorio;

@Service
public class TopicoServico {

    @Autowired
    TopicoRepositorio topicoRepositorio;

    @Transactional
    public Topico salvarTopico(TopicoDTO topicoDTO) {
        Topico topico = new Topico();

        topico.setTitulo(topicoDTO.titulo());
        topico.setMensagem(topicoDTO.mensagem());
        topico.setAutor(topicoDTO.autor());
        topico.setCurso(topicoDTO.curso());

        return topicoRepositorio.save(topico);
    }

    public List<Topico> listarTopicos() {
        return topicoRepositorio.findAll();
    }

    public Optional<Topico> acharTopicoPorID(Long id) {
        return topicoRepositorio.findById(id);
    }

    @Transactional
    public Topico atualizarTopico(Long id, TopicoDTO topicoDTO) {
        Optional<Topico> optionalTopico = topicoRepositorio.findById(id);

        if (optionalTopico.isPresent()) {
            Topico topicoExistente = optionalTopico.get();
            topicoExistente.setTitulo(topicoDTO.titulo());
            topicoExistente.setMensagem(topicoDTO.mensagem());
            topicoExistente.setAutor(topicoDTO.autor());
            topicoExistente.setCurso(topicoDTO.curso());

            return topicoRepositorio.save(topicoExistente);
        } else {
            throw new RuntimeException("Tópico não encontrado com o ID: " + id);
        }
    }

}
