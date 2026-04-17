package br.com.alura.screenmatch;

import br.com.alura.screenmatch.model.DadosEpisodio;
import br.com.alura.screenmatch.model.DadosSerie;
import br.com.alura.screenmatch.service.ConsumoAPI;
import br.com.alura.screenmatch.service.ConverteDados;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@SpringBootApplication
public class ScreenmatchApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ScreenmatchApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Primeiro projeto Spring sem Web");

		//"https://www.omdbapi.com/?t=" + busca.replace(" ", "+") + "&plot=full&apiKey=351cada8"


		var consumidorAPI = new ConsumoAPI();
		var json = consumidorAPI.obterDados("https://www.omdbapi.com/?t=breaking+bad&plot=full&apiKey=351cada8");
		System.out.println(json);
		/*json = consumidorAPI.obterDados("https://coffee.alexflipnote.dev/random.json");
		System.out.println(json);*/
        var conversor = new ConverteDados();
		DadosSerie dados = conversor.obterDados(json, DadosSerie.class);
		System.out.println(dados);
		json = consumidorAPI.obterDados("https://www.omdbapi.com/?t=breaking+bad&season=3&episode=10&plot=full&apiKey=351cada8");
		DadosEpisodio dadosEpisodio = conversor.obterDados(json, DadosEpisodio.class);
		System.out.println(dadosEpisodio);
	}



}
