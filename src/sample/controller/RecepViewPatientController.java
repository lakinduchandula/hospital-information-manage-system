package sample.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import sample.model.UserEditDelete;

public class RecepViewPatientController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

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
    private Label ViewUserPassword;

    @FXML
    private ScrollPane ViewUserAllergiesScroll;

    @FXML
    private Text ViewUserAllergies;

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
        ViewUserAllergies.setText(PatientDetails[15]);

    }
}
