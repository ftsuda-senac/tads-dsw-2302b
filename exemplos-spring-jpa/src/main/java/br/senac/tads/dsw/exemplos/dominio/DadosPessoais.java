package br.senac.tads.dsw.exemplos.dominio;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;

import jakarta.annotation.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class DadosPessoais {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 100, nullable = false)
    private String nome;

    @Column(length = 64, nullable = false, unique = true)
    private String apelido;

    @Column(length = 200, nullable = false)
    private String email;

    @Column(length = 16)
    private String telefone;

    private LocalDate dataNascimento;

    @Column(length = 100)
    private String hashSenha;

    @ManyToMany
    @JoinTable(name = "pessoa_interesse_rel",
        joinColumns = @JoinColumn(name = "pessoa_id"),
        inverseJoinColumns = @JoinColumn(name = "interesse_id"))
    private Set<Interesse> interesses;

    @OneToMany(mappedBy = "pessoa")
    private Set<FotoPessoa> fotos;
    
}
