package model.entities;

import java.util.InputMismatchException;

public abstract class Product {
    private String nome;
    private Double preco;
    private Double porcentagem;

    public Product() {
    }

    public Product(String nome, Double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public Double getPreco() {
        return preco;
    }

    public Double getPorcentagem() {
        return porcentagem;
    }

    public Double calcularDesconto(double porcentagem) throws InputMismatchException {
        Double calculoPorcentagem = preco * porcentagem / 100;
        this.porcentagem = porcentagem;
        return preco - calculoPorcentagem;
    }
}
