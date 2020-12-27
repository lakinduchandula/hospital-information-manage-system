package sample.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.text.Text;
import sample.model.Appointment;
import sample.model.GetSetTextArea;

public class PatientViewAppointmentController {

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
    void initialize() {
        Appointment viewAppointment = new Appointment();
        viewAppointment.getAppointmentDetailsArray(PatientDashAppointmentController.appointmentID);
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
