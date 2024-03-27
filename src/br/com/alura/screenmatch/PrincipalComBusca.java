package br.com.alura.screenmatch;

import br.com.alura.screenmatch.excessoes.ErroDeConversaoDeAnoException;
import br.com.alura.screenmatch.modelos.Titulo;
import br.com.alura.screenmatch.modelos.TituloOmdb;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PrincipalComBusca {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner scanner = new Scanner(System.in);
        String filmeDesejado = "";
        List<Titulo> titulos = new ArrayList<>();

        Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .setPrettyPrinting()
                .create();

        while (!filmeDesejado.equalsIgnoreCase("sair")) {
            System.out.println("Escolha o filme que deseja: ");
            filmeDesejado = scanner.next();
            String apiKey = "INSIRA_SUA_API_KEY_AQUI";
            String endereco = "https://www.omdbapi.com/?t=" + filmeDesejado + "&apikey=" + apiKey;

            if(filmeDesejado.equalsIgnoreCase("sair")){
                break;
            }

            try {
                HttpClient client = HttpClient.newHttpClient();
                HttpRequest request = HttpRequest.newBuilder().uri(URI.create(endereco)).build();
                HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

                String json = response.body();
                TituloOmdb meuTituloOmdb = gson.fromJson(json, TituloOmdb.class);
                Titulo meuTitulo = new Titulo(meuTituloOmdb);
                titulos.add(meuTitulo);

                System.out.println("Titulo já convertido");
                System.out.println(meuTitulo);
            } catch (NumberFormatException e) {
                System.out.println("Aconteceu um erro: " + e.getMessage());
            } catch (IllegalArgumentException e) {
                System.out.println("Aconteceu um erro na busca, verifique o endereço");
            } catch (ErroDeConversaoDeAnoException e) {
                System.out.println(e.getMessage());
            }
            FileWriter file = new FileWriter("filmes.json");
            file.write(gson.toJson(titulos));
            file.close();

            System.out.println("O programa finalizou corretamente!");

        }
    }
}
