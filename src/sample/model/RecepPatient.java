package sample.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.time.LocalDate;

public class RecepPatient {

    private String[] recepPatientDetails;
    private String firstName;
    private String lastName;
    private String idCardNo;
    private String phoneNumber;
    private String gender;
    private LocalDate dOB;
    private String maritalStatus;
    private String addressLine1;
    private String addressLine2;
    private String city;
    private String bloodGroup;
    private String allergies;


    //Variable Constructor

    public RecepPatient(String firstName, String lastName, String idCardNo, String phoneNumber, String gender,
                           LocalDate dOB, String maritalStatus, String addressLine1, String addressLine2, String city,
                           String bloodGroup, String allergies) {
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setIdCardNo(idCardNo);
        this.setPhoneNumber(phoneNumber);
        this.setGender(gender);
        this.setdOB(dOB);
        this.setMaritalStatus(maritalStatus);
        this.setAddressLine1(addressLine1);
        this.setAddressLine2(addressLine2);
        this.setCity(city);
        this.setBloodGroup(bloodGroup);
        this.setAllergies(allergies);
    }

    //Default Constructor

    public RecepPatient(){
        this.setFirstName("");
        this.setLastName("");
        this.setIdCardNo("");
        this.setPhoneNumber("");
        this.setGender("");
        this.setdOB(null);
        this.setMaritalStatus("");
        this.setAddressLine1("");
        this.setAddressLine2("");
        this.setCity("");
        this.setBloodGroup("");
        this.setAllergies("");
    }
      // getters and setters

    public String getFirstName() { return this.firstName; }

    public String getLastName() { return this.lastName; }

    public String getIdCardNo() { return this.idCardNo; }

    public String getPhoneNumber() { return this.phoneNumber; }

    public String getGender() { return this.gender; }

    public LocalDate getdOB() { return this.dOB; }

    public String getMaritalStatus() { return this.maritalStatus; }

    public String getAddressLine1() { return this.addressLine1; }

    public String getAddressLine2() { return this.addressLine2; }

    public String getCity() { return this.city; }

    public String getBloodGroup() { return this.bloodGroup; }

    public String getAllergies() { return this.allergies; }

    public String[] getRecepPatientDetails() { return this.recepPatientDetails; }

    public void setFirstName(String firstName) { this.firstName = firstName; }

    public void setLastName(String lastName) { this.lastName = lastName; }

    public void setIdCardNo(String idCardNo) { this.idCardNo = idCardNo; }

    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }

    public void setGender(String gender) { this.gender = gender; }

    public void setdOB(LocalDate dOB) { this.dOB = dOB; }

    public void setRecepPatientDetails(String[] recepPatientDetails) {
        this.recepPatientDetails = recepPatientDetails; }

    public void setMaritalStatus(String maritalStatus) { this.maritalStatus = maritalStatus; }

    public void setAddressLine1(String addressLine1) { this.addressLine1 = addressLine1; }

    public void setAddressLine2(String addressLine2) { this.addressLine2 = addressLine2; }

    public void setCity(String city) { this.city = city; }

    public void setBloodGroup(String bloodGroup) { this.bloodGroup = bloodGroup; }

    public void setAllergies(String allergies) { this.allergies = allergies; }

    public String toString() {
        return String.format("%s~%s~%s~%s~%s~%s~%s~%s~%s~%s~%s~%s", getIdCardNo(),getFirstName(),
                getLastName(), getGender(),getdOB() , getMaritalStatus() ,getPhoneNumber() , getAddressLine1(),
                getAddressLine2() , getCity(), getBloodGroup(), getAllergies());
    }
    public void getRecepPatientDetailsArray(String idCardNo) {
        File file = new File("src/sample/data/Patient.txt");
        try (FileReader fileReader = new FileReader(file)) {
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = null;

            while ((line = bufferedReader.readLine()) != null) {
                String[] userCredentials = line.split("~");

                if(sameCredentials(userCredentials[0], idCardNo)){
                    System.out.println(userCredentials[0]);
                    setRecepPatientDetails(userCredentials);
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean sameCredentials(String line1, String line2){ return line1.equals(line2); }
}
