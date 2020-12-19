package sample.model;

import java.time.LocalDate;

public class Patient extends User {
    private String bloodGroup;
    private String allergiesLine1;
    private String allergiesLine2;
    private ComplaintRecord complaint;
    private Appointment appointment;

    //Constructors
    public Patient (){

    }
    public Patient(String userName, String firstName, String lastName, String gender, String phoneNumber, String idNo,
                   LocalDate dOB, String addressLine1, String addressLine2, String city, String country,
                   String maritalStatus, String password,String bloodGroup, String allergiesLine1, String allergiesLine2){
        super(userName, firstName, lastName, gender, phoneNumber, idNo, dOB, addressLine1, addressLine2, city, country,
                maritalStatus, password);
        this.setBloodGroup(bloodGroup);
        this.setAllergiesLine1(allergiesLine1);
    }


    //Getters and Setters
    public String getBloodGroup(){
        return bloodGroup;
    }

    public String getAllergiesLine1(){
        return allergiesLine1;
    }

    public String getAllergiesLine2(){
        return allergiesLine2;
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

    public void setAllergiesLine1(String allergiesLine1) {
        this.allergiesLine1 = allergiesLine1;
    }

    public void setAllergiesLine2(String allergiesLine2) {
        this.allergiesLine2 = allergiesLine2;
    }

    public void setComplaint(ComplaintRecord complaint) {
        this.complaint = complaint;
    }

    public void setAppointment(Appointment appointment) {
        this.appointment = appointment;
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

    @Override
    public String toString() {
        return super.toString() + String.format("~%s~%s~%s", getBloodGroup(), getAllergiesLine1(), getAllergiesLine2());
    }
}

