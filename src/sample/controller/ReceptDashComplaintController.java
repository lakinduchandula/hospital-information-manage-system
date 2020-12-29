package sample.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
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
    private JFXTextField AddComplaintDescription;

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
    private JFXTextField AddComplaintAdditionalPhoneNum;

    @FXML
    private JFXTextField ViewComplaintID;

    @FXML
    private JFXButton ViewComplaintBtn;


    @FXML
    void Add_Complaint(MouseEvent event) {
        try{
            ValidationController validate = new ValidationController(AddComplaintStackPane, AddComplaintAnchorPane, 4);
            if(        validate.validateNIC(AddComplaintIDNum)
                    && validate.validatePhone(AddComplaintPhoneNum)
                    && validate.validateUsername(AddComplaintUsername)

            ){

                ComplaintRecord newComplaintRecord = new ComplaintRecord();

                newComplaintRecord.setFirstName(AddComplaintFirstName.getText().trim());
                newComplaintRecord.setLastName(AddComplaintLastName.getText().trim());
                newComplaintRecord.setUsername(AddComplaintUsername.getText().trim());
                newComplaintRecord.setIdNum(AddComplaintIDNum.getText().trim());
                newComplaintRecord.setPhoneNum(AddComplaintPhoneNum.getText().trim());
                newComplaintRecord.setComplaintID(AddComplaintID.getText().trim());
                newComplaintRecord.setCurrentDate(AddComplaintDate.getValue());
                newComplaintRecord.setComplaintType(AddComplaintType.getValue());
                newComplaintRecord.setDescription(AddComplaintDescription.getText().trim());
                newComplaintRecord.setActionTaken(AddComplaintActionTaken.getText().trim());




                ReceptAddComplaint.writeToFile(newComplaintRecord);
                validate.successfulUserCreation("Complaint Record Successfully Created");
                clearFields();

            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public void clearFields() {
        AddComplaintFirstName.clear();
        AddComplaintLastName.clear();
        AddComplaintUsername.clear();
        AddComplaintIDNum.clear();
        AddComplaintPhoneNum.clear();
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
