package sample.model;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class UserAdd {
    public static void writeToFile(SystemUser newUser, int userMode) {
        final String[] fileLocation = {"src/sample/data/UserAdmin.txt", "src/sample/data/UserReceptionist.txt",
                "src/sample/data/UserPatient.txt", "src/sample/data/UserMedicalOfficer.txt"
        };
        try {
            FileWriter writer = new FileWriter(fileLocation[userMode], true);
            PrintWriter printWriter = new PrintWriter(writer);
            printWriter.println(newUser.toString());
            printWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
