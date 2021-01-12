package sample.model;

import javafx.scene.control.ComboBox;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

public class PrefMedicalOfficer {

    public static void MOList(String specialArea, ComboBox<String> MedicalOfficer) {
        File file = new File("src/sample/data/UserMedicalOfficer.txt");
        ArrayList<String> MOList = new ArrayList<>();
        try(FileReader fileReader = new FileReader(file)) {
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = null ;

            while((line = bufferedReader.readLine()) != null) {
                String[] userCredentials = line.split("~");

                if(credentialValidation(userCredentials[17], specialArea)){
                        MOList.add("Dr. "+userCredentials[2]+ " " + userCredentials[3]+" - "+userCredentials[14]);
                }
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        for (String item : MOList) {
            MedicalOfficer.getItems().addAll(item);
        }
    }

    public static void AllMOList(ComboBox<String> MedicalOfficer) {
        File file = new File("src/sample/data/UserMedicalOfficer.txt");
        ArrayList<String> MOList = new ArrayList<>();
        try(FileReader fileReader = new FileReader(file)) {
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = null ;

            while((line = bufferedReader.readLine()) != null) {
                String[] userCredentials = line.split("~");
                MOList.add("Dr. "+userCredentials[2]+ " " + userCredentials[3]+" - "+userCredentials[14]);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        for (String item : MOList) {
            MedicalOfficer.getItems().addAll(item);
        }
    }

    public static boolean credentialValidation(String MOAreaFile, String specialArea) {
        return MOAreaFile.equals(specialArea);
    }

}
