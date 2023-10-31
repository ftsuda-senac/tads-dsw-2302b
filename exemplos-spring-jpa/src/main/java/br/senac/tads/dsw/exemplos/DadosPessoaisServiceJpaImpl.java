package br.senac.tads.dsw.exemplos;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.senac.tads.dsw.exemplos.dominio.DadosPessoais;
import br.senac.tads.dsw.exemplos.dominio.DadosPessoaisRepository;
import br.senac.tads.dsw.exemplos.dominio.Interesse;
import br.senac.tads.dsw.exemplos.dominio.InteresseRepository;

@Service
public class DadosPessoaisServiceJpaImpl implements DadosPessoaisService {

    @Autowired
    private DadosPessoaisRepository repo;

    @Autowired
    private InteresseRepository interesseRepo;

    @Override
    public List<DadosPessoaisDto> findAll() {
        List<DadosPessoais> resultadoBd = repo.findAll();
        List<DadosPessoaisDto> resultadoFinal = new ArrayList<>();
        for (DadosPessoais bd : resultadoBd) {
            resultadoFinal.add(new DadosPessoaisDto(bd));
        }
        return resultadoFinal;
    }

    @Override
    public List<DadosPessoaisDto> searchByTermoBusca(String termoBusca, int pagina, int quantidade) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'searchByTermoBusca'");
    }

    @Override
    public DadosPessoaisDto findById(Integer id) {
        Optional<DadosPessoais> optBd = repo.findById(id);
        if (optBd.isPresent()) {
            return new DadosPessoaisDto(optBd.get());
        }
        return null;
    }

    @Override
    public Optional<DadosPessoaisDto> findByIdComOptional(Integer id) {
        return repo.findById(id).map(bd -> new DadosPessoaisDto(bd));
    }

    @Override
    public void save(DadosPessoaisDto dados) {

        DadosPessoais bd  =new DadosPessoais();
        bd.setId(dados.getId());
        bd.setNome(dados.getNome());
        bd.setApelido(dados.getApelido());
        bd.setEmail(dados.getEmail());
        bd.setTelefone(dados.getTelefone());
        bd.setHashSenha(dados.getSenha());
        bd.setDataNascimento(dados.getDataNascimento());
        Set<Interesse> interesses = new HashSet<>();
        for (String conhecimento : dados.getConhecimentos() ) {
            Optional<Interesse> optInteresse = interesseRepo.findByNomeIgnoreCase(conhecimento);
            if (optInteresse.isPresent()) {
                interesses.add(optInteresse.get());
            }
        }
        bd.setInteresses(interesses);
        repo.save(bd);
    }
    
}
 