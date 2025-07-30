package com.projeto.cadastro.controller;

import com.projeto.cadastro.dto.PessoaDTO;
import com.projeto.cadastro.service.PessoaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;

    @PostMapping()
    public PessoaDTO cadastar(@Valid @RequestBody PessoaDTO pessoaDTO) {
        return pessoaService.save(pessoaDTO);
    }

    @GetMapping("/{id}")
    public PessoaDTO findById(@PathVariable(name = "id")
                              Long id) {
        return pessoaService.findById(id);
    }

    @DeleteMapping("/{id}")
    public PessoaDTO deletar(@PathVariable(name = "id")
                             Long id) {
        return pessoaService.delete(id);
    }

    @GetMapping("/{nome}")
    public List<PessoaDTO> queryByNome(@PathVariable(value = "nome")
                                           String nome) {
        return pessoaService.queryByNome(nome);
    }


}
