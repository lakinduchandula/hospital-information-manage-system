package sample.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
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
import sample.model.ComplaintRecord;
import sample.model.GetSetTextArea;
import sample.model.ReceptAddComplaint;

public class AdEditComplaintController {

    private String[] complaintDetails;

    public void setComplaintDetails(String[] complaintDetails) {
        this.complaintDetails = complaintDetails;
    }

    public String[] getComplaintDetails(){
        return complaintDetails;
    }

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private StackPane ViewComplaintStackPane;

    @FXML
    private ScrollPane ViewComplaintBorderPane;

    @FXML
    private Label ViewComplaintID;

    @FXML
    private Label ViewComplaintDate;

    @FXML
    private Label ViewComplaintType;

    @FXML
    private Label ViewComplaintFirstName;

    @FXML
    private Label ViewComplaintLastName;

    @FXML
    private Label ViewComplaintUsername;

    @FXML
    private Label ViewComplaintNIC;

    @FXML
    private Label ViewComplaintPhone1;

    @FXML
    private Text ComplaintBodyMsg;

    @FXML
    private JFXTextArea AdEditEnterAction;

    @FXML
    private JFXButton updateComplaint;

    @FXML
    private AnchorPane AdEditCompAnchor;

    @FXML
    private BorderPane AdEditCompBorder;

    @FXML
    void update_complaint(MouseEvent event) throws IOException {
        ValidationController validate = new ValidationController(ViewComplaintStackPane, AdEditCompAnchor,
                1);
        ReceptAddComplaint.removeComplaint(AdDashComplaintController.complaintID);
        ComplaintRecord updateComplaintRecord = new ComplaintRecord();

        updateComplaintRecord.setComplaintID(ViewComplaintID.getText());
        updateComplaintRecord.setUsername(ViewComplaintUsername.getText());
        updateComplaintRecord.setFirstName(ViewComplaintFirstName.getText());
        updateComplaintRecord.setLastName(ViewComplaintLastName.getText());
        updateComplaintRecord.setIdNum(ViewComplaintNIC.getText());
        updateComplaintRecord.setPhoneNum(ViewComplaintPhone1.getText());
        updateComplaintRecord.setCurrentDate(LocalDate.parse(ViewComplaintDate.getText()));
        updateComplaintRecord.setComplaintType(ViewComplaintType.getText());
        updateComplaintRecord.setDescription(GetSetTextArea.getText(ComplaintBodyMsg.getText()));
        updateComplaintRecord.setActionTaken(GetSetTextArea.getText(AdEditEnterAction.getText()));
        updateComplaintRecord.setPatientGhostID(getComplaintDetails()[11]);

        ReceptAddComplaint.writeToFile(updateComplaintRecord);
        validate.detailedMsg("Update Complaint","Complaint Record Successfully updated");
        afterCreation();
    }

    public void afterCreation() throws IOException {
        Parent white = FXMLLoader.load(getClass()
                .getResource("/sample/view/WhiteBlank.fxml"));
        AdEditCompBorder.setCenter(white);
    }

    @FXML
    void initialize() {
        ComplaintRecord viewComplaintRecord = new ComplaintRecord();
        viewComplaintRecord.getComplaintDetailsArray(AdDashComplaintController.complaintID);
        String[] complaintDetails = viewComplaintRecord.getComplaintDetails();
        setComplaintDetails(complaintDetails);

        ViewComplaintID.setText(complaintDetails[0]);
        ViewComplaintUsername.setText(complaintDetails[1]);
        ViewComplaintFirstName.setText(complaintDetails[2]);
        ViewComplaintLastName.setText(complaintDetails[3]);
        ViewComplaintNIC.setText(complaintDetails[4]);
        ViewComplaintPhone1.setText(complaintDetails[5]);
        ViewComplaintDate.setText(complaintDetails[6]);
        ViewComplaintType.setText(complaintDetails[7]);
        ComplaintBodyMsg.setText(GetSetTextArea.setText(complaintDetails[8]));
        AdEditEnterAction.setText(GetSetTextArea.setText(complaintDetails[10]));
    }
}
