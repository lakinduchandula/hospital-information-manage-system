package sample.model;

import java.io.File;
import java.time.LocalDate;
import java.util.Date;

public class Receptionist extends User {
    private Visitor visitor;//Declare Variables
    private PostalMail postalMail;
    private ComplaintRecord complaint;
    private Appointment appointment;
    private Patient patient;
    private String staffID;
    private String staffEmail;
    private LocalDate dateOfJoin;

    public Receptionist(){

    }
    public Receptionist(String userName, String firstName, String lastName, String gender, String phoneNumber, String idNo, String staffID, String staffEmail, LocalDate dateOfJoin,
                        LocalDate dOB, String addressLine1, String addressLine2, String city, String country, String maritalStatus, String password, Visitor visitor,
                        PostalMail postalMail, ComplaintRecord complaint, Appointment appointment, Patient patient) {
        super(userName, firstName, lastName, gender, phoneNumber, idNo, dOB, addressLine1, addressLine2, city, country, maritalStatus, password);
        this.setVisitor(visitor);
        this.setPostalMail(postalMail);
        this.setComplaint(complaint);
        this.setAppointment(appointment);
        this.setPatient(patient);
        this.setDateOfJoin(dateOfJoin);
        this.setStaffEmail(staffEmail);
        this.setStaffID(staffID);
    }



    //Getters and Setters
    public String getStaffEmail() {
        return staffEmail;
    }
    public String getStaffID() {
        return staffID;
    }
    public LocalDate getDateOfJoin(){
        return dateOfJoin;
    }
    public Visitor getVisitor() {
        return visitor;
    }

    public PostalMail getPostalMail() {
        return postalMail;
    }

    public ComplaintRecord getComplaint() {
        return complaint;
    }

    public Appointment getAppointment() {
        return appointment;
    }

    public Patient getPatient() {
        return patient;
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

    public void setVisitor(Visitor visitor) {
        this.visitor = visitor;
    }

    public void setPostalMail(PostalMail postalMail) {
        this.postalMail = postalMail;
    }

    public void setComplaint(ComplaintRecord complaint) {
        this.complaint = complaint;
    }

    public void setAppointment(Appointment appointment) {
        this.appointment = appointment;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    //Methods
    public Visitor addVisitor(){
        return visitor;
    }

    public void viewVisitor(){
    }

    public Visitor editVisitor(Visitor visitor){
        return visitor;
    }

    public void deleteVisitor(Visitor visitor){
    }

    public PostalMail addPostalMail(){
        return postalMail;
    }

    public void deletePostalMail(PostalMail postalMail){
    }

    public void viewPostalMail(){
    }

    public PostalMail editPostalMail(PostalMail postalMail){
        return postalMail;
    }

    public ComplaintRecord addComplaint(){
        return complaint;
    }

    public ComplaintRecord viewComplaint(ComplaintRecord complaint){
        return  complaint;
    }

    public void viewAppointment(Appointment appointment){
    }

    public Appointment editAppointment(Appointment appointment){
      return appointment;
    }

    public Appointment addAppointment(){
        return appointment;
    }

    public void createAppointmentPDF(Appointment appointment){
    }

    public void printAppointmentPDF(File file){
    }

    public Patient addPatient(){
        return patient;
    }

    public Patient editPatient(Patient patient){
        return patient;
    }

    public void viewPatient(Patient patient){
    }

    public void ForceResetPatientPassword(Patient patient){
    }

    @Override
    public String toString() {
        return super.toString() + String.format("~%s~%s~%s", getStaffID(), getStaffEmail(), getDateOfJoin());
    }
}
