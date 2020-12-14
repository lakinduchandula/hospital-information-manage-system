package sample.model;

import java.io.File;

public class Receptionist {
    private Visitor visitor;//Declare Variables
    private PostalMail postalMail;
    private ComplaintRecord complaint;
    private Appointment appointment;
    private Patient patient;

    //Getters and Setters


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
}
