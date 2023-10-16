package br.senac.tads.dsw.exemplos;

import java.util.List;
import java.util.Optional;

public interface DadosPessoaisService {

    List<DadosPessoais> findAll();

    List<DadosPessoais> searchByTermoBusca(String termoBusca, int pagina, int quantidade);

    DadosPessoais findById(Integer id);

    Optional<DadosPessoais> findByIdComOptional(Integer id);

}
