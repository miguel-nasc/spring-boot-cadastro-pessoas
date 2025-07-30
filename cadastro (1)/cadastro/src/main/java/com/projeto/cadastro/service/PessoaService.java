package com.projeto.cadastro.service;

import com.projeto.cadastro.dto.PessoaDTO;
import com.projeto.cadastro.entitade.Pessoa;
import com.projeto.cadastro.repositorio.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;


    public PessoaDTO findById(Long id) {
        Optional<Pessoa> pessoa = pessoaRepository.findById(id);
        return pessoa.map(PessoaDTO::convertToDTO).orElse(null);

    }

    public List<PessoaDTO> queryByNome(String nome) {
        List<Pessoa> pessoas = pessoaRepository.getByNomeLike(nome);
        return pessoas.stream().map(PessoaDTO::convertToDTO).collect(Collectors.toList());
    }

    public PessoaDTO save(PessoaDTO pessoaDTO) {
        Pessoa pessoa = Pessoa.convertToEntity(pessoaDTO);
        pessoaRepository.save(pessoa);
        return PessoaDTO.convertToDTO(pessoa);
    }

    public PessoaDTO delete(Long id) {
        Optional<Pessoa> pessoa = pessoaRepository.findById(id);
        pessoa.ifPresent(p -> pessoaRepository.delete(p));
        return null;
    }


}
