package sample.controller;

import com.jfoenix.controls.JFXButton;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import sample.model.UserEditDelete;

public class DeleteMOAccountController {

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
    private Label ViewUserStaffID;

    @FXML
    private Label ViewUserPassword;

    @FXML
    private JFXButton DeleteAccount;

    @FXML
    private Label ViewUserStaffEmail;

    @FXML
    private Label ViewUserDOF;

    @FXML
    private Label ViewUserSpecialArea;

    @FXML
    void DeleteMOAccount(MouseEvent event) throws IOException {
        UserEditDelete newDeleteProfile = new UserEditDelete(2);
        ValidationController deleteValidate = new ValidationController(DeletePatientStackPane, DeletePatientAnchor, 1);
        deleteValidate.detailedMsg("Account Delete", "Medical Officer Account was Successfully Deleted");
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
        UserEditDelete newViewProfile = new UserEditDelete(2);
        newViewProfile.UserEdit(AdDashEditUserController.username);
        String[] MODetails = newViewProfile.getUserDetailArray();
        ViewUserUsername.setText(MODetails[0]);
        ViewUserPassword.setText(MODetails[1]);
        ViewUserFirstName.setText(MODetails[2]);
        ViewUserLastName.setText(MODetails[3]);
        ViewUserIDNo.setText(MODetails[4]);
        ViewUserPhoneNumber.setText(MODetails[5]);
        ViewUserGender.setText(MODetails[6]);
        ViewUserDOB.setText(MODetails[7]);
        ViewUserMatrital.setText(MODetails[8]);
        ViewUserAddNo.setText(MODetails[9]);
        ViewUserAddStreet.setText(MODetails[10]);
        ViewUserCity.setText(MODetails[11]);
        ViewUserCountry.setText(MODetails[12]);
        ViewUserStaffID.setText(MODetails[14]);
        ViewUserStaffEmail.setText(MODetails[15]);
        ViewUserDOF.setText(MODetails[16]);
        ViewUserSpecialArea.setText(MODetails[17]);
    }
}
