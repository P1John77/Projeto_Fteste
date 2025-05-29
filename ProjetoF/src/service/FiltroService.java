package service;

import model.Produto;
import java.util.List;
import java.util.stream.Collectors;

public class FiltroService {
    public List<Produto> filtrarPorCategoriaEPreco(List<Produto> produtos, String categoria, double precoMin, double precoMax) {
        return produtos.stream()
                .filter(p -> p.getCategoria().equalsIgnoreCase(categoria))
                .filter(p -> p.getPreco() >= precoMin && p.getPreco() <= precoMax)
                .collect(Collectors.toList());
    }
}
