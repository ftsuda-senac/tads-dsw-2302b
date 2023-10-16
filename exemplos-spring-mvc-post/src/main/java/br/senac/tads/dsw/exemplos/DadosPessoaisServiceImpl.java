package br.senac.tads.dsw.exemplos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import jakarta.annotation.PostConstruct;

@Service
public class DadosPessoaisServiceImpl implements DadosPessoaisService {

    private Map<Integer, DadosPessoais> usuarios = new LinkedHashMap<>();

    @PostConstruct
    public void init() {
        usuarios.put(1, new DadosPessoais(1, "Fulano da Silva", "fulano", "fulano@teste.com.br", "(11) 99999-1122",
                "abcd$1234", "abcd$1234", LocalDate.parse("2000-10-20"), Arrays.asList("Java", "HTML", "CSS")));
        usuarios.put(2, new DadosPessoais(2, "Ciclano de Souza", "ciclano", "ciclano@teste.com.br", "(11) 98765-1234",
                "abcd$1234", "abcd$1234", LocalDate.parse("2001-05-15"),  Arrays.asList("Java", "HTML", "Javascript")));
        usuarios.put(3, new DadosPessoais(3, "Beltrana dos Santos", "beltrana", "beltrana@teste.com.br", "(11) 91234-8877",
                "abcd$1234", "abcd$1234", LocalDate.parse("1999-02-01"),  Arrays.asList("HTML", "CSS", "Javascript")));
    }

    @Override
    public List<DadosPessoais> findAll() {
        return new ArrayList<>(usuarios.values());
    }

    @Override
    public List<DadosPessoais> searchByTermoBusca(String termoBusca, int pagina, int quantidade) {
        List<DadosPessoais> resultadosTotal = new ArrayList<>();
        for (DadosPessoais dados : usuarios.values()) {
            if (dados.getNome().toLowerCase()
                    .contains(termoBusca.toLowerCase())) {
                resultadosTotal.add(dados);
            }
        }
        // Para usuarios, contagem começa em 1, mas
        // na programacao, indices começam em 0
        int paginaAjustada = pagina - 1;
        int offset = paginaAjustada * quantidade;

        List<DadosPessoais> resultados = new ArrayList<>();
        for (int i = offset; i < (offset + quantidade) && i < resultadosTotal.size(); i++) {
            resultados.add(resultadosTotal.get(i));
        }
        return resultados;
    }

    @Override
    public DadosPessoais findById(Integer id) {
        DadosPessoais dados = usuarios.get(id);
        if (dados != null) {
            return dados;
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "ID " + id + " não encontrado");
        }
    }

    @Override
    public Optional<DadosPessoais> findByIdComOptional(Integer id) {
        return Optional.ofNullable(usuarios.get(id));
    }

}
