package model;

import java.util.List;
import java.util.Set;

public class Produto {
    private Set<String> tags;
    private List<Avaliacao> avaliacoes;
    private int visualizacoes;
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


    // Adicione os getters e setters que faltam
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getTamanho() {
        return tamanho;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public void setQuantidadeEstoque(int quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public String getUrlPostInstagram() {
        return urlPostInstagram;
    }

    public void setUrlPostInstagram(String urlPostInstagram) {
        this.urlPostInstagram = urlPostInstagram;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }



    @Override
    public String toString() {
        return "Produto{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                ", preco=" + preco +
                ", tamanho='" + tamanho + '\'' +
                ", cor='" + cor + '\'' +
                ", categoria='" + categoria + '\'' +
                ", quantidadeEstoque=" + quantidadeEstoque +
                ", urlPostInstagram='" + urlPostInstagram + '\'' +
                ", disponivel=" + disponivel +
                '}';
    }

    public void setTags(Set<String> tags) {
    }

    public Set<String> getTags() {
        return Set.of();
    }
}
