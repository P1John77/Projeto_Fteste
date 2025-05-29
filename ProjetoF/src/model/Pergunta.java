package model;

import java.time.LocalDate;

public class Pergunta {
    private String pergunta;
    private String resposta;
    private LocalDate data;

    public Pergunta(String pergunta) {
        this.pergunta = pergunta;
        this.data = LocalDate.now();
    }

    public void setResposta(String resposta) {
        this.resposta = resposta;
    }
}
