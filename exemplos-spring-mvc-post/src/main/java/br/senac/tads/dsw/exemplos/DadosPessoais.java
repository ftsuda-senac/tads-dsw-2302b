package br.senac.tads.dsw.exemplos;

import java.time.LocalDate;
import java.util.List;

public class DadosPessoais {

    private Integer id;

    private String nome;

    private String apelido;

    private String email;

    private String telefone;

    private String senha;

    private String senhaRepetida;

    private LocalDate dataNascimento;

    private List<String> conhecimentos;

    public DadosPessoais() {
    }

    public DadosPessoais(Integer id, String nome, String apelido, String email, String telefone, String senha, String senhaRepetida,
            LocalDate dataNascimento, List<String> conhecimentos) {
        this.id = id;
        this.nome = nome;
        this.apelido = apelido;
        this.email = email;
        this.telefone = telefone;
        this.senha = senha;
        this.senhaRepetida = senhaRepetida;
        this.dataNascimento = dataNascimento;
        this.conhecimentos = conhecimentos;
    }

    public DadosPessoais(String nome, String apelido, String email, String telefone, String senha, String senhaRepetida,
            LocalDate dataNascimento, List<String> conhecimentos) {
        this(null, nome, apelido, email, telefone, senha, senhaRepetida, dataNascimento, conhecimentos);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getApelido() {
        return apelido;
    }

    public void setApelido(String apelido) {
        this.apelido = apelido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getSenhaRepetida() {
        return senhaRepetida;
    }

    public void setSenhaRepetida(String senhaRepetida) {
        this.senhaRepetida = senhaRepetida;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public List<String> getConhecimentos() {
        return conhecimentos;
    }

    public void setConhecimentos(List<String> conhecimentos) {
        this.conhecimentos = conhecimentos;
    }

    @Override
    public String toString() {
        return "****** DadosPessoais [id=" + id + ", nome=" + nome + ", apelido=" + apelido + ", email=" + email
                + ", telefone=" + telefone + ", senha=" + senha + ", senhaRepetida=" + senhaRepetida
                + ", dataNascimento=" + dataNascimento + ", conhecimentos=" + conhecimentos + "]";
    }

}
