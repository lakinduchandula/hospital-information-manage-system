package sample.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.time.LocalDate;

public class HomeDetails {
    private int[] homeDetailCount;


    public void setHomeDetailCount(int[] homeDetailCount){
        this.homeDetailCount = homeDetailCount;
    }

    public int[] getHomeDetailCount(){
        return homeDetailCount;
    }

    public void textReader(){
        final String[] fileLocation = {"src/sample/data/UserReceptionist.txt",
                "src/sample/data/UserPatient.txt", "src/sample/data/UserMedicalOfficer.txt",
                "src/sample/data/Appointment.txt", "src/sample/data/Complaint.txt"
        };

        int[] Count = new int[5];
        for(int i = 0; i < 5; i++){
            File file = new File(fileLocation[i]);
            try (FileReader fileReader = new FileReader(file)) {
                BufferedReader bufferedReader = new BufferedReader(fileReader);

                String line = null;
                int countLines = 0;
                while ((line = bufferedReader.readLine()) != null) {
                    countLines = countLines + 1;
                }
                Count[i] = countLines;

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        setHomeDetailCount(Count);
    }
}
