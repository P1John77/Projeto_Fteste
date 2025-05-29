package service;

import model.Produto;

public class CompartilhamentoService {
    public String gerarLink(Produto produto) {
        return String.format("Confira este produto: %s (R$%.2f)\n%s",
                produto.getNome(), produto.getPreco(), produto.getUrlPostInstagram());
    }
}
