package sample.controller;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import sample.model.GetSetTextArea;
import sample.model.PrefMedicalOfficer;
import sample.model.RandomID;

import java.io.*;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class AdReportsModuleController {
    private LocalDate today;
    private LocalTime now;
    private String uniqueCode;
    private static int count;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private JFXDatePicker UserLogFrom;

    @FXML
    private JFXDatePicker UserLogTo;

    @FXML
    private JFXComboBox<String> UserLogUsermode;

    @FXML
    private JFXButton UserLogPDF;

    @FXML
    private JFXButton UserLogCSV;

    @FXML
    private JFXDatePicker AppointmentFrom;

    @FXML
    private JFXDatePicker AppointmentTo;

    @FXML
    private JFXComboBox<String> AppointmentMO;

    @FXML
    private JFXButton AppointmentPDF;

    @FXML
    private JFXButton AppointementCSV;

    @FXML
    private JFXButton PatientPDF;

    @FXML
    private JFXButton PatientCSV;

    @FXML
    private StackPane ReportsStackPane;

    @FXML
    private AnchorPane ReportAnchorPane;


    @FXML
    void initialize() {
        // comboBox - items
        UserLogUsermode.getItems().add("Receptionist");
        UserLogUsermode.getItems().add("Patient");
        UserLogUsermode.getItems().add("Medical Officer");

        // add items to the medical officer
        PrefMedicalOfficer.AllMOList(AppointmentMO);
    }

    @FXML
    void appointment_csv(MouseEvent event) {
        ValidationController simpleMsg = new ValidationController(ReportsStackPane, ReportAnchorPane, 1);
        if(!(AppointmentFrom.getValue() == null) && !(AppointmentTo.getValue() == null) && !(AppointmentMO.getValue() == null)) {
            exportCSVAppointment(AppointmentFrom.getValue(), AppointmentTo.getValue(), AppointmentMO.getValue());
            simpleMsg.detailedMsg("Reports", "Appointment CSV generated.");
            AppointmentFrom.getEditor().clear();
            AppointmentTo.getEditor().clear();
            AppointmentMO.getSelectionModel().clearSelection();
        } else {
            simpleMsg.detailedMsg("Reports", "Some fields are empty");
        }
    }

    @FXML
    void appointment_pdf(MouseEvent event) throws FileNotFoundException, DocumentException {
        ValidationController simpleMsg = new ValidationController(ReportsStackPane, ReportAnchorPane, 1);
        if(!(AppointmentFrom.getValue() == null) && !(AppointmentTo.getValue() == null) && !(AppointmentMO.getValue() == null)){
            exportPDFAppointments(AppointmentFrom.getValue(), AppointmentTo.getValue(), AppointmentMO.getValue());
            simpleMsg.detailedMsg("Reports", "Appointment PDF generated.");
            AppointmentFrom.getEditor().clear();
            AppointmentTo.getEditor().clear();
            AppointmentMO.getSelectionModel().clearSelection();
        } else {
            simpleMsg.detailedMsg("Reports", "Some fields are empty");
        }
    }

    @FXML
    void patient_csv(MouseEvent event) {
        ValidationController simpleMsg = new ValidationController(ReportsStackPane, ReportAnchorPane, 1);
        exportCSVPatientLogin();
        simpleMsg.detailedMsg("Reports", "Patient Login Credentials CSV generated.");
    }

    @FXML
    void patient_pdf(MouseEvent event) throws FileNotFoundException, DocumentException {
        ValidationController simpleMsg = new ValidationController(ReportsStackPane, ReportAnchorPane, 1);
            exportPDFPatientLogin();
            simpleMsg.detailedMsg("Reports", "Patient Login Credentials PDF generated.");
    }

    @FXML
    void user_log_csv(MouseEvent event) {
        ValidationController simpleMsg = new ValidationController(ReportsStackPane, ReportAnchorPane, 1);
        if(!(UserLogFrom.getValue() == null) && !(UserLogTo.getValue() == null) && !(UserLogUsermode.getValue() == null)){
        exportCSVUserLog(UserLogFrom.getValue(), UserLogTo.getValue(), UserLogUsermode.getValue());
            simpleMsg.detailedMsg("Reports", "Log Credentials CSV generated.");
            UserLogFrom.getEditor().clear();
            UserLogTo.getEditor().clear();
            UserLogUsermode.getSelectionModel().clearSelection();
        }else {
            simpleMsg.detailedMsg("Reports", "Some fields are empty");
        }
    }

    @FXML
    void user_log_pdf(MouseEvent event) throws FileNotFoundException, DocumentException {
        ValidationController simpleMsg = new ValidationController(ReportsStackPane, ReportAnchorPane, 1);
        if(!(UserLogFrom.getValue() == null) && !(UserLogTo.getValue() == null) && !(UserLogUsermode.getValue() == null)){
            exportPDFLog(UserLogFrom.getValue(), UserLogTo.getValue(), UserLogUsermode.getValue());
            simpleMsg.detailedMsg("Reports", "Log Credentials PDF generated.");
            UserLogFrom.getEditor().clear();
            UserLogTo.getEditor().clear();
            UserLogUsermode.getSelectionModel().clearSelection();
        } else {
            simpleMsg.detailedMsg("Reports", "Some fields are empty");
        }
    }

    public void exportCSVAppointment(LocalDate from, LocalDate to, String medicalOfficer){
        File file = new File("src/sample/data/Appointment.txt");
        try (FileReader fileReader = new FileReader(file)) {
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            FileWriter writer = new FileWriter("src/sample/export/csv/appointments/appointment"
                    + java.time.LocalDate.now() + RandomID.getUniqueId() + ".csv");
            PrintWriter printWriter = new PrintWriter(writer);

            String line = null;

            while ((line = bufferedReader.readLine()) != null) {
                String[] appointmentDetail = line.split("~");
                LocalDate date;
                date = LocalDate.parse(appointmentDetail[13]);
                if(sameCredentialValidation(medicalOfficer, appointmentDetail[15])
                        && to.isAfter(date) && from.isBefore(date)){
                    printWriter.println(
                                            appointmentDetail[2]
                                    + "," + appointmentDetail[3]
                                    + "," + appointmentDetail[4]
                                    + "," + appointmentDetail[5]
                                    + "," + appointmentDetail[6]
                                    + "," + appointmentDetail[7]
                                    + "," + appointmentDetail[8]
                                    + "," + appointmentDetail[9]
                                    + "," + appointmentDetail[10]
                                    + "," + appointmentDetail[11]
                                    + "," + GetSetTextArea.setText(appointmentDetail[12])
                                    + "," + appointmentDetail[13]
                                    + "," + appointmentDetail[14]
                                    + "," + appointmentDetail[15]
                                    + "," + appointmentDetail[16]
                    );
                }
            }
            printWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void exportCSVUserLog(LocalDate from, LocalDate to, String usermode){
        File file = new File("src/sample/data/Log.txt");
        try (FileReader fileReader = new FileReader(file)) {
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            FileWriter writer = new FileWriter("src/sample/export/csv/log/log"
                    + java.time.LocalDate.now() + RandomID.getUniqueId() + ".csv");
            PrintWriter printWriter = new PrintWriter(writer);

            String line = null;

            while ((line = bufferedReader.readLine()) != null) {
                String[] LogDetail = line.split("~");
                LocalDate date;
                date = LocalDate.parse(LogDetail[2]);
                if(sameCredentialValidation(usermode, LogDetail[0])
                        && to.isAfter(date) && from.isBefore(date)){
                    printWriter.println(
                                            LogDetail[0]
                                    + "," + LogDetail[1]
                                    + "," + LogDetail[2]
                                    + "," + LogDetail[3]
                    );
                }
            }
            printWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void exportCSVPatientLogin(){
        File file = new File("src/sample/data/UserPatient.txt");
        try (FileReader fileReader = new FileReader(file)) {
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            FileWriter writer = new FileWriter("src/sample/export/csv/patient_login_credentials/plogd"
                    + java.time.LocalDate.now() + RandomID.getUniqueId() + ".csv");
            PrintWriter printWriter = new PrintWriter(writer);

            String line = null;

            while ((line = bufferedReader.readLine()) != null) {
                String[] patientCredentials = line.split("~");
                printWriter.println(
                                     patientCredentials[2]
                                +","+patientCredentials[3]
                                +","+patientCredentials[0]
                                +","+patientCredentials[1]
                );
            }
            printWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void exportPDFLog(LocalDate from, LocalDate to, String usermode) throws FileNotFoundException, DocumentException {
        // open doc
        Document document = new Document(PageSize.A4, 25, 25, 50, 50);
        // path to export pdf // from "RandomID.getUniqueId()" this will keep unique name to pdf
        PdfWriter.getInstance(document,
                new FileOutputStream("src/sample/export/pdf/log/log"
                        + java.time.LocalDate.now() + RandomID.getUniqueId() + ".pdf"
                )
        );
        // open the document
        document.open();
        document.add(new Paragraph("---------------------------------------------------------------------------------------------------------------------------"));
        document.add(new Paragraph("                                                   Log Details                                                     "));
        document.add(new Paragraph("---------------------------------------------------------------------------------------------------------------------------"));
        // body of the log file
        File file = new File("src/sample/data/Log.txt");
        try (FileReader fileReader = new FileReader(file)) {
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line = null;

            while ((line = bufferedReader.readLine()) != null) {
                String[] LogDetail = line.split("~");
                LocalDate Date;
                Date = LocalDate.parse(LogDetail[2]);
                if(sameCredentialValidation(usermode, LogDetail[0])
                        && to.isAfter(Date) && from.isBefore(Date)){
                    document.add(new Paragraph("Date :" + java.time.LocalDate.now()));
                    document.add(new Paragraph("Time :" + java.time.LocalTime.now()));
                    document.add(new Paragraph(" "));
                    document.add(new Paragraph("Login Details"));
                    document.add(new Paragraph("---------------------------------------------------------------------------------------------------------------------------"));
                    document.add(new Paragraph("                     Username            : " + LogDetail[1]));
                    document.add(new Paragraph("                     Usermode            : " + LogDetail[0]));
                    document.add(new Paragraph("                     Date                : " + LogDetail[2]));
                    document.add(new Paragraph("                     Time                : " + LogDetail[3]));
                    document.add(new Paragraph("---------------------------------------------------------------------------------------------------------------------------"));
                }
            }
            document.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void exportPDFAppointments(LocalDate from, LocalDate to, String medicalOfficer) throws FileNotFoundException, DocumentException {
        // open doc
        Document document = new Document(PageSize.A4, 25, 25, 50, 50);
        // path to export pdf // from "RandomID.getUniqueId()" this will keep unique name to pdf
        PdfWriter.getInstance(document,
                new FileOutputStream("src/sample/export/pdf/appointments/appointment"
                        + java.time.LocalDate.now() + RandomID.getUniqueId() + ".pdf"
                )
        );
        // open the document
        document.open();
        document.add(new Paragraph("---------------------------------------------------------------------------------------------------------------------------"));
        document.add(new Paragraph("                                                   Appointment Details                                                     "));
        document.add(new Paragraph("---------------------------------------------------------------------------------------------------------------------------"));
        // body of the log file
        File file = new File("src/sample/data/Appointment.txt");
        try (FileReader fileReader = new FileReader(file)) {
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line = null;

            while ((line = bufferedReader.readLine()) != null) {
                String[] appointmentDetail = line.split("~");
                LocalDate Date;
                Date = LocalDate.parse(appointmentDetail[13]);
                if(sameCredentialValidation(medicalOfficer, appointmentDetail[15])
                        && to.isAfter(Date) && from.isBefore(Date)){
                    document.add(new Paragraph("                                       " + appointmentDetail[0]+ "                                              "));
                    document.add(new Paragraph("---------------------------------------------------------------------------------------------------------------------------"));
                    document.add(new Paragraph("Date :" + java.time.LocalDate.now()));
                    document.add(new Paragraph("Time :" + java.time.LocalTime.now()));
                    document.add(new Paragraph(" "));
                    document.add(new Paragraph("Patient Details"));
                    document.add(new Paragraph("---------------------------------------------------------------------------------------------------------------------------"));
                    document.add(new Paragraph("                     Name            : " + appointmentDetail[2] + " " + appointmentDetail[3]));
                    document.add(new Paragraph("                     NIC             : " + appointmentDetail[4]));
                    document.add(new Paragraph("                     Phone           : " + appointmentDetail[5]));
                    document.add(new Paragraph("                     Gender          : " + appointmentDetail[6]));
                    document.add(new Paragraph("                     Date of Birth   : " + appointmentDetail[7]));
                    document.add(new Paragraph("                     Address         : " + appointmentDetail[8] + ", " + appointmentDetail[9] + ", " + appointmentDetail[10]));
                    document.add(new Paragraph("                     Blood Group     : " + appointmentDetail[11]));
                    document.add(new Paragraph("                     Symptoms        : " + GetSetTextArea.setText(appointmentDetail[12])));
                    document.add(new Paragraph("                     Blood Group     : " + appointmentDetail[11]));
                    document.add(new Paragraph("Appointment Details"));
                    document.add(new Paragraph("---------------------------------------------------------------------------------------------------------------------------"));
                    document.add(new Paragraph("                     Date            :  " + appointmentDetail[13]));
                    document.add(new Paragraph("                     Time            :  " + appointmentDetail[14]));
                    document.add(new Paragraph("                     Medical Officer :  " + appointmentDetail[15]));
                    document.add(new Paragraph("                     Status          :  " + appointmentDetail[16]));
                }
            }
            document.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

        public static boolean sameCredentialValidation (String userCredentials1, String userCredentials2){
            return userCredentials1.equals(userCredentials2);
        }

        public void exportPDFPatientLogin () throws FileNotFoundException, DocumentException {
            // open doc
            Document document = new Document(PageSize.A4, 25, 25, 50, 50);
            // path to export pdf // from "RandomID.getUniqueId()" this will keep unique name to pdf
            PdfWriter.getInstance(document,
                    new FileOutputStream("src/sample/export/pdf/patient_login_credentials/plogd"
                            + java.time.LocalDate.now() + RandomID.getUniqueId() + ".pdf"
                    )
            );
            // open the document
            document.open();
            document.add(new Paragraph("---------------------------------------------------------------------------------------------------------------------------"));
            document.add(new Paragraph("                                             Patient Login Credentials                                                     "));
            document.add(new Paragraph("---------------------------------------------------------------------------------------------------------------------------"));
            document.add(new Paragraph("                                       username,first-name,last-name,password                                              "));
            document.add(new Paragraph("---------------------------------------------------------------------------------------------------------------------------"));
            document.add(new Paragraph("Date :" + java.time.LocalDate.now()));
            document.add(new Paragraph("Time :" + java.time.LocalTime.now()));
            document.add(new Paragraph(" "));
            // body of the log file
            File file = new File("src/sample/data/UserPatient.txt");
            try (FileReader fileReader = new FileReader(file)) {
                BufferedReader bufferedReader = new BufferedReader(fileReader);

                String line = null;

                while ((line = bufferedReader.readLine()) != null) {
                    String[] userCredentials = line.split("~");

                    document.add(new Paragraph("Patient " + count + " "
                            + userCredentials[0] + "," + userCredentials[2] + "," + userCredentials[3] + "," + userCredentials[1])
                    );
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            document.close();

        }

}
