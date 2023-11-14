package br.senac.tads.dsw.exemplos.security;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/forca")
public class ForcaController {

    @GetMapping
    @PreAuthorize("isAuthenticated()")
    public Resposta comum() {
        return new Resposta("Bem vindo ao mundo Star wars");
    }

    @GetMapping("/jedi")
    @PreAuthorize("hasAuthority('SCOPE_JEDI')")
    public Resposta retrieveMensagemJedi() {
        return new Resposta("Que a força esteja com você");
    }

    @GetMapping("/sith")
    @PreAuthorize("hasAuthority('SCOPE_LORD_SITH')")
    public Resposta retrieveMensagemSith() {
         return new Resposta("Você não pode resistir ao lado sombrio da Força");
    }

    public static record Resposta(String mensagem) {

    }
    
}
