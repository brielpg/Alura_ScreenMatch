package br.com.alura.screenmatch.exerciciosExtras;

public class TituloDesafio {
    private String nome;
    private int anoDeLancamento;
    private int duracaoEmMinutos;

    public TituloDesafio(String nome, int anoDeLancamento, int duracaoEmMinutos) {
        this.nome = nome;
        this.anoDeLancamento = anoDeLancamento;
        this.duracaoEmMinutos = duracaoEmMinutos;
    }

    public String getNome() {
        return nome;
    }

    public int getAnoDeLancamento() {
        return anoDeLancamento;
    }

    public int getDuracaoEmMinutos() {
        return duracaoEmMinutos;
    }

    @Override
    public String toString() {
        return String.format("%s (%s) | %s min",nome,anoDeLancamento,duracaoEmMinutos);
    }
}
