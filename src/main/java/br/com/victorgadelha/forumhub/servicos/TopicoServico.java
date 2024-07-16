package br.com.victorgadelha.forumhub.servicos;

import java.util.List;

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

        // topico.setId(topicoDTO.id());
        topico.setTitulo(topicoDTO.titulo());
        topico.setMensagem(topicoDTO.mensagem());
        topico.setAutor(topicoDTO.autor());
        topico.setCurso(topicoDTO.curso());

        return topicoRepositorio.save(topico);
    }

    public List<Topico> listarTopicos() {
        return topicoRepositorio.findAll();
    }

}
