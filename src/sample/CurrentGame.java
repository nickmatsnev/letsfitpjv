package sample;

public class CurrentGame {
    //here will be contained info about runned game
    public static String gamename;

    public static String getGamename() {
        return gamename;
    }

    public static void setGamename(String gamename) {
        CurrentGame.gamename = gamename;
    }
//put in the container data from jbdc
    //last question correct only
    /*public CurrentGame(Questions questions, String gamename){

    }*/
}
