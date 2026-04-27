package br.com.alura.screenmatch.principal;

import br.com.alura.screenmatch.model.DadosEpisodio;
import br.com.alura.screenmatch.model.DadosSerie;
import br.com.alura.screenmatch.model.DadosTemporada;
import br.com.alura.screenmatch.service.ConsumoAPI;
import br.com.alura.screenmatch.service.ConverteDados;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Principal {
    private Scanner leitura = new Scanner(System.in);
    private ConsumoAPI consumidorAPI = new ConsumoAPI();
    private ConverteDados conversor = new ConverteDados();

    //Constantes
    private final String ENDERECO_BUSCA = "https://www.omdbapi.com/?t=";
    private final String API_KEY = "&apiKey=351cada8";

     public void exibeMenu(){

         /*System.out.println("Digite o nome da série para busca:");
         var nomeSerie = leitura.nextLine();
         var json = consumidorAPI.obterDados(ENDERECO_BUSCA + nomeSerie.replace(" ", "+") + API_KEY);
         DadosSerie dados = conversor.obterDados(json, DadosSerie.class);
         System.out.println(dados);

         List<DadosTemporada> temporadas = new ArrayList<>();
         for ( int i = 1; i <= dados.totalTemporadas(); i++){
             json = consumidorAPI.obterDados(ENDERECO_BUSCA + nomeSerie.replace(" ", "+") + "&season=" + i + API_KEY);
             DadosTemporada dadosTemporada  = conversor.obterDados(json, DadosTemporada.class);
             temporadas.add(dadosTemporada);
         }

         temporadas.forEach(t -> t.episodios().forEach( e -> System.out.println("Título: " + e.titulo() + " /" +
                 " Avaliação: " + e.avaliacao() + " /" +
                 " Lançado em: " + e.dataLancamento())));*/

         List<String> nomes = Arrays.asList("Jacque", "Iasmin", "Paulo", "Rodrigo", "Nico");
         nomes.stream()
                 .sorted()
                 .filter(n -> n.startsWith("N"))
                 .limit(3) // operações intermediárias - processamento dos dados
                 .map(n -> n.toUpperCase())
                 .forEach(System.out::println); // operações finais - saída

     }
}
