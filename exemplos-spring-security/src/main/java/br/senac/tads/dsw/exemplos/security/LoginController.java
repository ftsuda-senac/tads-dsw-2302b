package br.senac.tads.dsw.exemplos.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping
    public String login(Credencial usuarioCred) {
        Authentication auth = authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(
                usuarioCred.username(), usuarioCred.senha()));
        UsuarioSistema usuario = (UsuarioSistema) auth.getPrincipal();
        return usuario.getNomeCompleto() + " " + usuario.getEmail();

    }

    public static record Credencial (String username, String senha) {
    }
    
}
