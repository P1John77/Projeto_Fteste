package model;

import java.time.LocalDate;

public class Avaliacao {
    private int estrelas;
    private String comentario;
    private String autor;
    private LocalDate data;

    public Avaliacao(int estrelas, String comentario, String autor) {
        this.estrelas = estrelas;
        this.comentario = comentario;
        this.autor = autor;
        this.data = LocalDate.now();
    }

    public int getEstrelas() {
        return estrelas;
    }

    public String getComentario() {
        return comentario;
    }

    public String getAutor() {
        return autor;
    }

    public LocalDate getData() {
        return data;
    }
}
