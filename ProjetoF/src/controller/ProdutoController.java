package controller;

import model.Produto;
import service.ProdutoService;
import service.CarrinhoService;

import java.util.List;

public class ProdutoController {
    private ProdutoService produtoService = new ProdutoService();
    private CarrinhoService carrinhoService = new CarrinhoService();

    public Produto salvar(Produto produto) {
        return produtoService.salvar(produto);
    }

    public List<Produto> listarTodos() {
        return produtoService.getProdutos();
    }

    public Produto buscarPorId(Integer id) {
        return produtoService.buscarPorId(id);
    }

    public boolean remover(Integer id) {
        return produtoService.removerProduto(id);
    }

    public void adicionarAoCarrinho(Produto produto) {
        carrinhoService.adicionarItem(produto);
    }

    public List<Produto> visualizarCarrinho() {
        return carrinhoService.getItens();
    }

    public void limparCarrinho() {
        carrinhoService.limpar();
    }

    public double calcularTotalCarrinho() {
        return carrinhoService.calcularTotal();
    }
}
