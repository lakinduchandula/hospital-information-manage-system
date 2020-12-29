package sample.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTabPane;
import com.jfoenix.controls.JFXTextField;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Tab;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;

public class AdDashComplaintController {

    public static String complaintID;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private StackPane AdDashCompStackPane;

    @FXML
    private AnchorPane AdDashCompAnchor;

    @FXML
    private JFXTabPane mainComplaintTabPane;

    @FXML
    private JFXTextField ViewUserComplaintID;

    @FXML
    private JFXTextField EditUserUsername;

    @FXML
    private JFXButton ViewComplaintBtn;

    @FXML
    private BorderPane CompViewBorderPane;

    @FXML
    private Tab EditComplaintUsername;

    @FXML
    private JFXTextField EditUserCompID;

    @FXML
    private JFXButton EditComplaintBtn;

    @FXML
    private BorderPane CompEditBorderPane;

    @FXML
    void Edit_Complaint(MouseEvent event) throws IOException {
        ValidationController complaintValidationID = new ValidationController(AdDashCompStackPane,
                AdDashCompAnchor, 1);
        if(!EditUserCompID.getText().isEmpty()){
            if (complaintValidationID.complaintValidationID(EditUserCompID)) {
                complaintID = EditUserCompID.getText().trim();
                Parent complaintPane = FXMLLoader.load(getClass().getResource("/sample/view/AdEditComplaint.fxml"));
                CompEditBorderPane.setCenter(complaintPane);
            }
            EditUserCompID.clear();
        } else {
            complaintValidationID.detailedMsg("Invalid Input Data", "Complaint ID is empty");
        }
    }

    @FXML
    void View_Complaint(MouseEvent event) throws IOException {
        ValidationController complaintValidationID = new ValidationController(AdDashCompStackPane,
                AdDashCompAnchor, 1);
        if(!ViewUserComplaintID.getText().isEmpty()){
            if (complaintValidationID.complaintValidationID(ViewUserComplaintID)) {
                complaintID = ViewUserComplaintID.getText().trim();
                Parent complaintPane = FXMLLoader.load(getClass().getResource("/sample/view/AdViewComplaint.fxml"));
                CompViewBorderPane.setCenter(complaintPane);
            }
            ViewUserComplaintID.clear();
        } else {
            complaintValidationID.detailedMsg("Invalid Input Data", "Complaint ID is empty");
        }
    }

    @FXML
    void initialize() {

    }
}
