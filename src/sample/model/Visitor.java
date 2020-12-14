package sample.model;

import java.io.File;
import java.sql.Time;
import java.util.Date;

public class Visitor {
    private String purpose;
    private String name;
    private int idCardNo;
    private Date date;
    private Time inTime;
    private Time outTime;
    private File attachDoc;
    private String note;

    //Variable constructor
    public Visitor(String purpose, String name, int idCardNo, Date date, Time inTime, Time outTime, File attachDoc, String note){
        this.setPurpose(purpose);
        this.setName(name);
        this.setIdCardNo(idCardNo);
        this.setDate(date);
        this.setInTime(inTime);
        this.setOutTime(outTime);
        this.setAttachDoc(attachDoc);
        this.setNote(note);
    }

    //Default constructor
    public Visitor(){
        this.setPurpose("");
        this.setName("");
        this.setIdCardNo(0);
        this.setDate(null);
        this.setInTime(null);
        this.setOutTime(null);
        this.setAttachDoc(null);
        this.setNote("");
    }

    //Getters and Setters
    public String getPurpose(){
        return this.purpose;
    }

    public String getName(){
        return this.name;
    }

    public int getIdCardNo(){
        return this.idCardNo;
    }

    public Date getDate() {
        return this.date;
    }

    public Time getInTime(){
        return this.inTime;
    }

    public Time getOutTime(){
        return this.outTime;
    }

    public File getAttachDoc() {
        return this.attachDoc;
    }

    public String getNote(){
        return this.note;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setIdCardNo(int idCardNo){
        this.idCardNo = idCardNo;
    }

    public void setDate(Date date){
        this.date = date;
    }

    public void setInTime(Time inTime){
        this.inTime = inTime;
    }

    public void setOutTime(Time outTime){
        this.outTime = outTime;
    }

    public void setAttachDoc(File attachDoc) {
        this.attachDoc = attachDoc;
    }

    public void setNote(String note) {
        this.note = note;
    }

}

