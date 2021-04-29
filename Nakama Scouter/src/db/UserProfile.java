package db;

/**
 * This class holds all the data for a single user of the application.
 * Last modified 04/23/2021 by Edward Hicks
 * @author Edward Hicks
 */
public class UserProfile extends DataObject{
    protected final String dataTable = "User";
    protected String userName;
    protected String email;
    protected String passWord;
    protected int age;
    protected String city;
    protected int zipCode;
    //Anime preferences
    //Food preferences

    public UserProfile(String _userName, String _email, String _passWord, int _age, String _city, String _zipCode) {}

    //Creates a new account that's approved by the UserDatabase
    public UserProfile(String _userName, String _email, String _passWord, int _age, String _city, int _zipCode) {
        this.userName = _userName;
        this.email = _email;
        this.passWord = _passWord;
        this.age = _age;
        this.city = _city;
        this.zipCode = _zipCode;
        //Anime and food preferences are created, using default settings
    }

    //=================  GETTERS ===============
    public String getUsername() { return this.userName; }
    public String getEmail() { return this.email; }
    public String getPassword() { return this.passWord; }
    public int getAge() { return this.age; }
    public String getCity() { return this.city; }
    public int getZipCode() { return this.zipCode; }

    //=================  SETTERS ===============
    public void setUsername(String _userName) { this.userName = _userName; }
    public void setEmail(String _email) { this.email = _email; }
    public void setPassword(String _passWord) { this.passWord = _passWord; }
    public void setAge(int _age) { this.age = _age; }
    public void setCity(String _city) { this.city = _city; }
    public void setZipCode(int _zipCode) { this.zipCode = _zipCode; }
}