package service;

import model.Produto;
import java.util.ArrayList;
import java.util.List;

public class CarrinhoService {
    private List<Produto> itens = new ArrayList<>();

    public void adicionarItem(Produto produto) {
        itens.add(produto);
    }

    public List<Produto> getItens() {
        return itens;
    }

    public void limpar() {
        itens.clear();
    }

    public double calcularTotal() {
        return itens.stream().mapToDouble(Produto::getPreco).sum();
    }
}
