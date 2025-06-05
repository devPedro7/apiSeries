package br.com.pedro.screenmatch.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosEpisodios(@JsonAlias("Title") String titulo, @JsonAlias("Season") Integer temporada, @JsonAlias("Episode")Integer numeroEpisodio, @JsonAlias("imdbRating")String avaliacaoEpisodio,
                             @JsonAlias("Released")String dataLancamento) {


}
