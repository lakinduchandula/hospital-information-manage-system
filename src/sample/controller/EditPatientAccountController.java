package sample.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import sample.model.*;

public class EditPatientAccountController {

    private String[] userDetailArray ;

    public void setUserDetailArray(String[] userDetailArray){
        this.userDetailArray = userDetailArray;
    }

    public String[] getUserDetailArray(){
        return userDetailArray;
    }

    @FXML
    private StackPane EditPatientStackPane;

    @FXML
    private BorderPane EditPatientBorderPane;

    @FXML
    private AnchorPane EditPatientAnchor;

    @FXML
    private JFXTextField EditUserEditFirstName;

    @FXML
    private JFXTextField EditUserEditLastName;

    @FXML
    private JFXTextField EditUserEditUsername;

    @FXML
    private JFXTextField EditUserEditPhoneNumber;

    @FXML
    private JFXTextField EditUserEditIDCardNumber;

    @FXML
    private JFXTextField EditUserEditAddLine2;

    @FXML
    private JFXTextField EditUserEditAddLine1;

    @FXML
    private JFXComboBox<String> EditUserEditMaritalStatus;

    @FXML
    private JFXTextField EditUserEditAddCity;

    @FXML
    private JFXTextField EditUserEditAddCountry;

    @FXML
    private JFXButton EditUserSaveChange;

    @FXML
    private JFXTextArea EditPatientAllergies;

    @FXML
    private JFXTextField EditUserEditPassword;

    @FXML
    void SaveChanges(MouseEvent event) {
        try{
            UserEditDelete newEditProfile = new UserEditDelete(1);
            newEditProfile.UserDelete(AdDashEditUserController.username);
            ValidationController validate = new ValidationController(EditPatientStackPane, EditPatientAnchor, 1);
            if(        validate.validatePhone(EditUserEditPhoneNumber)
                    && validate.validateUsername(EditUserEditUsername)
                    && validate.sameIDNo(EditUserEditIDCardNumber)
                    && validate.samePhoneNumber(EditUserEditPhoneNumber)){

                Patient editPatient = new Patient();

                editPatient.setFirstName(EditUserEditFirstName.getText().trim());
                editPatient.setLastName(EditUserEditLastName.getText().trim());
                editPatient.setUserName(EditUserEditUsername.getText().trim());
                editPatient.setIdNo(EditUserEditIDCardNumber.getText().trim());
                editPatient.setPassword(EditUserEditPassword.getText().trim());
                editPatient.setGender(getUserDetailArray()[6]);
                editPatient.setPhoneNumber(EditUserEditPhoneNumber.getText().trim());
                editPatient.setMaritalStatus(EditUserEditMaritalStatus.getValue());
                editPatient.setDOB(LocalDate.parse(getUserDetailArray()[7]));
                editPatient.setAddressLine1(EditUserEditAddLine1.getText().trim());
                editPatient.setAddressLine2(EditUserEditAddLine2.getText().trim());
                editPatient.setCity(EditUserEditAddCity.getText().trim());
                editPatient.setCountry(EditUserEditAddCountry.getText().trim());
                editPatient.setProfilePicPath(getUserDetailArray()[13]);
                editPatient.setBloodGroup(getUserDetailArray()[14]);
                editPatient.setAllergies(GetSetTextArea.getText(EditPatientAllergies.getText().trim()));

                UserAdd.writeToFile(editPatient, 2);
                validate.successfulUserCreation("Patient Account Successfully Updated");
                afterCreation();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void afterCreation() throws IOException {
        Parent white = FXMLLoader.load(getClass()
                .getResource("/sample/view/WhiteBlank.fxml"));
        EditPatientBorderPane.setCenter(white);
    }

    @FXML
    void initialize() {
        // combo-box items for marital status at create user account
        EditUserEditMaritalStatus.getItems().add("Unmarried");
        EditUserEditMaritalStatus.getItems().add("Married");
        EditUserEditMaritalStatus.getItems().add("Divorced");
        EditUserEditMaritalStatus.getItems().add("Widowed");
        EditUserEditMaritalStatus.getItems().add("Legally Separated");

        UserEditDelete newEditProfile = new UserEditDelete(1);
        newEditProfile.UserEdit(AdDashEditUserController.username);
        String[] PatientDetails = newEditProfile.getUserDetailArray();
        setUserDetailArray(PatientDetails);
        EditUserEditUsername.setText(PatientDetails[0]);
        EditUserEditPassword.setText(PatientDetails[1]);
        EditUserEditFirstName.setText(PatientDetails[2]);
        EditUserEditLastName.setText(PatientDetails[3]);
        EditUserEditIDCardNumber.setText(PatientDetails[4]);
        EditUserEditPhoneNumber.setText(PatientDetails[5]);
        EditUserEditMaritalStatus.setValue(PatientDetails[8]);
        EditUserEditAddLine1.setText(PatientDetails[9]);
        EditUserEditAddLine2.setText(PatientDetails[10]);
        EditUserEditAddCity.setText(PatientDetails[11]);
        EditUserEditAddCountry.setText(PatientDetails[12]);
        EditPatientAllergies.setText(GetSetTextArea.setText(PatientDetails[15]));
    }
}
