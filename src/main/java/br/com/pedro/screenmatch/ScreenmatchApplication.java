package br.com.pedro.screenmatch;

import br.com.pedro.screenmatch.principal.Principal;
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

        Principal principal = new Principal();
        principal.exibeMenu();


    }
}