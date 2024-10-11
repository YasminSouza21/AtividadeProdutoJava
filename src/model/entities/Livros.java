package model.entities;

import model.entities.enums.CategoriasLivro;

import java.util.InputMismatchException;

public class Livros extends Product {
    private CategoriasLivro categoriaLivro;

    public Livros(String nome, Double preco, CategoriasLivro categoriaLivro) {
        super(nome, preco);
        this.categoriaLivro = categoriaLivro;
    }

    public CategoriasLivro getCategoriaLivro() {
        return categoriaLivro;
    }


    @Override
    public Double calcularDesconto(double porcentagem) throws InputMismatchException {
        if (categoriaLivro.equals(CategoriasLivro.ROMANCE)) {
            return super.calcularDesconto(porcentagem) - 50.0;
        } else if (categoriaLivro.equals(CategoriasLivro.HEROI)) {
            return super.calcularDesconto(porcentagem) - 40.0;
        } else if (categoriaLivro.equals(CategoriasLivro.FANTASIA)) {
            return super.calcularDesconto(porcentagem) - 30.0;
        } else if (categoriaLivro.equals(CategoriasLivro.SUSPENSE)) {
            return super.calcularDesconto(porcentagem) - 20.0;
        } else {
            return super.calcularDesconto(porcentagem) - 10.0;
        }
    }
}
