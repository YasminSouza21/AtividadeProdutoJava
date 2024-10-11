package model.view;

import model.entities.Eletrodomestico;
import model.entities.Livros;
import model.entities.enums.CategoriasLivro;
import model.services.EstoqueService;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);

        try (Scanner sc = new Scanner(System.in)) {
            EstoqueService estoque = new EstoqueService(new ArrayList<>());
            String resp;
            do {
                opcoesDeEscolha();
                int opcaoEscolhida = sc.nextInt();
                switch (opcaoEscolhida) {
                    case 1:
                        opcaoEscolhaProduto();
                        int opcaoEscolhidaProduto = sc.nextInt();
                        System.out.println("Qual o nome do produto: ");
                        sc.nextLine();
                        String nomeProduto = sc.nextLine();
                        System.out.println("Qual o preco do produto: ");
                        double precoProduto = sc.nextDouble();
                        if (opcaoEscolhidaProduto == 2) {
                            opcaoCategoriaLivro();
                            int opcaoEscolhidaCategoriaLivro = sc.nextInt();
                            if (opcaoEscolhidaCategoriaLivro == 1) {
                                estoque.addItem(new Livros(nomeProduto, precoProduto, CategoriasLivro.ROMANCE));
                            } else if (opcaoEscolhidaCategoriaLivro == 2) {
                                estoque.addItem(new Livros(nomeProduto, precoProduto, CategoriasLivro.HEROI));
                            } else if (opcaoEscolhidaCategoriaLivro == 3) {
                                estoque.addItem(new Livros(nomeProduto, precoProduto, CategoriasLivro.ACAO));
                            } else if (opcaoEscolhidaCategoriaLivro == 4) {
                                estoque.addItem(new Livros(nomeProduto, precoProduto, CategoriasLivro.TERROR));
                            } else if (opcaoEscolhidaCategoriaLivro == 5) {
                                estoque.addItem(new Livros(nomeProduto, precoProduto, CategoriasLivro.SUSPENSE));
                            } else if (opcaoEscolhidaCategoriaLivro == 6) {
                                estoque.addItem(new Livros(nomeProduto, precoProduto, CategoriasLivro.FANTASIA));
                            } else {
                                System.out.println("Opção inexistente");
                            }
                        } else {
                            estoque.addItem(new Eletrodomestico(nomeProduto, precoProduto));
                        }
                        break;
                    case 2:
                        System.out.println("Qual item você deseja remover: ");
                        for (int i = 0; i < estoque.getProducts().size(); i++) {
                            System.out.printf("Item %d°- %s%n", i, estoque.getProducts().get(i).getNome());
                        }
                        int itemRemovido = sc.nextInt();
                        estoque.removeItem(estoque.getProducts().get(itemRemovido));
                        break;
                    case 3:
                        estoque.calcularPrecosComDesconto(estoque.getProducts(), sc);
                        break;
                    case 4:
                        estoque.exibirPrecosComDesconto(estoque.getProducts());
                        break;
                    case 5:
                        System.out.println("Saindo...");
                        break;
                    default:
                        System.out.println("Opção inexistente");
                }

                System.out.println("Deseja continuar? (S/N)");
                sc.nextLine();
                resp = sc.nextLine();
            } while (resp.equals("S"));

        } catch (InputMismatchException e) {
            System.out.println("Digite valores permitidos");

        } catch (IndexOutOfBoundsException e) {
            System.out.println("Valor de item inexistente");
        }

    }

    public static void opcoesDeEscolha() {
        System.out.println("""
                Deseja escolher qual opção:
                1 - Adicionar item na lista
                2 - Remover item da lista
                3 - Calcular descontos dos itens da lista
                4 - Exibir itens na lista
                5 - Sair
                """);
    }

    public static void opcaoEscolhaProduto() {
        System.out.println("""
                Qual opção você deseja escolher:
                1- Adicionar produto de eletrodomestico
                2- Adicionar produto de livro
                """);
    }

    public static void opcaoCategoriaLivro() {
        System.out.println("""
                Qual a categoria do livro que voce deseja escolher:
                1 - ROMANCE
                2 - HEROI
                3 - ACAO
                4 - TERROR
                5 - SUSPENSE
                6 - FANTASIA
                """);
    }

}