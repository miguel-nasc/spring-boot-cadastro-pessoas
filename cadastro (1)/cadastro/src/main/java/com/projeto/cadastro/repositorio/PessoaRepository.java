package com.projeto.cadastro.repositorio;

import com.projeto.cadastro.entitade.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PessoaRepository
        extends JpaRepository<Pessoa, Long> {


    Optional<Pessoa> findById(Long id);
    List<Pessoa> getByNomeLike(String nome);
}
