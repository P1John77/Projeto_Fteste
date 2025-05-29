package service;

import model.Produto;
import java.util.ArrayList;
import java.util.List;

public class DestaqueService {
    private List<Produto> destaques = new ArrayList<>();

    public void adicionarDestaque(Produto produto) {
        destaques.add(produto);
    }

    public List<Produto> getDestaques() {
        return destaques;
    }
}
