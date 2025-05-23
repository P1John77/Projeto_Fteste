package service;

import model.Produto;

import java.util.ArrayList;
import java.util.List;

public class ProdutoService {

    List<Produto> produtos = new ArrayList<>();
    List<Produto> carrinho = new ArrayList<>();
    private int nextId = 1;

    public Produto salvar(Produto produto) {
        if (produto.getId() == null) {
            produto.setId(nextId++);
        } else {
            produtos.removeIf(p -> p.getId().equals(produto.getId()));
        }
        produtos.add(produto);
        return produto;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public Produto buscarPorId(Integer id) {
        for (Produto produto : produtos) {
            if (produto.getId().equals(id)) {
                return produto;
            }
        }
        return null;
    }

    public boolean removerProduto(Integer id) {
        return produtos.removeIf(p -> p.getId().equals(id));
    }

    public void adicionarAoCarrinho(Produto produto) {
        carrinho.add(produto);
    }

    public List<Produto> getCarrinho() {
        return carrinho;
    }

    public void limparCarrinho() {
        carrinho.clear();
    }
}
