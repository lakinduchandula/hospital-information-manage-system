package sample.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTabPane;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Tab;

public class AdDashComplaintController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private JFXTabPane mainComplaintTabPane;

    @FXML
    private Tab ViewComplaintUsername;

    @FXML
    private JFXTextField EditUserUsername;

    @FXML
    private JFXButton ViewComplaintBtn;

    @FXML
    private Tab EditComplaintUsername;

    @FXML
    private JFXTextField EditUserUsername1;

    @FXML
    private JFXButton EditComplaintBtn;

    @FXML
    private Tab DeleteComplaint;

    @FXML
    private JFXTextField DeleteComplaintUsername;

    @FXML
    private JFXButton DeleteComplaintBtn;

    @FXML
    void initialize() {


    }
}
