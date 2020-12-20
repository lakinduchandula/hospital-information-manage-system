package sample.model;


import java.io.*;
import java.util.ArrayList;

public class UserEditDelete {
    private String[] userDetailArray ;
    private String[] deleteUserDetailsArray;
    private int userMode;

    public UserEditDelete(int userMode){
        setUserMode(userMode);
    }

    public int getUserMode(){
        return userMode;
    }

    public void setUserMode(int userMode){
        this.userMode = userMode;
    }

    public String[] getUserDetailArray() {
        return userDetailArray;
    }

    public String[] getDeleteUserDetailsArray() {
        return deleteUserDetailsArray;
    }

    public void setUserDetailArray(String[] userDetailArray) {
        this.userDetailArray = userDetailArray;
    }

    public void setDeleteUserDetailsArray(String[] deleteUserDetailsArray) {
        this.deleteUserDetailsArray = deleteUserDetailsArray;
    }

    public void UserEdit(String username) {
        final String[] fileLocation = {"src/sample/data/UserReceptionist.txt",
                "src/sample/data/UserPatient.txt", "src/sample/data/UserMedicalOfficer.txt"
        };
        File file = new File(fileLocation[getUserMode()]);
        try(FileReader fileReader = new FileReader(file)) {
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line = null ;

            while((line = bufferedReader.readLine()) != null) {
                String[] userCredentials = line.split("~");

                if(credentialValidation(userCredentials[0], username)){
                    setUserDetailArray(userCredentials);
                }
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean credentialValidation(String userName, String username) {
        return username.equals(userName);
    }

    public void UserDelete(String username){
        final String[] fileLocation = {"src/sample/data/UserReceptionist.txt",
                "src/sample/data/UserPatient.txt", "src/sample/data/UserMedicalOfficer.txt"
        };
        File file = new File(fileLocation[getUserMode()]);
        try(FileReader fileReader = new FileReader(file)) {
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line = null ;
            ArrayList<String[]> userAccounts = new ArrayList<>();
            while((line = bufferedReader.readLine()) != null) {
                String[] userCredentials = line.split("~");
                userAccounts.add(userCredentials);
                if(credentialValidation(userCredentials[0], username)){
                    setDeleteUserDetailsArray(userCredentials);
                    userAccounts.remove(userCredentials);
                }
            }

            // add other userAccounts to the file
            try {
                FileWriter writer = new FileWriter(fileLocation[userMode]);
                PrintWriter printWriter = new PrintWriter(writer);
                for(String[] elementArray : userAccounts){
                    for(String element: elementArray){
                        printWriter.print(element + "~");
                    }
                    printWriter.println();
                }
                printWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
