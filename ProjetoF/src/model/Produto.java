package model;

public class Produto {
    private Integer id;
    private String nome;
    private String descricao;
    private double preco;
    private String tamanho;
    private String cor;
    private String categoria;
    private int quantidadeEstoque;
    private String urlPostInstagram;
    private boolean disponivel;

    public Produto() {
    }

    public Produto(Integer id, String nome, String descricao, double preco, String tamanho,
                   String cor, String categoria, int quantidadeEstoque,
                   String urlPostInstagram, boolean disponivel) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.tamanho = tamanho;
        this.cor = cor;
        this.categoria = categoria;
        this.quantidadeEstoque = quantidadeEstoque;
        this.urlPostInstagram = urlPostInstagram;
        this.disponivel = disponivel;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }



    @Override
    public String toString() {
        return "Produto{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", preco=" + preco +
                ", tamanho='" + tamanho + '\'' +
                ", disponivel=" + disponivel +
                '}';
    }

    public String getDescricao() {
        return "";
    }
}