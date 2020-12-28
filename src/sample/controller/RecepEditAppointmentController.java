package sample.controller;

import com.jfoenix.controls.*;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import sample.model.*;

public class RecepEditAppointmentController {

    private String[] appEditDetails ;

    public void setAppEditDetails(String[] appEditDetails){
        this.appEditDetails = appEditDetails;
    }

    public String[] getAppEditDetails(){
        return appEditDetails;
    }

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private JFXTextField EditAppointmentNumber;

    @FXML
    private JFXComboBox<String> EditAppointmentStatus;

    @FXML
    private JFXDatePicker EditAppointmentDate;

    @FXML
    private JFXTimePicker EditAppointmentTime;

    @FXML
    private JFXComboBox<String> EditAppointmentMO;

    @FXML
    private StackPane RecepEdirAppoStackPane;

    @FXML
    private JFXComboBox<String> EditAppointmentSpecial;

    @FXML
    private JFXTextArea EditAppointmentSymptoms;

    @FXML
    private JFXButton EditAppointmentSaveChange;

    @FXML
    private AnchorPane AnchPaneRecepEditApp;

    @FXML
    private BorderPane RecepEditBordere;

    @FXML
    void SaveChanges(MouseEvent event) throws IOException {
        ValidationController validate = new ValidationController(RecepEdirAppoStackPane, AnchPaneRecepEditApp,
                4 );
        Appointment editAppointment = new Appointment();
        editAppointment.deleteAppointment(ReceptDashAppointmentController.AppointmentIDGlobal);

        editAppointment.setAppointmentNo(getAppEditDetails()[0]);
        editAppointment.setFirstName(getAppEditDetails()[2]);
        editAppointment.setLastName(getAppEditDetails()[3]);
        editAppointment.setUserName(getAppEditDetails()[1]);
        editAppointment.setIdNo(getAppEditDetails()[4]);
        editAppointment.setGender(getAppEditDetails()[6]);
        editAppointment.setPhoneNumber(getAppEditDetails()[5]);
        editAppointment.setDOB(LocalDate.parse(getAppEditDetails()[7]));
        editAppointment.setAddressLine1(getAppEditDetails()[8]);
        editAppointment.setAddressLine2(getAppEditDetails()[9]);
        editAppointment.setCity(getAppEditDetails()[10]);
        editAppointment.setMedicalOfficer(EditAppointmentMO.getValue());
        editAppointment.setMedicalSpecialArea(EditAppointmentSpecial.getValue());
        editAppointment.setBloodGroup(getAppEditDetails()[11]);
        editAppointment.setSymptoms(GetSetTextArea.getText(EditAppointmentSymptoms.getText().trim()));
        editAppointment.setAppointmentDate(EditAppointmentDate.getValue());
        editAppointment.setAppointmentTime(EditAppointmentTime.getValue());
        editAppointment.setAppointmentRecordStatus(EditAppointmentStatus.getValue());

        ReceptAddAppointment.writeToFile(editAppointment);
        validate.successfulUserCreation("Appointment Successfully Updated");
        clearFields();
        afterCreation();
    }

    public void afterCreation() throws IOException {
        Parent white = FXMLLoader.load(getClass()
                .getResource("/sample/view/WhiteBlank.fxml"));
        RecepEditBordere.setCenter(white);
    }

    @FXML
    void initialize() {
        // add medial officer special area to combo-box
        AdReference.readItem(EditAppointmentSpecial, 0);

        // add items to the medical officer
        PrefMedicalOfficer.MOList(EditAppointmentSpecial.getValue(), EditAppointmentMO);

        // combo-box items for AppointmentRecordStatus
        EditAppointmentStatus.getItems().add("Pending");
        EditAppointmentStatus.getItems().add("Approved");

        Appointment editAppointment = new Appointment();
        editAppointment.getAppointmentDetailsArray(ReceptDashAppointmentController.AppointmentIDGlobal);
        String[] appointmentDetails = editAppointment.getAppointmentDetails();
        setAppEditDetails(appointmentDetails);

        // set values to text fields
        EditAppointmentNumber.setText(appointmentDetails[0]);
        EditAppointmentStatus.setValue(appointmentDetails[16]);
        EditAppointmentTime.setValue(LocalTime.parse(appointmentDetails[14]));
        EditAppointmentDate.setValue(LocalDate.parse(appointmentDetails[13]));
        EditAppointmentSpecial.setValue(appointmentDetails[17]);

        // add items to the medical officer
        PrefMedicalOfficer.MOList(EditAppointmentSpecial.getValue(), EditAppointmentMO);

        EditAppointmentMO.setValue(appointmentDetails[15]);
        EditAppointmentSymptoms.setText(GetSetTextArea.setText(appointmentDetails[12]));
    }

    @FXML
    void selecting_edit_MO(ActionEvent event) {
        if(EditAppointmentMO.isDisabled()){
            EditAppointmentMO.setDisable(false);
        }
        EditAppointmentMO.getSelectionModel().clearSelection();
        EditAppointmentMO.getItems().clear();
        PrefMedicalOfficer.MOList(EditAppointmentSpecial.getValue(), EditAppointmentMO);
    }

    @FXML
    void app_edit_status(ActionEvent event) {
        if(EditAppointmentStatus.getValue() == "Approved"){
            EditAppointmentNumber.setDisable(false);
            EditAppointmentNumber.setText(getAppEditDetails()[0]);
        } else {
            EditAppointmentNumber.clear();
            EditAppointmentNumber.setDisable(true);
        }
    }

    public void clearFields() {
        EditAppointmentNumber.clear();
        EditAppointmentStatus.getSelectionModel().clearSelection();
        EditAppointmentTime.getEditor().clear();
        EditAppointmentDate.getEditor().clear();
        EditAppointmentSpecial.getSelectionModel().clearSelection();
        EditAppointmentMO.getSelectionModel().clearSelection();
        EditAppointmentSymptoms.clear();
    }
}
