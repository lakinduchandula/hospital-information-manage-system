package sample.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXTreeTableColumn;
import com.jfoenix.controls.JFXTreeTableView;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TreeTableColumn;
import javafx.util.Callback;
import sample.model.Appointment;

public class MODashAppointmentController {

    @FXML
    private JFXTreeTableView<Appointment> AppointmentList;

    @FXML
    private JFXTextField appointmentNoTextField;

    @FXML
    private JFXButton changeStatusButton;

    @FXML
    void initialize() {
        JFXTreeTableColumn<Appointment, String> patientFirstName = new JFXTreeTableColumn<>("First Name");
        patientFirstName.setPrefWidth(150);
        patientFirstName.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Appointment, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Appointment, String> appointmentStringCellDataFeatures) {
                return null;
            }
        });
    }

}
