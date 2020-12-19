package sample.model;

import java.time.LocalDate;

public class MedicalOfficer extends User {

    private String specialtyArea;
    private String staffID;
    private String staffEmail;
    private LocalDate dateOfJoin;
    private Appointment appointment;

    //Default constructor
    public MedicalOfficer(){

    }

    public String getSpecialtyArea(){
        return this.specialtyArea;
    }

    public String getStaffEmail() {
        return staffEmail;
    }

    public String getStaffID() {
        return staffID;
    }

    public LocalDate getDateOfJoin(){
        return dateOfJoin;
    }

    public void setDateOfJoin(LocalDate dateOfJoin){
        this.dateOfJoin = dateOfJoin;
    }

    public void setStaffEmail(String staffEmail){
        this.staffEmail = staffEmail;
    }

    public void setStaffID(String staffID){
        this.staffID = staffID;
    }

    public void setSpecialtyArea(String specialty){
        this.specialtyArea = specialty;
    }

    public Appointment ViewAppointment(){ return appointment;    }

    public Appointment EditAppointment(){
        return appointment;
    }

    public String toString(){
        return super.toString() + String.format("~%s~%s~%s~%s", getStaffID(), getStaffEmail(), getDateOfJoin(),
                getSpecialtyArea());
    }
}
