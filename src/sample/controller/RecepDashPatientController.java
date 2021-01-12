package sample.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import sample.model.AdReference;
import sample.model.GetSetTextArea;
import sample.model.Patient;
import sample.model.UserAdd;

public class RecepDashPatientController {

    public static String PatientUsername;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private StackPane RecepAddPatientStackPane;

    @FXML
    private AnchorPane RecepAddPatientAnchorPane;

    @FXML
    private JFXTextField AddPatientFirstName;

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
    private JFXComboBox<String> AddPatientBloodGroup;

    @FXML
    private JFXButton CreateAPatient;

    @FXML
    private JFXTextField AddPatientUsername;

    @FXML
    private JFXTextArea PatientAddAllergies;

    @FXML
    private JFXTextField EditPatientUsername;

    @FXML
    private JFXTextField AddPatientCountry;

    @FXML
    private JFXButton EditPatientAccount;

    @FXML
    private BorderPane EditPatientBorderPane;

    @FXML
    private JFXTextField ViewPatientUsername;

    @FXML
    private JFXButton ViewPatientAccount;

    @FXML
    private BorderPane ViewPatientBorderPane;

    @FXML
    void Add_Patient(MouseEvent event) {
        try{
            ValidationController validate = new ValidationController(RecepAddPatientStackPane, RecepAddPatientAnchorPane,
                    4);
            if(        validate.validateNIC(AddPatientIDCardNumber)
                    && validate.validatePhone(AddPatientPhoneNumber)
                    && validate.validateUsername(AddPatientUsername)
                    && validate.sameIDNo(AddPatientIDCardNumber)
                    && validate.samePhoneNumber(AddPatientPhoneNumber)){

                Patient newPatient = new Patient();

                newPatient.setFirstName(AddPatientFirstName.getText().trim());
                newPatient.setLastName(AddPatientLastName.getText().trim());
                newPatient.setUserName(AddPatientUsername.getText().trim());
                newPatient.setIdNo(AddPatientIDCardNumber.getText().trim());
                newPatient.setPassword(AddPatientIDCardNumber.getText().trim());
                newPatient.setGender(AddPatientGender.getValue());
                newPatient.setPhoneNumber(AddPatientPhoneNumber.getText().trim());
                newPatient.setMaritalStatus(AddPatientMaritalStatus.getValue());
                newPatient.setDOB(AddPatientDOB.getValue());
                newPatient.setAddressLine1(AddPatientAddressLine1.getText().trim());
                newPatient.setAddressLine2(AddPatientAddressLine2.getText().trim());
                newPatient.setCity(AddPatientCity.getText().trim());
                newPatient.setCountry(AddPatientCountry.getText().trim());
                newPatient.setBloodGroup(AddPatientBloodGroup.getValue());
                newPatient.setAllergies(GetSetTextArea.getText(PatientAddAllergies.getText().trim()));
                newPatient.setProfilePicPath("src/sample/app/profile/default-profile-picture.png");

                UserAdd.writeToFile(newPatient, 2);
                validate.successfulUserCreation("Patient Account Successfully Created");
                clearFields();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void Edit_Patient(MouseEvent event) throws IOException {
        ValidationController validatePatientEditAccount = new ValidationController(RecepAddPatientStackPane,
                RecepAddPatientAnchorPane, 4);
        if(!EditPatientUsername.getText().isEmpty()){
            if (validatePatientEditAccount.validateEditUsername(EditPatientUsername, 2)) {
                PatientUsername = EditPatientUsername.getText().trim();
                Parent editUserAccount = FXMLLoader.load(getClass()
                        .getResource("/sample/view/RecepEditPatient.fxml"));
                EditPatientBorderPane.setCenter(editUserAccount);
                clearFields();
            } else {
                validatePatientEditAccount.detailedMsg("User Not Found",
                        "Username that you've entered is not in Patient Database");
            }
        }else{
            validatePatientEditAccount.detailedMsg("Invalid Input Data",
                    "Please Enter valid username and try again.");
        }
    }

    @FXML
    void View_Patient(MouseEvent event) throws IOException {
        ValidationController validatePatientViewAccount = new ValidationController(RecepAddPatientStackPane,
                RecepAddPatientAnchorPane, 4);
        if(!ViewPatientUsername.getText().isEmpty()){
            if (validatePatientViewAccount.validateEditUsername(ViewPatientUsername, 2)) {
                PatientUsername = ViewPatientUsername.getText().trim();
                Parent editUserAccount = FXMLLoader.load(getClass()
                        .getResource("/sample/view/RecepViewPatient.fxml"));
                EditPatientBorderPane.setCenter(editUserAccount);
                clearFields();
            } else {
                validatePatientViewAccount.detailedMsg("User Not Found",
                        "Username that you've entered is not in Patient Database");
            }
        }else{
            validatePatientViewAccount.detailedMsg("Invalid Input Data",
                    "Please Enter valid username and try again.");
        }
    }

    @FXML
    void initialize() {
        // combo-box items for gender at create user account
        AddPatientGender.getItems().add("Male");
        AddPatientGender.getItems().add("Female");

        // combo-box items for marital status at create user account
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

    void clearFields(){
        AddPatientFirstName.clear();
        AddPatientLastName.clear();
        AddPatientUsername.clear();
        AddPatientIDCardNumber.clear();
        AddPatientGender.getSelectionModel().clearSelection();
        AddPatientPhoneNumber.clear();
        AddPatientMaritalStatus.getSelectionModel().clearSelection();
        AddPatientDOB.getEditor().clear();
        AddPatientAddressLine1.clear();
        AddPatientAddressLine2.clear();
        AddPatientCity.clear();
        AddPatientBloodGroup.getSelectionModel().clearSelection();
        PatientAddAllergies.clear();
        EditPatientUsername.clear();
        ViewPatientUsername.clear();
    }
}
