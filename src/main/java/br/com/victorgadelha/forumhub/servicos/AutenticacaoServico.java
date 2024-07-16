package br.com.victorgadelha.forumhub.servicos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.victorgadelha.forumhub.repositorios.UsuarioRepositorio;

@Service
public class AutenticacaoServico implements UserDetailsService {

    @Autowired
    private UsuarioRepositorio repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return repository.findByLogin(username);
    }
}
