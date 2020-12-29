package sample.controller;

import com.jfoenix.controls.JFXButton;

import java.io.IOException;
import java.net.URL;
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

public class AdViewComplaintController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private StackPane ViewComplaintStackPane;

    @FXML
    private ScrollPane ViewComplaintScrollPane;

    @FXML
    private Text ViewComplaintDescription;

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
    private AnchorPane AdViewCompAnchor;

    @FXML
    private BorderPane AdViewBorderPane;

    @FXML
    private JFXButton DeleteComplaint;

    @FXML
    void Delete_Complaint(MouseEvent event) throws IOException {
        ValidationController deleteComplaint = new ValidationController(ViewComplaintStackPane, AdViewCompAnchor,
                1);
        ReceptAddComplaint.removeComplaint(AdDashComplaintController.complaintID);
        deleteComplaint.detailedMsg("Complaint Removed",
                "That Complaint was Successfully Removed from database");
        afterCreation();
    }

    public void afterCreation() throws IOException {
        Parent white = FXMLLoader.load(getClass()
                .getResource("/sample/view/WhiteBlank.fxml"));
        AdViewBorderPane.setCenter(white);
    }

    @FXML
    void initialize() {
        ComplaintRecord viewComplaintRecord = new ComplaintRecord();
        viewComplaintRecord.getComplaintDetailsArray(AdDashComplaintController.complaintID);
        String[] complaintDetails = viewComplaintRecord.getComplaintDetails();

        ViewComplaintID.setText(complaintDetails[0]);
        ViewComplaintUsername.setText(complaintDetails[1]);
        ViewComplaintFirstName.setText(complaintDetails[2]);
        ViewComplaintLastName.setText(complaintDetails[3]);
        ViewComplaintNIC.setText(complaintDetails[4]);
        ViewComplaintPhoneNum.setText(complaintDetails[5]);
        ViewComplaintDate.setText(complaintDetails[6]);
        ViewComplaintType.setText(complaintDetails[7]);
        ViewComplaintDescription.setText(GetSetTextArea.setText(complaintDetails[8]));
        ViewComplaintActionTaken.setText(GetSetTextArea.setText(complaintDetails[10]));
    }
}
