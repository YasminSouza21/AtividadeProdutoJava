package model.services;

import model.entities.Product;

import java.util.List;
import java.util.Scanner;

public class EstoqueService {

    private List<Product> products;

    public EstoqueService(List<Product> products) {
        this.products = products;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void calcularPrecosComDesconto(List<? extends Product> products, Scanner sc) {
        double desconto = 0;
        for (int i = 0; i < products.size(); i++) {
            System.out.printf("Digite o desconto para o %s° item: ", i + 1);
            desconto = sc.nextDouble();
            products.get(i).calcularDesconto(desconto);
        }
    }

    public void exibirPrecosComDesconto(List<? extends Product> products) {
        for (Product product : products
        ) {
            System.out.printf("""
                    Item: %s
                    Valor sem desconto: R$%.2f
                    Valor com desconto: R$%.2f
                    """, product.getNome(), product.getPreco(), product.calcularDesconto(product.getPorcentagem()));
        }
    }

    public void addItem(Product product) {
        products.add(product);
    }

    public void removeItem(Product product) {
        products.remove(product);
    }
}
