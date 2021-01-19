package sample.controller;

import com.jfoenix.controls.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import sample.model.*;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import static java.time.LocalDate.parse;

public class RecepEditPatientController {

    private String[] userDetailArray ;

    public void setUserDetailArray(String[] userDetailArray){
        this.userDetailArray = userDetailArray;
    }

    public String[] getUserDetailArray(){
        return userDetailArray;
    }

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private StackPane EditPatientStackPane;

    @FXML
    private BorderPane EditPatientBorderPane;

    @FXML
    private AnchorPane EditPatientAnchorPane;

    @FXML
    private JFXTextField EditPatientFirstName;

    @FXML
    private JFXTextField EditPatientLastName;

    @FXML
    private JFXTextField EditPatientIDCardNumber;

    @FXML
    private JFXComboBox<String> EditPatientMaritalStatus;

    @FXML
    private JFXTextField EditPatientPhoneNumber;

    @FXML
    private JFXTextField EditPatientAddressLine1;

    @FXML
    private JFXTextField EditPatientAddressLine2;

    @FXML
    private JFXTextField EditPatientCity;

    @FXML
    private JFXButton EditPatientSaveChange;

    @FXML
    private JFXTextField EditUserEditCountry;

    @FXML
    private JFXTextArea EditPatientAllergies;

    @FXML
    private JFXTextField EditPatientUsername;

    @FXML
    private JFXTextField EditPatientEditPassword;

    @FXML
    void SaveChanges(MouseEvent event) {
        try{
            UserEditDelete newEditProfile = new UserEditDelete(1);
            newEditProfile.UserDelete(RecepDashPatientController.PatientUsername);
            ValidationController validate = new ValidationController(EditPatientStackPane, EditPatientAnchorPane,
                    4);
            if(        validate.validatePhone(EditPatientPhoneNumber)
                    && validate.validateUsername(EditPatientUsername)
                    && validate.sameIDNo(EditPatientIDCardNumber)
                    && validate.samePhoneNumber(EditPatientPhoneNumber)){

                Patient editPatient = new Patient();

                editPatient.setFirstName(EditPatientFirstName.getText().trim());
                editPatient.setLastName(EditPatientLastName.getText().trim());
                editPatient.setUserName(EditPatientUsername.getText().trim());
                editPatient.setIdNo(EditPatientIDCardNumber.getText().trim());
                editPatient.setPassword(EditPatientEditPassword.getText().trim());
                editPatient.setGender(getUserDetailArray()[6]);
                editPatient.setPhoneNumber(EditPatientPhoneNumber.getText().trim());
                editPatient.setMaritalStatus(EditPatientMaritalStatus.getValue());
                editPatient.setDOB(LocalDate.parse(getUserDetailArray()[7]));
                editPatient.setAddressLine1(EditPatientAddressLine1.getText().trim());
                editPatient.setAddressLine2(EditPatientAddressLine2.getText().trim());
                editPatient.setCity(EditPatientCity.getText().trim());
                editPatient.setCountry(EditUserEditCountry.getText().trim());
                editPatient.setProfilePicPath(getUserDetailArray()[13]);
                editPatient.setBloodGroup(getUserDetailArray()[14]);
                editPatient.setAllergies(GetSetTextArea.getText(EditPatientAllergies.getText().trim()));
                editPatient.setGhostUniqueID(getUserDetailArray()[16]);

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
        // combo-box items for marital status at edit account
        EditPatientMaritalStatus.getItems().add("Unmarried");
        EditPatientMaritalStatus.getItems().add("Married");
        EditPatientMaritalStatus.getItems().add("Divorced");
        EditPatientMaritalStatus.getItems().add("Widowed");
        EditPatientMaritalStatus.getItems().add("Legally Separated");

        UserEditDelete newEditProfile = new UserEditDelete(1);
        newEditProfile.UserEdit(RecepDashPatientController.PatientUsername);
        String[] PatientDetails = newEditProfile.getUserDetailArray();
        setUserDetailArray(PatientDetails);
        EditPatientUsername.setText(PatientDetails[0]);
        EditPatientEditPassword.setText(PatientDetails[1]);
        EditPatientFirstName.setText(PatientDetails[2]);
        EditPatientLastName.setText(PatientDetails[3]);
        EditPatientIDCardNumber.setText(PatientDetails[4]);
        EditPatientPhoneNumber.setText(PatientDetails[5]);
        EditPatientMaritalStatus.setValue(PatientDetails[8]);
        EditPatientAddressLine1.setText(PatientDetails[9]);
        EditPatientAddressLine2.setText(PatientDetails[10]);
        EditPatientCity.setText(PatientDetails[11]);
        EditUserEditCountry.setText(PatientDetails[12]);
        EditPatientAllergies.setText(GetSetTextArea.setText(PatientDetails[15]));
    }


}
