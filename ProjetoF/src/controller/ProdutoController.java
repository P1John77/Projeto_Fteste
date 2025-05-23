package controller;

import model.Produto;
import service.ProdutoService;

import java.util.List;

public class ProdutoController {

    private ProdutoService produtoService = new ProdutoService();

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
        produtoService.adicionarAoCarrinho(produto);
    }

    public List<Produto> visualizarCarrinho() {
        return produtoService.getCarrinho();
    }

    public void limparCarrinho() {
        produtoService.limparCarrinho();
    }
}
