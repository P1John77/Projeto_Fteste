package model;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
    private String nome;
    private String email;
    private List<Produto> favoritos = new ArrayList<>();

    public void adicionarFavorito(Produto produto) {
        favoritos.add(produto);
    }

    public List<Produto> getFavoritos() {
        return favoritos;
    }

    public Object getId() {
        return null;
    }

    public void setId(int i) {
    }

    public void setNome(String usuárioPadrão) {
    }

    public void setEmail(String mail) {
    }
}
