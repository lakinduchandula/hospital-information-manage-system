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
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import sample.model.RandomID;
import sample.model.UserEditDelete;

public class PatientDashComplaintController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private StackPane PatientDashComplaint;

    @FXML
    private BorderPane ComplaintBorderPane;

    @FXML
    private Label ComplaintAddUsername;

    @FXML
    private Label ComplaintAddFirstName;

    @FXML
    private Label ComplaintAddID;

    @FXML
    private Label ComplaintAddLastName;

    @FXML
    private Label ComplaintAddUserPhone;

    @FXML
    private Label ComplaintAddCompID;

    @FXML
    private JFXDatePicker ComplaintAddDate;

    @FXML
    private JFXComboBox<String> ComplaintAddCompType;

    @FXML
    private JFXTextArea ComplaintAddCompDisc;

    @FXML
    private JFXButton MakeAComplaint;

    @FXML
    private JFXTextField ComplaintAddAddiPhone;

    @FXML
    void MakeAComplaint(MouseEvent event) {

    }

    @FXML
    void ViewComplaint(MouseEvent event) throws IOException {
        Parent complaint = FXMLLoader.load(getClass().getResource("/sample/view/ViewComplaint.fxml"));
        ComplaintBorderPane.setCenter(complaint);
    }

    @FXML
    void initialize() {
        UserEditDelete patientUserDetails = new UserEditDelete(1);
        patientUserDetails.UserEdit(LoginController.currentUser);
        String[] PatientDetails = patientUserDetails.getUserDetailArray();

        ComplaintAddFirstName.setText(PatientDetails[2]);
        ComplaintAddLastName.setText(PatientDetails[3]);
        ComplaintAddUsername.setText(PatientDetails[0]);
        ComplaintAddUserPhone.setText(PatientDetails[5]);
        ComplaintAddID.setText(PatientDetails[4]);

        ComplaintAddCompID.setText(RandomID.getUniqueId());

        ComplaintAddDate.setValue(java.time.LocalDate.now());
    }

    public void edit_user_account(MouseEvent mouseEvent) {
    }
}
