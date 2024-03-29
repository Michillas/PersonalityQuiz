package es.michillas.models;

public class Usuario {
    private int id;

    private String username;
    private String mbti;

    private int focus; /* 0 - Extra / 100 - Intro */
    private int information; /* 0 - Sensing / 100 - Intuition */
    private int decisions; /* 0 - Thinking / 100 - Feeling */
    private int outerlife; /* 0 - Judging / 100 - Perceiving */

    public Usuario() {
    }

    public Usuario(int id, String username, String mbti, int focus, int information, int decisions, int outerlife) {
        this.id = id;
        this.username = username;
        this.mbti = mbti;
        this.focus = focus;
        this.information = information;
        this.decisions = decisions;
        this.outerlife = outerlife;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMbti() {
        return mbti;
    }

    public void setMbti(String mbti) {
        this.mbti = mbti;
    }

    public int getFocus() {
        return focus;
    }

    public void setFocus(int focus) {
        this.focus = focus;
    }

    public int getInformation() {
        return information;
    }

    public void setInformation(int information) {
        this.information = information;
    }

    public int getDecisions() {
        return decisions;
    }

    public void setDecisions(int decisions) {
        this.decisions = decisions;
    }

    public int getOuterlife() {
        return outerlife;
    }

    public void setOuterlife(int outerlife) {
        this.outerlife = outerlife;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", mbti='" + mbti + '\'' +
                ", focus=" + focus +
                ", information=" + information +
                ", decisions=" + decisions +
                ", outerlife=" + outerlife +
                '}';
    }
}
