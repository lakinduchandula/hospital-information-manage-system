package sample.controller;

import com.jfoenix.controls.*;
import javafx.fxml.FXML;
import javafx.scene.control.Tab;

public class ReceptDashComplaintController {
    @FXML
    private JFXTabPane mainComplaintTabPane;

    @FXML
    private Tab ViewComplaintUsername;

    @FXML
    private JFXTextField ComplaintBy;

    @FXML
    private JFXButton AddComplaintBtn;

    @FXML
    private JFXComboBox<?> ComplaintType;

    @FXML
    private JFXTextField ComplaintPersonPhoneNumber;

    @FXML
    private JFXDatePicker ComplaintDate;

    @FXML
    private JFXTextField Complaint;

    @FXML
    private JFXTextField AddComplaintNote;

    @FXML
    private JFXButton ComplaintAttachDoc;

    @FXML
    private JFXTextField ComplaintActionTaken;

    @FXML
    private Tab EditComplaintUsername;

    @FXML
    private JFXTextField ViewComplaintUserName;

    @FXML
    private JFXButton ViewComplaintBtn;
}
