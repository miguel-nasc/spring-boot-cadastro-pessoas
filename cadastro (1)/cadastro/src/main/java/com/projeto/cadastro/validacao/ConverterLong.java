package com.projeto.cadastro.validacao;

public class ConverterLong {

    private Long id;

    private void setId(String string) {
        Long valor = Long.parseLong(string);
        id = valor;
    }

    public Long getId() {
        return id;
    }

    public ConverterLong(String valor) {
        assert valor != null;
        if (!valor.matches("[-+]?[0-9]*\\.?[0-9]+") || valor.isEmpty()) {
            id = 0L;
        }
        else {
            String valorString = valor.replace(",", ".");
            setId(valor);
        }
    }



}
