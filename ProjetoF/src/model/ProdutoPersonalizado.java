package model;

public class ProdutoPersonalizado {
    private Produto produtoBase;
    private String textoPersonalizado;
    private String corPersonalizada;

    public ProdutoPersonalizado(Produto produtoBase, String texto, String cor) {
        this.produtoBase = produtoBase;
        this.textoPersonalizado = texto;
        this.corPersonalizada = cor;
    }
}
