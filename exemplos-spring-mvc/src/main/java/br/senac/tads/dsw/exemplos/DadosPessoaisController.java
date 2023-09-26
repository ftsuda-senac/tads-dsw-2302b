package br.senac.tads.dsw.exemplos;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.spel.support.ReflectivePropertyAccessor.OptimalPropertyAccessor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/dados-pessoais")
public class DadosPessoaisController {

    // private DadosPessoaisService service = new DadosPessoaisServiceImpl();

    @Autowired
    private DadosPessoaisService service;

    @GetMapping
    public List<DadosPessoais> findAll() {
        return service.findAll();
    }
    // @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) // ISO-8601 
    @GetMapping("/busca")
    public List<DadosPessoais> searchByTermoBusca(
        @RequestParam(name = "termo") String termoBusca,
        @RequestParam(required = false) LocalDate dataNascimento,
        @RequestParam(defaultValue = "1") Integer pagina,
        @RequestParam(defaultValue = "1") Integer quantidade) {
        System.out.println("Data nascimento: " + dataNascimento);
        System.out.println("Pagina: " + pagina);
        return service.searchByTermoBusca(termoBusca, pagina, quantidade);
    }

    @GetMapping("/{id}")
    public DadosPessoais findById(@PathVariable Integer id) {
        return service.findById(id);
    }

    @GetMapping("/{id}/opt")
    public DadosPessoais findByIdComOptional(@PathVariable Integer id) {
        // Optional<DadosPessoais> optDados = service.findByIdComOptional(id);
        // if (optDados.isPresent()) {
        //     return optDados.get();
        // } else {
        //     throw new ResponseStatusException(HttpStatus.NOT_FOUND, "ID " + id + " não encontrado");
        // }

        // Alternativa
        return service.findByIdComOptional(id)
            .orElseThrow(() -> new ResponseStatusException(
                HttpStatus.NOT_FOUND, "ID " + id + " não encontrado"));
       
    }
    
}
