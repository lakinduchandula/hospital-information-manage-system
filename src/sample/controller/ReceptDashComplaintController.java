package sample.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;

import java.net.URL;
import java.util.ResourceBundle;

public class ReceptDashComplaintController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private JFXComboBox<?> ComplaintType;

    @FXML
    private JFXTextField ComplaintBy;

    @FXML
    private JFXTextField ComplaintPersonPhoneNum;

    @FXML
    private JFXDatePicker ComplaintDate;

    @FXML
    private JFXTextField Complaint;

    @FXML
    private JFXTextField ComplaintNote;

    @FXML
    private JFXTextField ComplaintAttachDoc;

    @FXML
    private JFXButton AddComplaintAttachBtn;

    @FXML
    private JFXButton AddComplaintBtn;

    @FXML
    private JFXTextField ComplaintActionTaken;

    @FXML
    private JFXTextField ViewComplaintUserName;

    @FXML
    private JFXButton ViewComplaintBtn;
}
