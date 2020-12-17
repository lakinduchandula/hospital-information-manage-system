package sample.model;

import java.time.LocalDate;
import java.util.Date;

public class Admin {
    private String firstName;
    private String lastName;
    private String username;
    private String password;

    // setter for firstName
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    // setter for lastName
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    // setter for username
    public void setUsername(String username) {
        this.username = username;
    }
    // getter for firstName
    public String getFirstName(){
        return firstName;
    }
    // getter for lastName
    public String getLastName() {
        return lastName;
    }
    // getter for username

    public String getPassword() {
        return password;
    }

    void viewAppointment() {

    }

    void deleteAppointment() {

    }

    public void viewComplaint() {

    }

    public void addComplaint() {

    }

    public void deleteComplaint() {

    }

    public void updateComplaint() {

    }

    public void addUserReceptionist(String userName, String firstName, String lastName, String gender, String phoneNumber,
                                    String idNo, String staffID, String staffEmail, LocalDate dateOfJoin, LocalDate dOB,
                                    String addressLine1, String addressLine2, String city, String country,
                                    String maritalStatus, String password, Visitor visitor, PostalMail postalMail,
                                    ComplaintRecord complaint, Appointment appointment, Patient patient) {
        Receptionist newReceptionist = new Receptionist(userName, firstName, lastName, gender, phoneNumber, idNo,
                staffID, staffEmail, dateOfJoin, dOB, addressLine1, addressLine2, city, country, maritalStatus,
                password, visitor, postalMail, complaint, appointment, patient);

    }

    public void addUserPatient() {

    }

    public void addUserMedicalOfficer() {

    }

    public void editUser() {

    }

    public void viewUser() {

    }

    public void deleteUser() {

    }

    public void exportAppointmentReport() {

    }

    public void exportPatientLoginCredentials() {

    }

}
