package es.michillas.models;

public class Mbti {
    private String letters;
    private String name;
    private String description;

    public Mbti() {
    }

    public Mbti(String letters, String name, String description) {
        this.letters = letters;
        this.name = name;
        this.description = description;
    }

    public String getLetters() {
        return letters;
    }

    public void setLetters(String letters) {
        this.letters = letters;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Mbti{" +
                "letters='" + letters + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
