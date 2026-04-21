package br.com.alura.screenmatch.principal;

import br.com.alura.screenmatch.model.DadosSerie;
import br.com.alura.screenmatch.service.ConsumoAPI;
import br.com.alura.screenmatch.service.ConverteDados;

import java.util.Scanner;

public class Principal {
    private Scanner leitura = new Scanner(System.in);

    //Constantes
    private final String ENDERECO_BUSCA = "https://www.omdbapi.com/?t=";
    private final String API_KEY = "&apiKey=351cada8";

    private ConsumoAPI consumidorAPI = new ConsumoAPI();
    private ConverteDados conversor = new ConverteDados();

     public void exibeMenu(){

         System.out.println("Digite o nome da série para busca:");
         var nomeSerie = leitura.nextLine();
         var json = consumidorAPI.obterDados(ENDERECO_BUSCA + nomeSerie.replace(" ", "+") + API_KEY);
         DadosSerie dados = conversor.obterDados(json, DadosSerie.class);
         System.out.println(dados);
     }
}
