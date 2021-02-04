package sample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCConnector {


    public void setGameAndQuestions(Questions[] questions, String gameName ){
        try{
            Connection con= DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/letsfitupdated?serverTimezone=UTC","matsnnik","Torvald01");
            Statement stmt=con.createStatement();
            String sql = "INSERT INTO Game(game_name, creator_username,played_times) " +
                    "VALUES ('" + gameName + "', '" + CurrentUser.getUsername() + "','0')";
            stmt.executeUpdate(sql);
            for(int i = 0; i < 6; i++){
                String questionInsert = "INSERT INTO Question(question,"
                        + " correct_answer,wrong_answer_one,wrong_answer_two,wrong_answer_three,"
                        + "game_name) VALUES ('" + questions[i].getQuestion() + "', '" + questions[i].getAnswers()[3]
                        + "', '" + questions[i].getAnswers()[0] +"', '" + questions[i].getAnswers()[1]
                        + "', '" + questions[i].getAnswers()[2] + "', '" + CurrentGame.getGamename() + "')";
                stmt.executeUpdate(questionInsert);
            }
            setScore(CurrentUser.getUsername(), CurrentUser.getScore() + 1);
            CurrentUser.setScore(CurrentUser.getScore() + 1);

            con.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }

    }

    public int getScore(String username){
        try {
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://127.0.0.1:3306/letsfitupdated?serverTimezone=UTC", "matsnnik", "Torvald01");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from player");
            while (rs.next()) {
                if (rs.getString("username").equals(username)) {
                    return Integer.parseInt(rs.getString("score"));
                }
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return 0;
    }

    public boolean loginCheck(String name, String password) {
        try {
            Connection con= DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/letsfitupdated?serverTimezone=UTC","matsnnik","Torvald01");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from player");
            while (rs.next()) {
                if (rs.getString("username").equals(name)
                        && rs.getString("password").equals(password)) {
                    System.out.println("Success login");
                    return true;
                }
            }
            con.close();
            return false;
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }
    public void setNewUser(String name, String password){
        try{
            Connection con= DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/letsfitupdated?serverTimezone=UTC","matsnnik","Torvald01");
            Statement stmt=con.createStatement();
            String sql = "INSERT INTO Player(username, password,score,games_created) " +
                    "VALUES ('" + name + "', '" + password + "','0','0')";
            stmt.executeUpdate(sql);
            con.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
    public void setScore(String name, int score){
        try{
            Connection con= DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/letsfitupdated?serverTimezone=UTC","matsnnik","Torvald01");
            Statement stmt=con.createStatement();
            String sql = "UPDATE Player SET score=" + score + "where username='" + name +"'";
            stmt.executeUpdate(sql);
            con.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}
