package sample.model;

public class Patient {
    private String bloodGroup;
    private String allergies;
    private ComplaintRecord complaint;
    private Appointment appointment;

    //Constructors
    public Patient(String bloodGroup, String allergies){
        this.setBloodGroup(bloodGroup);
        this.setAllergies(allergies);
    }

    public Patient(){
        this.setBloodGroup("");
        this.setAllergies("");
    }

    //Getters and Setters
    public String getBloodGroup(){
        return bloodGroup;
    }

    public String getAllergies(){
        return allergies;
    }

    public ComplaintRecord getComplaint() {
        return complaint;
    }

    public Appointment getAppointment() {
        return appointment;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public void setAllergies(String allergies) {
        this.allergies = allergies;
    }

    public void setComplaint(ComplaintRecord complaint) {
        this.complaint = complaint;
    }

    public void setAppointment(Appointment appointment) {
        this.appointment = appointment;
    }

    public ComplaintRecord addComplaint(){
        return complaint;
    }

    public void viewComplaint(ComplaintRecord complaint){
    }

    public Appointment addAppointment(){
        return appointment;
    }

    public void viewAppointment(Appointment appointment){
    }
}

