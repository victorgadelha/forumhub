package br.com.victorgadelha.forumhub.servicos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.victorgadelha.forumhub.modelos.Topico;
import br.com.victorgadelha.forumhub.repositorios.TopicoRepositorio;

@Service
public class TopicoServico {

    @Autowired
    TopicoRepositorio topicoRepositorio;

    @Transactional
    public Topico salvarTopico(Topico topico) {
        return topicoRepositorio.save(topico);
    }

}
