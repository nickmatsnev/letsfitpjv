package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JDBCConnector {

    public Integer getScoreByUsername(String username){
        try {
            int result = 0;
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://127.0.0.1:3306/letsfitupdated?serverTimezone=UTC", "matsnnik", "Torvald01");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select score from player where username='" + username + "' limit 1");
            while (rs.next()) {
                result = rs.getInt("score");
            }
            con.close();
            return result;
        } catch (Exception e) {
            System.out.println(e);
        }
        return 0;
    }

    public Integer getScoreByGameName(String name){
        try {
            int result = 0;
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://127.0.0.1:3306/letsfitupdated?serverTimezone=UTC", "matsnnik", "Torvald01");
            Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("select played_times from game where game_name='" + name + "' limit 1");
            while (rs.next()) {
                result = rs.getInt("played_times");
            }
            con.close();
            return result;
        } catch (Exception e) {
            System.out.println(e);
        }
        return 0;
    }

    public String getPlayerByGame(String gameName){
        try {
            String result = "";
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://127.0.0.1:3306/letsfitupdated?serverTimezone=UTC", "matsnnik", "Torvald01");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select creator_username from game where game_name='" + gameName + "' limit 1");
            while (rs.next()) {
                result = rs.getString("creator_username");

            }
            con.close();
            return result;
        } catch (Exception e) {
            System.out.println(e);
        }
        return gameName;
    }

    public List<Questions> setUpGame(String name) {
        try {
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://127.0.0.1:3306/letsfitupdated?serverTimezone=UTC", "matsnnik", "Torvald01");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from question where game_name='" + name + "';");
            System.out.println("this is setUpGame");
            List<Questions> gottenQuestions = new ArrayList<Questions>();
            while (rs.next()) {
                String[] array = new String[4];
                String question = rs.getString("question");
                array[0] = rs.getString("wrong_answer_one");
                array[1] = rs.getString("wrong_answer_two");
                array[2] = rs.getString("wrong_answer_three");
                array[3] = rs.getString("correct_answer");
                gottenQuestions.add(new Questions(question, array));
            }
            con.close();
            return gottenQuestions;
        } catch (Exception e) {
            System.out.println(e);

        }
        return null;
    }

    public List<Game> gamesByName(String input){
        try {

            List<Game> games = new ArrayList<Game>();
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://127.0.0.1:3306/letsfitupdated?serverTimezone=UTC", "matsnnik", "Torvald01");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from game where game_name='" + input + "'");

            System.out.println("this is gamesByName");
            while (rs.next()) {
                int score = rs.getInt("played_times");
                String name = rs.getString("game_name");
                String creatorName = rs.getString("creator_username");
                System.out.println(name + " : " + score + " by " + creatorName);
                games.add(new Game(name, score, creatorName));
            }
            con.close();
            return games;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public List<Game> bestGames(){
        try {

            List<Game> games = new ArrayList<Game>();
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://127.0.0.1:3306/letsfitupdated?serverTimezone=UTC", "matsnnik", "Torvald01");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from game order by played_times DESC");

            System.out.println("this is bestGames");
            while (rs.next()) {
                int score = rs.getInt("played_times");
                String name = rs.getString("game_name");
                System.out.println(name + " : " + score);
                games.add(new Game(name, score));
            }
            con.close();
            return games;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public List<Player> bestUsers(){
        try {
            List<Player> players = new ArrayList<Player>();
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://127.0.0.1:3306/letsfitupdated?serverTimezone=UTC", "matsnnik", "Torvald01");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from player order by score DESC");
            while (rs.next()) {
                int score = rs.getInt("score");
                String name = rs.getString("username");
                players.add(new Player(name, score));
            }
            con.close();
            return players;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public void setNewPassword( String password){
        try{
            Connection con= DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/letsfitupdated?serverTimezone=UTC","matsnnik","Torvald01");
            Statement stmt=con.createStatement();

            String sql = "UPDATE Player SET password='" + password + "' where username='" + CurrentUser.getUsername() +"'";
            stmt.executeUpdate(sql);
            con.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
    public String getBestGame(String username){
        try {
            String result = "";
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://127.0.0.1:3306/letsfitupdated?serverTimezone=UTC", "matsnnik", "Torvald01");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select max(game_name) from game where creator_username='" + CurrentUser.getUsername() + "' limit 1;");
            while(rs.next()){
                result = rs.getString(1);
            }
            con.close();
            return result;
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("best game connection is failed");
        }
        return "empty";
    }

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
                        + " correct_answer,wrong_answer_one,wrong_answer_two,wrong_answer_three, "
                        + "game_name) VALUES ('" + questions[i].getQuestion() + "', '" + questions[i].getAnswers()[3]
                        + "', '" + questions[i].getAnswers()[0] +"', '" + questions[i].getAnswers()[1]
                        + "', '" + questions[i].getAnswers()[2] + "', '" + CurrentGame.getGamename() + "')";
                stmt.executeUpdate(questionInsert);
            }
            setScorePlayer(CurrentUser.getUsername(), CurrentUser.getScore() + 1);
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
    public void setScorePlayer(String name, int score){
        try{
            Connection con= DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/letsfitupdated?serverTimezone=UTC","matsnnik","Torvald01");
            Statement stmt=con.createStatement();
            String sql = "UPDATE Player SET score=" + score + " where username='" + name +"'";
            stmt.executeUpdate(sql);
            con.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }

    public int getGamesCreatedByName(String username){
        try{
        int factor = 0;
        Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/letsfitupdated?serverTimezone=UTC","matsnnik","Torvald01");
        Statement stmt=con.createStatement();
        String request = "select games_created from player where username='" + username + "' limit 1";
        ResultSet rs = stmt.executeQuery(request);
        while (rs.next()) {
            factor = rs.getInt("games_created");
        }
        con.close();
        return factor;
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        return 0;
    }

    public void incrementCreatedGames(String username){
        try{
            int factor = 0;
            Connection con= DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/letsfitupdated?serverTimezone=UTC","matsnnik","Torvald01");
            Statement stmt=con.createStatement();
            factor = getGamesCreatedByName(username);
            String sql = "UPDATE player SET games_created=" + factor + " where username='" + username +"'";
            stmt.executeUpdate(sql);
            con.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }

    public void setScoreGame(String name, int score){
        try{
            Connection con= DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/letsfitupdated?serverTimezone=UTC","matsnnik","Torvald01");
            Statement stmt=con.createStatement();
            String sql = "UPDATE game SET played_times=" + score + " where game_name='" + name +"'";
            stmt.executeUpdate(sql);
            con.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}
