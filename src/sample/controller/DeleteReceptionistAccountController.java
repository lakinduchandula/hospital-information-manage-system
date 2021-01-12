package sample.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import sample.model.UserEditDelete;

public class DeleteReceptionistAccountController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private StackPane DeleteRecepStackPane;

    @FXML
    private BorderPane DeleteRecepBorder;

    @FXML
    private AnchorPane DeleteRecepAnchor;

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
    private Label ViewUserRecepID;

    @FXML
    private Label ViewUserRecepEmail;

    @FXML
    private Label ViewUserDateOfJoin;

    @FXML
    private Label ViewUserPassword;

    @FXML
    private JFXButton DeleteAccount;


    @FXML
    void DeleteRecepAccount(MouseEvent event) throws IOException {
        UserEditDelete newDeleteProfile = new UserEditDelete(0);
        ValidationController deleteValidate = new ValidationController(DeleteRecepStackPane, DeleteRecepAnchor, 1);
        deleteValidate.detailedMsg("Account Delete", "Receptionist Account was Successfully Deleted");
        newDeleteProfile.UserDelete(AdDashEditUserController.username);
        afterCreation();
    }

    public void afterCreation() throws IOException {
        Parent white = FXMLLoader.load(getClass()
                .getResource("/sample/view/WhiteBlank.fxml"));
        DeleteRecepBorder.setCenter(white);
    }

    @FXML
    void initialize() {
        UserEditDelete newViewProfile = new UserEditDelete(0);
        newViewProfile.UserEdit(AdDashEditUserController.username);
        String[] RecepDetails = newViewProfile.getUserDetailArray();
        ViewUserUsername.setText(RecepDetails[0]);
        ViewUserPassword.setText(RecepDetails[1]);
        ViewUserFirstName.setText(RecepDetails[2]);
        ViewUserLastName.setText(RecepDetails[3]);
        ViewUserIDNo.setText(RecepDetails[4]);
        ViewUserPhoneNumber.setText(RecepDetails[5]);
        ViewUserGender.setText(RecepDetails[6]);
        ViewUserDOB.setText(RecepDetails[7]);
        ViewUserMatrital.setText(RecepDetails[8]);
        ViewUserAddNo.setText(RecepDetails[9]);
        ViewUserAddStreet.setText(RecepDetails[10]);
        ViewUserCity.setText(RecepDetails[11]);
        ViewUserCountry.setText(RecepDetails[12]);
        ViewUserRecepID.setText(RecepDetails[14]);
        ViewUserRecepEmail.setText(RecepDetails[15]);
        ViewUserDateOfJoin.setText(RecepDetails[16]);
    }
}
