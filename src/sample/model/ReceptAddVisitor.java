package sample.model;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class ReceptAddVisitor  {
    public static void writeToFile(Visitor newVisitor) {


        try {
            FileWriter writer = new FileWriter("src/sample/data/ReceptVisitor.txt", true);
            PrintWriter printWriter = new PrintWriter(writer);
            printWriter.println(newVisitor.toString());
            printWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
