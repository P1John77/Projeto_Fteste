package service;

import model.Produto;
import java.util.List;
import java.util.stream.Collectors;

public class SugestaoService {
    public List<Produto> sugerir(List<Produto> produtos, Produto produtoBase) {
        return produtos.stream()
                .filter(p -> p.getCategoria().equals(produtoBase.getCategoria()))
                .filter(p -> !p.getId().equals(produtoBase.getId()))
                .limit(3)
                .collect(Collectors.toList());
    }
}
