package org.senai.ecommerce.config;

import org.senai.ecommerce.entity.Produto;
import org.senai.ecommerce.service.ProdutoService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailsServiceCustom implements UserDetailsService {

    private final ProdutoService produtoService;

    public UserDetailsServiceCustom(ProdutoService usuarioService) {
        this.produtoService = usuarioService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Produto> usuario = produtoService.getProdutoPorCodigo(username);
        if(!usuario.isPresent())
            new UsernameNotFoundException("Usuário não encontrado!");

        return new UserDetailsCustom(produto);
    }
}

