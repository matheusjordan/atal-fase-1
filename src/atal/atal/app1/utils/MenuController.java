package atal.app1.utils;

import java.util.Scanner;

import atal.app1.models.EBook;
import atal.app1.models.SortBy;
import atal.list.ArrayListWithQuickSort;

public class MenuController {
	private static ArrayListWithQuickSort list = new ArrayListWithQuickSort();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n##### Entrega Fase 1 #####");
            System.out.println("##### Menu - Biblioteca #####");
            System.out.println("1. Criar Livro");
            System.out.println("2. Buscar Livro");
            System.out.println("3. Atualizar Livro");
            System.out.println("4. Remover Livro");
            System.out.println("5. Ordenar Livros");
            System.out.println("6. Todos os Livros");
            System.out.println("\n0. Sair");
            System.out.print("Escolha uma opção: ");
            
            
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                	adicionarLivros(scanner);
                    break;
                case 2:
                	obterLivro(scanner);
                case 3:
                    editarLivro(scanner);
                    break;
                case 4:
                    removerLivro(scanner);
                    break;
                case 5:
                    ordenarLista(scanner);
                    break;
                case 6:
                    exibirLista();
                    break;
                case 0:
                	break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }	
        } while (opcao != 0);

        scanner.close();
    }

    private static void adicionarLivros(Scanner scanner) {
        String opcao;
        
        do {
            System.out.println("\nCarregar livros do cache? (Digite '1' para confirmar e '0' para sair):");
        	opcao = scanner.nextLine();
        } while(!opcao.equals("1") && !opcao.equals("0"));
        
        if (opcao.equals("1")) {
        	carregarLivros();
        	
        } else {
            String id, title, author, publishDate;
            System.out.println("\nAdicione os novos Livros (Digite '00' para sair):");

            do {
                System.out.print("\nID do livro: ");
                id = scanner.nextLine();

                if (!id.equals("00")) {
                    System.out.print("Título: ");
                    title = scanner.nextLine();

                    System.out.print("Autor: ");
                    author = scanner.nextLine();

                    System.out.print("Ano de publicação: ");
                    publishDate = scanner.nextLine();

                    try {
                        Integer bookID = Integer.valueOf(id);
                        Integer year = Integer.valueOf(publishDate);

                        EBook livro = new EBook(bookID, title, author, year);
                        list.add(livro);
                 
                    } catch (NumberFormatException e) {
                        System.out.println("Entrada inválida. Por favor, insira números válidos para ID e ano de publicação.");
                    }
                }
            } while (!id.equals("00"));
        }
        System.out.println("Fim da adição de livros.");	
    }
    
    private static void editarLivro(Scanner scanner) {
    	System.out.print("\nDigite o índice do Livro (0 a " + (list.size() - 1) + "): ");
    	int index = Integer.valueOf(scanner.nextLine());
        
    	if (index >= 0 && index < list.size()) {
    		EBook selecionado = list.get(index); 
    		exibirLivro(selecionado);
    		
    		String id, title, author, publishDate;
            System.out.println("\nAdicione o novo Livro (Digite '00' para sair):");

            System.out.print("\nID do livro: ");
            scanner.reset();
            id = scanner.nextLine();

            if (!id.equals("00")) {
                System.out.print("Título: ");
                title = scanner.nextLine();

                System.out.print("Autor: ");
                author = scanner.nextLine();

                System.out.print("Ano de publicação: ");
                publishDate = scanner.nextLine();

                try {
                    Integer bookID = Integer.valueOf(id);
                    Integer year = Integer.valueOf(publishDate);

                    EBook livro = new EBook(bookID, title, author, year);
                    list.set(index, livro);
             
                } catch (NumberFormatException e) {
                    System.out.println("Entrada inválida. Por favor, insira números válidos para ID e ano de publicação.");
                }
            }
        
        } else {
            System.out.println("Índice inválido.");
        }
    }
    
    private static void carregarLivros() {
    	list.add(new EBook(1, "1984", "George Orwell", 1949));
        list.add(new EBook(9, "To Kill a Mockingbird", "Harper Lee", 1960));
        list.add(new EBook(7, "The Great Gatsby", "F. Scott Fitzgerald", 1925));
        list.add(new EBook(4, "Moby Dick", "Herman Melville", 1851));
        list.add(new EBook(10, "War and Peace", "Leo Tolstoy", 1869));
        list.add(new EBook(6, "Pride and Prejudice", "Jane Austen", 1813));
        list.add(new EBook(3, "The Catcher in the Rye", "J.D. Salinger", 1951));
        list.add(new EBook(8, "The Hobbit", "J.R.R. Tolkien", 1937));
        list.add(new EBook(2, "Brave New World", "Aldous Huxley", 1932));
        list.add(new EBook(5, "The Odyssey", "Homer", -800));
    }
    
    private static void exibirLivro(EBook book) {
    	System.out.println("\nLivro: " + book.getTitle());
		System.out.println("Author: " + book.getAuthor());
		System.out.println("Publicacao: " + book.getPublishDate());
		System.out.println("ID: " + book.getId());
		System.out.println();
    }

    private static void obterLivro(Scanner scanner) {
        System.out.print("\nDigite o índice do Livro (0 a " + (list.size() - 1) + "): ");
        int index = scanner.nextInt();
        if (index >= 0 && index < list.size()) {
        	EBook book = list.get(index);
        	exibirLivro(book);
        } else {
            System.out.println("Índice inválido.");
        }
    }
    
    private static void exibirLista() {
        if (list.isEmpty()) {
            System.out.println("\nA lista está vazia.");
        } else {
            System.out.println("\nLivros da Biblioteca:");
            for (int i = 0; i < list.size(); i++) {
    			EBook book = list.get(i);
    			exibirLivro(book);
    		}
        }
    }

    private static void removerLivro(Scanner scanner) {
        System.out.print("\nDigite o índice do Livro (0 a " + (list.size() - 1) + "): ");
        int index = scanner.nextInt();
        if (index >= 0 && index < list.size()) {
            list.remove(index);
        } else {
            System.out.println("Índice inválido.");
        }
    }
    
    private static void ordenarLista(Scanner scanner) {
        String opcao;

        System.out.println("\nComo desejar ordenar os Livros?");
        System.out.println("1. ID");
        System.out.println("2. Título");
        System.out.println("3. Autor");
        System.out.println("4. Ano de Publicação");
        System.out.print("Digite o número desejado: ");
        opcao = scanner.nextLine();

        switch (opcao) {
            case "1": 
                list.sort(SortBy.ID);
                break;
            case "2":
                list.sort(SortBy.TITLE);
                break;
            case "3":
                list.sort(SortBy.AUTHOR);
                break;
            case "4":
                list.sort(SortBy.PUBLISH_DATE);
                break;
            default:
                System.out.println("Opção inválida. A lista não será ordenada.");
                return;
        }
        exibirLista();
    }
}
