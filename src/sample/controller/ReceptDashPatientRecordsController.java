package sample.controller;

import com.jfoenix.controls.*;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import sample.model.AdReference;

import javax.print.DocFlavor;

public class ReceptDashPatientRecordsController {
    @FXML
    private JFXTextField AddPatientFirstName;

    @FXML
    private JFXTextField AddPatientUsername;

    @FXML
    private JFXComboBox<String> AddPatientGender;

    @FXML
    private JFXComboBox<String> AddPatientMaritalStatus;

    @FXML
    private JFXTextField AddPatientAddressLine1;

    @FXML
    private JFXTextField AddPatientCity;

    @FXML
    private JFXTextField AddPatientLastName;

    @FXML
    private JFXTextField AddPatientIDCardNumber;

    @FXML
    private JFXTextField AddPatientPhoneNumber;

    @FXML
    private JFXDatePicker AddPatientDOB;

    @FXML
    private JFXTextField AddPatientAddressLine2;

    @FXML
    private JFXTextField AddPatientCountry;

    @FXML
    private JFXComboBox<String> AddPatientBloodGroup;

    @FXML
    private JFXTextArea AddPatientAllergies;

    @FXML
    private JFXButton AddPatientBtn;

    @FXML
    private JFXButton EditPatientUserName;

    @FXML
    private JFXButton ViewPatientUserName;

    @FXML
    private JFXButton DeletePatientUserName;

    @FXML
    void Add_Patient(MouseEvent event) {

    }

    @FXML
    void Delete_Patient(MouseEvent event) {

    }

    @FXML
    void Edit_Patient(MouseEvent event) {

    }

    @FXML
    void View_Patient(MouseEvent event) {

    }

    @FXML
    void initialize() {
        // combo-box items for gender at create add patient
        AddPatientGender.getItems().add("Male");
        AddPatientGender.getItems().add("Female");

        // combo-box items for marital status at create add patient
        AddPatientMaritalStatus.getItems().add("Unmarried");
        AddPatientMaritalStatus.getItems().add("Married");
        AddPatientMaritalStatus.getItems().add("Divorced");
        AddPatientMaritalStatus.getItems().add("Widowed");
        AddPatientMaritalStatus.getItems().add("Legally Separated");


        // combo-box items for blood-group status at create user account
        AddPatientBloodGroup.getItems().add("A+");
        AddPatientBloodGroup.getItems().add("A-");
        AddPatientBloodGroup.getItems().add("B+");
        AddPatientBloodGroup.getItems().add("B-");
        AddPatientBloodGroup.getItems().add("O+");
        AddPatientBloodGroup.getItems().add("O-");
        AddPatientBloodGroup.getItems().add("AB+");
        AddPatientBloodGroup.getItems().add("AB-");


    }
}
