package br.com.alura.screenmatch.exerciciosExtras;

public record Pessoa(String nome, int idade, String cidade) {

    @Override
    public String toString() {
        return String.format("%s (%s) | %s",nome,idade,cidade);
    }
}
