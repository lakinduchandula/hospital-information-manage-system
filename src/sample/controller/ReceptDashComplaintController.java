package sample.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import sample.model.Appointment;
import sample.model.ComplaintRecord;
import sample.model.ReceptAddAppointment;
import sample.model.ReceptAddComplaint;

import java.net.URL;
import java.util.ResourceBundle;

public class ReceptDashComplaintController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

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
    private JFXTextField AddComplaintAttachDoc;

    @FXML
    private JFXButton AddComplaintAttachBtn;

    @FXML
    private JFXButton AddComplaintBtn;

    @FXML
    private JFXTextField AddComplaintActionTaken;

    @FXML
    private JFXTextField AddComplaintUsername;

    @FXML
    private JFXTextField AddComplaintLastName;

    @FXML
    private JFXTextField AddComplaintIDNum;

    @FXML
    private JFXTextField AddComplaintID;

    @FXML
    private JFXTextField AddComplaintAdditionalPhoneNum;

    @FXML
    private JFXTextField ViewComplaintUserName;

    @FXML
    private JFXButton ViewComplaintBtn;


    @FXML
    void Add_Complaint(MouseEvent event) {
        try{
            ValidationController validate = new ValidationController(AddComplaintStackPane, AddComplaintAnchorPane, 1);
            if(        validate.validateNIC(AddComplaintIDNum)
                    && validate.validatePhone(AddComplaintPhoneNum)
                    && validate.validateUsername(AddComplaintUsername)
                    && validate.sameIDNo(AddComplaintIDNum)
                    && validate.samePhoneNumber(AddComplaintPhoneNum)
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
                newComplaintRecord.setAdditionalPhoneNum(AddComplaintAdditionalPhoneNum.getText().trim());
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
        AddComplaintID.clear();
        AddComplaintDate.getEditor().clear();
        AddComplaintType.getSelectionModel().clearSelection();
        AddComplaintAdditionalPhoneNum.clear();
        AddComplaintDescription.clear();
        AddComplaintActionTaken.clear();


    }

    @FXML
    void View_Complaint(MouseEvent event) {

    }
}
