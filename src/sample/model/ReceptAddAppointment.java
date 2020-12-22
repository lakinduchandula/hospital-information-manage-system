package sample.model;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class ReceptAddAppointment {
    public static void writeToFile(SystemUser newUser, int userMode) {
    final String[] fileLocation = {"src/sample/data/ReceptAddAppointmnet.txt"
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
