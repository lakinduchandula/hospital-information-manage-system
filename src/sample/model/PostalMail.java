package sample.model;

import java.io.File;
import java.time.LocalDate;
import java.util.Date;

public class PostalMail  {
    private String referenceNo;
    private LocalDate currentDate;
    private File attachDoc;
    private String note;

    //Variable Constructor
    public PostalMail(String referenceNo, LocalDate currentDate,File attachDoc, String note ){
        this.setReferenceNo(referenceNo);
        this.setCurrentDate(currentDate);
        this.setAttachDoc(attachDoc);
        this.setNote(note);
    }
    //Default Constructor
    public PostalMail( ){
        this.setReferenceNo("");
        this.setCurrentDate(null);
        this.setAttachDoc(null);
        this.setNote("");
    }

    //Getters and Setters
    public String getReferenceNo(){
        return this.referenceNo;
    }

    public LocalDate getCurrentDate(){
        return this.currentDate = currentDate;
    }

    public File getAttachDoc(){
        return this.attachDoc;
    }

    public String getNote(){
        return this.note;
    }

    public void setReferenceNo(String referenceNo){
        this.referenceNo = referenceNo;
    }

    public void setCurrentDate(LocalDate currentDate) {
        this.currentDate = currentDate;
    }

    public void setAttachDoc(File attachDoc) {
        this.attachDoc = attachDoc;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String toString() {
        return String.format("%s~%s~%s", getReferenceNo(), getCurrentDate(), getNote());
    }



}
