package br.senac.tads.dswb.exemplos;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebserviceController {

    @GetMapping("/ws")
    public String exemplo2() {
        return "{ \"nome\": \"Fulano da Silva\", \"email\": \"fulano@teste.com.br\" }";
    }
    
}
