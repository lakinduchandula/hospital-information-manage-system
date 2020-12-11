package sample.module;

import java.io.File;
import java.util.Date;

public class ReceptionistORMedicalOfficer extends User{
    private int staffID;
    private String staffEmailAddress;
    private Date dateOfJoin;
    private File staffPhotograph;
    private File attachDoc;

    //Variable Constructor
    public ReceptionistORMedicalOfficer(int staffID, String staffEmailAddress, Date dateOfJoin, File staffPhotograph, File attachDoc){
        this.setStaffID(staffID);
        this.setStaffEmailAddress(staffEmailAddress);
        this.setDateOfJoin(dateOfJoin);
        this.setStaffPhotograph(staffPhotograph);
        this.setAttachDoc(attachDoc);
    }

    //Default Constructor
    public ReceptionistORMedicalOfficer(){
        this.setStaffID(0);
        this.setStaffEmailAddress("");
        this.setDateOfJoin(null);
        this.setStaffPhotograph(null);
        this.setAttachDoc(null);
    }

    private void setStaffEmailAddress(java.lang.String s) {
    }

    //Getters and Setters
    public int getStaffID(){
        return this.staffID;
    }

    public String getStaffEmailAddress(){
        return this.staffEmailAddress;
    }

    public Date getDateOfJoin(){
        return this.dateOfJoin;
    }

    public File getStaffPhotograph(){
        return this.staffPhotograph;
    }

    public File getAttachDoc(){
        return this.attachDoc;
    }

    public void setStaffID(int staffID){
        this.staffID = staffID;
    }

    public void setStaffEmailAddress(String staffEmailAddress){
        this.staffEmailAddress = staffEmailAddress;
    }

    public void setDateOfJoin(Date dateOfJoin){
        this.dateOfJoin = dateOfJoin;
    }

    public void setStaffPhotograph(File staffPhotograph){
        this.staffPhotograph = staffPhotograph;
    }

    public void setAttachDoc(File attachDoc){
        this.attachDoc = attachDoc;
    }

}
