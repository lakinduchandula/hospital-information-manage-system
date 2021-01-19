package sample.controller;

import com.jfoenix.controls.JFXButton;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import sample.model.GetSetTextArea;
import sample.model.UserEditDelete;

public class DeletePatientAccountController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ScrollPane ViewUserAllergiesScroll;

    @FXML
    private StackPane DeletePatientStackPane;

    @FXML
    private BorderPane DeletePatientBorder;

    @FXML
    private AnchorPane DeletePatientAnchor;

    @FXML
    private Label ViewUserFirstName;

    @FXML
    private Label ViewUserLastName;

    @FXML
    private Label ViewUserUsername;

    @FXML
    private Label ViewUserIDNo;

    @FXML
    private Label ViewUserGender;

    @FXML
    private Label ViewUserPhoneNumber;

    @FXML
    private Label ViewUserMatrital;

    @FXML
    private Label ViewUserDOB;

    @FXML
    private Label ViewUserAddStreet;

    @FXML
    private Label ViewUserAddNo;

    @FXML
    private Label ViewUserCountry;

    @FXML
    private Label ViewUserCity;

    @FXML
    private Label ViewUserBloodGroup;

    @FXML
    private Text ViewUserAllergies;

    @FXML
    private Label ViewUserPassword;

    @FXML
    private JFXButton DeleteAccount;

    @FXML
    void DeletePatientAccount(MouseEvent event) throws IOException {
        UserEditDelete newDeleteProfile = new UserEditDelete(1);
        ValidationController deleteValidate = new ValidationController(DeletePatientStackPane, DeletePatientAnchor, 1);
        deleteValidate.detailedMsg("Account Delete", "Patient Account was Successfully Deleted");
        newDeleteProfile.UserDelete(AdDashEditUserController.username);
        afterCreation();
    }

    public void afterCreation() throws IOException {
        Parent white = FXMLLoader.load(getClass()
                .getResource("/sample/view/WhiteBlank.fxml"));
        DeletePatientBorder.setCenter(white);
    }

    @FXML
    void initialize() {
        UserEditDelete newViewProfile = new UserEditDelete(1);
        newViewProfile.UserEdit(AdDashEditUserController.username);
        String[] PatientDetails = newViewProfile.getUserDetailArray();

        ViewUserUsername.setText(PatientDetails[0]);
        ViewUserPassword.setText(PatientDetails[1]);
        ViewUserFirstName.setText(PatientDetails[2]);
        ViewUserLastName.setText(PatientDetails[3]);
        ViewUserIDNo.setText(PatientDetails[4]);
        ViewUserPhoneNumber.setText(PatientDetails[5]);
        ViewUserGender.setText(PatientDetails[6]);
        ViewUserDOB.setText(PatientDetails[7]);
        ViewUserMatrital.setText(PatientDetails[8]);
        ViewUserAddNo.setText(PatientDetails[9]);
        ViewUserAddStreet.setText(PatientDetails[10]);
        ViewUserCity.setText(PatientDetails[11]);
        ViewUserCountry.setText(PatientDetails[12]);
        ViewUserBloodGroup.setText(PatientDetails[14]);
        ViewUserAllergies.setText(GetSetTextArea.setText(PatientDetails[15]));
    }
}
