package sample.model;

import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import javafx.collections.ObservableList;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.time.LocalDate;
import java.time.LocalTime;

public class Appointment extends RecursiveTreeObject<Appointment> {
    private String userName;
    private String appointmentNo;
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
    private MedicalOfficer medicalOfficer;
    private String appointmentRecordStatus;

    //Default Constructor
    public Appointment(){

    }

    //Variable Constructor
    public Appointment( String userName,String firstName,String lastName,String idNo,String phoneNumber,
                        String gender,LocalDate dOB,String maritalStatus,String addressLine1,String addressLine2,
                        String bloodGroup, String allergies ,LocalDate appointmentDate, LocalTime appointmentTime,
                        String symptoms,MedicalOfficer medicalOfficer, String appointmentRecordStatus, String appointmentNo){

        this.setUserName(userName);
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setIdNo(idNo);
        this.setPhoneNumber(phoneNumber);
        this.setGender(gender);
        this.setDOB(dOB);
        this.setMaritalStatus(maritalStatus);
        this.setAddressLine1(addressLine1);
        this.setAddressLine2(addressLine2);
        this.setBloodGroup(bloodGroup);
        this.setAllergies(allergies);
        this.setAppointmentDate(appointmentDate);
        this.setAppointmentTime(appointmentTime);
        this.setSymptoms(symptoms);
        this.setMedicalOfficer(medicalOfficer);
        this.setAppointmentRecordStatus(appointmentRecordStatus);
        this.setAppointmentNo(appointmentNo);
    }

    public Appointment(String appointmentNo, String firstName, String lastName, String idNo, String phoneNumber,
                       String gender, LocalDate date, LocalTime time, String symptoms) {
        this.setAppointmentNo(appointmentNo);
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setIdNo(idNo);
        this.setPhoneNumber(phoneNumber);
        this.setGender(gender);
        this.setAppointmentDate(date);
        this.setAppointmentTime(time);
        this.setSymptoms(symptoms);
    }

    public String getUserName() { return this.userName; }

    public String getFirstName() { return this.firstName; }

    public String getLastName() { return this.lastName; }

    public String getIdNo() { return this.idNo; }

    public String getPhoneNumber() { return this.phoneNumber; }

    public String getGender() { return this.gender; }

    public LocalDate getDOB() { return this.dOB;  }

    public String getMaritalStatus() { return this.maritalStatus; }

    public String getAddressLine1() { return this.addressLine1; }

    public String getAddressLine2() { return this.addressLine2; }

    public String getBloodGroup() { return this.bloodGroup; }

    public String getAllergies() { return this.allergies; }


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

    public String getAppointmentNo(){
        return this.appointmentNo;
    }

    public String getAppointmentRecordStatus() { return this.appointmentRecordStatus; }

    public void setUserName(String userName) { this.userName = userName; }

    public void setFirstName(String firstName) { this.firstName = firstName; }

    public void setLastName(String lastName) { this.lastName = lastName; }

    public void setIdNo(String idNo) { this.idNo = idNo; }

    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }

    public void setGender(String gender) { this.gender = gender; }

    public void setDOB(LocalDate dOB) { this.dOB = dOB; }

    public void setMaritalStatus(String maritalStatus) { this.maritalStatus = maritalStatus; }

    public void setAddressLine1(String addressLine1) { this.addressLine1 = addressLine1; }

    public void setAddressLine2(String addressLine2) { this.addressLine2 = addressLine2; }

    public void setBloodGroup(String bloodGroup) { this.bloodGroup = bloodGroup; }

    public void setAllergies(String allergies) { this.allergies = allergies; }


    public void setAppointmentDate(LocalDate appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public void setAppointmentTime(LocalTime appointmentTime) {
        this.appointmentTime =  appointmentTime;
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
                getLastName(), getIdNo(),getPhoneNumber(),getDOB(),getMaritalStatus() , getAddressLine1(),
                getAddressLine2(),getBloodGroup() , getAllergies() , getSymptoms() , getAppointmentDate() ,
                getAppointmentTime(),getMedicalOfficer(), getAppointmentNo(),getAppointmentRecordStatus());
    }

    public ObservableList<Appointment> getApprovedAppointmentList(MedicalOfficer medicalOfficer){
        File file = new File("src/sample/data/Appointment.txt");
        try(FileReader fileReader = new FileReader(file)) {
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line = null ;

            while((line = bufferedReader.readLine()) != null) {
                String[] userCredentials = line.split("~");

                if(credentialValidation(userCredentials[0], getUserName())){
                    
                }
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean credentialValidation(String userName, String username) {
        return username.equals(userName);
    }
}
