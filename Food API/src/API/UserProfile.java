package API;

/**
 * This class holds all the data for a single user of the application.
 * Last modified 03/24/2021
 * @author Edward Hicks
 */
public class UserProfile {
    protected String userName;
    protected String email;
    protected String passWord;
    protected int age;
    protected String city;
    protected String ipAddress;
    //Anime preferences
    //Food preferences

    //Creates a new account that's approved by the UserDatabase
    public UserProfile(String _userName, String _email, String _passWord, int _age, String _city, String _ipAddress) {
        this.userName = _userName;
        this.email = _email;
        this.passWord = _passWord;
        this.age = _age;
        this.city = _city;
        this.ipAddress = _ipAddress;
        //Anime and food preferences are created, using default settings
    }

    //=================  GETTERS ===============
    public String getUsername() { return this.userName; }
    public String getEmail() { return this.email; }
    public String getPassword() { return this.passWord; }
    public int getAge() { return this.age; }
    public String getCity() { return this.city; }
    public String getIpAddress() { return this.ipAddress; }

    //=================  SETTERS ===============
    public void setUsername(String _userName) { this.userName = _userName; }
    public void setEmail(String _email) { this.email = _email; }
    public void setPassword(String _passWord) { this.passWord = _passWord; }
    public void setAge(int _age) { this.age = _age; }
    public void setCity(String _city) { this.city = _city; }
    public void setIpAddress(String _ipAddress) { this.ipAddress = _ipAddress; }
}
