package es.michillas.models;

public class Usuario {
    private int id;
    private String username;
    private String mbti;

    private int attitude;
    private int perception;
    private int orientation;
    private int behavior;

    public Usuario() {
    }

    public Usuario(int id, String username, String mbti, int attitude, int perception, int orientation, int behavior) {
        this.id = id;
        this.username = username;
        this.mbti = mbti;
        this.attitude = attitude;
        this.perception = perception;
        this.orientation = orientation;
        this.behavior = behavior;
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

    public int getAttitude() {
        return attitude;
    }

    public void setAttitude(int attitude) {
        this.attitude = attitude;
    }

    public int getPerception() {
        return perception;
    }

    public void setPerception(int perception) {
        this.perception = perception;
    }

    public int getOrientation() {
        return orientation;
    }

    public void setOrientation(int orientation) {
        this.orientation = orientation;
    }

    public int getBehavior() {
        return behavior;
    }

    public void setBehavior(int behavior) {
        this.behavior = behavior;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", mbti='" + mbti + '\'' +
                ", attitude=" + attitude +
                ", perception=" + perception +
                ", orientation=" + orientation +
                ", behavior=" + behavior +
                '}';
    }
}
