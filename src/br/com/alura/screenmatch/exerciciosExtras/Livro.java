package br.com.alura.screenmatch.exerciciosExtras;

public record Livro(String titulo, String autor, Editora editora) {
    @Override
    public String toString() {
        return String.format("Livro: %s | Autor(a): %s\nEditora %s", titulo, autor, editora);
    }
}
