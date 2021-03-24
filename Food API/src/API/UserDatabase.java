package API;

import java.util.ArrayList;
import java.util.List;

/**
 * This class contains a list of every user of the applications, and can handle adding new users to the database
 * and editting the data of preexisting users.
 * Last modified 03/24/2021
 * @author Edward Hicks
 */
public class UserDatabase {
    protected List<UserProfile> applicationUser;

    public UserDatabase() {
        this.applicationUser = new ArrayList<UserProfile>();
    }

    /*
    This methods checks to see if the username of the new account is unique and if it is, creates a new account using the
    provided username and password and adds it to the applicationUser List. The applicationUser list is then sorted.
     */
    public void addNewApplicationUser(String _userName, String _email, String _passWord, int _age, String _city, String _ipAddress) {
        //Create new user and add it to the List
        if (checkForValidUsername(_userName)) {
            UserProfile newUser = new UserProfile(_userName, _email, _passWord, _age, _city, _ipAddress);
            applicationUser.add(newUser);
            sortList();
            System.out.println("New account created! Username: " + _userName + ", Password: " + _passWord);
        }
        else System.out.println("The username " + _userName + " is already being used by another account. Account registration denied.");
    }

    /*
    The applicationUser database is searched to see if the desired username doesn't already exist, returning the outcome.
     */
    public boolean checkForValidUsername(String _userName) {
        //First, check is database is empty. If so, return true.
        if (this.applicationUser.size() == 0) return true;

        int lowerThreshold = 0;
        int upperThreshold = this.applicationUser.size()-1;

        for (int i = upperThreshold / 2; ; i = lowerThreshold + ((upperThreshold-lowerThreshold)/2)) {
            int usernameCompare = compareWithCase(_userName, getUsernameByIndex(i));
            //A matching username has been found, new username is not unique
            if (usernameCompare == 0) return false;
            //A matching username has not been found, new username is unique
            else if (lowerThreshold == upperThreshold) return true;
            //Index is too high, move upperThreshold down
            else if (usernameCompare < 0) upperThreshold = i;
            //Index is too low, move lowerIndex up
            else {
                //If the thresholds are 1 away from each other, move lowerThreshold up to prevent infinite loop
                if (upperThreshold-lowerThreshold == 1) lowerThreshold = upperThreshold;
                else lowerThreshold = i;
            }
        }
    }

    /*
    A single new user is added to the database, sorted so that it's in alphabetical order.
    NOTE: THIS METHOD SHOULD BE CALLED IMMEDIATELY AFTER A NEW ACCOUNT IS CREATED
     */
    public void sortList() {
        if (this.applicationUser.size() > 1) {
            UserProfile newestUser = this.applicationUser.get(this.applicationUser.size()-1);
            String newestUsername = newestUser.getUsername();
            int lowerSortThreshold = 0;
            int upperSortThreshold = this.applicationUser.size()-2;
            int index = upperSortThreshold / 2;
            //Find the appropriate index for the new account. Loop will continue until the newest username comes after the username at i-1 and before the username at i
            for (; ; index = lowerSortThreshold + ((upperSortThreshold-lowerSortThreshold)/2)) {
                //If the new username should come before i...
                if (compareWithCase(newestUsername, getUsernameByIndex(index)) < 0) {
                    //...and it's already at the start, it belongs at the beginning.
                    if (index == 0) break;
                    //Otherwise, lower the upperSortThreshold.
                    else upperSortThreshold = index;
                }
                //If the newest username should come after i AND before i+1 (or it IS i+1 ie it's at the end), shift i up and break loop
                else if (compareWithCase(newestUsername, getUsernameByIndex(index+1)) <= 0) {
                    index++;
                    break;
                }
                //The newest username comes after i and i+1, raise lowerSortThreshold
                else lowerSortThreshold = index;
            }
            //Shift every account "greater than" the new account forward one space
            for (int j = this.applicationUser.size()-1; j > index; j--) setUserProfileByIndex(j, getUserProfileByIndex(j-1));
            //Set the new account to the correct index
            this.applicationUser.set(index, newestUser);
        }
    }

    /*
    Compares two strings with a uniform case.
     */
    public int compareWithCase(String _userName1, String _userName2) { return _userName1.toLowerCase().compareTo(_userName2.toLowerCase()); }

    //=================  GETTERS =================
    public UserProfile getUserProfileByIndex(int _i) { return this.applicationUser.get(_i); }
    public String getUsernameByIndex(int _i) { return this.applicationUser.get(_i).getUsername(); }
    public String getEmailByIndex(int _i) { return this.applicationUser.get(_i).getEmail(); }
    public String getPasswordByIndex(int _i) { return this.applicationUser.get(_i).getPassword(); }
    public int getAgeByIndex(int _i) { return this.applicationUser.get(_i).getAge(); }
    public String getCityByIndex(int _i) { return this.applicationUser.get(_i).getCity(); }
    public String getIpAddressByIndex(int _i) { return this.applicationUser.get(_i).getIpAddress(); }
    public int getSize() { return this.applicationUser.size(); }

    //=================  SETTERS =================
    public void setUserProfileByIndex(int _i, UserProfile _userName) { this.applicationUser.set(_i, _userName); }
    public void setUsernameByIndex(int _i, String _userName) {
        UserProfile edittedUser = getUserProfileByIndex(_i);
        edittedUser.setUsername(_userName);
        setUserProfileByIndex(_i, edittedUser);
    }
    public void setEmailByIndex(int _i, String _email) {
        UserProfile edittedUser = getUserProfileByIndex(_i);
        edittedUser.setEmail(_email);
        setUserProfileByIndex(_i, edittedUser);
    }
    public void setPasswordByIndex(int _i, String _passWord) {
        UserProfile edittedUser = getUserProfileByIndex(_i);
        edittedUser.setPassword(_passWord);
        setUserProfileByIndex(_i, edittedUser);
    }
    public void setBirthdayByIndex(int _i, int _age) {
        UserProfile edittedUser = getUserProfileByIndex(_i);
        edittedUser.setAge(_age);
        setUserProfileByIndex(_i, edittedUser);
    }
    public void setCityByIndex(int _i, String _city) {
        UserProfile edittedUser = getUserProfileByIndex(_i);
        edittedUser.setCity(_city);
        setUserProfileByIndex(_i, edittedUser);
    }
    public void setIpAddressByIndex(int _i, String _ipAddress) {
        UserProfile edittedUser = getUserProfileByIndex(_i);
        edittedUser.setIpAddress(_ipAddress);
        setUserProfileByIndex(_i, edittedUser);
    }
}