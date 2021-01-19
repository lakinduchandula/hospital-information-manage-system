package sample.model;

import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Appointment extends RecursiveTreeObject<Appointment> {
    private String[] appointmentDetails;
    private String[] DeleteAppDetailsArray;
    private String userName;
    private String appointmentNo;
    private String firstName;
    private String lastName;
    private String idNo;
    private String phoneNumber;
    private String gender;
    private LocalDate dOB;
    private String addressLine1;
    private String addressLine2;
    private String city;
    private String bloodGroup;
    private LocalDate appointmentDate;
    private LocalTime appointmentTime;
    private String symptoms;
    private String medicalOfficer;
    private String MOStaffID;
    private String medicalSpecialArea;
    private String appointmentRecordStatus;
    private String patientUniqueID;
    private ObservableList<Appointment> ApprovedAppointments = FXCollections.observableArrayList();

    //Default Constructor
    public Appointment(){

    }

    //Variable Constructor
    public Appointment( String userName,String firstName,String lastName,String idNo,String phoneNumber,
                        String gender,LocalDate dOB,String addressLine1,String addressLine2, String city,
                        String bloodGroup, LocalDate appointmentDate, LocalTime appointmentTime,
                        String symptoms, String medicalOfficer, String appointmentRecordStatus, String appointmentNo){

        this.setUserName(userName);
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setIdNo(idNo);
        this.setPhoneNumber(phoneNumber);
        this.setGender(gender);
        this.setDOB(dOB);
        this.setCity(city);
        this.setAddressLine1(addressLine1);
        this.setAddressLine2(addressLine2);
        this.setBloodGroup(bloodGroup);
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

    public Appointment(String appointmentNo, String firstName, String lastName, String idNo, String phoneNumber,
                       String gender, LocalDate date, LocalTime time, String symptoms, String status) {
        this.setAppointmentNo(appointmentNo);
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setIdNo(idNo);
        this.setPhoneNumber(phoneNumber);
        this.setGender(gender);
        this.setAppointmentDate(date);
        this.setAppointmentTime(time);
        this.setSymptoms(symptoms);
        this.setAppointmentRecordStatus(status);
    }

    public String getMOStaffID() {return MOStaffID;}

    public String getPatientUniqueID() {return patientUniqueID;}

    public String getMedicalSpecialArea() {
        return medicalSpecialArea;
    }

    public ObservableList<Appointment> getApprovedAppointments(){
        return ApprovedAppointments;
    }

    public String[] getAppointmentDetails() {
        return this.appointmentDetails;
    }

    public String[] getDeleteAppDetailsArray() {
        return this.DeleteAppDetailsArray;
    }

    public String getUserName() { return this.userName; }

    public String getFirstName() { return this.firstName; }

    public String getLastName() { return this.lastName; }

    public String getIdNo() { return this.idNo; }

    public String getPhoneNumber() { return this.phoneNumber; }

    public String getGender() { return this.gender; }

    public LocalDate getDOB() { return this.dOB;  }

    public String getCity() { return this.city; }

    public String getAddressLine1() { return this.addressLine1; }

    public String getAddressLine2() { return this.addressLine2; }

    public String getBloodGroup() { return this.bloodGroup; }

    public LocalDate getAppointmentDate(){
        return this.appointmentDate;
    }

    public LocalTime getAppointmentTime(){
        return this.appointmentTime;
    }

    public String getSymptoms(){
        return this.symptoms;
    }

    public String getMedicalOfficer(){
        return this.medicalOfficer;
    }

    public String getAppointmentNo(){
        return this.appointmentNo;
    }

    public String getAppointmentRecordStatus() { return this.appointmentRecordStatus; }

    public void setApprovedAppointments(ObservableList<Appointment> ApprovedAppointments){
        this.ApprovedAppointments = ApprovedAppointments;
    }

    public void setAppointmentDetails(String[] appointmentDetails){
        this.appointmentDetails = appointmentDetails;
    }

    public void setPatientUniqueID(String patientUniqueID){
        this.patientUniqueID = patientUniqueID;
    }

    public void setMedicalSpecialArea(String medicalSpecialArea){
        this.medicalSpecialArea = medicalSpecialArea ;
    }

    public void setDeleteAppDetailsArray(String[] DeleteAppDetailsArray) {
        this.DeleteAppDetailsArray = DeleteAppDetailsArray ;
    }

    public void setMOStaffID(String MOStaffID) { this.MOStaffID = MOStaffID; }

    public void setUserName(String userName) { this.userName = userName; }

    public void setFirstName(String firstName) { this.firstName = firstName; }

    public void setLastName(String lastName) { this.lastName = lastName; }

    public void setIdNo(String idNo) { this.idNo = idNo; }

    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }

    public void setGender(String gender) { this.gender = gender; }

    public void setDOB(LocalDate dOB) { this.dOB = dOB; }

    public void setCity(String city) { this.city = city; }

    public void setAddressLine1(String addressLine1) { this.addressLine1 = addressLine1; }

    public void setAddressLine2(String addressLine2) { this.addressLine2 = addressLine2; }

    public void setBloodGroup(String bloodGroup) { this.bloodGroup = bloodGroup; }

    public void setAppointmentDate(LocalDate appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public void setAppointmentTime(LocalTime appointmentTime) {
        this.appointmentTime =  appointmentTime;
    }

    public void setSymptoms(String symptoms) {
        this.symptoms = symptoms;
    }

    public void setMedicalOfficer(String medicalOfficer) {
        this.medicalOfficer = medicalOfficer;
    }

    public void setAppointmentNo(String appointmentNo) {
        this.appointmentNo = appointmentNo;
    }

    public void setAppointmentRecordStatus(String appointmentRecordStatus) { this.appointmentRecordStatus
            = appointmentRecordStatus; }

    public String toString() {
        return String.format("%s~%s~%s~%s~%s~%s~%s~%s~%s~%s~%s~%s~%s~%s~%s~%s~%s~%s~%s~%s",getAppointmentNo(), getUserName(),
                getFirstName(), getLastName(), getIdNo(), getPhoneNumber(), getGender(), getDOB(), getAddressLine1(),
                getAddressLine2(), getCity(), getBloodGroup(), getSymptoms() , getAppointmentDate() ,
                getAppointmentTime(), getMedicalOfficer(), getAppointmentRecordStatus(), getMedicalSpecialArea(),
                getMOStaffID(), getPatientUniqueID()
        );
    }

    public void getApprovedAppointmentList(String username, String status){
        UserEditDelete newUser = new UserEditDelete(2);
        newUser.UserEdit(username);
        String[] userDetails = newUser.getUserDetailArray();
        String reqDoctorDetail = "Dr. "+userDetails[2]+ " " + userDetails[3]+" - "+userDetails[14] ;
        File file = new File("src/sample/data/Appointment.txt");
        try(FileReader fileReader = new FileReader(file)) {
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line = null ;

            while((line = bufferedReader.readLine()) != null) {
                String[] appointmentDetails = line.split("~");
                if(sameCredentials(appointmentDetails[18], userDetails[14])
                        && credentialValidation(appointmentDetails[16], status)){
                    ApprovedAppointments.add(new Appointment(appointmentDetails[0], appointmentDetails[2],
                            appointmentDetails[3], appointmentDetails[4], appointmentDetails[5], appointmentDetails[6],
                            LocalDate.parse(appointmentDetails[13]), LocalTime.parse(appointmentDetails[14]),
                            GetSetTextArea.setText(appointmentDetails[12]))
                    );
                }
            }
            setApprovedAppointments(ApprovedAppointments);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getAppointmentDetailsArray(String appointmentID) {
        File file = new File("src/sample/data/Appointment.txt");
        try (FileReader fileReader = new FileReader(file)) {
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line = null;

            while ((line = bufferedReader.readLine()) != null) {
                String[] userCredentials = line.split("~");
                System.out.println("line 244");
                if(sameCredentials(userCredentials[0], appointmentID)){
                    System.out.println(userCredentials[0]);
                    setAppointmentDetails(userCredentials);
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteAppointment(String appointmentID) {
        File file = new File("src/sample/data/Appointment.txt");
        try (FileReader fileReader = new FileReader(file)) {
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line = null;
            ArrayList<String[]> appointments = new ArrayList<>();
            while ((line = bufferedReader.readLine()) != null) {
                String[] userCredentials = line.split("~");
                appointments.add(userCredentials);
                if (credentialValidation(userCredentials[0], appointmentID)) {
                    setDeleteAppDetailsArray(userCredentials);
                    appointments.remove(userCredentials);
                }
            }

            // add other appointments to the file
            try {
                FileWriter writer = new FileWriter("src/sample/data/Appointment.txt");
                PrintWriter printWriter = new PrintWriter(writer);
                for(String[] elementArray : appointments){
                    for(String element: elementArray){
                        printWriter.print(element + "~");
                    }
                    printWriter.println();
                }
                printWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getAppointmentMOStaffID(String DrOneLine){
        File file = new File("src/sample/data/UserMedicalOfficer.txt");
        try (FileReader fileReader = new FileReader(file)) {
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line = null;

            while ((line = bufferedReader.readLine()) != null) {
                String[] userCredentials = line.split("~");

                String drStringLiteral = "Dr. "+userCredentials[2]+ " " + userCredentials[3]+" - "+userCredentials[14];

                if(sameCredentials(drStringLiteral, DrOneLine)){
                    return userCredentials[14];
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Error ... Not Found, class Appointment - Line 311";
    }

    public String getIDFromName(String DrString){
        String[] detailArray = DrString.split("-");
        return detailArray[1].trim();
    }

    public void getPendingAppointmentList(String status){
        UserEditDelete newUser = new UserEditDelete(2);
        File file = new File("src/sample/data/Appointment.txt");
        try(FileReader fileReader = new FileReader(file)) {
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line = null ;

            while((line = bufferedReader.readLine()) != null) {
                String[] appointmentDetails = line.split("~");
                if(credentialValidation(appointmentDetails[16], status)){
                    ApprovedAppointments.add(new Appointment(appointmentDetails[0], appointmentDetails[2],
                            appointmentDetails[3], appointmentDetails[4], appointmentDetails[5], appointmentDetails[6],
                            LocalDate.parse(appointmentDetails[13]), LocalTime.parse(appointmentDetails[14]),
                            GetSetTextArea.setText(appointmentDetails[12]), appointmentDetails[16]
                    ));
                }
            }
            setApprovedAppointments(ApprovedAppointments);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean sameCredentials(String line1, String line2){
        return line1.equals(line2);
    }
    public boolean credentialValidation(String userName, String username) {
        return username.equals(userName);
    }
}
