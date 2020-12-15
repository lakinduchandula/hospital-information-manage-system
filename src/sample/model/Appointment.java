package sample.model;

import java.sql.Time;
import java.util.Date;

public class Appointment
{
    private String patient;
    private Date appointmentDate;
    private Time appointmentTime;
    private String symptoms;
    private MedicalOfficer medicalOfficer;
    private String appointmentRecordStatus;
    private int appointmentNo;

    //Variable Constructor
    public Appointment(String patient, Date date, Time time, String symptoms, String recordStatus, int appNo){
        this.setPatient(patient);
        this.setAppointmentDate(date);
        this.setAppointmentTime(time);
        this.setSymptoms(symptoms);
        this.setAppointmentRecordStatus(recordStatus);
        this.setAppointmentNo(appNo);
    }

    //Default Constructor
    public Appointment(){
        this.setPatient("");
        this.setAppointmentDate(null);
        this.setAppointmentTime(null);
        this.setSymptoms("");
        this.setAppointmentRecordStatus("");
        this.setAppointmentNo(0);
    }


    //Getters and Setters
    public String getPatient(){
        return this.patient;
    }

    public Date getAppointmentDate(){
        return this.appointmentDate;
    }

    public Time getAppointmentTime(){
        return this.appointmentTime;
    }

    public String getSymptoms(){
        return this.symptoms;
    }

    public MedicalOfficer getMedicalOfficer(){
        return this.medicalOfficer;
    }

    public String getAppointmentRecordStatus(){
        return this.appointmentRecordStatus;
    }

    public int getAppointmentNo(){
        return this.appointmentNo;
    }

    public void setPatient(String patient){
        this.patient = patient;
    }

    public void setAppointmentDate(Date appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public void setAppointmentTime(Time appointmentTime) {
        this.appointmentTime = appointmentTime;
    }

    public void setSymptoms(String symptoms) {
        this.symptoms = symptoms;
    }

    public void setMedicalOfficer(MedicalOfficer medicalOfficer) {
        this.medicalOfficer = medicalOfficer;
    }

    public void setAppointmentNo(int appointmentNo) {
        this.appointmentNo = appointmentNo;
    }

    public void setAppointmentRecordStatus(String appointmentRecordStatus) {
        this.appointmentRecordStatus = appointmentRecordStatus;
    }

    public String toString(){
        return this.patient;
    }

}
