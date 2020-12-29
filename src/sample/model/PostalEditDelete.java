package sample.model;

import java.io.*;
import java.util.ArrayList;

import static sample.model.PrefMedicalOfficer.credentialValidation;

public class PostalEditDelete {
    private String[] postalDetailsArray;
    private String[] deletePostalDetailsArray;
    private int postalMailType;

    public PostalEditDelete(int postalMailType) {
        setPostalMailType(postalMailType);
    }

    public int getPostalMailType() {
        return postalMailType;
    }

    public void setPostalMailType(int postalMailType) {
        this.postalMailType = postalMailType;
    }

    public String[] getPostalDetailsArray() {
        return postalDetailsArray;
    }



    public String[] getDeletePostalDetailsArray() {
        return deletePostalDetailsArray;
    }

    public void setPostalDetailsArray(String[] postalDetailsArray) {
       this.postalDetailsArray = postalDetailsArray;
    }

    public void setDeletePostalDetailsArray(String[] deletePostalDetailsArray) {
        this.deletePostalDetailsArray = deletePostalDetailsArray;
    }

    public void PostalMailEdit(String referenceNo) {
        final String[] fileLocation = {"src/sample/data/ReceivedPostalMail.txt",
                "src/sample/data/DispatchPostalMail.txt"
        };
        File file = new File(fileLocation[getPostalMailType()]);
        try(FileReader fileReader = new FileReader(file)) {
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line = null ;

            while((line = bufferedReader.readLine()) != null) {
                String[] userCredentials = line.split("~");

                if(credentialValidation(userCredentials[0], referenceNo)){
                    setPostalDetailsArray(userCredentials);
                }
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void PostalMailDelete(String referenceNo){
        final String[] fileLocation = {"src/sample/data/ReceivedPostalMail.txt",
                "src/sample/data/DispatchPostalMail.txt"};
        File file = new File(fileLocation[getPostalMailType()]);
        try(FileReader fileReader = new FileReader(file)) {

            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line = null ;
            ArrayList<String[]> postalMails = new ArrayList<>();
            while((line = bufferedReader.readLine()) != null) {
                String[] userCredentials = line.split("~");
                postalMails.add(userCredentials);
                if(credentialValidation(userCredentials[0], referenceNo)){
                    setDeletePostalDetailsArray(userCredentials);
                    postalMails.remove(userCredentials);
                }
            }


            try {
                FileWriter writer = new FileWriter(fileLocation[postalMailType]);
                PrintWriter printWriter = new PrintWriter(writer);
                for(String[] elementArray : postalMails){
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




}