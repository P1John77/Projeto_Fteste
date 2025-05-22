package controller;

import model.Produto;
import service.ProdutoService;

public class ProdutoController {

    private ProdutoService produtoService = new ProdutoService();

    public Produto salvar(Produto produto) {
        return produtoService.salvar(produto);
    }


}
