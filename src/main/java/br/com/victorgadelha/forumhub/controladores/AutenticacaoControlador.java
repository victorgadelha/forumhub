package br.com.victorgadelha.forumhub.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.victorgadelha.forumhub.DTO.UsuarioDTO;
import br.com.victorgadelha.forumhub.infra.seguranca.TokenService;
import br.com.victorgadelha.forumhub.modelos.Usuario;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/login")
public class AutenticacaoControlador {

    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity efetuarLogin(@RequestBody @Valid UsuarioDTO usuarioDTO) {
        var authenticationToken = new UsernamePasswordAuthenticationToken(usuarioDTO.login(), usuarioDTO.senha());
        var authentication = manager.authenticate(authenticationToken);

        // var tokenJWT = tokenService.gerarToken((Usuario)
        // authentication.getPrincipal());

        return ResponseEntity.ok(tokenService.gerarToken((Usuario) authentication.getPrincipal()));
    }
}