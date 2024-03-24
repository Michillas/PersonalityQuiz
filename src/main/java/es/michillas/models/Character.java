package es.michillas.models;

public class Character {

    private String mbti;
    private String name;
    private String img;

    public Character() {
    }

    public Character(String name, String mbti, String img) {
        this.name = name;
        this.mbti = mbti;
        this.img = img;
    }

    public String getMbti() {
        return mbti;
    }

    public void setMbti(String mbti) {
        this.mbti = mbti;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
