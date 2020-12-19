package sample.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;

public class EditMOAccountController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

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
    private JFXComboBox<?> EditUserEditMaritalStatus;

    @FXML
    private JFXTextField EditUserEditAddCity;

    @FXML
    private JFXTextField EditUserEditAddCountry;

    @FXML
    private JFXTextField EditUserEditRecepStaffID;

    @FXML
    private JFXTextField EditUserEditRecepEmail;

    @FXML
    private JFXButton EditUserMOSaveChange;

    @FXML
    private JFXComboBox<?> EditUserMOSpecificArea;

    @FXML
    void edit_user_account(MouseEvent event) {

    }

    @FXML
    void initialize() {


    }
}
