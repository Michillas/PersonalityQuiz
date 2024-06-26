package es.michillas.models;

public class Pregunta {
    private String question;
    private String type;

    public Pregunta() {
    }

    public Pregunta(String question, String type) {
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

    @Override
    public String toString() {
        return "Pregunta{" +
                "question='" + question + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
