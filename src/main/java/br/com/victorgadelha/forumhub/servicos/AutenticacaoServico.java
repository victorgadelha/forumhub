package br.com.victorgadelha.forumhub.servicos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import br.com.victorgadelha.forumhub.repositorios.UsuarioRepositorio;

public class AutenticacaoServico implements UserDetailsService {

    @Autowired
    UsuarioRepositorio repositorio;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return repositorio.findByLogin(username);
    }

}
