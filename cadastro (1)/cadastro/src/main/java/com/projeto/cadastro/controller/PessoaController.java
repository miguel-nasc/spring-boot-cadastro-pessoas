package com.projeto.cadastro.controller;

import com.projeto.cadastro.dto.PessoaDTO;
import com.projeto.cadastro.service.PessoaService;
import com.projeto.cadastro.validacao.ConverterLong;
import jakarta.persistence.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;

    @PostMapping("/cadastrar")
    public PessoaDTO cadastar(@RequestBody PessoaDTO pessoaDTO) {
        return pessoaService.save(pessoaDTO);
    }

    @GetMapping("/id/{id}")
    public PessoaDTO findById(@PathVariable(name = "id")
                              String id) {
        ConverterLong idConvert = new ConverterLong(id);
        return pessoaService.findById(idConvert.getId());
    }

    @DeleteMapping("/deletar/{id}")
    public PessoaDTO deletar(@PathVariable(name = "id")
                             String id) {
        ConverterLong idConvert = new ConverterLong(id);
        return pessoaService.delete(idConvert.getId());
    }

    @GetMapping("/nome/{nome}")
    public List<PessoaDTO> queryByNome(@PathVariable(value = "nome")
                                           String nome) {
        return pessoaService.queryByNome(nome);
    }


}
