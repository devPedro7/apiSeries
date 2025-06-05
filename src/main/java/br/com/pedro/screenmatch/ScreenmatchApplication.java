package br.com.pedro.screenmatch;

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
		var json = consumoApi.obterDadosAPI("https://www.omdbapi.com/?t=supernatural&apikey=6fe3c211");
		//System.out.println(json);

		ConverteDados conversor = new ConverteDados();
		DadosSerie dados = conversor.obterDados(json, DadosSerie.class);

		System.out.println(dados);


	}
}
