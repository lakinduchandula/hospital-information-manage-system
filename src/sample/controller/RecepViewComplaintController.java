package sample.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.StackPane;
import sample.model.ComplaintRecord;
import sample.model.GetSetTextArea;

public class RecepViewComplaintController {

    @FXML
    private StackPane ViewComplaintStackPane;

    @FXML
    private ScrollPane ViewComplaintScrollPane;

    @FXML
    private Label ViewComplaintDescription;

    @FXML
    private Label ViewComplaintID;

    @FXML
    private Label ViewComplaintType;

    @FXML
    private Label ViewComplaintDate;

    @FXML
    private Label ViewComplaintActionTaken;

    @FXML
    private Label ViewComplaintFirstName;

    @FXML
    private Label ViewComplaintUsername;

    @FXML
    private Label ViewComplaintPhoneNum;

    @FXML
    private Label ViewComplaintLastName;

    @FXML
    private Label ViewComplaintNIC;

    @FXML
    void initialize() {
        ComplaintRecord viewComplaintRecord = new ComplaintRecord();
        viewComplaintRecord.getComplaintDetailsArray(ReceptDashComplaintController.ComplaintIDGlobal);
        String[] complaintDetails = viewComplaintRecord.getComplaintDetails();

        ViewComplaintID.setText(complaintDetails[0]);
        ViewComplaintUsername.setText(complaintDetails[1]);
        ViewComplaintFirstName.setText(complaintDetails[2]);
        ViewComplaintLastName.setText(complaintDetails[3]);
        ViewComplaintNIC.setText(complaintDetails[4]);
        ViewComplaintPhoneNum.setText(complaintDetails[5]);
        ViewComplaintDate.setText(complaintDetails[6]);
        ViewComplaintType.setText(complaintDetails[7]);
        ViewComplaintDescription.setText(complaintDetails[8]);
        ViewComplaintActionTaken.setText(complaintDetails[10]);

    }
}
