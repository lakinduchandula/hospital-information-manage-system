package sample.model;

import com.jfoenix.controls.JFXTextField;
import javafx.scene.control.ComboBox;
import java.io.*;
import java.util.ArrayList;

public class AdReference {

    private static JFXTextField txt;

    public static void addItem(JFXTextField ItemAdd, int LocationIndex){
        String[] fileLocationList = {"src/sample/data/MOSpecialArea.txt", "src/sample/data/ComplaintDepartment.txt"};
        try {
            FileWriter writer = new FileWriter(fileLocationList[LocationIndex], true);
            PrintWriter printWriter = new PrintWriter(writer);
            printWriter.println(ItemAdd.getText().trim());
            printWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readItem(ComboBox<String> readItems, int LocationIndex) {
        String[] fileLocationList = {"src/sample/data/MOSpecialArea.txt", "src/sample/data/ComplaintDepartment.txt"};
        ArrayList<String> ItemList = new ArrayList<>();
        File file = new File(fileLocationList[LocationIndex]);
        try (FileReader fileReader = new FileReader(file)) {
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

    public static void removeItem(JFXTextField ItemRemove, int LocationIndex){
        String[] fileLocationList = {"src/sample/data/MOSpecialArea.txt", "src/sample/data/ComplaintDepartment.txt"};
        ArrayList<String> ItemList = new ArrayList<>();
        File file = new File(fileLocationList[LocationIndex]);
        try (FileReader fileReader = new FileReader(file)) {
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String itemRemove = null;

            while ((itemRemove = bufferedReader.readLine()) != null) {
                ItemList.add(itemRemove);
                if(itemRemove.equals(ItemRemove.getText().trim())){
                    ItemList.remove(itemRemove);
                }
            }

            try {
                FileWriter writer = new FileWriter(fileLocationList[LocationIndex]);
                PrintWriter printWriter = new PrintWriter(writer);
                for(String element : ItemList){
                    printWriter.println(element);
                }
                printWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
