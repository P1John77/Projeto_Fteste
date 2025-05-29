package model;

public class AlertaPreco {
    private Usuario usuario;
    private Produto produto;
    private double precoDesejado;

    public AlertaPreco(Usuario usuario, Produto produto, double precoDesejado) {
        this.usuario = usuario;
        this.produto = produto;
        this.precoDesejado = precoDesejado;
    }
}
