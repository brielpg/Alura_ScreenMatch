package br.com.alura.screenmatch;

import br.com.alura.screenmatch.modelos.Movie;
import br.com.alura.screenmatch.modelos.Serie;
import br.com.alura.screenmatch.modelos.Titulo;

import java.util.ArrayList;
import java.util.List;

public class PrincipalComListas {
    public static void main(String[] args) {
        Movie filme1 = new Movie("O poderoso chefão", 1970);
        filme1.avalia(9);

        Movie filme2 = new Movie("Avatar", 2023);
        filme2.avalia(6);

        Movie filme3 = new Movie("Dogville", 2003);
        filme3.avalia(10);

        Serie lost = new Serie("Lost", 2000);

        List<Titulo> lista = new ArrayList<>();
        lista.add(filme1);
        lista.add(filme2);
        lista.add(filme3);
        lista.add(lost);
        for (Titulo item: lista) {
            System.out.println(item.getNome());
            if (item instanceof  Movie filme && filme.getClassificacao() > 2) {
                System.out.println("Classificação " + filme.getClassificacao());
            }

        }
    }
}
