package sample.controller;

import com.jfoenix.controls.*;
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
    private JFXTextField AddAppointmentSymptoms;

    @FXML
    private JFXDatePicker AddAppointmentFromDate;


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
    private JFXComboBox<String> AddAppointmentPatientMaritalStatus;

    @FXML
    private JFXTextField AddAppointmentPatientAddressLine2;

    @FXML
    private JFXComboBox<String> AddAppointemntPatientBloodGroup;

    @FXML
    private JFXTextArea AddAppointmentPatientAllergies;

    @FXML
    private JFXTextField EditAppointmentUsername;

    @FXML
    private JFXButton EditAppointmentBtn;

    @FXML
    private JFXTextField ViewAppointmentUsername;

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
    void Add_Appointment(MouseEvent event) {
        try{
            ValidationController validate = new ValidationController(AddAppointmentStackPane, AddAppointmentAnchorPane, 1);
            if(        validate.validateNIC(AddAppointmentPatientIDNum)
                    && validate.validatePhone(AddAppointmentPatientPhoneNumber)
                    && validate.validateUsername(AddAppointmentPatientUserName)
                    && validate.sameIDNo(AddAppointmentPatientIDNum)
                    && validate.samePhoneNumber(AddAppointmentPatientPhoneNumber)
                 ){

                Appointment newAppointment = new Appointment();

                newAppointment.setFirstName(AddAppointmentPatientFirstname.getText().trim());
                newAppointment.setLastName(AddAppointmentPatientLastname.getText().trim());
                newAppointment.setUserName(AddAppointmentPatientUserName.getText().trim());
                newAppointment.setIdNo(AddAppointmentPatientIDNum.getText().trim());

                newAppointment.setGender(AddAppointmentPatientGender.getValue());
                newAppointment.setPhoneNumber(AddAppointmentPatientPhoneNumber.getText().trim());
                newAppointment.setMaritalStatus(AddAppointmentPatientMaritalStatus.getValue());
                newAppointment.setdOB(AddAppointmentPatientDOB.getValue());
                newAppointment.setAddressLine1(AddAppointmentPatientAddressLine1.getText().trim());
                newAppointment.setAddressLine2(AddAppointmentPatientAddressLine1.getText().trim());

                newAppointment.setBloodGroup(AddAppointemntPatientBloodGroup.getValue());
                newAppointment.setAllergies(AddAppointmentPatientAllergies.getText().trim());
                newAppointment.setSymptoms(AddAppointmentSymptoms.getText().trim());
                newAppointment.setSymptomsFromDate(AddAppointmentFromDate.getValue());
                newAppointment.setAppointmentDate(AddAppointmentAppointmentDate.getValue());
                newAppointment.setAppointmentNo(AddAppointmentAppointmentNumber.getText().trim());
                newAppointment.setAppointmentTime(AddAppointmentAppointmentTime.getValue());
                newAppointment.setAppointmentRecordStatus(AddAppointmentAppointmentRecordStatus.getValue());


                ReceptAddAppointment.writeToFile(newAppointment);
                validate.successfulUserCreation("Appointment Successfully Created");
                clearFields();

            }
        } catch (Exception e) {
            e.printStackTrace();
        }



    }

    @FXML
    void initialize() {
        // combo-box items for gender at add appointment
        AddAppointmentPatientGender.getItems().add("Male");
        AddAppointmentPatientGender.getItems().add("Female");

        // combo-box items for marital status at add appointment
        AddAppointmentPatientMaritalStatus.getItems().add("Unmarried");
        AddAppointmentPatientMaritalStatus.getItems().add("Married");
        AddAppointmentPatientMaritalStatus.getItems().add("Divorced");
        AddAppointmentPatientMaritalStatus.getItems().add("Widowed");
        AddAppointmentPatientMaritalStatus.getItems().add("Legally Separated");

        // combo-box items for blood-group status at add appointment
        AddAppointemntPatientBloodGroup.getItems().add("A+");
        AddAppointemntPatientBloodGroup.getItems().add("A-");
        AddAppointemntPatientBloodGroup.getItems().add("B+");
        AddAppointemntPatientBloodGroup.getItems().add("B-");
        AddAppointemntPatientBloodGroup.getItems().add("O+");
        AddAppointemntPatientBloodGroup.getItems().add("O-");
        AddAppointemntPatientBloodGroup.getItems().add("AB+");
        AddAppointemntPatientBloodGroup.getItems().add("AB-");

        // combo-box items for AppointmentRecordStatus
        AddAppointmentAppointmentRecordStatus.getItems().add("Pending");
        AddAppointmentAppointmentRecordStatus.getItems().add("Approved");



    }

    public void clearFields() {
        AddAppointmentPatientFirstname.clear();
        AddAppointmentPatientLastname.clear();
        AddAppointmentPatientUserName.clear();
        AddAppointmentPatientIDNum.clear();
        AddAppointmentPatientGender.getSelectionModel().clearSelection();
        AddAppointmentPatientPhoneNumber.clear();
        AddAppointmentPatientMaritalStatus.getSelectionModel().clearSelection();
        AddAppointmentPatientDOB.getEditor().clear();
        AddAppointmentPatientAddressLine1.clear();
        AddAppointmentPatientAddressLine2.clear();

        AddAppointemntPatientBloodGroup.getSelectionModel().clearSelection();
        AddAppointmentPatientAllergies.clear();
        AddAppointmentSymptoms.clear();
        AddAppointmentFromDate.getEditor().clear();
        AddAppointmentAppointmentDate.getEditor().clear();
        AddAppointmentAppointmentNumber.clear();
        AddAppointmentAppointmentTime.getEditor().clear();
        AddAppointmentAppointmentPrefferedMO.getSelectionModel().clearSelection();
        AddAppointmentAppointmentRecordStatus.getSelectionModel().clearSelection();



    }
    @FXML
    void Delete_Appointment(MouseEvent event) {

    }

    @FXML
    void Edit_Appointment(MouseEvent event) {

    }
    @FXML
    void View_Appointment(MouseEvent event) throws IOException {
        Parent appointmentPane = FXMLLoader.load(getClass().getResource("/sample/view/ViewAppointment.fxml"));
        ViewAppointmentBorderPane.setCenter(appointmentPane);
    }

<<<<<<< HEAD
    @FXML
    void initialize() {

    }
=======
>>>>>>> e0026a6df73b773c0e895a3471eab80010c853ee

}
