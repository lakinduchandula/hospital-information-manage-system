package sample.controller;

import com.jfoenix.controls.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import sample.model.*;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ReceptDashComplaintController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    public static String ComplaintIDGlobal;

    @FXML
    private StackPane AddComplaintStackPane;

    @FXML
    private AnchorPane AddComplaintAnchorPane;

    @FXML
    private JFXComboBox<String> AddComplaintType;

    @FXML
    private JFXTextField AddComplaintFirstName;

    @FXML
    private JFXTextField AddComplaintPhoneNum;

    @FXML
    private JFXDatePicker AddComplaintDate;

    @FXML
    private JFXTextArea AddComplaintDescription;

    @FXML
    private JFXTextField AddComplaintActionTaken;

    @FXML
    private JFXTextField AddComplaintAttachDoc;

    @FXML
    private JFXButton AddComplaintAttachBtn;

    @FXML
    private JFXButton AddComplaintBtn;

    @FXML
    private BorderPane ViewComplaintBorderPane;

    @FXML
    private AnchorPane ViewComplaintAnchorPane;

    @FXML
    private JFXTextField AddComplaintUsername;

    @FXML
    private JFXTextField AddComplaintLastName;

    @FXML
    private JFXTextField AddComplaintIDNum;

    @FXML
    private Label AddComplaintID;

    @FXML
    private JFXTextField ViewComplaintID;

    @FXML
    private JFXButton ViewComplaintBtn;


    @FXML
    void Add_Complaint(MouseEvent event) {
        ValidationController validate = new ValidationController(AddComplaintStackPane, AddComplaintAnchorPane,
                4);
        if(        !(AddComplaintType.getValue() == null)
                && !(AddComplaintActionTaken.getText().isEmpty())
                && !(AddComplaintDate.getValue() == null)
                && !(AddComplaintUsername.getText() == null)
                && !(AddComplaintFirstName.getText() == null)
                && !(AddComplaintLastName.getText() == null)
                && !(AddComplaintIDNum.getText() == null)
                && !(AddComplaintPhoneNum.getText() == null)
                && !(AddComplaintDescription.getText() == null)){
            try {
                if (validate.validateNIC(AddComplaintIDNum)
                        && validate.validatePhone(AddComplaintPhoneNum)
                        && validate.validateExitingPatientUsername(AddComplaintUsername)
                ) {

                    ComplaintRecord newComplaintRecord = new ComplaintRecord();
                    Patient newPatient = new Patient();

                    newComplaintRecord.setFirstName(AddComplaintFirstName.getText().trim());
                    newComplaintRecord.setLastName(AddComplaintLastName.getText().trim());
                    newComplaintRecord.setUsername(AddComplaintUsername.getText().trim());
                    newComplaintRecord.setIdNum(AddComplaintIDNum.getText().trim());
                    newComplaintRecord.setPhoneNum(AddComplaintPhoneNum.getText().trim());
                    newComplaintRecord.setComplaintID(AddComplaintID.getText().trim());
                    newComplaintRecord.setCurrentDate(AddComplaintDate.getValue());
                    newComplaintRecord.setComplaintType(AddComplaintType.getValue());
                    newComplaintRecord.setDescription(GetSetTextArea.getText(AddComplaintDescription.getText().trim()));
                    newComplaintRecord.setActionTaken(AddComplaintActionTaken.getText().trim());
                    newComplaintRecord.setPatientGhostID(newPatient.getPatientGhostID(AddComplaintUsername.getText().trim()));

                    ReceptAddComplaint.writeToFile(newComplaintRecord);
                    validate.successfulUserCreation("Complaint Record Successfully Created");
                    clearFields();

                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        validate.detailedMsg("Missing Data", "Some fields are empty fill those and try again.");
    }

    public void clearFields() {
        AddComplaintFirstName.clear();
        AddComplaintLastName.clear();
        AddComplaintUsername.clear();
        AddComplaintIDNum.clear();
        AddComplaintPhoneNum.clear();
        AddComplaintID.setText(RandomID.getUniqueId());
       // AddComplaintID.clear():
        AddComplaintDate.getEditor().clear();
        AddComplaintType.getSelectionModel().clearSelection();
        AddComplaintDescription.clear();
        AddComplaintActionTaken.clear();
        ViewComplaintID.clear();
    }
    @FXML
    void initialize() {

        AddComplaintDate.setValue(java.time.LocalDate.now());
        AddComplaintID.setText(RandomID.getUniqueId());

        // add items to complaint type
        AdReference.readItem(AddComplaintType, 1);

    }

    @FXML
    void View_Complaint(MouseEvent event) throws IOException {
        ValidationController complaintValidationID = new ValidationController(AddComplaintStackPane,
                AddComplaintAnchorPane, 4);
        if(complaintValidationID.complaintValidationID(ViewComplaintID)){
            ComplaintIDGlobal = ViewComplaintID.getText().trim();
            Parent complaintPane = FXMLLoader.load(getClass().getResource("/sample/view/RecepViewComplaint.fxml"));
            ViewComplaintBorderPane.setCenter(complaintPane);
            clearFields();
        }
    }
}
