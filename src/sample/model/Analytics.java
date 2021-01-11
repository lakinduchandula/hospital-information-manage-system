// this class calculate the analytics of appointments and the complaints
package sample.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.time.LocalDate;
import java.time.LocalTime;

public class Analytics {
    private int[] AppointmentByMonth = new int[12];
    private int[] ComplaintsByMonth = new int[12];
    private int[] AppointmentTypePlusComplaint = new int[4];

    public void setAppointmentByMonth(int[] AppointmentByMonth){
        this.AppointmentByMonth = AppointmentByMonth;
    }

    public void setComplaintsByMonth(int[] ComplaintByMonth){
        this.ComplaintsByMonth = ComplaintByMonth;
    }

    public void setAppointmentTypePlusComplaint(int[] AppointmentTypePlusComplaint){
        this.AppointmentTypePlusComplaint = AppointmentTypePlusComplaint;
    }

    public int[] getAppointmentByMonth(){
        return AppointmentByMonth;
    }

    public int[] getAppointmentTypePlusComplaint(){
        return AppointmentTypePlusComplaint;
    }

    public int[] getComplaintsByMonth(){
        return ComplaintsByMonth;
    }

    public void CombineAppointmentComplaint(){
        File file = new File("src/sample/data/Appointment.txt");
        try(FileReader fileReader = new FileReader(file)) {
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = null ;

            while((line = bufferedReader.readLine()) != null) {
                String[] appointmentDetail = line.split("~");

                switch (appointmentDetail[16]) {
                    case "Pending" -> {
                        this.AppointmentTypePlusComplaint[0]++;
                    }
                    case "Approved" -> {
                        this.AppointmentTypePlusComplaint[1]++;
                    }
                    case "Completed" -> {
                        this.AppointmentTypePlusComplaint[2]++;
                    }

                }
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void AppointmentCalculations(){
        File file = new File("src/sample/data/Appointment.txt");
        try(FileReader fileReader = new FileReader(file)) {
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = null ;

            while((line = bufferedReader.readLine()) != null) {
                String[] appointmentDetail = line.split("~");
                String[] date = appointmentDetail[13].split("-");
                switch (date[1]) {
                    case "01" -> {
                        this.AppointmentByMonth[0]++;
                    }
                    case "02" -> {
                        this.AppointmentByMonth[1]++;
                    }
                    case "03" -> {
                        this.AppointmentByMonth[2]++;
                    }
                    case "04" -> {
                        this.AppointmentByMonth[3]++;
                    }
                    case "05" -> {
                        this.AppointmentByMonth[4]++;
                    }
                    case "06" -> {
                        this.AppointmentByMonth[5]++;
                    }
                    case "07" -> {
                        this.AppointmentByMonth[6]++;
                    }
                    case "08" -> {
                        this.AppointmentByMonth[7]++;
                    }
                    case "09" -> {
                        this.AppointmentByMonth[8]++;
                    }
                    case "10" -> {
                        this.AppointmentByMonth[9]++;
                    }
                    case "11" -> {
                        this.AppointmentByMonth[10]++;
                    }
                    case "12" -> {
                        this.AppointmentByMonth[11]++;
                    }
                }
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void ComplaintCalculations(){
        File file = new File("src/sample/data/Complaint.txt");
        try(FileReader fileReader = new FileReader(file)) {
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line = null ;

            while((line = bufferedReader.readLine()) != null) {
                String[] complaintDetail = line.split("~");
                String[] date = complaintDetail[6].split("-");
                switch (date[1]) {
                    case "01" -> {
                        this.ComplaintsByMonth[0]++;
                    }
                    case "02" -> {
                        this.ComplaintsByMonth[1]++;
                    }
                    case "03" -> {
                        this.ComplaintsByMonth[2]++;
                    }
                    case "04" -> {
                        this.ComplaintsByMonth[3]++;
                    }
                    case "05" -> {
                        this.ComplaintsByMonth[4]++;
                    }
                    case "06" -> {
                        this.ComplaintsByMonth[5]++;
                    }
                    case "07" -> {
                        this.ComplaintsByMonth[6]++;
                    }
                    case "08" -> {
                        this.ComplaintsByMonth[7]++;;
                    }
                    case "09" -> {
                        this.ComplaintsByMonth[8]++;
                    }
                    case "10" -> {
                        this.ComplaintsByMonth[9]++;
                    }
                    case "11" -> {
                        this.ComplaintsByMonth[10]++;
                    }
                    case "12" -> {
                        this.ComplaintsByMonth[11]++;
                    }
                }
                if((complaintDetail[10] == null) || (complaintDetail[10].equals("No Action"))){
                    this.AppointmentTypePlusComplaint[3]++;
                }
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
