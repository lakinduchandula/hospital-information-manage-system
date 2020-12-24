package sample.model;

import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

public class Appointment {
    private String userName;
    private String firstName;
    private String lastName;
    private String idNo;
    private String phoneNumber;
    private String gender;
    private LocalDate dOB;
    private String maritalStatus;
    private String addressLine1;
    private String addressLine2;
    private String bloodGroup;
    private String allergies;
    private LocalDate appointmentDate;
    private LocalTime appointmentTime;
    private String symptoms;
    private LocalDate symptomsFromDate;
    private MedicalOfficer medicalOfficer;
    private String appointmentRecordStatus;
    private String appointmentNo;

    //Variable Constructor
    public Appointment( String userName,String firstName,String lastName,String idNo,String phoneNumber,
                        String gender,LocalDate dOB,String maritalStatus,String addressLine1,String addressLine2
                        ,String bloodGroup, String allergies ,LocalDate appointmentDate, LocalTime appointmentTime,
                        String symptoms, LocalDate symptomsFromDate,MedicalOfficer medicalOfficer,
                        String appointmentRecordStatus, String appointmentNo){

        this.setUserName(userName);
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setIdNo(idNo);
        this.setPhoneNumber(phoneNumber);
        this.setGender(gender);
        this.setdOB(dOB);
        this.setMaritalStatus(maritalStatus);
        this.setAddressLine1(addressLine1);
        this.setAddressLine2(addressLine2);
        this.setBloodGroup(bloodGroup);
        this.setAllergies(allergies);
        this.setAppointmentDate(appointmentDate);
        this.setAppointmentTime(appointmentTime);
        this.setSymptoms(symptoms);
        this.setSymptomsFromDate(symptomsFromDate);
        this.setMedicalOfficer(medicalOfficer);
        this.setAppointmentRecordStatus(appointmentRecordStatus);
        this.setAppointmentNo(appointmentNo);
    }

    //Default Constructor
    public Appointment(){

        this.setUserName("");
        this.setFirstName("");
        this.setLastName("");
        this.setIdNo("");
        this.setPhoneNumber("");
        this.setGender("");
        this.setdOB(null);
        this.setMaritalStatus("");
        this.setAddressLine1("");
        this.setAddressLine2("");
        this.setBloodGroup("");
        this.setAllergies("");
        this.setAppointmentDate(null);
        this.setAppointmentTime(null);
        this.setSymptoms("");
        this.setSymptomsFromDate(null);
        this.setMedicalOfficer(null);
        this.setAppointmentRecordStatus("");
        this.setAppointmentNo("");
    }


    //Getters and Setters

    public String getUserName() { return this.userName; }

    public String getFirstName() { return this.firstName; }

    public String getLastName() { return this.lastName; }

    public String getIdNo() { return this.idNo; }

    public String getPhoneNumber() { return this.phoneNumber; }

    public String getGender() { return this.gender; }

    public LocalDate getdOB() { return this.dOB;  }

    public String getMaritalStatus() { return this.maritalStatus; }

    public String getAddressLine1() { return this.addressLine1; }

    public String getAddressLine2() { return this.addressLine2; }

    public String getBloodGroup() { return this.bloodGroup; }

    public String getAllergies() { return this.allergies; }

    public LocalDate getSymptomsFromDate() { return this.symptomsFromDate; }

    public LocalDate getAppointmentDate(){
        return this.appointmentDate;
    }

    public LocalTime getAppointmentTime(){
        return this.appointmentTime;
    }

    public String getSymptoms(){
        return this.symptoms;
    }

    public MedicalOfficer getMedicalOfficer(){
        return this.medicalOfficer;
    }

    public String getAppointmentRecordStatus(){
        return this.appointmentRecordStatus;
    }

    public String getAppointmentNo(){
        return this.appointmentNo;
    }


    public void setUserName(String userName) { this.userName = userName; }

    public void setFirstName(String firstName) { this.firstName = firstName; }

    public void setLastName(String lastName) { this.lastName = lastName; }

    public void setIdNo(String idNo) { this.idNo = idNo; }

    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }

    public void setGender(String gender) { this.gender = gender; }

    public void setdOB(LocalDate dOB) { this.dOB = dOB; }

    public void setMaritalStatus(String maritalStatus) { this.maritalStatus = maritalStatus; }

    public void setAddressLine1(String addressLine1) { this.addressLine1 = addressLine1; }

    public void setAddressLine2(String addressLine2) { this.addressLine2 = addressLine2; }

    public void setBloodGroup(String bloodGroup) { this.bloodGroup = bloodGroup; }

    public void setAllergies(String allergies) { this.allergies = allergies; }

    public void setSymptomsFromDate(LocalDate symptomsFromDate) { this.symptomsFromDate = symptomsFromDate; }

    public void setAppointmentDate(LocalDate appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public void setAppointmentTime(LocalTime appointmentTime) {
        this.appointmentTime = appointmentTime;
    }

    public void setSymptoms(String symptoms) {
        this.symptoms = symptoms;
    }

    public void setMedicalOfficer(MedicalOfficer medicalOfficer) {
        this.medicalOfficer = medicalOfficer;
    }

    public void setAppointmentNo(String appointmentNo) {
        this.appointmentNo = appointmentNo;
    }

    public void setAppointmentRecordStatus(String appointmentRecordStatus) { this.appointmentRecordStatus
            = appointmentRecordStatus; }

    public String toString() {
        return String.format("%s~%s~%s~%s~%s~%s~%s~%s~%s~%s~%s~%s~%s~%s~%s~%s~%s", getUserName(),getFirstName(),
                getLastName(), getIdNo(),getPhoneNumber(),getdOB(),getMaritalStatus() , getAddressLine1(),
                getAddressLine2(),getBloodGroup() , getAllergies() , getSymptoms() , getSymptomsFromDate() ,
                getAppointmentDate() ,getAppointmentTime(),getMedicalOfficer(), getAppointmentNo());
    }


}
