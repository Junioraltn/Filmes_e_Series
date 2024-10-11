package br.bigdata.screemath;

import br.bigdata.screemath.model.DadosSerie;
import br.bigdata.screemath.service.ConsumirApi;
import br.bigdata.screemath.service.ConverterDados;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class ScreemathApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ScreemathApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		var consumoApi = new ConsumirApi();


		Scanner ler = new Scanner(System.in);
		System.out.println("Digite um filme para busca: ");
		var busca = ler.nextLine();

		String endereço = "http://www.omdbapi.com/?t="+busca+"&apikey=c9aaad36";

		var json = consumoApi.obterDados(endereço);
		System.out.println(json);

		ConverterDados conversor = new ConverterDados();
		DadosSerie dados = conversor.obterDados(json,DadosSerie.class);
		System.out.println(dados);
	}
}