package br.com.pedro.screenmatch;

import br.com.pedro.screenmatch.model.DadosEpisodios;
import br.com.pedro.screenmatch.model.DadosSerie;
import br.com.pedro.screenmatch.service.ConsumoApi;
import br.com.pedro.screenmatch.service.ConverteDados;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ScreenmatchApplication implements CommandLineRunner {

	public static void main(String[] args)  {

		SpringApplication.run(ScreenmatchApplication.class, args);

	}

	@Override//tudo o que estiver aqui vai ser compilado no terminal
	public void run(String... args) throws Exception {

		ConsumoApi consumoApi = new ConsumoApi();
		var jsonSerie = consumoApi.obterDadosAPI("https://www.omdbapi.com/?t=supernatural&apikey=6fe3c211");
		var jsonEpisodio = consumoApi.obterDadosAPI("https://www.omdbapi.com/?t=supernatural&season=1&episode=1&apikey=6fe3c211");
		//System.out.println(json);

		ConverteDados conversor = new ConverteDados();
		DadosSerie dados = conversor.obterDados(jsonSerie, DadosSerie.class);

		DadosEpisodios dadosEpisodios = conversor.obterDados(jsonEpisodio, DadosEpisodios.class);

		System.out.println("Dados da série: " + dados);
		System.out.println("Dados do episódio: " + dadosEpisodios);


	}
}
