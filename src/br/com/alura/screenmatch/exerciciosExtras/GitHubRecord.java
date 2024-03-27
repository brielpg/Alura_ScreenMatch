package br.com.alura.screenmatch.exerciciosExtras;

public record GitHubRecord(String name, int id, String avatar_url, String html_url) {
    @Override
    public String toString() {
        return String.format("Usuario: %s | Id: %s | Avatar: %s | Perfil: %s",name,id,avatar_url,html_url);
    }
}
