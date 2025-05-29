package service;

import model.Produto;

public class ComparadorService {
    public String comparar(Produto p1, Produto p2) {
        return String.format("Comparação:\n%s - R$%.2f\n%s - R$%.2f",
                p1.getNome(), p1.getPreco(), p2.getNome(), p2.getPreco());
    }
}
