package sample.model;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class ReceptAddPostalMail {
    public static void writeToFile(PostalMail newPostalMail, int postalMailType) {
        final String[] fileLocation = {"src/sample/data/ReceivedPostalMail.txt", "src/sample/data/DispatchPostalMail.txt"};
        try {
            FileWriter writer = new FileWriter(fileLocation[postalMailType], true);
            PrintWriter printWriter = new PrintWriter(writer);
            printWriter.println(newPostalMail.toString());
            printWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
