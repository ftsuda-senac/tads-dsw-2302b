package br.senac.tads.dswb.exemplos;

import java.time.LocalDate;

public class DadosDto {

    private String nome;

    private String email;

    private String telefone;

    private LocalDate dataNascimento;

    private String linkedInUrl;

    private String gitHubUrl;

    
    public DadosDto() {
    }


    public DadosDto(String nome, String email, String telefone, LocalDate dataNascimento, String linkedInUrl,
            String gitHubUrl) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.dataNascimento = dataNascimento;
        this.linkedInUrl = linkedInUrl;
        this.gitHubUrl = gitHubUrl;
    }



    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getLinkedInUrl() {
        return linkedInUrl;
    }

    public void setLinkedInUrl(String linkedInUrl) {
        this.linkedInUrl = linkedInUrl;
    }

    public String getGitHubUrl() {
        return gitHubUrl;
    }

    public void setGitHubUrl(String gitHubUrl) {
        this.gitHubUrl = gitHubUrl;
    }

    
    
}