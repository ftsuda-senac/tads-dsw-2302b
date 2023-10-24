package br.senac.tads.dsw.exemplos.dominio;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
public class InteresseRepository {

    @PersistenceContext
    private EntityManager em;

    public List<Interesse> findAll() {
        TypedQuery<Interesse> jpqlQuery = 
            em.createQuery("SELECT i FROM Interesse i", 
            Interesse.class);
        return jpqlQuery.getResultList();
    }

    public Optional<Interesse> findById(Integer id) {
        TypedQuery<Interesse> jpqlQuery = 
            em.createQuery("SELECT i FROM Interesse i WHERE i.id = :idInteresse", 
            Interesse.class)
            .setParameter("idInteresse", id);
        try {
            Interesse resultado = jpqlQuery.getSingleResult();
            return Optional.of(resultado);
        } catch(NoResultException ex) {
            return Optional.empty();
        }
    }

    @Transactional
    public Interesse save(Interesse interesse) {
        if (interesse.getId() == null) {
            // Criar item novo
            em.persist(interesse);
        } else {
            // Atualizar item existente
            em.merge(interesse);
        }
        return interesse;
    }

    @Transactional
    public void deleteById(Integer id) {
        // TEM QUE FAZER CONSULTA PARA OBJETO FICAR ASSOCIADO (ATTACHED) 
        // AO ENTITY MANAGER 
        Interesse interesse = em.find(Interesse.class, id);
        em.remove(interesse);
    }
}
