package sample.controller;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTabPane;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Tab;

public class AdDashEditUserController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

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
    private JFXComboBox<?> EditUserGender;

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
    private JFXComboBox<?> EditUserMaritalStatus;

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
    private JFXComboBox<?> EditUserMOSpecificArea;

    @FXML
    private JFXTextField EditUserMOStaffID;

    @FXML
    private JFXTextField EditUserMOStaffEmail;

    @FXML
    private JFXDatePicker EditUserMODateofJoin;

    @FXML
    private Tab Patient;

    @FXML
    private JFXComboBox<?> EditUserPatientBlood;

    @FXML
    private JFXTextArea EditUserPatientAllergies;

    @FXML
    private Tab EditUserAccount;

    @FXML
    private Tab DeleteUserAccount;

    @FXML
    void initialize() {


    }
}
