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
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import sample.model.*;

public class PatientDashComplaintController {

    public static String complaintID;

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
    private AnchorPane PatientDashAnchor;

    @FXML
    private JFXTextField ComplaintViewID;

    @FXML
    private JFXTextField ComplaintAddAddiPhone;

    @FXML
    void MakeAComplaint(MouseEvent event) {
        System.out.println("work");
        ValidationController validate = new ValidationController(PatientDashComplaint, PatientDashAnchor,
                3);
        if(        !(ComplaintAddCompType.getValue() == null)
                && !(ComplaintAddDate.getValue() == null)
                && !(ComplaintAddCompDisc.getText() == null)){
            try {
                {
                    Patient newPatient = new Patient();
                    ComplaintRecord newComplaintRecord = new ComplaintRecord();

                    newComplaintRecord.setFirstName(ComplaintAddFirstName.getText().trim());
                    newComplaintRecord.setLastName(ComplaintAddLastName.getText().trim());
                    newComplaintRecord.setUsername(ComplaintAddUsername.getText().trim());
                    newComplaintRecord.setIdNum(ComplaintAddID.getText().trim());
                    newComplaintRecord.setPhoneNum(ComplaintAddUserPhone.getText().trim());
                    newComplaintRecord.setComplaintID(ComplaintAddCompID.getText().trim());
                    newComplaintRecord.setCurrentDate(ComplaintAddDate.getValue());
                    newComplaintRecord.setComplaintType(ComplaintAddCompType.getValue());
                    newComplaintRecord.setDescription(GetSetTextArea.getText(ComplaintAddCompDisc.getText().trim()));
                    newComplaintRecord.setActionTaken("No Action");
                    newComplaintRecord.setPatientGhostID(newPatient.getPatientGhostID(ComplaintAddUsername.getText().trim()));

                    ReceptAddComplaint.writeToFile(newComplaintRecord);
                    validate.successfulUserCreation("Complaint Record Successfully Created");
                    clearFields();

                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            validate.detailedMsg("Missing Data", "Some fields are empty fill those and try again.");
        }
    }

    void clearFields() {
        ComplaintAddAddiPhone.clear();
        ComplaintAddCompType.getSelectionModel().clearSelection();
        ComplaintAddDate.getEditor().clear();
        ComplaintAddCompDisc.clear();
        ComplaintAddCompID.setText(RandomID.getUniqueId());
    }

    @FXML
    void ViewComplaint(MouseEvent event) throws IOException {
        ValidationController validate = new ValidationController(PatientDashComplaint, PatientDashAnchor,
                3);
        if(validate.ValidNotEmpty(ComplaintViewID)){
            if(validate.correctComplaint(LoginController.currentUser ,ComplaintViewID)){
                complaintID = ComplaintViewID.getText().trim();
                Parent complaint = FXMLLoader.load(getClass().getResource("/sample/view/ViewComplaint.fxml"));
                ComplaintBorderPane.setCenter(complaint);
            }
            ComplaintViewID.clear();
        }else {
            validate.detailedMsg("Invalid Input Data", "Complaint ID is empty");
        }
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

        // add random unique id to the complaint
        ComplaintAddCompID.setText(RandomID.getUniqueId());

        // add current time to the label
        ComplaintAddDate.setValue(java.time.LocalDate.now());

        // add items to the complaint type
        AdReference.readItem(ComplaintAddCompType, 1);
    }

    public void edit_user_account(MouseEvent mouseEvent) {
    }
}
