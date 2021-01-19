package sample.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.time.LocalDate;

public class Patient extends User {
    private String bloodGroup;
    private String allergies;
    private ComplaintRecord complaint;
    private Appointment appointment;
    private String ghostUniqueID;

    //Constructors
    public Patient (){

    }
    public Patient(String userName, String firstName, String lastName, String gender, String phoneNumber, String idNo,
                   LocalDate dOB, String addressLine1, String addressLine2, String city, String country,
                   String maritalStatus, String password,String bloodGroup, String allergies){
        super(userName, firstName, lastName, gender, phoneNumber, idNo, dOB, addressLine1, addressLine2, city, country,
                maritalStatus, password);
        this.setBloodGroup(bloodGroup);
        this.setAllergies(allergies);
    }


    //Getters and Setters
    public String getBloodGroup(){
        return bloodGroup;
    }

    public String getGhostUniqueID(){
        return ghostUniqueID;
    }

    public String getAllergies(){
        return allergies;
    }

    public ComplaintRecord getComplaint() {
        return complaint;
    }

    public Appointment getAppointment() {
        return appointment;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public void setAllergies(String allergies) {
        this.allergies = allergies;
    }

    public void setComplaint(ComplaintRecord complaint) {
        this.complaint = complaint;
    }

    public void setAppointment(Appointment appointment) {
        this.appointment = appointment;
    }

    public void setGhostUniqueID(String ghostUniqueID) {
        this.ghostUniqueID = ghostUniqueID;
    }

    public ComplaintRecord addComplaint(){
        return complaint;
    }

    public void viewComplaint(ComplaintRecord complaint){
    }

    public Appointment addAppointment(){
        return appointment;
    }

    public void viewAppointment(Appointment appointment){
    }

    public String getPatientGhostID(String username){
        File file = new File("src/sample/data/UserPatient.txt");
        try(FileReader fileReader = new FileReader(file)) {
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line = null ;

            while((line = bufferedReader.readLine()) != null) {
                String[] userCredentials = line.split("~");

                if(credentialValidation(userCredentials[0], username)){
                    return userCredentials[16];
                }
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return "User not found-patient.java-line-102";
    }

    public boolean credentialValidation(String userName, String username) {
        return username.equals(userName);
    }

    @Override
    public String toString() {
        return super.toString() + String.format("~%s~%s~%s~", getBloodGroup(), getAllergies(),
                 getGhostUniqueID());
    }
}

