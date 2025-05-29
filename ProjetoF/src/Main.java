import controller.ProdutoController;
import model.*;
import service.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static ProdutoController produtoController = new ProdutoController();
    private static CarrinhoService carrinhoService = new CarrinhoService();
    private static ComparadorService comparadorService = new ComparadorService();
    private static CompartilhamentoService compartilhamentoService = new CompartilhamentoService();
    private static DestaqueService destaqueService = new DestaqueService();
    private static EstoqueService estoqueService = new EstoqueService();
    private static FiltroService filtroService = new FiltroService();
    private static ProdutoService produtoService = new ProdutoService();
    private static SugestaoService sugestaoService = new SugestaoService();
    private static TagService tagService = new TagService();

    private static Scanner scanner = new Scanner(System.in);
    private static Usuario usuarioAtual;
    public static void main(String[] args) {
        inicializarSistema();
        menuPrincipal();
    }

    private static void inicializarSistema() {
        usuarioAtual = new Usuario();
        usuarioAtual.setId(1);
        usuarioAtual.setNome("Usuário Padrão");
        usuarioAtual.setEmail("usuario@email.com");

        Produto produto1 = new Produto();
        produto1.setId(1);
        produto1.setNome("Camiseta Básica");
        produto1.setPreco(29.90);
        produtoController.salvar(produto1);

        Produto produto2 = new Produto();
        produto2.setId(2);
        produto2.setNome("Calça Jeans");
        produto2.setPreco(99.90);
        produtoController.salvar(produto2);
    }

    private static void menuPrincipal() {
        int opcao;
        do {
            System.out.println("\n=== SISTEMA DE PRODUTOS ===");
            System.out.println("1. Gerenciar Produtos");
            System.out.println("2. Gerenciar Carrinho");
            System.out.println("3. Comparar Produtos");
            System.out.println("4. Gerenciar Avaliações");
            System.out.println("5. Histórico do Usuário");
            System.out.println("6. Gerenciar Perguntas");
            System.out.println("7. Produtos Personalizados");
            System.out.println("8. Serviços Adicionais");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    menuProdutos();
                    break;
                case 2:
                    menuCarrinho();
                    break;
                case 3:
                    menuComparador();
                    break;
                case 4:
                    menuAvaliacoes();
                    break;
                case 5:
                    menuHistoricoUsuario();
                    break;
                case 6:
                    menuPerguntas();
                    break;
                case 7:
                    menuProdutosPersonalizados();
                    break;
                case 8:
                    menuServicosAdicionais();
                    break;
                case 0:
                    System.out.println("Saindo do sistema...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 0);
    }

    private static void menuProdutos() {
        int opcao;
        do {
            System.out.println("\n=== GERENCIAR PRODUTOS ===");
            System.out.println("1. Adicionar Produto");
            System.out.println("2. Listar Produtos");
            System.out.println("3. Editar Produto");
            System.out.println("4. Remover Produto");
            System.out.println("5. Ver Detalhes do Produto");
            System.out.println("0. Voltar");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();
            scanner.nextLine();

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
                    verDetalhesProduto();
                    break;
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
                System.out.println("ID: " + p.getId() + " | " + p.getNome() + " | R$" + p.getPreco());
            }
        }
    }

    private static void menuCarrinho() {
        int opcao;
        do {
            System.out.println("\n=== GERENCIAR CARRINHO ===");
            System.out.println("1. Adicionar ao Carrinho");
            System.out.println("2. Visualizar Carrinho");
            System.out.println("3. Remover do Carrinho");
            System.out.println("4. Limpar Carrinho");
            System.out.println("5. Finalizar Compra");
            System.out.println("0. Voltar");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    adicionarAoCarrinho();
                    break;
                case 2:
                    visualizarCarrinho();
                    break;
                case 3:
                    removerDoCarrinho();
                    break;
                case 4:
                    limparCarrinho();
                    break;
                case 5:
                    finalizarCompra();
                    break;
            }
        } while (opcao != 0);
    }

    private static void adicionarAoCarrinho() {
        listarProdutos();
        System.out.print("\nDigite o ID do produto que deseja adicionar ao carrinho: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Produto produto = produtoController.buscarPorId(id);
        if (produto != null) {
            carrinhoService.adicionarItem(produto);
            System.out.println("Produto adicionado ao carrinho!");
        } else {
            System.out.println("Produto não encontrado!");
        }
    }

    private static void visualizarCarrinho() {
        List<Produto> itens = carrinhoService.getItens();
        if (itens.isEmpty()) {
            System.out.println("Carrinho vazio!");
        } else {
            System.out.println("\n=== CARRINHO DE COMPRAS ===");
            double total = 0;
            for (Produto p : itens) {
                System.out.println(p.getNome() + " - R$" + p.getPreco());
                total += p.getPreco();
            }
            System.out.println("TOTAL: R$" + total);
        }
    }

    private static void menuAlertasPreco() {
        int opcao;
        do {
            System.out.println("\n=== ALERTAS DE PREÇO ===");
            System.out.println("1. Criar Alerta de Preço");
            System.out.println("2. Meus Alertas");
            System.out.println("3. Remover Alerta");
            System.out.println("0. Voltar");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();
            scanner.nextLine();

        } while (opcao != 0);
    }

    private static void finalizarCompra() {
        if (carrinhoService.getItens().isEmpty()) {
            System.out.println("Carrinho vazio! Adicione produtos antes de finalizar.");
            return;
        }

        System.out.println("\n=== FINALIZAR COMPRA ===");
        visualizarCarrinho();

        HistoricoUsuario historico = new HistoricoUsuario();
        historico.setUsuarioId(usuarioAtual.getId());
        historico.setItens(new ArrayList<>(carrinhoService.getItens()));
        historico.setDataCompra(new java.util.Date());

        System.out.println("Compra finalizada com sucesso!");
        carrinhoService.limparCarrinho();
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

    private static void verDetalhesProduto() {
        listarProdutos();
        System.out.print("\nDigite o ID do produto para ver detalhes: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Produto produto = produtoController.buscarPorId(id);
        if (produto != null) {
            System.out.println("\n=== DETALHES DO PRODUTO ===");
            System.out.println("ID: " + produto.getId());
            System.out.println("Nome: " + produto.getNome());
            System.out.println("Descrição: " + produto.getDescricao());
            System.out.println("Preço: R$" + produto.getPreco());
            System.out.println("Tamanho: " + produto.getTamanho());
            System.out.println("Cor: " + produto.getCor());
            System.out.println("Categoria: " + produto.getCategoria());
            System.out.println("Estoque: " + produto.getQuantidadeEstoque());
        } else {
            System.out.println("Produto não encontrado!");
        }
    }

    private static void removerDoCarrinho() {
        visualizarCarrinho();
        if (carrinhoService.getItens().isEmpty()) return;

        System.out.print("\nDigite o índice do item que deseja remover: ");
        int indice = scanner.nextInt();
        scanner.nextLine();

        if (indice >= 0 && indice < carrinhoService.getItens().size()) {
            carrinhoService.removerItem(indice);
            System.out.println("Item removido do carrinho!");
        } else {
            System.out.println("Índice inválido!");
        }
    }

    private static void limparCarrinho() {
        carrinhoService.limparCarrinho();
        System.out.println("Carrinho limpo com sucesso!");
    }

    private static void menuComparador() {
        System.out.println("\nFuncionalidade de comparação de produtos será implementada aqui");
    }

    private static void menuAvaliacoes() {
        System.out.println("\nFuncionalidade de avaliações será implementada aqui");
    }

    private static void menuHistoricoUsuario() {
        System.out.println("\nFuncionalidade de histórico do usuário será implementada aqui");
    }

    private static void menuPerguntas() {
        System.out.println("\nFuncionalidade de perguntas será implementada aqui");
    }

    private static void menuProdutosPersonalizados() {
        System.out.println("\nFuncionalidade de produtos personalizados será implementada aqui");
    }

    private static void menuServicosAdicionais() {
        System.out.println("\nFuncionalidade de serviços adicionais será implementada aqui");
    }

    public static ComparadorService getComparadorService() {
        return comparadorService;
    }

    public static void setComparadorService(ComparadorService comparadorService) {
        Main.comparadorService = comparadorService;
    }

    public static CompartilhamentoService getCompartilhamentoService() {
        return compartilhamentoService;
    }

    public static void setCompartilhamentoService(CompartilhamentoService compartilhamentoService) {
        Main.compartilhamentoService = compartilhamentoService;
    }

    public static DestaqueService getDestaqueService() {
        return destaqueService;
    }

    public static void setDestaqueService(DestaqueService destaqueService) {
        Main.destaqueService = destaqueService;
    }

    public static EstoqueService getEstoqueService() {
        return estoqueService;
    }

    public static void setEstoqueService(EstoqueService estoqueService) {
        Main.estoqueService = estoqueService;
    }

    public static FiltroService getFiltroService() {
        return filtroService;
    }

    public static void setFiltroService(FiltroService filtroService) {
        Main.filtroService = filtroService;
    }

    public static ProdutoService getProdutoService() {
        return produtoService;
    }

    public static void setProdutoService(ProdutoService produtoService) {
        Main.produtoService = produtoService;
    }

    public static SugestaoService getSugestaoService() {
        return sugestaoService;
    }

    public static void setSugestaoService(SugestaoService sugestaoService) {
        Main.sugestaoService = sugestaoService;
    }

    public static TagService getTagService() {
        return tagService;
    }

    public static void setTagService(TagService tagService) {
        Main.tagService = tagService;
    }
}
