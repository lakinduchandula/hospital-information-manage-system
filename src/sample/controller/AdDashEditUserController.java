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
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import sample.model.Receptionist;
import sample.model.UserAdd;

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
    private JFXButton CreateAReceptionist;

    @FXML
    void edit_user_account(MouseEvent event) throws IOException {
        Parent editUserAccount = FXMLLoader.load(getClass().getResource("/sample/view/EditReceptionistAccount.fxml"));
        EditUserEditBoarderPane.setCenter(editUserAccount);
    }

    public AdDashEditUserController() {
    }

    @FXML
    void createAReceptionist(MouseEvent event) {
        try{
            ValidationController validate = new ValidationController(EditUserStackPane, EditUserAnchor);
            if(validate.validateNIC(EditUserIDCardNumber) && validate.validatePhone(EditUserPhoneNumber)) {
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
                System.out.println("Receptionist User Created");
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

        // add receptionist


    }
}
