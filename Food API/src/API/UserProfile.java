package API;

/**
 * This class holds all the data for a single user of the application.
 * Last modified 03/24/2021
 * @author Edward Hicks
 */
public class UserProfile {
    protected String username;
    protected String password;
    //Anime preferences
    //Food preferences

    //Creates a new account that's approved by the UserDatabase
    public UserProfile(String _u, String _p) {
        this.username = _u;
        this.password = _p;
        //Anime and food preferences are created, using default settings
    }

    //=================  GETTERS ===============
    public String getUsername() { return this.username; }
    public String getPassword() { return this.password; }

    //=================  SETTERS ===============
    public void setUsername(String _u) { this.username = _u; }
    public void setPassword(String _p) { this.password = _p; }
}
