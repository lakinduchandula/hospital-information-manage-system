package sample.model;

import java.io.File;
import java.util.Date;

public class PostalMail {
    private int referenceNo;
    private Date currentDate;
    private File attachDoc;
    private String note;

    //Variable Constructor
    public PostalMail(int referenceNo, Date currentDate,File attachDoc, String note ){
        this.setReferenceNo(referenceNo);
        this.setCurrentDate(currentDate);
        this.setAttachDoc(attachDoc);
        this.setNote(note);
    }
    //Default Constructor
    public PostalMail( ){
        this.setReferenceNo(00);
        this.setCurrentDate(null);
        this.setAttachDoc(null);
        this.setNote("");
    }

    //Getters and Setters
    public int getReferenceNo(){
        return this.referenceNo;
    }

    public Date getCurrentDate(){
        return this.currentDate = currentDate;
    }

    public File getAttachDoc(){
        return this.attachDoc;
    }

    public String getNote(){
        return this.note;
    }

    public void setReferenceNo(int referenceNo){
        this.referenceNo = referenceNo;
    }

    public void setCurrentDate(Date currentDate) {
        this.currentDate = currentDate;
    }

    public void setAttachDoc(File attachDoc) {
        this.attachDoc = attachDoc;
    }

    public void setNote(String note) {
        this.note = note;
    }

}
