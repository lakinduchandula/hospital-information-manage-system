package sample.model;

import java.time.LocalDate;
import java.util.Date;

public class User extends SystemUser {

    private String userName;
    private String password;
    private String firstName;
    private String lastName;
    private String idNo;
    private String phoneNumber;
    private String gender;
    private LocalDate dOB;
    private String maritalStatus;
    private String addressLine1;
    private String addressLine2;
    private String city;
    private String country;



    public User() {

    }

    public User (String userName, String firstName, String lastName, String gender, String phoneNumber, String idNo,
                 LocalDate dOB, String addressLine1, String addressLine2, String city, String country, String maritalStatus, String password){
        this.setUserName(userName);
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setGender(gender);
        this.setPhoneNumber(phoneNumber);
        this.setIdNo(idNo);
        this.setDOB(dOB);
        this.setAddressLine1(addressLine1);
        this.setAddressLine2(addressLine2);
        this.setCity(city);
        this.setMaritalStatus(maritalStatus);
        this.setPassword(password);
    }

    //Getters and Setters
    public String getUserName(){
        return this.userName;
    }

    public String getPassword() {
        return this.password;
    }

    public String getFirstName(){
        return this.firstName;
    }

    public String getLastName(){
        return this.lastName;
    }

    public String getGender(){
        return this.gender;
    }

    public String getPhoneNumber(){
        return this.phoneNumber;
    }

    public String getIdNo(){
        return this.idNo;
    }

    public LocalDate getDOB() {
        return dOB;
    }

    public String getAddressLine1(){
        return this.addressLine1;
    }

    public String getAddressLine2(){
        return this.addressLine2;
    }

    public String getCity(){
        return this.city;
    }

    public String getCountry(){
        return this.country;
    }



    public String getMaritalStatus(){
        return this.maritalStatus;
    }

    public void setUserName(String userName){
        this.userName = userName;
    }

    public void setFirstName(String name) {
        this.firstName = name;
    }

    public void setLastName(String name) {
        this.lastName = name;
    }

    public void setIdNo(String idNo) {
        this.idNo = idNo;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setDOB(LocalDate dOB) {
        this.dOB = dOB;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setMaritalStatus(String maritalStatus){
        this.maritalStatus = maritalStatus;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public String UpdatePassword(){
        return this.password;
    }

    public String toString() {
        return String.format("%s~%s~%s~%s~%s~%s~%s~%s~%s~%s~%s~%s~%s", getUserName(), getPassword(), getFirstName(),
                getLastName(), getIdNo(), getPhoneNumber(), getGender(), getDOB(), getMaritalStatus(),
                getAddressLine1(), getAddressLine2(), getCity(), getCountry());
    }

}
