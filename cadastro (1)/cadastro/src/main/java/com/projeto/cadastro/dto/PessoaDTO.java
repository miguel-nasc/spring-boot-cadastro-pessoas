package com.projeto.cadastro.dto;

import com.projeto.cadastro.entitade.Pessoa;
import jakarta.validation.constraints.NotNull;

public class PessoaDTO {
    @NotNull
    private String nome;
    @NotNull
    private String email;
    @NotNull
    private String genero;

    public PessoaDTO() {
    }

    public PessoaDTO(String email, String genero, String nome) {
        this.email = email;
        this.genero = genero;
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public static PessoaDTO convertToDTO(Pessoa pessoa) {
        PessoaDTO pessoaDTO = new PessoaDTO();
        pessoaDTO.setNome(pessoa.getNome());
        pessoaDTO.setEmail(pessoa.getEmail());
        pessoaDTO.setGenero(pessoa.getGenero());
        return pessoaDTO;
    }
}
