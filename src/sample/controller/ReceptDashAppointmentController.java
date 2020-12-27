package sample.controller;

import com.jfoenix.controls.*;
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

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ReceptDashAppointmentController {

    public static String AppointmentIDGlobal;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private StackPane AddAppointmentStackPane;

    @FXML
    private AnchorPane AddAppointmentAnchorPane;

    @FXML
    private JFXTextField AddAppointmentPatientFirstname;

    @FXML
    private JFXTextField AddAppointmentPatientAddressLine1;

    @FXML
    private JFXTextField AddAppointmentPatientLastname;

    @FXML
    private JFXDatePicker AddAppointmentPatientDOB;

    @FXML
    private JFXTextField AddAppointmentPatientPhoneNumber;

    @FXML
    private JFXTextArea AddAppointmentSymptoms;


    @FXML
    private JFXTimePicker AddAppointmentAppointmentTime;

    @FXML
    private JFXTextField AddAppointmentAppointmentNumber;

    @FXML
    private JFXComboBox<String> AddAppointmentAppointmentPrefferedMO;

    @FXML
    private JFXComboBox<String> AddAppointmentAppointmentRecordStatus;

    @FXML
    private JFXButton AddAppointmentBtn;

    @FXML
    private JFXDatePicker AddAppointmentAppointmentDate;

    @FXML
    private JFXTextField AddAppointmentPatientUserName;

    @FXML
    private JFXTextField AddAppointmentPatientIDNum;

    @FXML
    private JFXComboBox<String> AddAppointmentPatientGender;

    @FXML
    private JFXTextField AddAppointmentPatientAddressLine2;

    @FXML
    private JFXTextField AddAppointmentCity;

    @FXML
    private JFXComboBox<String> AddAppointmentSpecialMO;

    @FXML
    private JFXComboBox<String> AddAppointemntPatientBloodGroup;

    @FXML
    private JFXTextField EditAppointmentID;

    @FXML
    private JFXButton EditAppointmentBtn;

    @FXML
    private JFXTextField ViewAppointmentID;

    @FXML
    private JFXButton ViewAppointmentBtn;

    @FXML
    private BorderPane ViewAppointmentBorderPane;

    @FXML
    private JFXTextField DeleteAppointmentUsername;

    @FXML
    private JFXButton DeleteAppointmentBtn;

    @FXML
    private BorderPane DeleteAppointmentBorderPane;

    @FXML
    private BorderPane EditAppointmentBorderPane;

    @FXML
    void Add_Appointment(MouseEvent event) {
        try{
            ValidationController validate = new ValidationController(AddAppointmentStackPane, AddAppointmentAnchorPane, 1);
            if(        !(AddAppointmentAppointmentTime.getValue() == null)
                    && !(AddAppointmentAppointmentDate.getValue() == null)
                    && !(AddAppointmentPatientDOB.getValue() == null)
                    && !(AddAppointmentAppointmentPrefferedMO.getSelectionModel().isEmpty())
                    && !(AddAppointemntPatientBloodGroup.getSelectionModel().isEmpty())
                    && validate.ValidNotEmpty(AddAppointmentPatientUserName)
                    && validate.ValidNotEmpty(AddAppointmentPatientIDNum)
                    && validate.ValidNotEmpty(AddAppointmentPatientFirstname)
                    && validate.ValidNotEmpty(AddAppointmentPatientLastname)
                    && validate.ValidNotEmpty(AddAppointmentPatientPhoneNumber)
                    && validate.ValidNotEmpty(AddAppointmentPatientAddressLine1)
                    && validate.ValidNotEmpty(AddAppointmentPatientAddressLine2)
                    && validate.ValidNotEmpty(AddAppointmentCity)
            )
            {
                if (validate.validateNIC(AddAppointmentPatientIDNum)
                        && validate.validatePhone(AddAppointmentPatientPhoneNumber)
                        && validate.validateExitingPatientUsername(AddAppointmentPatientUserName)
                ) {

                    Appointment newAppointment = new Appointment();
                    newAppointment.setAppointmentNo(AddAppointmentAppointmentNumber.getText().trim());
                    newAppointment.setFirstName(AddAppointmentPatientFirstname.getText().trim());
                    newAppointment.setLastName(AddAppointmentPatientLastname.getText().trim());
                    newAppointment.setUserName(AddAppointmentPatientUserName.getText().trim());
                    newAppointment.setIdNo(AddAppointmentPatientIDNum.getText().trim());
                    newAppointment.setGender(AddAppointmentPatientGender.getValue());
                    newAppointment.setPhoneNumber(AddAppointmentPatientPhoneNumber.getText().trim());
                    newAppointment.setDOB(AddAppointmentPatientDOB.getValue());
                    newAppointment.setAddressLine1(AddAppointmentPatientAddressLine1.getText().trim());
                    newAppointment.setAddressLine2(AddAppointmentPatientAddressLine2.getText().trim());
                    newAppointment.setCity(AddAppointmentCity.getText().trim());
                    newAppointment.setMedicalOfficer(AddAppointmentAppointmentPrefferedMO.getValue());
                    newAppointment.setMedicalSpecialArea(AddAppointmentSpecialMO.getValue());
                    newAppointment.setBloodGroup(AddAppointemntPatientBloodGroup.getValue());
                    newAppointment.setSymptoms(GetSetTextArea.getText(AddAppointmentSymptoms.getText().trim()));
                    newAppointment.setAppointmentDate(AddAppointmentAppointmentDate.getValue());
                    newAppointment.setAppointmentTime(AddAppointmentAppointmentTime.getValue());
                    newAppointment.setAppointmentRecordStatus(AddAppointmentAppointmentRecordStatus.getValue());

                    ReceptAddAppointment.writeToFile(newAppointment);
                    validate.successfulUserCreation("Appointment Successfully Created");
                    clearFields();
                }
            } else {
                validate.detailedMsg("Invalid Input Data", "Some fields are empty." +
                        " Enter data and try again");
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void initialize() {
        // combo-box items for gender at add appointment
        AddAppointmentPatientGender.getItems().add("Male");
        AddAppointmentPatientGender.getItems().add("Female");

        // combo-box items for blood-group status at add appointment
        AddAppointemntPatientBloodGroup.getItems().add("A+");
        AddAppointemntPatientBloodGroup.getItems().add("A-");
        AddAppointemntPatientBloodGroup.getItems().add("B+");
        AddAppointemntPatientBloodGroup.getItems().add("B-");
        AddAppointemntPatientBloodGroup.getItems().add("O+");
        AddAppointemntPatientBloodGroup.getItems().add("O-");
        AddAppointemntPatientBloodGroup.getItems().add("AB+");
        AddAppointemntPatientBloodGroup.getItems().add("AB-");

        // add medial officer special area to combo-box
        AdReference.readItem(AddAppointmentSpecialMO);

        // combo-box items for AppointmentRecordStatus
        AddAppointmentAppointmentRecordStatus.getItems().add("Pending");
        AddAppointmentAppointmentRecordStatus.getItems().add("Approved");

        // initial value of appointment ID is disable
        AddAppointmentAppointmentNumber.setDisable(true);

        // Selecting medical Officer is disable until selecting speciality area
        boolean disable = !AddAppointmentAppointmentPrefferedMO.isDisabled();
        AddAppointmentAppointmentPrefferedMO.setDisable(disable);

    }

    public void clearFields() {
        AddAppointmentPatientFirstname.clear();
        AddAppointmentPatientLastname.clear();
        AddAppointmentPatientUserName.clear();
        AddAppointmentPatientIDNum.clear();
        AddAppointmentPatientGender.getSelectionModel().clearSelection();
        AddAppointmentPatientPhoneNumber.clear();
        AddAppointmentPatientDOB.getEditor().clear();
        AddAppointmentPatientAddressLine1.clear();
        AddAppointmentPatientAddressLine2.clear();
        AddAppointemntPatientBloodGroup.getSelectionModel().clearSelection();
        AddAppointmentSymptoms.clear();
        AddAppointmentAppointmentDate.getEditor().clear();
        AddAppointmentAppointmentNumber.clear();
        AddAppointmentAppointmentTime.getEditor().clear();
        AddAppointmentAppointmentPrefferedMO.getSelectionModel().clearSelection();
        AddAppointmentAppointmentRecordStatus.getSelectionModel().clearSelection();
        AddAppointmentCity.clear();
        AddAppointmentSpecialMO.getSelectionModel().clearSelection();
        ViewAppointmentID.clear();
        EditAppointmentID.clear();
    }

    @FXML
    void Edit_Appointment(MouseEvent event) throws IOException {
        ValidationController appointmentValidation = new ValidationController(AddAppointmentStackPane,
                AddAppointmentAnchorPane, 1);
        if(appointmentValidation.ValidNotEmpty(EditAppointmentID)){
            if (appointmentValidation.validateAppointmentID(EditAppointmentID)) {
                AppointmentIDGlobal = EditAppointmentID.getText().trim();
                Parent appointmentPane = FXMLLoader.load(getClass()
                        .getResource("/sample/view/RecepEditAppointment.fxml"));
                EditAppointmentBorderPane.setCenter(appointmentPane);
                clearFields();
            }
        }
    }
    @FXML
    void View_Appointment(MouseEvent event) throws IOException {
        ValidationController appointmentValidation = new ValidationController(AddAppointmentStackPane,
                AddAppointmentAnchorPane, 1);
        if(appointmentValidation.ValidNotEmpty(ViewAppointmentID)){
            if (appointmentValidation.validateAppointmentID(ViewAppointmentID)) {
                AppointmentIDGlobal = ViewAppointmentID.getText().trim();
                Parent appointmentPane = FXMLLoader.load(getClass().getResource("/sample/view/RecepViewAppointment.fxml"));
                ViewAppointmentBorderPane.setCenter(appointmentPane);
                clearFields();
            }
        }
    }

    @FXML
    void selectingMO(ActionEvent event) {
        if(AddAppointmentAppointmentPrefferedMO.isDisabled()){
            AddAppointmentAppointmentPrefferedMO.setDisable(false);
        }
        AddAppointmentAppointmentPrefferedMO.getSelectionModel().clearSelection();
        AddAppointmentAppointmentPrefferedMO.getItems().clear();
        PrefMedicalOfficer.MOList(AddAppointmentSpecialMO.getValue(), AddAppointmentAppointmentPrefferedMO);
    }

    @FXML
    void app_status(ActionEvent event) {
        if(AddAppointmentAppointmentRecordStatus.getValue() == "Approved"){
            AddAppointmentAppointmentNumber.setDisable(false);
            AddAppointmentAppointmentNumber.setText(RandomID.getUniqueId());
        } else {
            AddAppointmentAppointmentNumber.clear();
            AddAppointmentAppointmentNumber.setDisable(true);
        }
    }
}
