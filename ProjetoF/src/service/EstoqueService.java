package service;

import model.Produto;

public class EstoqueService {
    public void verificarEstoque(Produto produto) {
        if (produto.getQuantidadeEstoque() < 5) {
            System.out.println("ALERTA: Estoque baixo para " + produto.getNome());
        }
    }
}
