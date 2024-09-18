package atal.app1.utils;

import java.util.Scanner;

import atal.app1.models.EBook;
import atal.list.ListaSequencial;

public class OptionsMenu {
	private static ListaSequencial<String> list = new ListaSequencial<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n##### Entrega Fase 1 #####");
            System.out.println("##### Menu - Biblioteca #####");
            System.out.println("1. Adicionar Livro");
            System.out.println("2. Buscar Livro");
            System.out.println("3. Remover Livro");
            System.out.println("4. Ordenar Livros");
            System.out.println("5. Todos os Livros");
            System.out.println("\n00. Sair");
            System.out.print("Escolha uma opção: ");
            
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    adicionarElemento(scanner);
                    break;
                case 2:
                    obterElemento(scanner);
                    break;
                case 3:
                    removerElemento(scanner);
                    break;
                case 4:
//                    ordenarLista();
                    break;
                case 5:
                    exibirLista();
                    break;
                case 6:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 00);

        scanner.close();
    }

    private static void adicionarElemento(Scanner scanner) {
        String elemento;
        System.out.println("\nDigite os elementos a serem adicionados (Digite '00' para sair):");
        
        do {
            System.out.print("Elemento: ");
            elemento = scanner.nextLine();
            
            if (!elemento.equals("00")) {
                list.add(elemento);
            }
        } while (!elemento.equals("00"));
        
        System.out.println("Fim da adição de elementos.");
    }

    private static void obterElemento(Scanner scanner) {
        System.out.print("\nDigite o índice do elemento (0 a " + (list.size() - 1) + "): ");
        int index = scanner.nextInt();
        if (index >= 0 && index < list.size()) {
            System.out.println("Elemento no índice " + index + ": " + list.get(index));
        } else {
            System.out.println("Índice inválido.");
        }
    }
    
    private static void exibirLista() {
        if (list.isEmpty()) {
            System.out.println("\nA lista está vazia.");
        } else {
            System.out.println("\nElementos da lista:");
            for (int i = 0; i < list.size(); i++) {
                System.out.println(i + ": " + list.get(i));
            }
        }
    }

    private static void removerElemento(Scanner scanner) {
        System.out.print("\nDigite o índice do elemento a ser removido (0 a " + (list.size() - 1) + "): ");
        int index = scanner.nextInt();
        if (index >= 0 && index < list.size()) {
            list.remove(index);
        } else {
            System.out.println("Índice inválido.");
        }
    }
//
//    private static void ordenarLista() {
//        list.sort(String::compareTo);
//        System.out.println("Lista ordenada com sucesso.");
//    }
}
