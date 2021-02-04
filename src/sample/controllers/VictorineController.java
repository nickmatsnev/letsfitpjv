package sample.controllers;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.text.Text;
import sample.MegaController;
import sample.Questions;
import sample.Switcher;

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

    private Questions[] questions = new Questions[] {
            new Questions("What is a correct way to output some data in the console?", new String[] {"Console.Write()", "console.log()", "print()", "System.out.println()"}),
            new Questions("Which data type has only two values?", new String[] {"String", "Float", "Boolean", "Integer"}),
            new Questions("What is correct form of assigning some data to an element of two dimensioned array?", new String[] {"a(0)(0) = 1;", "a[0 0] = 1;", "a{0}{0} = 1;", "a[0][0] = 1;"}),
            new Questions("Which method allows to run applications on Java?", new String[] {"THere is no main method", "From the class, which was written first and from its methods", "Any, you can manage it in the project settings", "From method 'main' in any of the classes"}),
            new Questions("Every file should be called...", new String[] {"By the name of the first library", "By the name of the package", "How you want", "By the name of the class"}),
            new Questions("How much parameters function can have as arguments?", new String[] {"5", "10", "20", "Infinitely many"})
    };

    private int nowQuestion = 0, correctAnswers;
    private String nowCorrectAnswer;

    @FXML
    public void initialize() {
        try {

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
                    if (nowQuestion + 1 == questions.length) {
                        radio_btn_1.setVisible(false);
                        radio_btn_2.setVisible(false);
                        radio_btn_3.setVisible(false);
                        radio_btn_4.setVisible(false);
                        answerBtn.setVisible(false);

                        question_text.setText("You had answered correctly " + correctAnswers + " out of " + questions.length + " questions!");
                    } else {
                        nowQuestion++;
                        nowCorrectAnswer = questions[nowQuestion].correctAnswer();

                        question_text.setText(questions[nowQuestion].getQuestion());
                        String[] answers = questions[nowQuestion].getAnswers();


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
