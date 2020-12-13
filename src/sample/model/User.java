package sample.module;

import java.util.Date;

public class User {

    private String userName;
    private String name;
    private String gender;
    private int phoneNumber;
    private int idNo;
    private Date dOB;
    private String address;
    private String maritalStatus;
    private int password;

    public User (String userName, String name, String gender, int phoneNumber, int idNo, Date dOB, String address, String maritalStatus, int password){
        this.setUserName(userName);
        this.setName(name);
        this.setGender(gender);
        this.setPhoneNumber(phoneNumber);
        this.setIdNo(idNo);
        this.setDOB(dOB);
        this.setAddress(address);
        this.setMaritalStatus(maritalStatus);
        this.setPassword(password);
    }

    public User(){
        this.setUserName("");
        this.setName("");
        this.setGender("");
        this.setPhoneNumber(0);
        this.setIdNo(0);
        this.setDOB(null);
        this.setAddress("");
        this.setMaritalStatus("");
        this.setPassword(0);
    }

    //Getters and Setters
    public String getUserName(){
        return this.userName;
    }

    public String getName(){
        return this.name;
    }

    public String getGender(){
        return this.gender;
    }

    public int getPhoneNumber(){
        return this.phoneNumber;
    }

    public int getIdNo(){
        return this.idNo;
    }

    public Date getDOB() {
        return dOB;
    }

    public String getAddress(){
        return this.address;
    }

    public String getMaritalStatus(){
        return this.maritalStatus;
    }

    public void setUserName(String userName){
        this.userName = userName;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setIdNo(int idNo) {
        this.idNo = idNo;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setDOB(Date dOB) {
        this.dOB = dOB;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setMaritalStatus(String maritalStatus){
        this.maritalStatus = maritalStatus;
    }

    public void setPassword(int password){
        this.password = password;
    }

    public int UpdatePassword(){
        return this.password;
    }

}
