package model.entities;

import java.util.InputMismatchException;

public class Eletrodomestico extends Product {

    public Eletrodomestico(String nome, Double preco) {
        super(nome, preco);
    }

    @Override
    public Double calcularDesconto(double porcentagem) throws InputMismatchException {
        if (porcentagem >= 50) {
            return super.calcularDesconto(porcentagem) - 50;
        } else {
            return super.calcularDesconto(porcentagem) - 100;
        }
    }
}
