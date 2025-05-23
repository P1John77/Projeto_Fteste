// Arquivo: Main.java
import controller.ProdutoController;
import model.Produto;

import java.util.List;
import java.util.Scanner;

public class Main {
    private static ProdutoController produtoController = new ProdutoController();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcao;
        do {
            System.out.println("\n==== MENU ====");
            System.out.println("1. Adicionar Produto");
            System.out.println("2. Listar Produtos");
            System.out.println("3. Editar Produto");
            System.out.println("4. Remover Produto");
            System.out.println("5. Adicionar ao Carrinho");
            System.out.println("6. Visualizar Carrinho");
            System.out.println("7. Limpar Carrinho");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar buffer

            switch (opcao) {
                case 1:
                    adicionarProduto();
                    break;
                case 2:
                    listarProdutos();
                    break;
                case 3:
                    editarProduto();
                    break;
                case 4:
                    removerProduto();
                    break;
                case 5:
                    adicionarAoCarrinho();
                    break;
                case 6:
                    visualizarCarrinho();
                    break;
                case 7:
                    limparCarrinho();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 0);
    }

    private static void adicionarProduto() {
        Produto produto = new Produto();

        System.out.print("Nome: ");
        produto.setNome(scanner.nextLine());

        System.out.print("Descrição: ");
        produto.setDescricao(scanner.nextLine());

        System.out.print("Preço: ");
        produto.setPreco(scanner.nextDouble());
        scanner.nextLine();

        System.out.print("Tamanho: ");
        produto.setTamanho(scanner.nextLine());

        System.out.print("Cor: ");
        produto.setCor(scanner.nextLine());

        System.out.print("Categoria: ");
        produto.setCategoria(scanner.nextLine());

        System.out.print("Quantidade em Estoque: ");
        produto.setQuantidadeEstoque(scanner.nextInt());
        scanner.nextLine();

        System.out.print("URL Post Instagram: ");
        produto.setUrlPostInstagram(scanner.nextLine());

        System.out.print("Disponível (true/false): ");
        produto.setDisponivel(scanner.nextBoolean());
        scanner.nextLine();

        produto = produtoController.salvar(produto);
        System.out.println("Produto adicionado com sucesso! ID: " + produto.getId());
    }

    private static void listarProdutos() {
        List<Produto> produtos = produtoController.listarTodos();
        if (produtos.isEmpty()) {
            System.out.println("Nenhum produto cadastrado.");
        } else {
            System.out.println("\n=== LISTA DE PRODUTOS ===");
            for (Produto p : produtos) {
                System.out.println(p);
            }
        }
    }

    private static void editarProduto() {
        listarProdutos();
        System.out.print("\nDigite o ID do produto que deseja editar: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Produto produto = produtoController.buscarPorId(id);
        if (produto == null) {
            System.out.println("Produto não encontrado!");
            return;
        }

        System.out.println("Editando produto: " + produto.getNome());
        System.out.println("Deixe em branco para manter o valor atual.");

        System.out.print("Nome (" + produto.getNome() + "): ");
        String nome = scanner.nextLine();
        if (!nome.isEmpty()) produto.setNome(nome);

        System.out.print("Descrição (" + produto.getDescricao() + "): ");
        String descricao = scanner.nextLine();
        if (!descricao.isEmpty()) produto.setDescricao(descricao);

        // Continue para todos os outros campos...

        produtoController.salvar(produto);
        System.out.println("Produto atualizado com sucesso!");
    }

    private static void removerProduto() {
        listarProdutos();
        System.out.print("\nDigite o ID do produto que deseja remover: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        if (produtoController.remover(id)) {
            System.out.println("Produto removido com sucesso!");
        } else {
            System.out.println("Produto não encontrado!");
        }
    }

    private static void adicionarAoCarrinho() {
        listarProdutos();
        System.out.print("\nDigite o ID do produto que deseja adicionar ao carrinho: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Produto produto = produtoController.buscarPorId(id);
        if (produto != null) {
            produtoController.adicionarAoCarrinho(produto);
            System.out.println("Produto adicionado ao carrinho!");
        } else {
            System.out.println("Produto não encontrado!");
        }
    }

    private static void visualizarCarrinho() {
        List<Produto> carrinho = produtoController.visualizarCarrinho();
        if (carrinho.isEmpty()) {
            System.out.println("Carrinho vazio!");
        } else {
            System.out.println("\n=== CARRINHO DE COMPRAS ===");
            double total = 0;
            for (Produto p : carrinho) {
                System.out.println(p.getNome() + " - R$" + p.getPreco());
                total += p.getPreco();
            }
            System.out.println("TOTAL: R$" + total);
        }
    }

    private static void limparCarrinho() {
        produtoController.limparCarrinho();
        System.out.println("Carrinho limpo com sucesso!");
    }
}
