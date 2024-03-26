package br.com.alura.screenmatch.exerciciosExtras;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class main1 {
    public static void main(String[] args) {
        String json = "{" +
                            "\"nome\":\"Rodrigo\"," +
                            "\"idade\":20," +
                            "\"cidade\":\"Brasília\"" +
                    "}";

        Gson gson = new GsonBuilder().setLenient().create();
        Pessoa pessoa1 = gson.fromJson(json, Pessoa.class);

        System.out.println(pessoa1);

        String jsonLivro = "{" +
                                "\"titulo\":\"Aventuras do Java\"," +
                                "\"autor\":\"Akemi\"," +
                                "\"editora\":{\"nome\":\"TechBooks\",\"cidade\":\"São Paulo\"}" +
                            "}";

        Gson gsonLivro = new Gson();
        Livro livro1 = gsonLivro.fromJson(jsonLivro, Livro.class);
        System.out.println(livro1);
    }
}
