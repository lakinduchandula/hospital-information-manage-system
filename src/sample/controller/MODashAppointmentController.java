package sample.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import sample.model.Appointment;

public class MODashAppointmentController {

    public static String appointmentID;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private JFXButton CopyID;

    @FXML
    private TableView<Appointment> TableAppointmentList;

    @FXML
    private TableColumn<Appointment, String> TableAppointmentID;

    @FXML
    private TableColumn<Appointment, String> TableFirstName;

    @FXML
    private TableColumn<Appointment, String> TableLastName;

    @FXML
    private TableColumn<Appointment, String> TablePatientNIC;

    @FXML
    private TableColumn<Appointment, String> TablePhoneNumber;

    @FXML
    private TableColumn<Appointment, String> TableGender;

    @FXML
    private TableColumn<Appointment, LocalDate> TableDate;

    @FXML
    private TableColumn<Appointment, LocalTime> TableTime;

    @FXML
    private TableColumn<Appointment, String> TableSymptoms;

    @FXML
    private BorderPane MOTakeAppBorderPane;

    @FXML
    private JFXTextField MOTakeAppointment;

    @FXML
    private JFXButton TakeAppointment;

    @FXML
    private StackPane MODashAppStackPane;

    @FXML
    private AnchorPane MODashAppAnchor;


//            new Appointment("ABS12584", "Lakindu", "Chandula", "991623361V",
//                    "0752094801", "Male", LocalDate.parse("2020-12-25"), LocalTime.parse("10:17"),
//                    "null")
//    );

    @FXML
    void initialize() {
        TableAppointmentID.setCellValueFactory(new PropertyValueFactory<>("appointmentNo"));
        TableFirstName.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        TableLastName.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        TablePatientNIC.setCellValueFactory(new PropertyValueFactory<>("idNo"));
        TablePhoneNumber.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
        TableGender.setCellValueFactory(new PropertyValueFactory<>("gender"));
        TableDate.setCellValueFactory(new PropertyValueFactory<>("appointmentDate"));
        TableTime.setCellValueFactory(new PropertyValueFactory<>("appointmentTime"));
        TableSymptoms.setCellValueFactory(new PropertyValueFactory<>("symptoms"));

        ObservableList<TablePosition> selectedCells = TableAppointmentList.getSelectionModel().getSelectedCells() ;


        // add appointment to the table which are belongs to this login user medical officer
        Appointment tableAppointment = new Appointment();
        tableAppointment.getApprovedAppointmentList(LoginController.currentUser, "Approved");
        ObservableList<Appointment> appointmentList = FXCollections.observableArrayList(tableAppointment.getApprovedAppointments());
        TableAppointmentList.setItems(appointmentList);

    }

    @FXML
    void take_appointment(MouseEvent event) throws IOException {
        ValidationController validate = new ValidationController(MODashAppStackPane, MODashAppAnchor, 1);
        if(validate.validateAppointmentID(MOTakeAppointment) && validate.correctAppointment(LoginController.currentUser,
                MOTakeAppointment)){
            appointmentID = MOTakeAppointment.getText().trim();
            Parent editUserAccount = FXMLLoader.load(getClass()
                    .getResource("/sample/view/TakeAppointment.fxml"));
            MOTakeAppBorderPane.setCenter(editUserAccount);
            MOTakeAppointment.clear();
        }
    }

    @FXML
    void copyID(MouseEvent event) {
        TablePosition pos = TableAppointmentList.getSelectionModel().getSelectedCells().get(0);
        int row = pos.getRow();

        // Item here is the table view type:
        Appointment item = TableAppointmentList.getItems().get(row);

        TableColumn col = pos.getTableColumn();

        // this gives the value in the selected cell:
        String data = (String) col.getCellObservableValue(item).getValue();
        System.out.println(data);
    }
}
