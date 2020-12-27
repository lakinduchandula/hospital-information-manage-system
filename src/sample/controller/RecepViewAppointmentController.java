package sample.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
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

public class RecepViewAppointmentController {

    @FXML
    private StackPane RecepViewStackPane;

    @FXML
    private AnchorPane RecepViewAnchorPane;

    @FXML
    private BorderPane RecepViewBorder;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label ViewAppointmentID;

    @FXML
    private Label ViewAppointmentDate;

    @FXML
    private Label ViewAppointmentTime;

    @FXML
    private Label ViewAppointmentStatus;

    @FXML
    private Label ViewAppointmentLastName;

    @FXML
    private Label ViewAppointmentFirstName;

    @FXML
    private Label ViewAppointmentUsername;

    @FXML
    private Label ViewAppointmentUserID;

    @FXML
    private Label ViewAppointmentPhone;

    @FXML
    private Label ViewAppointmentMO;

    @FXML
    private Text ViewAppointmentSymptoms;

    @FXML
    private JFXButton DeleteAccount;

    @FXML
    void DeleteAppointment(MouseEvent event) throws IOException {
        Appointment deleteAppointment = new Appointment();
        ValidationController deleteValidate = new ValidationController(RecepViewStackPane, RecepViewAnchorPane, 1);
        deleteValidate.detailedMsg("Appointment Delete", "Appointment was Successfully Deleted");
        deleteAppointment.deleteAppointment(ReceptDashAppointmentController.AppointmentIDGlobal);
        afterCreation();
    }

    public void afterCreation() throws IOException {
        Parent white = FXMLLoader.load(getClass()
                .getResource("/sample/view/WhiteBlank.fxml"));
        RecepViewBorder.setCenter(white);
    }


    @FXML
    void initialize() {
        Appointment viewAppointment = new Appointment();
        viewAppointment.getAppointmentDetailsArray(ReceptDashAppointmentController.AppointmentIDGlobal);
        String[] appointmentDetail = viewAppointment.getAppointmentDetails();

        ViewAppointmentID.setText(appointmentDetail[0]);
        ViewAppointmentStatus.setText(appointmentDetail[16]);
        ViewAppointmentDate.setText(appointmentDetail[13]);
        ViewAppointmentTime.setText(appointmentDetail[14]);
        ViewAppointmentFirstName.setText(appointmentDetail[2]);
        ViewAppointmentLastName.setText(appointmentDetail[3]);
        ViewAppointmentUsername.setText(appointmentDetail[1]);
        ViewAppointmentUserID.setText(appointmentDetail[4]);
        ViewAppointmentPhone.setText(appointmentDetail[5]);
        ViewAppointmentMO.setText(appointmentDetail[15]);
        ViewAppointmentSymptoms.setText(GetSetTextArea.setText(appointmentDetail[12]));
    }

}
