package es.michillas.models;

public class Preguntas {
    String question;
    String type; // focus, information, decisions, outerlife

    public Preguntas() {
    }

    public Preguntas(String question, String type) {
        this.question = question;
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }
}
