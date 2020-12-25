package sample.model;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class ReceptAddComplaint {
    public static void writeToFile(ComplaintRecord newComplaintRecord) {


        try {
            FileWriter writer = new FileWriter("src/sample/data/Complaint.txt", true);
            PrintWriter printWriter = new PrintWriter(writer);
            printWriter.println(newComplaintRecord.toString());
            printWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
