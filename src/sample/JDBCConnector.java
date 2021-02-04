package sample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCConnector {


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
}
