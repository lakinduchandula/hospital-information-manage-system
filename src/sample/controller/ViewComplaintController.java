package sample.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.StackPane;

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
    private Label ViewComplaintPhone2;

    @FXML
    void initialize() {

    }
}
