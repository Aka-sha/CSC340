package db;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * This class contains a list of every user of the applications, and can handle adding new users to the database
 * and editting the data of preexisting users.
 * Last modified 04/23/2021 by Edward Hicks
 * @author Edward Hicks
 */
public class UserDatabase {
    protected List<UserProfile> applicationUser = new ArrayList<UserProfile>();
    private final int MINIMUM_USERNAME_LENGTH = 4;
    private final int MINIMUM_PASSWORD_LENGTH = 8;
    private final int MINIMUM_AGE = 18;
    private final String DEFAULTDATABASEADDRESS = System.getProperty("user.home") + File.separator + "Documents\\test.txt";

    public UserDatabase() { }

    /**
     * This methods checks to see if the username of the new account is unique and if it is, creates a new account using the
     *     provided username and password and adds it to the applicationUser List. The applicationUser list is then sorted.
     * @param _userName
     * @param _email
     * @param _passWord
     * @param _age
     * @param _city
     * @param _zipCode
     */
    public void addNewApplicationUser(String _userName, String _email, String _passWord, int _age, String _city, int _zipCode) {
        //Create new user and add it to the List
        if (checkForValidUsername(_userName) && checkForValidPassword(_passWord) && checkForValidAge(_age) && checkForNoTabs(_userName, _passWord, _email, _city)) {
            UserProfile newUser = new UserProfile(_userName, _email, _passWord, _age, _city, _zipCode);
            applicationUser.add(newUser);
            singleSortList();
            System.out.println("New account created! Username: " + _userName + ", Password: " + _passWord);
        }
        else System.out.println("Account registration denied.");
        }

    /**
     * This method adds a user to the user database, only checking for username duplicates and tabs, skipping the
     * sort at the end.
     * @param _userName
     * @param _email
     * @param _passWord
     * @param _age
     * @param _city
     * @param _zipCode
     */
    public void quickAddNewApplicationUser(String _userName, String _email, String _passWord, int _age, String _city, int _zipCode) {
        if (checkUsernameForDuplicates(_userName) && checkForNoTabs(_userName, _passWord, _email, _city)) {
            UserProfile newUser = new UserProfile(_userName, _email, _passWord, _age, _city, _zipCode);
            applicationUser.add(newUser);
        }
    }

    /**
     * The username is checked to see if it is compliant with various username requirements, then is checked for duplicates among
     * pre-existing users.
     * @param _userName
     * @return
     */
    public boolean checkForValidUsername(String _userName) {
        boolean usernameIsCompliant = true;
        //Checks the username to see if it meets the minimum password length
        if (_userName.length() < MINIMUM_USERNAME_LENGTH) {
            System.out.println("Username must be at least " + MINIMUM_USERNAME_LENGTH + " characters in length.");
           usernameIsCompliant = false;
        }
        //Checks the username to ensure it has no spaces
        if (_userName.contains(" ")) {
            System.out.println("Username must not contain any spaces.");
            usernameIsCompliant = false;
        }
        if (usernameIsCompliant) return checkUsernameForDuplicates(_userName);
        return false;
    }

    /**
     * The applicationUser database is searched to see if the desired username doesn't already exist, returning the outcome.
     * @param _userName
     * @return
     */
    public boolean checkUsernameForDuplicates(String _userName) {
        //First, check if database is empty. If so, return true.
        if (this.applicationUser.size() == 0) return true;
        if (this.getIndexByUsername(_userName) != -1) {
            System.out.println("The username " + _userName + " is already being used by another account.");
            return false;
        }
        return true;
    }

    /**
     * The password provided is checked to see if it is compliant with various password requirements.
     * @param _passWord
     * @return
     */
    public boolean checkForValidPassword(String _passWord) {
        boolean passwordIsCompliant = true;

        //Checks the password to see if meets the minimum password length
        if (_passWord.length() < MINIMUM_PASSWORD_LENGTH) {
            System.out.println("Password must be at least " + MINIMUM_PASSWORD_LENGTH + " characters in length.");
            passwordIsCompliant = false;
        }
        //Checks the password to ensure it has no spaces
        if (_passWord.contains(" ")) {
            System.out.println("Password must not contain any spaces.");
            passwordIsCompliant = false;
        }
        //Checks the password to ensure it contains both uppercase and lowercase letters
        if (_passWord.equals(_passWord.toUpperCase()) || _passWord.equals(_passWord.toLowerCase())) {
            System.out.println("Password must contain both uppercase and lowercase letters.");
            passwordIsCompliant = false;
        }
        //Checks the password to ensure it contains at least one number
        if (!_passWord.contains("0") && !_passWord.contains("1") &&!_passWord.contains("2") &&!_passWord.contains("3") &&!_passWord.contains("4") &&!_passWord.contains("5") &&!_passWord.contains("6") &&!_passWord.contains("7") &&!_passWord.contains("8") &&!_passWord.contains("9")) {
            System.out.println("Password must contain at least one number.");
            passwordIsCompliant = false;
        }
        return passwordIsCompliant;
    }

    /**
     * The age is checked to see if it satisfies the minimum age requirement
     * @param _age
     * @return
     */
    public boolean checkForValidAge(int _age) {
        if (_age < 18) {
            System.out.println("Users must be over the age of " + MINIMUM_AGE + " to use this service.");
            return false;
        }
        return true;
    }

    /**
     * All String information is checked to ensure it doesn't contain a tab that would break how the database is saved and loaded.
     * Probably useless, but is there just in case.
     * @param _userName
     * @param _passWord
     * @param _email
     * @param _city
     * @return
     */
    public boolean checkForNoTabs(String _userName, String _passWord, String _email, String _city) {
        boolean noTabs = true;
        if (_userName.contains(";")) {
            System.out.println("Username must not contain a tab.");
            noTabs = false;
        }
        if (_passWord.contains(";")) {
            System.out.println("Password must not contain a tab.");
            noTabs = false;
        }
        if (_email.contains(";")) {
            System.out.println("Email address must not contain a tab.");
            noTabs = false;
        }
        if (_city.contains(";")) {
            System.out.println("City must not contain a tab.");
            noTabs = false;
        }
        return noTabs;
    }

    /**
     * A single new user is added to the database, sorted so that it's in alphabetical order.
     *     NOTE: THIS METHOD SHOULD BE CALLED IMMEDIATELY AFTER A NEW ACCOUNT IS CREATED
     */
    public void singleSortList() {
        if (this.getSize() > 1) {
            UserProfile newestUser = this.applicationUser.get(this.applicationUser.size()-1);
            String newestUsername = newestUser.getUsername();
            int lowerSortThreshold = 0;
            int upperSortThreshold = this.getSize()-2;
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

    /**
     * A backup in case the database becomes unsorted, the entire database is sorted using merge sort.
     */
    public void mergeSortList() {
        if (this.getSize() > 1) {
            this.applicationUser = this.mergeSort(this.applicationUser);
            System.out.println("Database re-sorted.");
        }
    }

    /**
     * The actual method that handles the merge sort. Lists are recursively broken down into smaller lists,
     * the smaller lists are sorted, and the full list is gradually reassembled.
     * @param _list
     * @return
     */
    private List<UserProfile> mergeSort(List<UserProfile> _list) {
        if (_list.size() > 1) {
            //Dividing the list into two and recursing
            int midpoint = (_list.size() / 2);
            List<UserProfile> sortedList = new ArrayList<UserProfile>();
            List<UserProfile> miniList1 = this.mergeSort(_list.subList(0, midpoint));
            List<UserProfile> miniList2 = this.mergeSort(_list.subList(midpoint, _list.size()));

            //Assembling the sorted miniLists back together. Loop continues until one of the miniLists is empty
            int index1 = 0;
            int index2 = 0;
            while(index1 < miniList1.size() && index2 < miniList2.size()){
                //If the first element of miniList1 should come before the first element of miniList2, add it to the sortedList and add 1 to index1
                if (this.compareWithCase(miniList1.get(index1).getUsername(), miniList2.get(index2).getUsername()) < 0) {
                    sortedList.add(miniList1.get(index1));
                    index1++;
                }
                //Otherwise, the first element of miniList2 should be added to sortedList and add 1 to index2
                else {
                    sortedList.add(miniList2.get(index2));
                    index2++;
                }
            }
            //One of the miniLists has been exhausted, dump the contents of the remaining miniList onto sortedList
            for (; index1 < miniList1.size(); index1++) sortedList.add(miniList1.get(index1));
            for (; index2 < miniList2.size(); index2++) sortedList.add(miniList2.get(index2));
            return sortedList;
        }
        else return _list;
    }

    /**
     * Compares two strings with a uniform case.
     * @param _string1
     * @param _string2
     * @return
     */
    public int compareWithCase(String _string1, String _string2) { return _string1.toLowerCase().compareTo(_string2.toLowerCase()); }

    /**
     * Converts the personal information of all users into a String.
     * @return
     */
    public String printDatabase() {
        //Returns nothing if the method is called while the database is empty
        if(this.getSize() == 0) return "";

        String allUserData = "";
        //This loop gets the data of every user in order and adds them to a single String.
        for (int i = 0; i < this.getSize(); i++) {
            allUserData += this.printUser(i) + "\n";
        }
        return allUserData;
    }

    /**
     * Converts the personal information of a single user into a String, returning the outcome.
     * @param i
     * @return
     */
    public String printUser(int i) {
        try {
            String userData = "";
            userData += this.getUsernameByIndex(i) + "\t";
            userData += this.getPasswordByIndex(i) + "\t";
            userData += this.getEmailByIndex(i) + "\t";
            userData += this.getAgeByIndex(i) + "\t";
            userData += this.getCityByIndex(i) + "\t";
            userData += this.getZipCodeByIndex(i) + "\t";
            return userData;
        } catch (Exception ex) {
            //Only happens if i exceeds the size of the database or is less than 0 (Hopefully)
            return "";
        }
    }

    /**
     * Converts the user database to String and saves it to the provided address
     * @param _address
     */
    public void saveUserDatabase(String _address) {
        FileReadAndWriter saveFile = new FileReadAndWriter();
        //Try to create file if it doesn't already exist
        saveFile.createFile(_address);
        //Save the database to the text file
        saveFile.writeToFile(_address, this.printDatabase());
        System.out.println("Database successfully saved to " + _address);
    }

    /**
     * Converts the user database to String and saves it to the default address
     */
    public void saveUserDatabaseDefault() { this.saveUserDatabase(DEFAULTDATABASEADDRESS); }

    /**
     * Uses an inputted address for finding the user data text file and converting it into String.
     * @param _address
     */
    public void loadUserDatabase(String _address) {
        try {
            FileReadAndWriter fileLoader = new FileReadAndWriter();
            String userDatabase = fileLoader.readFile(_address);
            while (!userDatabase.isEmpty()) {
                //Getting the substring for the next user
                String userSubstring = userDatabase.substring(0, userDatabase.indexOf("\n"));
                //Getting the username from the substring
                String newUsername = userSubstring.substring(0, userSubstring.indexOf("\t"));
                userSubstring = userSubstring.substring(userSubstring.indexOf("\t")+1);
                //Getting the password from the substring
                String newPassword = userSubstring.substring(0, userSubstring.indexOf("\t"));
                userSubstring = userSubstring.substring(userSubstring.indexOf("\t")+1);
                //Getting the email from the substring
                String newEmail = userSubstring.substring(0, userSubstring.indexOf("\t"));
                userSubstring = userSubstring.substring(userSubstring.indexOf("\t")+1);
                //Getting the age from the substring
                int newAge = Integer.parseInt(userSubstring.substring(0, userSubstring.indexOf("\t")));
                userSubstring = userSubstring.substring(userSubstring.indexOf("\t")+1);
                //Getting the city from the substring
                String newCity = userSubstring.substring(0, userSubstring.indexOf("\t"));
                userSubstring = userSubstring.substring(userSubstring.indexOf("\t")+1);
                //Getting the IP address from the substring
                int newZipCode = Integer.parseInt(userSubstring);
                //Creating the new user
                quickAddNewApplicationUser(newUsername, newEmail, newPassword, newAge, newCity, newZipCode);
                //Trim the userDatabase
                userDatabase = userDatabase.substring(userDatabase.indexOf("\n")+1);
            }
            System.out.println("Database successfully loaded from " + _address);
        } catch (Exception ex) {
            System.out.println("An error has occurred when loading the user database. The file is formatted incorrectly or might have been tampered with.");
        }
    }

    /**
     * Uses the default address for finding the user data text file and converting it into String
     * @return
     */
    public void loadUserDatabaseDefault() { this.loadUserDatabase(DEFAULTDATABASEADDRESS); }

    //=================  GETTERS =================
    public UserProfile getUserProfileByIndex(int _i) { return this.applicationUser.get(_i); }
    public String getUsernameByIndex(int _i) { return this.applicationUser.get(_i).getUsername(); }
    public String getEmailByIndex(int _i) { return this.applicationUser.get(_i).getEmail(); }
    public String getPasswordByIndex(int _i) { return this.applicationUser.get(_i).getPassword(); }
    public int getAgeByIndex(int _i) { return this.applicationUser.get(_i).getAge(); }
    public String getCityByIndex(int _i) { return this.applicationUser.get(_i).getCity(); }
    public int getZipCodeByIndex(int _i) { return this.applicationUser.get(_i).getZipCode(); }
    public int getSize() { return this.applicationUser.size(); }
    public int getIndexByUsername(String _u) {
        int lowerThreshold = 0;
        int upperThreshold = this.applicationUser.size()-1;

        for (int i = upperThreshold / 2; ; i = lowerThreshold + ((upperThreshold-lowerThreshold)/2)) {
            int usernameCompare = compareWithCase(_u, getUsernameByIndex(i));
            //A matching username has been found
            if (usernameCompare == 0) {
                return i;
            }
            //A matching username has not been found
            else if (lowerThreshold == upperThreshold) return -1;
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

    //=================  SETTERS =================
    public void setUserProfileByIndex(int _i, UserProfile _userName) { this.applicationUser.set(_i, _userName); }
    public void setUsernameByIndex(int _i, String _userName) {
        UserProfile edittedUser = getUserProfileByIndex(_i);
        edittedUser.setUsername(_userName);
        setUserProfileByIndex(_i, edittedUser);
        mergeSortList();
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
    public void setAgeByIndex(int _i, int _age) {
        UserProfile edittedUser = getUserProfileByIndex(_i);
        edittedUser.setAge(_age);
        setUserProfileByIndex(_i, edittedUser);
    }
    public void setCityByIndex(int _i, String _city) {
        UserProfile edittedUser = getUserProfileByIndex(_i);
        edittedUser.setCity(_city);
        setUserProfileByIndex(_i, edittedUser);
    }
    public void setZipCodeByIndex(int _i, int _zipCode) {
        UserProfile edittedUser = getUserProfileByIndex(_i);
        edittedUser.setZipCode(_zipCode);
        setUserProfileByIndex(_i, edittedUser);
    }
}