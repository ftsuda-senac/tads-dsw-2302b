package br.senac.tads.dswb.exemplos;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TradicionalController {

    @GetMapping("/tradicional")
    public String exemplo01() {
        return "tela-tradicional";
    }
    
}
