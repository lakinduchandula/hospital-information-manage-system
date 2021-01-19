package sample.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXTimePicker;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import sample.model.*;

public class PatientDashAppointmentController {

    private String[] patientDetailArray;

    public String[] getPatientDetailArray(){
        return patientDetailArray;
    }

    public void setPatientDetailArray(String[] patientDetailArray){
        this.patientDetailArray = patientDetailArray;
    }

    public static String appointmentID;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private StackPane PatientDashAppStackPane;

    @FXML
    private AnchorPane PatientDashAppAnchor;

    @FXML
    private Label AppointmentAddUsername;

    @FXML
    private Label AppointmentAddFirstName;

    @FXML
    private Label AppointmentAddUserID;

    @FXML
    private Label AppointmentAddLastName;

    @FXML
    private Label AppointmentAddUserPhone;

    @FXML
    private JFXDatePicker AppointmentAddDate;

    @FXML
    private JFXTextArea AppointmentAddSymptoms;

    @FXML
    private JFXButton MakeAnAppointment;

    @FXML
    private JFXTimePicker AppointmentAddTime;

    @FXML
    private JFXComboBox<String> AppointmentAddSpecial;

    @FXML
    private JFXComboBox<String> AppointmentAddMO;

    @FXML
    private JFXTextField ViewAppointmentID;

    @FXML
    private JFXButton AppointmentView;

    @FXML
    private Label AppointmentAddID;

    @FXML
    private BorderPane ViewAppointmentBorder;

    @FXML
    void Info_tip(MouseEvent event) {

    }

    @FXML
    void ViewAppointment(MouseEvent event) throws IOException {
        ValidationController appointmentValidation = new ValidationController(PatientDashAppStackPane,
                PatientDashAppAnchor, 3);
        if(appointmentValidation.ValidNotEmpty(ViewAppointmentID) && appointmentValidation
                .rightAppointmentPatient(ViewAppointmentID.getText().trim(),
                LoginController.currentUser)) {
            appointmentID = ViewAppointmentID.getText().trim();
            Parent viewAppointment = FXMLLoader.load(getClass()
                    .getResource("/sample/view/PatientViewAppointment.fxml"));
            ViewAppointmentBorder.setCenter(viewAppointment);
            ViewAppointmentID.clear();
        }
    }

    @FXML
    void makeAnAppointment(MouseEvent event) {
        ValidationController MakeAppValidate = new ValidationController(PatientDashAppStackPane,
                PatientDashAppAnchor, 3);

        if(        !AppointmentAddMO.getSelectionModel().isEmpty()
                && !(AppointmentAddDate.getValue() == null)
                && !(AppointmentAddTime.getValue() == null)) {

            Patient newPatient = new Patient();
            Appointment newAppointment = new Appointment();

            newAppointment.setAppointmentNo(AppointmentAddID.getText().trim());
            newAppointment.setFirstName(getPatientDetailArray()[2]);
            newAppointment.setLastName(getPatientDetailArray()[3]);
            newAppointment.setUserName(getPatientDetailArray()[0]);
            newAppointment.setIdNo(getPatientDetailArray()[4]);
            newAppointment.setGender(getPatientDetailArray()[6]);
            newAppointment.setPhoneNumber(getPatientDetailArray()[5]);
            newAppointment.setDOB(LocalDate.parse(getPatientDetailArray()[7]));
            newAppointment.setAddressLine1(getPatientDetailArray()[9]);
            newAppointment.setAddressLine2(getPatientDetailArray()[10]);
            newAppointment.setCity(getPatientDetailArray()[11]);
            newAppointment.setMedicalOfficer(AppointmentAddMO.getValue());
            newAppointment.setMedicalSpecialArea(AppointmentAddSpecial.getValue());
            newAppointment.setBloodGroup(getPatientDetailArray()[14]);
            newAppointment.setSymptoms(GetSetTextArea.getText(AppointmentAddSymptoms.getText().trim()));
            newAppointment.setAppointmentDate(AppointmentAddDate.getValue());
            newAppointment.setAppointmentTime(AppointmentAddTime.getValue());
            newAppointment.setAppointmentRecordStatus("Pending");
            newAppointment.setMOStaffID(newAppointment.getIDFromName(AppointmentAddMO.getValue()));
            newAppointment.setPatientUniqueID(newPatient.getPatientGhostID(getPatientDetailArray()[0]));

            ReceptAddAppointment.writeToFile(newAppointment);
            MakeAppValidate.detailedMsg("Appointment Creation", "Appointment made Successfully");
            clearFields();
        } else {
            MakeAppValidate.detailedMsg("Invalid Input Data", "Some fields are empty." +
                    " Enter data and try again");
        }
    }

    @FXML
    void initialize() {
        // add items to Medical Officer Speciality area combo-box
        AdReference.readItem(AppointmentAddSpecial, 0);

        // add unique id for appointment
        AppointmentAddID.setText(RandomID.getUniqueId());

        UserEditDelete patientUserDetails = new UserEditDelete(1);
        patientUserDetails.UserEdit(LoginController.currentUser);
        String[] PatientDetails = patientUserDetails.getUserDetailArray();

        // Selecting medical Officer is disable until selecting speciality area
        boolean disable = !AppointmentAddMO.isDisabled();
        AppointmentAddMO.setDisable(disable);

        // set array for future use
        setPatientDetailArray(PatientDetails);

        // set values to the labels of appointment add
        AppointmentAddFirstName.setText(PatientDetails[2]);
        AppointmentAddLastName.setText(PatientDetails[3]);
        AppointmentAddUsername.setText(PatientDetails[0]);
        AppointmentAddUserPhone.setText(PatientDetails[5]);
        AppointmentAddUserID.setText(PatientDetails[4]);
    }

    void clearFields() {
        AppointmentAddID.setText(RandomID.getUniqueId());
        AppointmentAddDate.getEditor().clear();
        AppointmentAddTime.getEditor().clear();
        AppointmentAddSpecial.getSelectionModel().clearSelection();
        AppointmentAddMO.getSelectionModel().clearSelection();
        AppointmentAddSymptoms.clear();
    }

    @FXML
    void selectingMO(ActionEvent event) {
        if(AppointmentAddMO.isDisabled()){
            AppointmentAddMO.setDisable(false);
        }
        AppointmentAddMO.getSelectionModel().clearSelection();
        AppointmentAddMO.getItems().clear();
        PrefMedicalOfficer.MOList(AppointmentAddSpecial.getValue(), AppointmentAddMO);
    }
}
