package sample.module;

import java.io.File;
import java.util.Date;

public class ComplaintRecord {
    private String complaintType;
    private String complaintBy;
    private int phoneNO;
    private Date currentDate;
    private String description;
    private String actionTaken;
    private File attachDocORNote;

    //Variable Constructor
    public ComplaintRecord(String complaintType, String complaintBy, int phoneNO, Date currentDate, String description, String actionTaken, File attachDocORNote){
        this.setComplaintType(complaintType);
        this.setComplaintBy(complaintBy);
        this.setPhoneNO(phoneNO);
        this.setCurrentDate(currentDate);
        this.setDescription(description);
        this.setActionTaken(actionTaken);
        this.setAttachDocORNote(attachDocORNote);
    }
    //Default Variables
    public ComplaintRecord(){
        this.setComplaintType("");
        this.setComplaintBy("");
        this.setPhoneNO(0);
        this.setCurrentDate(null);
        this.setDescription("");
        this.setActionTaken("");
        this.setAttachDocORNote(null);
    }

    private void setActionTaken(java.lang.String s) {
    }

    private void setComplaintBy(java.lang.String s) {
    }
    private void setDescription(java.lang.String s) {
    }
    private void setComplaintType(java.lang.String s) {
    }
    //Getters and Setters
    public String getComplaintType(){
        return this.complaintType;
    }

    public String getComplaintBy(){
        return this.complaintBy;
    }

    public int getPhoneNO(){
        return this.phoneNO;
    }

    public Date getCurrentDate(){
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

    public void setComplaintBy(String complaintBy) {
        this.complaintBy = complaintBy;
    }

    public void setPhoneNO(int phoneNO) {
        this.phoneNO = phoneNO;
    }

    public void setCurrentDate(Date currentDate) {
        this.currentDate = currentDate;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setActionTaken(String actionTaken) {
        this.actionTaken = actionTaken;
    }

    public void setAttachDocORNote(File attachDocORNote) {
        this.attachDocORNote = attachDocORNote;
    }

}
