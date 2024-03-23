package es.michillas.model;

public class Preguntas {
    String question;
    String type; // focus, information, decisions, outerlife

    public Preguntas() {
    }

    public Preguntas(String question, String type) {
        this.question = question;
        this.type = type;
    }
}
