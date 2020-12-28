package sample.model;

import java.io.*;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;

import static sample.model.PrefMedicalOfficer.credentialValidation;

public class Visitor {

    private String[] visitorDetails;
    private String[] deleteVisitorDetailsArray;
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

    public String getFirstName(){
        return this.firstName;
    }

    public String getLastName(){
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

    public String[] getVisitorDetails() { return this.visitorDetails; }

    public String[] getDeleteVisitorDetailsArray(String visitorIDGlobal) { return this.deleteVisitorDetailsArray; }

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

    public void setVisitorDetails(String[] visitorDetails) { this.visitorDetails = visitorDetails; }

    public void setDeleteVisitorDetailsArray(String[] deleteVisitorDetailsArray) {
        this.deleteVisitorDetailsArray = deleteVisitorDetailsArray; }

    public String toString() {
        return String.format("%s~%s~%s~%s~%s~%s~%s~%s~%s~%s", getIdCardNo(), getFirstName(), getLastName(),
                 getPurpose(),getAddress(), getPhoneNumber(), getDate(),
                getInTime(), getOutTime(), getNote());
    }



    public void deleteVisitor(String idCardNo) {
        File file = new File("src/sample/data/Visitor.txt");
        try (FileReader fileReader = new FileReader(file)) {
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line = null;
            ArrayList<String[]> visitors = new ArrayList<>();
            while ((line = bufferedReader.readLine()) != null) {
                String[] userCredentials = line.split("~");
                visitors.add(userCredentials);
                if (credentialValidation(userCredentials[0], idCardNo)) {
                    setDeleteVisitorDetailsArray(userCredentials);
                    visitors.remove(userCredentials);
                }
            }

            // add other appointments to the file
            try {
                FileWriter writer = new FileWriter("src/sample/data/Visitor.txt");
                PrintWriter printWriter = new PrintWriter(writer);
                for(String[] elementArray : visitors){
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


    public void getVisitorDetailsArray(String idCardNo) {
        File file = new File("src/sample/data/Visitor.txt");
        try (FileReader fileReader = new FileReader(file)) {
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            System.out.println(idCardNo+"203");
            String line = null;

            while ((line = bufferedReader.readLine()) != null) {
                String[] userCredentials = line.split("~");

                if(sameCredentials(userCredentials[0], idCardNo)){
                    System.out.println(userCredentials[0]);
                    setVisitorDetails(userCredentials);
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public boolean sameCredentials(String line1, String line2){ return line1.equals(line2); }
}

