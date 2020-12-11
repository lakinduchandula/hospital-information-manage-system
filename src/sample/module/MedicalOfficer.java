package sample.module;

public class MedicalOfficer {

    private String specialtyArea;
    private Appointment appointment;

    //Variable constructor
    public MedicalOfficer(String specialty){
        this.setSpecialtyArea(specialty);
    }

    //Default constructor
    public MedicalOfficer(){
            this.setSpecialtyArea("");
    }

    private void setSpecialtyArea(java.lang.String s) {
    }

    public String getSpecialtyArea(){
        return this.specialtyArea;
    }

    public void setSpecialtyArea(String specialty){
        this.specialtyArea = specialty;
    }

    public Appointment ViewAppointment(){
    return appointment;    }

    public Appointment EditAppointment(){
        return appointment;
    }
}
