package sample.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import sample.model.Appointment;
import sample.model.GetSetTextArea;
import sample.model.RecepPatient;

public class RecepViewPatientController {
    @FXML
    private StackPane ViewPatientStackPane;

    @FXML
    private BorderPane ViewPatientBorderPane;

    @FXML
    private Label ViewPatientFirstName;

    @FXML
    private Label ViewPatientGender;

    @FXML
    private Label ViewPatientMaritalStatus;

    @FXML
    private Label ViewPatientAddressLine1;

    @FXML
    private Label ViewPatientCity;

    @FXML
    private Label ViewPatientLastName;

    @FXML
    private Label ViewPatientIDNum;

    @FXML
    private Label ViewPatientPhoneNum;

    @FXML
    private Label ViewPatientAddressLine2;

    @FXML
    private Label ViewPatientDOB;

    @FXML
    private Label ViewPatientBloodgroup;

    @FXML
    private Label ViewPatientAllergies;


    @FXML
    void initialize() {
        RecepPatient viewRecepPatient = new RecepPatient();
        viewRecepPatient.getRecepPatientDetailsArray(ReceptDashPatientRecordsController.PatientIDGlobal);
        String[] patientDetail = viewRecepPatient.getRecepPatientDetails();

        ViewPatientIDNum.setText(patientDetail[0]);
        ViewPatientFirstName.setText(patientDetail[1]);
        ViewPatientLastName.setText(patientDetail[2]);
        ViewPatientGender.setText(patientDetail[3]);
        ViewPatientDOB.setText(patientDetail[4]);
        ViewPatientMaritalStatus.setText(patientDetail[5]);
        ViewPatientPhoneNum.setText(patientDetail[6]);
        ViewPatientCity.setText(patientDetail[7]);
        ViewPatientAddressLine1.setText(patientDetail[8]);
        ViewPatientAddressLine2.setText(patientDetail[9]);
        ViewPatientBloodgroup.setText(patientDetail[10]);
        ViewPatientAllergies.setText(patientDetail[11]);


}

}
