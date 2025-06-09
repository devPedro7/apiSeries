package br.com.pedro.screenmatch.principal;

import br.com.pedro.screenmatch.model.DadosEpisodios;
import br.com.pedro.screenmatch.model.DadosSerie;
import br.com.pedro.screenmatch.model.DadosTemporada;
import br.com.pedro.screenmatch.service.ConsumoApi;
import br.com.pedro.screenmatch.service.ConverteDados;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {

    private Scanner leitorSerie = new Scanner(System.in);

    private final String ENDERECO = "https://www.omdbapi.com/?t=";
    private final String API_KEY = "&apikey=6fe3c211";
    private ConsumoApi consumo = new ConsumoApi();
    private ConverteDados conversor = new ConverteDados();

    public void exibeMenu() {
        System.out.println("Digite o nome da série que você quer buscar: ");
        var nomeSerie = leitorSerie.nextLine();
        var json = consumo.obterDadosAPI(ENDERECO + nomeSerie.replace(" ", "+") + API_KEY);

        DadosSerie dadosSerie = conversor.obterDados(json, DadosSerie.class);
        System.out.println("\n📺 Série encontrada:");
        System.out.println(dadosSerie);

        List<DadosTemporada> listaTemporadas = new ArrayList<>();
        for (int i = 1; i <= dadosSerie.totalTemporadas(); i++) {
            var jsonTemporada = consumo.obterDadosAPI(
                    ENDERECO + nomeSerie.replace(" ", "+") + "&season=" + i + API_KEY
            );
            DadosTemporada dadosTemporada = conversor.obterDados(jsonTemporada, DadosTemporada.class);
            listaTemporadas.add(dadosTemporada);
        }

        System.out.println("\n📆 Episódios por temporada:");
        int temporadaAtual = 1;
        for (DadosTemporada temporada : listaTemporadas) {
            System.out.println("\nTemporada " + temporadaAtual++);
            for (DadosEpisodios ep : temporada.episodios()) {
                System.out.println(" - " + ep.titulo());
            }

       // listaTemporadas.forEach(t -> t.episodios().forEach(e -> System.out.println(e.titulo())));
        }
    }
}
