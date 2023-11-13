package br.senac.tads.dsw.exemplos.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MeController {

    @Autowired
    private UserSistemaService userSistemaService;

    @GetMapping("/me")
    public UserInfo retrieveMe(Authentication auth) {



        Jwt jwt = (Jwt) auth.getPrincipal();
        UsuarioSistema usuario = userSistemaService.loadUserByUsername(jwt.getSubject());

        return new UserInfo(usuario.getNomeCompleto(), usuario.getEmail(), "http://localhost:8080/img/" + usuario.getFoto(), usuario.getHashSenha());
    }

    public static record UserInfo(String nome, String email, String urlFoto, String hashSenha) {

    }
    
}
