package br.com.pedro.screenmatch.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@JsonIgnoreProperties(ignoreUnknown = true) //AQUI ELE IGNORA O QUE NAO ESTIVER MAPEADO PARA NAO DAR ERRO
public record DadosSerie(@JsonAlias("Title") String titulo, @JsonAlias("Year") String ano, @JsonAlias("Genre") String genero,
                         @JsonAlias("totalSeasons") Integer totalTemporadas, @JsonAlias("imdbRating") String avaliacao) {

}
