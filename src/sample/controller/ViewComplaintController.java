package sample.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import sample.model.ComplaintRecord;
import sample.model.GetSetTextArea;

public class ViewComplaintController {

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
    private Label ViewComplaintActionTaken;

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
    void initialize() {
        ComplaintRecord viewComplaintRecord = new ComplaintRecord();
        viewComplaintRecord.getComplaintDetailsArray(PatientDashComplaintController.complaintID);
        String[] complaintDetails = viewComplaintRecord.getComplaintDetails();

        ViewComplaintID.setText(complaintDetails[0]);
        ViewComplaintUsername.setText(complaintDetails[1]);
        ViewComplaintFirstName.setText(complaintDetails[2]);
        ViewComplaintLastName.setText(complaintDetails[3]);
        ViewComplaintNIC.setText(complaintDetails[4]);
        ViewComplaintPhone1.setText(complaintDetails[5]);
        ViewComplaintDate.setText(complaintDetails[6]);
        ViewComplaintType.setText(complaintDetails[7]);
        ComplaintBodyMsg.setText(GetSetTextArea.setText(complaintDetails[8]));
        ViewComplaintActionTaken.setText(complaintDetails[10]);
    }
}
