package br.com.alura.screenmatch.exerciciosExtras;

import br.com.alura.screenmatch.exerciciosExtras.TituloDesafio;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class main1 {
    public static void main(String[] args) throws IOException {
        //PESSOA
        String json = "{" +
                            "\"nome\":\"Rodrigo\"," +
                            "\"idade\":20," +
                            "\"cidade\":\"Brasília\"" +
                    "}";

        Gson gson = new GsonBuilder().setLenient().create();
        Pessoa pessoa1 = gson.fromJson(json, Pessoa.class);

        System.out.println(pessoa1);
        //LIVRO
        String jsonLivro = "{" +
                                "\"titulo\":\"Aventuras do Java\"," +
                                "\"autor\":\"Akemi\"," +
                                "\"editora\":{\"nome\":\"TechBooks\",\"cidade\":\"São Paulo\"}" +
                            "}";

        Gson gsonLivro = new Gson();
        Livro livro1 = gsonLivro.fromJson(jsonLivro, Livro.class);
        System.out.println(livro1);
        //DIVISAO
        int numero1 = 10;
        int numero2 = 0;
        try {
            System.out.println(numero1/numero2);
        }catch (ArithmeticException e){
            System.out.println("Ocorreu algum erro aritimético: " + e.getMessage());
        }
        //SENHA
        String senha = "";

        try {
            if (senha.length() < 8) {
                throw new SenhaInvalidaException("A senha deve ter pelo menos 8 caracteres.");
            }
            System.out.println("Senha válida. Acesso permitido.");
        } catch (SenhaInvalidaException e) {
            System.out.println("Erro: " + e.getMessage());
        }
        //GITHUB
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o nome de usuário do GitHub para consultar informações: ");
        String usuario = scanner.next();
        String endereco = "https://api.github.com/users/"+usuario;

        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder().uri(URI.create(endereco)).build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 404){
                throw new ErroConsultaGitHubException("Usuario nao encontrado");
            }

            String jsonGithub = response.body();
            Gson gsonGithub = new Gson();
            System.out.println(gsonGithub.fromJson(jsonGithub, GitHubRecord.class));

        }catch (IOException | InterruptedException e){
            System.out.println(e.getMessage());
        }catch (ErroConsultaGitHubException e){
            System.out.println(e.getMessage());
        }


        //  DESAFIO


        FileWriter file = new FileWriter("arquivo.txt");
        file.write("Conteúdo a ser gravado no arquivo");
        file.close();

        TituloDesafio titulo1 = new TituloDesafio("TituloTeste", 1990, 150);
        Gson gsonDesafio = new GsonBuilder().setPrettyPrinting().create();
        System.out.println(gsonDesafio.toJson(titulo1));
    }
}
