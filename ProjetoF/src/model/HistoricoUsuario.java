package model;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Date;
import java.util.Deque;

public class HistoricoUsuario {
    private Deque<Produto> historico = new ArrayDeque<>(10);

    public void adicionar(Produto produto) {
        historico.addFirst(produto);
        if (historico.size() > 10) {
            historico.removeLast();
        }
    }

    public Deque<Produto> getHistorico() {
        return historico;
    }

    public void setItens(ArrayList<Produto> produtos) {
    }

    public void setDataCompra(Date date) {
    }

    public void setUsuarioId(Object id) {
    }
}
