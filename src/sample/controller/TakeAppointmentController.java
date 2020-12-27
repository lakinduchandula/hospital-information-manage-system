package sample.controller;

import com.jfoenix.controls.JFXButton;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXToggleButton;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import sample.model.Appointment;
import sample.model.GetSetTextArea;
import sample.model.ReceptAddAppointment;

public class TakeAppointmentController {

    private String[] TakeAppointmentDetails;
    private String MOTakeAppointmentID;

    public String[] getTakeAppointmentDetails() {
        return TakeAppointmentDetails;
    }

    public void setTakeAppointmentDetails(String[] TakeAppointmentDetails) {
        this.TakeAppointmentDetails = TakeAppointmentDetails;
    }

    public String getTakeAppointmentID() {
        return this.MOTakeAppointmentID;
    }

    public void setTakeAppointmentID(String MOTakeAppointmentID){
        this.MOTakeAppointmentID = MOTakeAppointmentID;
    }

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private StackPane TakeAppointmentStackPane;

    @FXML
    private AnchorPane TakeAppointmentAnchor;

    @FXML
    private Label TakeAppointmentFName;

    @FXML
    private Label TakeAppointmentLName;

    @FXML
    private Label TakeAppointmentID;

    @FXML
    private Label TakeAppointmentDate;

    @FXML
    private Label TakeAppointmentTime;

    @FXML
    private Label TakeAppointmentStatus;

    @FXML
    private JFXButton TakeAppointmentMakeStatus;

    @FXML
    private Label TakeAppointmentUsername;

    @FXML
    private Label TakeAppointmentNIC;

    @FXML
    private Label TakeAppointmentPhone;

    @FXML
    private Text TakeAppointmentSymptoms;

    @FXML
    private JFXButton TakeAppointmentEnd;

    @FXML
    private BorderPane TakeAppointmentBorderPane;

    @FXML
    void change_status(MouseEvent event) {
        if(TakeAppointmentStatus.getText().equals("Approved")){
            TakeAppointmentStatus.setText("Completed");
            TakeAppointmentMakeStatus.setText("Make Status Approved");
            TakeAppointmentMakeStatus.setStyle("-fx-background-color: #ff8f00");
        } else {
            TakeAppointmentStatus.setText("Approved");
            TakeAppointmentMakeStatus.setText("Make Status Complete");
            TakeAppointmentMakeStatus.setStyle("-fx-background-color:  #00c853");
        }
    }

    @FXML
    void end_appointment(MouseEvent event) throws IOException {
        Appointment endAppointment = new Appointment();
        ValidationController validation = new ValidationController(TakeAppointmentStackPane, TakeAppointmentAnchor,
                1);
        if(TakeAppointmentStatus.getText().equals("Completed")){
            validation.detailedMsg("Appointment Completed", "This Appointment will remove from appointment list" +
                    ",\nnow Patient can view this appointment");
        }else {
            validation.detailedMsg("Appointment Status", "This Appointment will stay Approved status," +
                    "\nPlease mark as Completed to change status");
        }
        endAppointment.deleteAppointment(getTakeAppointmentID());

        Appointment saveEndAppointment = new Appointment();

        saveEndAppointment.setAppointmentRecordStatus(TakeAppointmentStatus.getText());
        saveEndAppointment.setAppointmentNo(getTakeAppointmentDetails()[0]);
        saveEndAppointment.setUserName(getTakeAppointmentDetails()[1]);
        saveEndAppointment.setFirstName(getTakeAppointmentDetails()[2]);
        saveEndAppointment.setLastName(getTakeAppointmentDetails()[3]);
        saveEndAppointment.setIdNo(getTakeAppointmentDetails()[4]);
        saveEndAppointment.setPhoneNumber(getTakeAppointmentDetails()[5]);
        saveEndAppointment.setGender(getTakeAppointmentDetails()[6]);
        saveEndAppointment.setDOB(LocalDate.parse(getTakeAppointmentDetails()[7]));
        saveEndAppointment.setAddressLine1(getTakeAppointmentDetails()[8]);
        saveEndAppointment.setAddressLine2(getTakeAppointmentDetails()[9]);
        saveEndAppointment.setCity(getTakeAppointmentDetails()[10]);
        saveEndAppointment.setBloodGroup(getTakeAppointmentDetails()[11]);
        saveEndAppointment.setSymptoms(getTakeAppointmentDetails()[12]);
        saveEndAppointment.setAppointmentTime(LocalTime.parse(getTakeAppointmentDetails()[14]));
        saveEndAppointment.setAppointmentDate(LocalDate.parse(getTakeAppointmentDetails()[13]));
        saveEndAppointment.setMedicalOfficer(getTakeAppointmentDetails()[15]);
        saveEndAppointment.setMedicalSpecialArea(getTakeAppointmentDetails()[17]);

        ReceptAddAppointment.writeToFile(saveEndAppointment);
        validation.successfulUserCreation("Appointment Successfully Created");
        afterCreation();

    }

    public void afterCreation() throws IOException {
        Parent white = FXMLLoader.load(getClass()
                .getResource("/sample/view/WhiteBlank.fxml"));
        TakeAppointmentBorderPane.setCenter(white);
    }

    @FXML
    void initialize() {
        MOTakeAppointmentID = MODashAppointmentController.appointmentID;
        Appointment TakeAppointment = new Appointment();
        TakeAppointment.getAppointmentDetailsArray(getTakeAppointmentID());
        String[] appointmentDetail = TakeAppointment.getAppointmentDetails();
        setTakeAppointmentDetails(appointmentDetail);
        TakeAppointmentID.setText(appointmentDetail[0]);
        TakeAppointmentStatus.setText(appointmentDetail[16]);
        TakeAppointmentDate.setText(appointmentDetail[13]);
        TakeAppointmentTime.setText(appointmentDetail[14]);
        TakeAppointmentFName.setText(appointmentDetail[2]);
        TakeAppointmentLName.setText(appointmentDetail[3]);
        TakeAppointmentUsername.setText(appointmentDetail[1]);
        TakeAppointmentNIC.setText(appointmentDetail[4]);
        TakeAppointmentPhone.setText(appointmentDetail[5]);
        TakeAppointmentSymptoms.setText(GetSetTextArea.setText(appointmentDetail[12]));

    }
}
