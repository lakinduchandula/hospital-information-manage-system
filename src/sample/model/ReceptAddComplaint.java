package sample.model;

import java.io.*;
import java.util.ArrayList;

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

    public static void removeComplaint(String complaintID){
        File file = new File("src/sample/data/Complaint.txt");
        try(FileReader fileReader = new FileReader(file)) {
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line = null ;
            ArrayList<String[]> complaintList = new ArrayList<>();
            while((line = bufferedReader.readLine()) != null) {
                String[] userCredentials = line.split("~");
                complaintList.add(userCredentials);
                if(credentialValidation(userCredentials[0], complaintID)){
                    complaintList.remove(userCredentials);
                }
            }

            // add other complaints to the file
            try {
                FileWriter writer = new FileWriter("src/sample/data/Complaint.txt");
                PrintWriter printWriter = new PrintWriter(writer);
                for(String[] elementArray : complaintList){
                    for(String element: elementArray){
                        printWriter.print(element + "~");
                    }
                    printWriter.println();
                }
                printWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean credentialValidation(String userName, String username) {
        return username.equals(userName);
    }

}
