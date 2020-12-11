package sample.controller;

import com.jfoenix.controls.*;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Tab;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;

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

    @FXML
    private JFXButton EditUserEditAccount;

    @FXML
    private BorderPane EditUserEditBoarderPane;

    @FXML
    void edit_user_account(MouseEvent event) throws IOException {
        Parent editUserAccount = FXMLLoader.load(getClass().getResource("/sample/view/EditReceptionistAccount.fxml"));
        EditUserEditBoarderPane.setCenter(editUserAccount);
    }

    public AdDashEditUserController() {
    }

    @FXML
    void initialize() {
        // combo-box items for gender at create user account
        EditUserGender.getItems().add("Male");
        EditUserGender.getItems().add("Female");

        // combo-box items for marital status at create user account
        EditUserMaritalStatus.getItems().add("Unmarried");
        EditUserMaritalStatus.getItems().add("Married");
        EditUserMaritalStatus.getItems().add("Divorced");
        EditUserMaritalStatus.getItems().add("Widowed");
        EditUserMaritalStatus.getItems().add("Legally Separated");

        // combo-box items for blood-group status at create user account
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
