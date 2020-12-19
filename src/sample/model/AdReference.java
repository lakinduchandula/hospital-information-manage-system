package sample.model;

import com.jfoenix.controls.JFXTextField;
import javafx.scene.control.ComboBox;
import java.io.*;
import java.util.ArrayList;

public class AdReference {

    public static void addItem(JFXTextField ItemAdd){
        String[] fileLocationList = {"src/sample/data/MOSpecialArea.txt"};
        try {
            FileWriter writer = new FileWriter(fileLocationList[0], true);
            PrintWriter printWriter = new PrintWriter(writer);
            printWriter.println(ItemAdd.getText().trim());
            printWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readItem(ComboBox<String> readItems) {
        String[] fileLocationList = {"src/sample/data/MOSpecialArea.txt"};
        ArrayList<String> ItemList = new ArrayList<>();
        File file = new File(fileLocationList[0]);
        try (
                FileReader fileReader = new FileReader(file)) {
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String itemContent = null;

            while ((itemContent = bufferedReader.readLine()) != null) {
                ItemList.add(itemContent);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (String item : ItemList) {
            readItems.getItems().addAll(item);
        }
    }
}
