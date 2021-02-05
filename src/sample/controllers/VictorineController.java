package sample.controllers;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.text.Text;
import sample.*;

import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class VictorineController {

    @FXML
    private ToggleGroup answers;

    @FXML
    private Text question_text;

    @FXML
    private RadioButton radio_btn_1;

    @FXML
    private RadioButton radio_btn_2;

    @FXML
    private RadioButton radio_btn_3;

    @FXML
    private RadioButton radio_btn_4;

    @FXML
    private Button answerBtn;

    @FXML
    private Button findBtn;

    @FXML
    private Button createBtn;

    @FXML
    private Button ratingBtn;

    @FXML
    private Button faqBtn;

    @FXML
    private Button aboutBtn;

    @FXML
    private Button profileBtn;

    @FXML
    private Button logoutBtn;

    @FXML
    private Button exitBtn;

    @FXML
    private Label nameAndScore;

    JDBCConnector jdb = new JDBCConnector();
    private List<Questions> questions = jdb.setUpGame(CurrentGame.getGamename());

    private int nowQuestion = 0, correctAnswers;
    private String nowCorrectAnswer;

    @FXML
    public void initialize() {
        try {

            nameAndScore.setText(CurrentUser.getUsername() + " / " + jdb.getScoreByUsername(CurrentUser.getUsername()));

            aboutBtn.setOnAction(e -> {
                MegaController mc = new MegaController();
                mc.toPage("aboutPage");
            });
            createBtn.setOnAction(e -> {
                MegaController mc = new MegaController();
                mc.toPage("createGame");
            });
            faqBtn.setOnAction(e -> {
                MegaController mc = new MegaController();
                mc.toPage("faqPage");
            });
            ratingBtn.setOnAction(e -> {
                MegaController mc = new MegaController();
                mc.toPage("ratingPage");
            });
            exitBtn.setOnAction(e -> {
                MegaController mc = new MegaController();
                mc.closePage();
            });
            logoutBtn.setOnAction(e -> {
                MegaController mc = new MegaController();
                mc.toPage("loginPage");
            });
            profileBtn.setOnAction(e -> {
                MegaController mc = new MegaController();
                mc.toPage("profilePage");
            });
            findBtn.setOnAction(e -> {
                MegaController mc = new MegaController();
                mc.toPage("findGame");
            });

            answerBtn.setOnAction(e -> {
                RadioButton selectedRadioButton = (RadioButton) answers.getSelectedToggle();
                if (selectedRadioButton != null) {
                    String toogleGroupValue = selectedRadioButton.getText();

                    if (toogleGroupValue.equals(nowCorrectAnswer)) {
                        System.out.println("Correct answer");
                        correctAnswers++;
                    } else {
                        System.out.println("Wrong answer");
                    }

                    // The last question
                    if (nowQuestion + 1 == questions.size()) {
                        radio_btn_1.setVisible(false);
                        radio_btn_2.setVisible(false);
                        radio_btn_3.setVisible(false);
                        radio_btn_4.setVisible(false);
                        answerBtn.setVisible(false);

                        jdb.setScoreGame(CurrentGame.getGamename(), jdb.getScoreByGameName(CurrentGame.getGamename()) + 1);

                        jdb.setScorePlayer(jdb.getPlayerByGame(CurrentGame.getGamename()),
                                jdb.getScoreByUsername(jdb.getPlayerByGame(CurrentGame.getGamename())) + 1);

                        question_text.setText("You had answered correctly " + correctAnswers + " out of " + questions.size() + " questions!");
                    } else {
                        Questions[] array = new Questions[questions.size()];
                        questions.toArray(array); // fill the array


                        nowQuestion++;
                        nowCorrectAnswer = array[nowQuestion].correctAnswer();

                        question_text.setText(array[nowQuestion].getQuestion());
                        String[] answers = array[nowQuestion].getAnswers();

                        List<String> intList = Arrays.asList(answers);

                        Collections.shuffle(intList);

                        radio_btn_1.setText(intList.get(0));
                        radio_btn_2.setText(intList.get(1));
                        radio_btn_3.setText(intList.get(2));
                        radio_btn_4.setText(intList.get(3));

                        selectedRadioButton.setSelected(false);
                    }
                }
            });
        }
        catch (Exception exc){
        System.out.println(exc);
        }
    }

}
