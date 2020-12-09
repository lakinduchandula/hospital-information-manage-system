package sample.controller;

import com.jfoenix.controls.*;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Tab;

public class AdDashEditUserController {

    @FXML
    private JFXTabPane mainEditUserTabPane;

    @FXML
    private Tab CreateUserAccount;

    @FXML
    private JFXTextField EditUserFirstName;

    @FXML
    private JFXTextField EditUserLastName;

    @FXML
    private JFXTextField EditUserUsername;

    @FXML
    private JFXComboBox<String> EditUserGender;

    @FXML
    private JFXTextField EditUserPhoneNumber;

    @FXML
    private JFXTextField EditUserIDCardNumber;

    @FXML
    private JFXDatePicker EditUserDOB;

    @FXML
    private JFXTextField EditUserAddLine1;

    @FXML
    private JFXTextField EditUserAddLine2;

    @FXML
    private JFXComboBox<String> EditUserMaritalStatus;

    @FXML
    private JFXTextField EditUserAddCity;

    @FXML
    private JFXTextField EditUserAddCountry;

    @FXML
    private JFXTabPane subEditUserTabPane;

    @FXML
    private Tab Receptionist;

    @FXML
    private JFXTextField EditUserRecepStaffID;

    @FXML
    private JFXTextField EditUserRecepEmail;

    @FXML
    private JFXDatePicker EditUserDateofJoin;

    @FXML
    private Tab MedicalOfficer;

    @FXML
    private JFXComboBox<String> EditUserMOSpecificArea;

    @FXML
    private JFXTextField EditUserMOStaffID;

    @FXML
    private JFXTextField EditUserMOStaffEmail;

    @FXML
    private JFXDatePicker EditUserMODateofJoin;

    @FXML
    private Tab Patient;

    @FXML
    private JFXComboBox<String> EditUserPatientBlood;

    @FXML
    private JFXTextArea EditUserPatientAllergies;

    @FXML
    private Tab EditUserAccount;

    @FXML
    private JFXTextField EditUserEditUsername;

    @FXML
    private JFXComboBox<String> EditUserEditUsermode;

    @FXML
    private JFXButton ViewComplaintBtn;

    @FXML
    private Tab DeleteUserAccount;

    @FXML
    private JFXTextField EditUserDeleteUsername;

    @FXML
    private JFXComboBox<String> EditUserDeleteUsermode;

    @FXML
    private JFXButton ViewComplaintBtn1;

    public AdDashEditUserController() {
    }

    @FXML
    void initialize() {
        // combo-box items for gender at create user account
        EditUserGender.setStyle("-fx-text-fill: #424242");
        EditUserGender.getItems().add("Male");
        EditUserGender.getItems().add("Female");

        // combo-box items for marital status at create user account
        EditUserMaritalStatus.setStyle("-fx-text-fill: #424242");
        EditUserMaritalStatus.getItems().add("Unmarried");
        EditUserMaritalStatus.getItems().add("Married");
        EditUserMaritalStatus.getItems().add("Divorced");
        EditUserMaritalStatus.getItems().add("Widowed");
        EditUserMaritalStatus.getItems().add("Legally Separated");

        // combo-box items for blood-group status at create user account
        EditUserPatientBlood.setStyle("-fx-text-fill: #424242");
        EditUserPatientBlood.getItems().add("A+");
        EditUserPatientBlood.getItems().add("A-");
        EditUserPatientBlood.getItems().add("B+");
        EditUserPatientBlood.getItems().add("B-");
        EditUserPatientBlood.getItems().add("O+");
        EditUserPatientBlood.getItems().add("O-");
        EditUserPatientBlood.getItems().add("AB+");
        EditUserPatientBlood.getItems().add("AB-");







    }
}
