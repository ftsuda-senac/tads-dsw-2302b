package br.senac.tads.dsw.exemplos;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/dados-pessoais-thy")
public class DadosPessoaisThymeleafController {

    @Autowired
    private DadosPessoaisService service;

    @GetMapping
    public ModelAndView findAll() {
        List<DadosPessoais> dados = service.findAll();

        ModelAndView mv = new ModelAndView("exemplo-thymeleaf");
        mv.addObject("resultados", dados);
        return mv;

    }

    @GetMapping("/busca")
    public ModelAndView searchByTermoBusca(
        @RequestParam(name = "termo") String termoBusca,
        @RequestParam(defaultValue = "1") Integer pagina,
        @RequestParam(defaultValue = "1") Integer quantidade) {
        
        List<DadosPessoais> dados = service.searchByTermoBusca(termoBusca, pagina, quantidade);
        
        ModelAndView mv = new ModelAndView("exemplo-thymeleaf");
        mv.addObject("resultados", dados);
        return mv;
    }
}
