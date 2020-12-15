package sample.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class UserLogin {
    // declaration of instance variables
    private String userName;
    private String password;
    private int userMode;
    private boolean userValidation;

    private final String[] fileLocation = {"src/sample/data/UserAdmin.txt", "src/sample/data/UserReceptionist.txt",
            "src/sample/data/UserPatient.txt", "src/sample/data/UserMedicalOfficer.txt"
    };

    public UserLogin(String userName, String password, int userMode) {
        setUserName(userName);
        setPassword(password);
        setUserMode(userMode);
    }

    // setter for userValidation
    public void setUserValidation(boolean userValidation){
        this.userValidation = userValidation;
    }

    // setter for Username
    public void setUserName(String Username) {
        this.userName = Username;
    }

    // setter for Password
    public void setPassword(String Password) {
        this.password = Password;
    }

    // setter for Usermode
    public void setUserMode(int Usermode) {
        this.userMode = Usermode;
    }

    // getter for Username
    public String getUserName() {
        return userName;
    }

    // getter for Password
    public String getPassword() {
        return password;
    }

    // getter for Usermode
    public String getUserMode() {
        return fileLocation[userMode];
    }

    // getter for userValidation
    public boolean getUserValidation() {
        return userValidation;
    }

    // validation of the user login credentials
    public void checkLoginValidation() {
        File file = new File(getUserMode());
        try(FileReader fileReader = new FileReader(file)) {
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line = null ;
            
            while((line = bufferedReader.readLine()) != null) {
                String[] userCredentials = line.split("~");

                if(credentialValidation(userCredentials[0], userCredentials[1])){
                    setUserValidation(true);
                }
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }


    }

    public boolean credentialValidation(String userName, String password) {
        return getUserName().equals(userName) && getPassword().equals(password);
    }


}
