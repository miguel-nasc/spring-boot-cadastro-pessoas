package com.projeto.cadastro.entitade;

import com.projeto.cadastro.dto.PessoaDTO;
import jakarta.persistence.*;

@Entity
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Nome", nullable = false, length = 80)
    private String nome;

    @Column(name = "Email", nullable = false, length = 100)
    private String email;

    @Column(name = "Gênero", nullable = false, length = 50)
    private String genero;


    public Pessoa() {
    }

    public Pessoa(String email, String genero, Long id, String nome) {
        this.email = email;
        this.genero = genero;
        this.id = id;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public static Pessoa convertToEntity(PessoaDTO pessoaDTO) {
        Pessoa pessoa = new Pessoa();
        pessoa.setNome(pessoaDTO.getNome());
        pessoa.setEmail(pessoaDTO.getEmail());
        pessoa.setGenero(pessoaDTO.getGenero());
        return pessoa;
    }
}
