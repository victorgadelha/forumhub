package br.com.victorgadelha.forumhub.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.victorgadelha.forumhub.DTO.TopicoDTO;
import br.com.victorgadelha.forumhub.modelos.Topico;
import br.com.victorgadelha.forumhub.servicos.TopicoServico;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/topicos")
public class TopicoControlador {

    @Autowired
    TopicoServico topicoServico;

    @PostMapping
    public ResponseEntity<Topico> cadastrarTopico(@Valid @RequestBody TopicoDTO topico) {
        Topico novoTopico = topicoServico.salvarTopico(topico);

        return ResponseEntity.status(HttpStatus.CREATED).body(novoTopico);
    }

    @GetMapping
    public ResponseEntity<List<Topico>> listarTopicos() {
        List<Topico> listaTopicos = topicoServico.listarTopicos();
        return ResponseEntity.status(HttpStatus.OK).body(listaTopicos);
    }

}
