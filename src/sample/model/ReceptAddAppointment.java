package sample.model;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class ReceptAddAppointment {
    public static void writeToFile(Appointment newAppointment) {

    try {
        FileWriter writer = new FileWriter("src/sample/data/Appointment.txt", true);
        PrintWriter printWriter = new PrintWriter(writer);
        printWriter.println(newAppointment.toString());
        printWriter.close();
    } catch (IOException e) {
        e.printStackTrace();
    }
}

}
