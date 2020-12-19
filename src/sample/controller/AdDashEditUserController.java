package sample.controller;

import com.jfoenix.controls.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Tab;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import sample.model.*;

public class AdDashEditUserController {

    @FXML
    private StackPane EditUserStackPane;

    @FXML
    private AnchorPane EditUserAnchor;

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
    private JFXComboBox<String> EditUserMOSpecificArea ;

    @FXML
    private JFXTextField EditUserMOStaffID;

    @FXML
    private JFXTextField EditUserMOStaffEmail;

    @FXML
    private JFXDatePicker EditUserMODateofJoin;

    @FXML
    private Tab PatientTab;

    @FXML
    private JFXComboBox<String> EditUserPatientBlood;

    @FXML
    private JFXTextField EditUserAddAllergiesLine1;

    @FXML
    private JFXTextField EditUserAddAllergiesLine2;

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
    private JFXButton CreateAReceptionist;

    @FXML
    private JFXButton CreateAPatient;

    @FXML
    void edit_user_account(MouseEvent event) throws IOException {
        // get the validity of the username according to the usermode
        ValidationController validateUserAccount = new ValidationController(EditUserStackPane, EditUserAnchor, 1);
        if (validateUserAccount.validateEmpty(EditUserEditUsername) && !(EditUserEditUsermode.getSelectionModel().isEmpty()) ) {
            switch (EditUserEditUsermode.getValue()) {
                case "Receptionist": {
                    if (validateUserAccount.validateEditUsername(EditUserEditUsername)) {
                        Parent editUserAccount = FXMLLoader.load(getClass()
                                .getResource("/sample/view/EditReceptionistAccount.fxml"));
                        EditUserEditBoarderPane.setCenter(editUserAccount);
                    } else {
                        validateUserAccount.detailedMsg("User Not Found",
                                "Username that you've entered is not in Receptionist Database");
                    }
                    break;
                }
                case "Patient": {
                    if (validateUserAccount.validateEditUsername(EditUserEditUsername)) {
                        Parent editUserAccount = FXMLLoader.load(getClass()
                                .getResource("/sample/view/EditPatientAccount.fxml"));
                        EditUserEditBoarderPane.setCenter(editUserAccount);
                    } else {
                        validateUserAccount.detailedMsg("User Not Found",
                                "Username that you've entered is not in Patient Database");
                    }
                    break;
                }
                case "Medical Officer": {
                    if (validateUserAccount.validateEditUsername(EditUserEditUsername)) {
                        Parent editUserAccount = FXMLLoader.load(getClass()
                                .getResource("/sample/view/EditMOAccount.fxml"));
                        EditUserEditBoarderPane.setCenter(editUserAccount);
                    } else {
                        validateUserAccount.detailedMsg("User Not Found",
                                "Username that you've entered is not in Medical Officer Database");
                    }
                    break;
                }
            }
        } else {
            validateUserAccount.detailedMsg("Input Data",
                    "Please Enter valid username and it's usermode\n" +
                            "to Edit User Account.");
        }

    }

    public AdDashEditUserController() {
    }

    @FXML
    void createAReceptionist(MouseEvent event) {
        try{
            ValidationController validate = new ValidationController(EditUserStackPane, EditUserAnchor, 1);
            if(        validate.validateNIC(EditUserIDCardNumber)
                    && validate.validEmail(EditUserRecepEmail)
                    && validate.validatePhone(EditUserPhoneNumber)
                    && validate.validateUsername(EditUserUsername)
                    && validate.sameIDNo(EditUserIDCardNumber)
                    && validate.samePhoneNumber(EditUserPhoneNumber)
                    && validate.sameStaffID(EditUserRecepStaffID)
                    && validate.sameStaffEmail(EditUserRecepEmail)){

                Receptionist newReceptionist = new Receptionist();

                newReceptionist.setFirstName(EditUserFirstName.getText().trim());
                newReceptionist.setLastName(EditUserLastName.getText().trim());
                newReceptionist.setUserName(EditUserUsername.getText().trim());
                newReceptionist.setIdNo(EditUserIDCardNumber.getText().trim());
                newReceptionist.setPassword(EditUserIDCardNumber.getText().trim());
                newReceptionist.setGender(EditUserGender.getValue());
                newReceptionist.setPhoneNumber(EditUserPhoneNumber.getText().trim());
                newReceptionist.setMaritalStatus(EditUserMaritalStatus.getValue());
                newReceptionist.setDOB(EditUserDOB.getValue());
                newReceptionist.setAddressLine1(EditUserAddLine1.getText().trim());
                newReceptionist.setAddressLine2(EditUserAddLine2.getText().trim());
                newReceptionist.setCity(EditUserAddCity.getText().trim());
                newReceptionist.setCountry(EditUserAddCountry.getText().trim());
                newReceptionist.setStaffID(EditUserRecepStaffID.getText().trim());
                newReceptionist.setStaffEmail(EditUserRecepEmail.getText().trim());
                newReceptionist.setDateOfJoin(EditUserDateofJoin.getValue());

                UserAdd.writeToFile(newReceptionist, 1);
                validate.successfulUserCreation("Receptionist Account Successfully Created");
                clearFields();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @FXML
    void CreateAPatient(MouseEvent event) {
        try{
            ValidationController validate = new ValidationController(EditUserStackPane, EditUserAnchor, 1);
            if(        validate.validateNIC(EditUserIDCardNumber)
                    && validate.validEmail(EditUserRecepEmail)
                    && validate.validatePhone(EditUserPhoneNumber)
                    && validate.validateUsername(EditUserUsername)
                    && validate.sameIDNo(EditUserIDCardNumber)
                    && validate.samePhoneNumber(EditUserPhoneNumber)
                    && validate.sameStaffID(EditUserRecepStaffID)
                    && validate.sameStaffEmail(EditUserRecepEmail)){

                Patient newPatient = new Patient();

                newPatient.setFirstName(EditUserFirstName.getText().trim());
                newPatient.setLastName(EditUserLastName.getText().trim());
                newPatient.setUserName(EditUserUsername.getText().trim());
                newPatient.setIdNo(EditUserIDCardNumber.getText().trim());
                newPatient.setPassword(EditUserIDCardNumber.getText().trim());
                newPatient.setGender(EditUserGender.getValue());
                newPatient.setPhoneNumber(EditUserPhoneNumber.getText().trim());
                newPatient.setMaritalStatus(EditUserMaritalStatus.getValue());
                newPatient.setDOB(EditUserDOB.getValue());
                newPatient.setAddressLine1(EditUserAddLine1.getText().trim());
                newPatient.setAddressLine2(EditUserAddLine2.getText().trim());
                newPatient.setCity(EditUserAddCity.getText().trim());
                newPatient.setCountry(EditUserAddCountry.getText().trim());
                newPatient.setBloodGroup(EditUserPatientBlood.getValue());
                newPatient.setAllergiesLine1(EditUserAddAllergiesLine1.getText().trim());
                newPatient.setAllergiesLine2(EditUserAddAllergiesLine2.getText().trim());

                UserAdd.writeToFile(newPatient, 2);
                validate.successfulUserCreation("Patient Account Successfully Created");
                clearFields();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void createAMedicalOfficer(MouseEvent event) {
        try{
            ValidationController validate = new ValidationController(EditUserStackPane, EditUserAnchor, 1);
            if (               validate.validateNIC(EditUserIDCardNumber)
                            && validate.validEmail(EditUserMOStaffEmail)
                            && validate.validatePhone(EditUserPhoneNumber)
                            && validate.validateUsername(EditUserUsername)
                            && validate.sameIDNo(EditUserIDCardNumber)
                            && validate.samePhoneNumber(EditUserPhoneNumber)
                            && validate.sameStaffID(EditUserMOStaffID)
                            && validate.sameStaffEmail(EditUserMOStaffEmail)
            ) {
                MedicalOfficer newMedicalOfficer = new MedicalOfficer();

                newMedicalOfficer.setFirstName(EditUserFirstName.getText().trim());
                newMedicalOfficer.setLastName(EditUserLastName.getText().trim());
                newMedicalOfficer.setUserName(EditUserUsername.getText().trim());
                newMedicalOfficer.setIdNo(EditUserIDCardNumber.getText().trim());
                newMedicalOfficer.setPassword(EditUserIDCardNumber.getText().trim());
                newMedicalOfficer.setGender(EditUserGender.getValue());
                newMedicalOfficer.setPhoneNumber(EditUserPhoneNumber.getText().trim());
                newMedicalOfficer.setMaritalStatus(EditUserMaritalStatus.getValue());
                newMedicalOfficer.setDOB(EditUserDOB.getValue());
                newMedicalOfficer.setAddressLine1(EditUserAddLine1.getText().trim());
                newMedicalOfficer.setAddressLine2(EditUserAddLine2.getText().trim());
                newMedicalOfficer.setCity(EditUserAddCity.getText().trim());
                newMedicalOfficer.setCountry(EditUserAddCountry.getText().trim());
                newMedicalOfficer.setStaffID(EditUserMOStaffID.getText().trim());
                newMedicalOfficer.setStaffEmail(EditUserMOStaffEmail.getText().trim());
                newMedicalOfficer.setDateOfJoin(EditUserMODateofJoin.getValue());
                newMedicalOfficer.setSpecialtyArea(EditUserMOSpecificArea.getValue());

                UserAdd.writeToFile(newMedicalOfficer, 3);
                validate.successfulUserCreation("Medical Officer Account Successfully Created");
                clearFields();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
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

        // combo-box items for usermode
        EditUserEditUsermode.getItems().add("Receptionist");
        EditUserEditUsermode.getItems().add("Patient");
        EditUserEditUsermode.getItems().add("Medical Officer");

        // add items to the medical officer specialist areas
        AdReference.readItem(EditUserMOSpecificArea);
    }


    public void clearFields() {
        EditUserFirstName.clear();
        EditUserLastName.clear();
        EditUserUsername.clear();
        EditUserIDCardNumber.clear();
        EditUserGender.getSelectionModel().clearSelection();
        EditUserPhoneNumber.clear();
        EditUserMaritalStatus.getSelectionModel().clearSelection();
        EditUserDOB.getEditor().clear();
        EditUserAddLine1.clear();
        EditUserAddLine2.clear();
        EditUserAddCity.clear();
        EditUserAddCountry.clear();
        EditUserRecepStaffID.clear();
        EditUserRecepEmail.clear();
        EditUserDateofJoin.getEditor().clear();
        EditUserPatientBlood.getEditor().clear();
        EditUserAddAllergiesLine1.clear();
        EditUserAddAllergiesLine2.clear();
        EditUserMOSpecificArea.getSelectionModel().clearSelection();
        EditUserMOStaffID.clear();
        EditUserMODateofJoin.getEditor().clear();
        EditUserMOStaffEmail.clear();

    }
}
