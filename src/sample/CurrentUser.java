package sample;

public class CurrentUser {
    private static String username;
    private static String password;
    private static int score;
    private static int games_created;

    /**
     *
     * @param username
     * @param password
     */
    public CurrentUser(String username, String password) {
        this.username = username;
        this.password = password;
    }

    /**
     *
     * @return
     */
    public static String getUsername() {
        return username;
    }

    /**
     *
     * @param username
     */
    public static void setUsername(String username) {
        CurrentUser.username = username;
    }

    public static String getPassword() {
        return password;
    }

    public static void setPassword(String password) {
        CurrentUser.password = password;
    }

    public static int getScore() {
        return score;
    }

    public static void setScore(int score) {
        CurrentUser.score = score;
    }

    public static int getGames_created() {
        return games_created;
    }

    public static void setGames_created(int games_created) {
        CurrentUser.games_created = games_created;
    }
}
