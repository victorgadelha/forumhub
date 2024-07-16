package br.com.victorgadelha.forumhub.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.victorgadelha.forumhub.modelos.Topico;
import br.com.victorgadelha.forumhub.servicos.TopicoServico;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/topicos")
public class TopicoControlador {

    @Autowired
    TopicoServico topicoServico;

    @PostMapping
    public ResponseEntity<Topico> cadastrarTopico(@Valid @RequestBody Topico topico) {
        Topico novoTopico = topicoServico.salvarTopico(topico);

        return ResponseEntity.status(HttpStatus.CREATED).body(novoTopico);
    }

}
