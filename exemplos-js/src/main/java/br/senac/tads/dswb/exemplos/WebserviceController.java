package br.senac.tads.dswb.exemplos;

import java.time.LocalDate;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class WebserviceController {

    @GetMapping("/ws")
    public String exemplo2() {
        return "{ \"nome\": \"Fulano da Silva\", \"email\": \"fulano@teste.com.br\" }";
    }
    
    @GetMapping("/dados")
	public DadosDto findOne() {
		DadosDto dados = new DadosDto(
		"Maria dos Santos", 
		"maria@teste.com.br", 
		"(11) 99999-1212", 
		LocalDate.parse("2000-10-20"), 
		"https://linkedin.com/maria",
		"https://github.com/maria");
		return dados;
	}
}
