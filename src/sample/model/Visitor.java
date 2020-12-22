package sample.model;

import java.io.File;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

public class Visitor {
    private String purpose;
    private String firstName;
    private String lastName;
    private String address;
    private String idCardNo;
    private LocalDate date;
    private LocalTime inTime;
    private LocalTime outTime;
    private File attachDoc;
    private String note;
    private String phoneNumber;

    //Variable constructor
    public Visitor(String purpose, String firstName,String lastName,String address, String idCardNo, LocalDate date, LocalTime inTime, LocalTime outTime, File attachDoc, String note,String phoneNumber){
        this.setPurpose(purpose);
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setIdCardNo(idCardNo);
        this.setDate(date);
        this.setInTime(inTime);
        this.setOutTime(outTime);
        this.setAttachDoc(attachDoc);
        this.setNote(note);
        this.setPhoneNumber(phoneNumber);
    }

    //Default constructor
    public Visitor(){
        this.setPurpose("");
        this.setFirstName("");
        this.setLastName("");
        this.setAddress("");
        this.setIdCardNo("");
        this.setDate(null);
        this.setInTime(null);
        this.setOutTime(null);
        this.setAttachDoc(null);
        this.setNote("");
        this.setPhoneNumber("");
    }

    //Getters and Setters
    public String getPurpose(){
        return this.purpose;
    }

    public String getFirstNameName(){
        return this.firstName;
    }

    public String getLastNameName(){
        return this.lastName;
    }

    public String getAddress(){
        return this.address;
    }

    public String getIdCardNo(){
        return this.idCardNo;
    }

    public LocalDate getDate() {
        return this.date;
    }

    public LocalTime getInTime(){
        return this.inTime;
    }

    public LocalTime getOutTime(){
        return this.outTime;
    }

    public File getAttachDoc() {
        return this.attachDoc;
    }

    public String getNote(){
        return this.note;
    }

    public String getPhoneNumber(){
        return this.phoneNumber;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    public void setAddress(String address){
        this.address = address;
    }

    public void setIdCardNo(String idCardNo){
        this.idCardNo = idCardNo;
    }

    public void setDate(LocalDate date){
        this.date = date;
    }

    public void setInTime(LocalTime inTime){
        this.inTime = inTime;
    }

    public void setOutTime(LocalTime outTime){
        this.outTime = outTime;
    }

    public void setAttachDoc(File attachDoc) {
        this.attachDoc = attachDoc;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String toString() {
        return String.format("%s~%s~%s~%s~%s~%s~%s~%s~%s~%s~%s", getFirstNameName(), getLastNameName(),
                getIdCardNo(), getPurpose(),getAddress(), getPhoneNumber(), getDate(), getPhoneNumber(),
                getInTime(), getOutTime(), getNote());
    }

}

