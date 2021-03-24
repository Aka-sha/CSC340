package API;

/**
 * This class holds all the data for a single user of the application.
 * Last modified 03/24/2021
 * @author Edward Hicks
 */
public class UserProfile {
    protected String userName;
    protected String passWord;
    //Anime preferences
    //Food preferences

    //Creates a new account that's approved by the UserDatabase
    public UserProfile(String _userName, String _passWord) {
        this.userName = _userName;
        this.passWord = _passWord;
        //Anime and food preferences are created, using default settings
    }

    //=================  GETTERS ===============
    public String getUsername() { return this.userName; }
    public String getPassword() { return this.passWord; }

    //=================  SETTERS ===============
    public void setUsername(String _userName) { this.userName = _userName; }
    public void setPassword(String _passWord) { this.passWord = _passWord; }
}
