package br.com.alura.screenmatch.exerciciosExtras;

public record Editora(String nome, String cidade) {
    @Override
    public String toString() {
        return String.format("%s (%s)",nome,cidade);
    }
}
