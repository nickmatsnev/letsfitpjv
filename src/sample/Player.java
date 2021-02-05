package sample;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Player {
    private final SimpleStringProperty username;
    private final SimpleIntegerProperty score;

    public Player(String username, Integer score) {
        this.username = new SimpleStringProperty(username);
        this.score = new SimpleIntegerProperty(score);
    }


    public String getUsername() {
        return username.get();
    }

    public void setUsername(String fusername) {
        username.set(fusername);
    }

    public int getScore() {
        return score.get();
    }

    public void setScore(int fscore) {
        score.set(fscore);
    }
}
