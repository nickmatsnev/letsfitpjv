package sample;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Game {

    private final SimpleStringProperty name;
    private final SimpleStringProperty creatorName;
    private final SimpleIntegerProperty score;

    public Game(String username, Integer score, String creatorName) {
        this.name = new SimpleStringProperty(username);
        this.score = new SimpleIntegerProperty(score);
        this.creatorName = new SimpleStringProperty(creatorName);
    }
    public Game(String username, Integer score) {
        this.name = new SimpleStringProperty(username);
        this.score = new SimpleIntegerProperty(score);
        this.creatorName = new SimpleStringProperty("");
    }

    public String getCreatorName() {
        return creatorName.get();
    }

    public void setCreatorName(String fcreatorName) {
        creatorName.set(fcreatorName);
    }
    public String getName() {
        return name.get();
    }

    public void setName(String fname) {
        name.set(fname);
    }

    public int getScore() {
        return score.get();
    }

    public void setScore(int fscore) {
        score.set(fscore);
    }
}
