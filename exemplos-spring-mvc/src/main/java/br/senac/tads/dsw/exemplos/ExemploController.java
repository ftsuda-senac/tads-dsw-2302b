package br.senac.tads.dsw.exemplos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExemploController {

    @GetMapping("/exemplo01")
    public String exemplo01() {
        return "texto gerado no Controller";
    }

    @GetMapping("/exemplo02")
    public String exemplo02() {
        return "{ \"nome\": \"Fulano da Silva\", \"email\": \"fulano@teste.com.br\" }";
    }

    @GetMapping("/exemplo03")
    public DadosPessoais exemplo03() {
        DadosPessoais dados = new DadosPessoais(1, "Ciclano de Souza", "ciclano@teste.com.br", "(11) 98765-1234", LocalDate.parse("2000-10-20"));
        return dados;
    }

    @GetMapping("/exemplo04")
    public List<DadosPessoais> exemplo04() {
        DadosPessoais dados1 = new DadosPessoais(1, "Fulano da Silva", "fulano@teste.com.br", "(11) 99999-1122", LocalDate.parse("2000-10-20"));
        DadosPessoais dados2 = new DadosPessoais(2, "Ciclano de Souza", "ciclano@teste.com.br", "(11) 98765-1234", LocalDate.parse("2001-05-15"));
        DadosPessoais dados3 = new DadosPessoais(3, "Beltrana dos Santos", "beltrana@teste.com.br", "(11) 91234-8877", LocalDate.parse("1999-02-01"));
        List<DadosPessoais> lista = new ArrayList<>();
        lista.add(dados1);
        lista.add(dados2);
        lista.add(dados3);
        return lista;
    }
    
}
