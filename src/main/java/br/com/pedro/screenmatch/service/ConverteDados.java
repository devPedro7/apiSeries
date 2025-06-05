package br.com.pedro.screenmatch.service;

import br.com.pedro.screenmatch.interfaces.IConvertDados;
import br.com.pedro.screenmatch.model.DadosSerie;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ConverteDados implements IConvertDados {
    @Override
    public <T> T obterDados(String json, Class<T> classe) {
        try {
            return mapper.readValue(json, classe);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    private ObjectMapper mapper = new ObjectMapper();



}
