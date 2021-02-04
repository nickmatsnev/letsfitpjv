package sample.controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import sample.*;

public class СreateController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label nameAndScoreLabel;

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
    private Button nextQuestionBtn;

    @FXML
    private TextArea inputQuestion;

    @FXML
    private TextField correctAnswerInput;

    @FXML
    private TextField wrongOne;

    @FXML
    private TextField wrongTwo;

    @FXML
    private TextField wrongThree;

    @FXML
    private Label counterLabel;

    @FXML
    private Label alarmInput;

    @FXML
    private  Label shitTexttwo;

    @FXML
    private Label shitTextone;

    @FXML
    private Label headerText;

    @FXML
    private TextField gameNameInput;
    @FXML
    private Label successLabel;

    private Questions[] questions = new Questions[7];

    private int counterOfPages;

    @FXML
    void initialize() {
        counterOfPages = -1;
        assert nameAndScoreLabel != null : "fx:id=\"nameAndScoreLabel\" was not injected: check your FXML file 'createGame.fxml'.";
        assert findBtn != null : "fx:id=\"findBtn\" was not injected: check your FXML file 'createGame.fxml'.";
        assert createBtn != null : "fx:id=\"createBtn\" was not injected: check your FXML file 'createGame.fxml'.";
        assert ratingBtn != null : "fx:id=\"ratingBtn\" was not injected: check your FXML file 'createGame.fxml'.";
        assert faqBtn != null : "fx:id=\"faqBtn\" was not injected: check your FXML file 'createGame.fxml'.";
        assert aboutBtn != null : "fx:id=\"aboutBtn\" was not injected: check your FXML file 'createGame.fxml'.";
        assert profileBtn != null : "fx:id=\"profileBtn\" was not injected: check your FXML file 'createGame.fxml'.";
        assert logoutBtn != null : "fx:id=\"logoutBtn\" was not injected: check your FXML file 'createGame.fxml'.";
        assert exitBtn != null : "fx:id=\"exitBtn\" was not injected: check your FXML file 'createGame.fxml'.";
        assert nextQuestionBtn != null : "fx:id=\"nextQuestionBtn\" was not injected: check your FXML file 'createGame.fxml'.";
        assert inputQuestion != null : "fx:id=\"inputQuestion\" was not injected: check your FXML file 'createGame.fxml'.";
        assert correctAnswerInput != null : "fx:id=\"correctAnswerInput\" was not injected: check your FXML file 'createGame.fxml'.";
        assert wrongOne != null : "fx:id=\"wrongOne\" was not injected: check your FXML file 'createGame.fxml'.";
        assert wrongTwo != null : "fx:id=\"wrongTwo\" was not injected: check your FXML file 'createGame.fxml'.";
        assert wrongThree != null : "fx:id=\"wrongThree\" was not injected: check your FXML file 'createGame.fxml'.";
        assert counterLabel != null : "fx:id=\"counterLabel\" was not injected: check your FXML file 'createGame.fxml'.";

        int show = counterOfPages + 1;

        JDBCConnector jc = new JDBCConnector();

        nameAndScoreLabel.setText(CurrentUser.getUsername() + " : " + jc.getScore(CurrentUser.getUsername()));
        counterLabel.setText(show + "/6");

        MegaController mc = new MegaController();
        aboutBtn.setOnAction(e -> {
            mc.toPage("aboutPage");
        });
        createBtn.setOnAction(e -> {
            mc.toPage("createGame");
        });
        faqBtn.setOnAction(e -> {
            mc.toPage("faqPage");
        });
        ratingBtn.setOnAction(e -> {
            mc.toPage("ratingPage");
        });
        exitBtn.setOnAction(e -> {
            mc.closePage();
        });
        logoutBtn.setOnAction(e -> {
            mc.toPage("loginPage");
        });
        profileBtn.setOnAction(e -> {
            mc.toPage("profilePage");
        });
        findBtn.setOnAction(e -> {
            mc.toPage("findGame");
        });

        nextQuestionBtn.setOnAction(e ->{
            successLabel.setText("");
            wrongOne.setVisible(true);
            wrongThree.setVisible(true);
            wrongTwo.setVisible(true);
            correctAnswerInput.setVisible(true);
            counterLabel.setVisible(true);
            alarmInput.setVisible(true);
            shitTextone.setVisible(true);
            shitTexttwo.setVisible(true);
            headerText.setVisible(true);
            inputQuestion.setVisible(true);
            gameNameInput.setVisible(true);
            nextQuestionBtn.setText("Submit question");



            counterOfPages += 1;

            //check correctness of the input
            if(inputQuestion.getText().equals("")
                    || correctAnswerInput.getText().equals("")
                    || wrongOne.getText().equals("")
                    || wrongTwo.getText().equals("")
                    || wrongThree.getText().equals("")
                    || gameNameInput.getText().equals("")){
            alarmInput.setText("Something is not filled");
            }
            else{
                questions[counterOfPages] = new Questions(inputQuestion.getText(), new String[] {wrongOne.getText(), wrongTwo.getText(), wrongThree.getText(), correctAnswerInput.getText()});

                System.out.println(questions[counterOfPages].getQuestion());
                if(counterOfPages == 5){
                    CurrentGame.setGamename(gameNameInput.getText());
                    successLabel.setText("Congratulations!");
                    wrongOne.setVisible(false);
                    wrongThree.setVisible(false);
                    wrongTwo.setVisible(false);
                    correctAnswerInput.setVisible(false);
                    counterLabel.setVisible(false);
                    alarmInput.setVisible(false);
                    shitTextone.setVisible(false);
                    shitTexttwo.setVisible(false);
                    headerText.setVisible(false);
                    inputQuestion.setVisible(false);
                    gameNameInput.setVisible(false);
                    nextQuestionBtn.setText("New test");
                    jc.setGameAndQuestions(questions, gameNameInput.getText());
                }
            }
            inputQuestion.setText("");
            wrongOne.setText("");
            wrongTwo.setText("");
            wrongThree.setText("");
            correctAnswerInput.setText("");

            inputQuestion.setPromptText("question");
            wrongOne.setPromptText("wrong answer");
            wrongTwo.setPromptText("wrong answer");
            wrongThree.setPromptText("wrong answer");
            correctAnswerInput.setPromptText("correct answer");

        });
    }
}
