package sample.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.time.LocalDate;

public class ComplaintRecord {

    private String[] complaintDetails;
    private String complaintType;
    private String firstName;
    private String lastName;
    private String username;
    private String idNum;
    private String phoneNum;
    private String complaintID;
    private LocalDate currentDate;
    private String description;
    private String actionTaken;
    private File attachDocORNote;

    //Variable Constructor

    public ComplaintRecord(String complaintType, String firstName,String lastName, String username, String idNum
                           ,String phoneNum , String complaintID, LocalDate currentDate
                           ,String description, String actionTaken, File attachDocORNote){

        this.setComplaintType(complaintType);
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setUsername(username);
        this.setIdNum(idNum);
        this.setPhoneNum(phoneNum);
        this.setComplaintID(complaintID);
        this.setCurrentDate(currentDate);
        this.setDescription(description);
        this.setActionTaken(actionTaken);
        this.setAttachDocORNote(attachDocORNote);
    }

    //Default Variables

    public ComplaintRecord(){
        this.setComplaintType("");
        this.setFirstName("");
        this.setLastName("");
        this.setUsername("");
        this.setIdNum("");
        this.setPhoneNum("");
        this.setComplaintID("");
        this.setCurrentDate(null);
        this.setDescription("");
        this.setActionTaken("");
        this.setAttachDocORNote(null);
    }

    //Getters and Setters

    public String getComplaintType(){
        return this.complaintType;
    }

    public String getFirstName() { return this.firstName; }

    public String getLastName() { return this.lastName; }

    public String getUsername() { return this.username; }

    public String getIdNum() { return this.idNum; }

    public String getPhoneNum() { return this.phoneNum; }

    public String getComplaintID() { return this.complaintID; }

    public String[] getComplaintDetails() { return this.complaintDetails; }

    public LocalDate getCurrentDate(){
        return this.currentDate;
    }

    public String getDescription(){
        return this.description;
    }

    public String getActionTaken(){
        return this.actionTaken;
    }

    public File getAttachDocORNote(){
        return this.attachDocORNote;
    }




    public void setComplaintType(String complaintType){
        this.complaintType = complaintType;
    }

    public void setFirstName(String firstName) { this.firstName = firstName; }

    public void setLastName(String lastName) { this.lastName = lastName; }

    public void setUsername(String username) { this.username = username; }

    public void setIdNum(String idNum) { this.idNum = idNum; }

    public void setPhoneNum(String phoneNum) { this.phoneNum = phoneNum; }

    public void setComplaintID(String complaintID) { this.complaintID = complaintID; }


    public void setCurrentDate(LocalDate currentDate) {
        this.currentDate = currentDate;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setActionTaken(String actionTaken) {
        this.actionTaken = actionTaken;
    }

    public void setComplaintDetails(String[] complaintDetails) { this.complaintDetails = complaintDetails; }

    public void setAttachDocORNote(File attachDocORNote) {
        this.attachDocORNote = attachDocORNote;
    }

    public String toString() {
        return String.format("%s~%s~%s~%s~%s~%s~%s~%s~%s~%s~%s",getComplaintID(),getUsername(),getFirstName(),
                getLastName(), getIdNum(), getPhoneNum() , getCurrentDate() , getComplaintType(),
                getDescription() , getAttachDocORNote() , getActionTaken());
    }

    public void getComplaintDetailsArray(String complaintID) {
        File file = new File("src/sample/data/Complaint.txt");
        try (FileReader fileReader = new FileReader(file)) {
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line = null;

            while ((line = bufferedReader.readLine()) != null) {
                String[] userCredentials = line.split("~");

                if(sameCredentials(userCredentials[0], complaintID)){
                    System.out.println(userCredentials[0]);
                    setComplaintDetails(userCredentials);
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean sameCredentials(String line1, String line2){
        return line1.equals(line2);
    }


}

