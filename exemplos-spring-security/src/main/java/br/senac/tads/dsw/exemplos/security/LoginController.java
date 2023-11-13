package br.senac.tads.dsw.exemplos.security;

import java.time.Duration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public String login(@RequestBody Credencial usuarioCred) {
        Authentication auth = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        usuarioCred.username(), usuarioCred.senha()));
        UsuarioSistema usuario = (UsuarioSistema) auth.getPrincipal();
        String jwt = tokenService.generateToken(usuario, Duration.ofMinutes(30));
        return jwt;

    }

    public static record Credencial(String username, String senha) {
    }

}
