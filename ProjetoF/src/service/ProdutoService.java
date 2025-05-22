package service;

import model.Produto;

import java.util.ArrayList;
import java.util.List;

public class ProdutoService {

    List<Produto> produtos = new ArrayList<>();

    // simulacao de post - salvar
    public Produto salvar(Produto produto) {
        produtos.add(produto);

        return produto;
    }
    // simulacao de get - pegar informações
    public List<Produto> getProdutos() {
        return produtos;
    }
}
