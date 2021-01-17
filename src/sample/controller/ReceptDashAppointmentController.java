package sample.controller;

import com.jfoenix.controls.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import sample.model.*;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ResourceBundle;

public class ReceptDashAppointmentController {

    public static String AppointmentIDGlobal;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private StackPane AddAppointmentStackPane;

    @FXML
    private AnchorPane AddAppointmentAnchorPane;

    @FXML
    private JFXTextField AddAppointmentPatientFirstname;

    @FXML
    private JFXTextField AddAppointmentPatientAddressLine1;

    @FXML
    private JFXTextField AddAppointmentPatientLastname;

    @FXML
    private JFXDatePicker AddAppointmentPatientDOB;

    @FXML
    private JFXTextField AddAppointmentPatientPhoneNumber;

    @FXML
    private JFXTextArea AddAppointmentSymptoms;


    @FXML
    private JFXTimePicker AddAppointmentAppointmentTime;

    @FXML
    private JFXTextField AddAppointmentAppointmentNumber;

    @FXML
    private JFXComboBox<String> AddAppointmentAppointmentPrefferedMO;

    @FXML
    private JFXComboBox<String> AddAppointmentAppointmentRecordStatus;

    @FXML
    private JFXButton AddAppointmentBtn;

    @FXML
    private JFXDatePicker AddAppointmentAppointmentDate;

    @FXML
    private JFXTextField AddAppointmentPatientUserName;

    @FXML
    private JFXTextField AddAppointmentPatientIDNum;

    @FXML
    private JFXComboBox<String> AddAppointmentPatientGender;

    @FXML
    private JFXTextField AddAppointmentPatientAddressLine2;

    @FXML
    private JFXTextField AddAppointmentCity;

    @FXML
    private JFXComboBox<String> AddAppointmentSpecialMO;

    @FXML
    private JFXComboBox<String> AddAppointemntPatientBloodGroup;

    @FXML
    private JFXTextField EditAppointmentID;

    @FXML
    private JFXButton EditAppointmentBtn;

    @FXML
    private JFXTextField ViewAppointmentID;

    @FXML
    private JFXButton ViewAppointmentBtn;

    @FXML
    private BorderPane ViewAppointmentBorderPane;

    @FXML
    private JFXTextField DeleteAppointmentUsername;

    @FXML
    private JFXButton DeleteAppointmentBtn;

    @FXML
    private BorderPane DeleteAppointmentBorderPane;

    @FXML
    private BorderPane EditAppointmentBorderPane;

    @FXML
    private TableView<Appointment> TablePendingAppointmentList;

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
    private TableColumn<Appointment, String> TableDate;

    @FXML
    private TableColumn<Appointment, String> TableTime;

    @FXML
    private TableColumn<Appointment, String> TableStatus;

    @FXML
    private TextField SearchBoxPending;


    @FXML
    void Add_Appointment(MouseEvent event) {
        try{
            ValidationController validate = new ValidationController(AddAppointmentStackPane, AddAppointmentAnchorPane, 4);
            if(        !(AddAppointmentAppointmentTime.getValue() == null)
                    && !(AddAppointmentAppointmentDate.getValue() == null)
                    && !(AddAppointmentPatientDOB.getValue() == null)
                    && !(AddAppointmentAppointmentPrefferedMO.getSelectionModel().isEmpty())
                    && !(AddAppointemntPatientBloodGroup.getSelectionModel().isEmpty())
                    && validate.ValidNotEmpty(AddAppointmentPatientUserName)
                    && validate.ValidNotEmpty(AddAppointmentPatientIDNum)
                    && validate.ValidNotEmpty(AddAppointmentPatientFirstname)
                    && validate.ValidNotEmpty(AddAppointmentPatientLastname)
                    && validate.ValidNotEmpty(AddAppointmentPatientPhoneNumber)
                    && validate.ValidNotEmpty(AddAppointmentPatientAddressLine1)
                    && validate.ValidNotEmpty(AddAppointmentPatientAddressLine2)
                    && validate.ValidNotEmpty(AddAppointmentCity)
            )
            {
                if (validate.validateNIC(AddAppointmentPatientIDNum)
                        && validate.validatePhone(AddAppointmentPatientPhoneNumber)
                        && validate.validateExitingPatientUsername(AddAppointmentPatientUserName)
                ) {

                    Appointment newAppointment = new Appointment();
                    newAppointment.setAppointmentNo(AddAppointmentAppointmentNumber.getText().trim());
                    newAppointment.setFirstName(AddAppointmentPatientFirstname.getText().trim());
                    newAppointment.setLastName(AddAppointmentPatientLastname.getText().trim());
                    newAppointment.setUserName(AddAppointmentPatientUserName.getText().trim());
                    newAppointment.setIdNo(AddAppointmentPatientIDNum.getText().trim());
                    newAppointment.setGender(AddAppointmentPatientGender.getValue());
                    newAppointment.setPhoneNumber(AddAppointmentPatientPhoneNumber.getText().trim());
                    newAppointment.setDOB(AddAppointmentPatientDOB.getValue());
                    newAppointment.setAddressLine1(AddAppointmentPatientAddressLine1.getText().trim());
                    newAppointment.setAddressLine2(AddAppointmentPatientAddressLine2.getText().trim());
                    newAppointment.setCity(AddAppointmentCity.getText().trim());
                    newAppointment.setMedicalOfficer(AddAppointmentAppointmentPrefferedMO.getValue());
                    newAppointment.setMedicalSpecialArea(AddAppointmentSpecialMO.getValue());
                    newAppointment.setBloodGroup(AddAppointemntPatientBloodGroup.getValue());
                    newAppointment.setSymptoms(GetSetTextArea.getText(AddAppointmentSymptoms.getText().trim()));
                    newAppointment.setAppointmentDate(AddAppointmentAppointmentDate.getValue());
                    newAppointment.setAppointmentTime(AddAppointmentAppointmentTime.getValue());
                    newAppointment.setAppointmentRecordStatus(AddAppointmentAppointmentRecordStatus.getValue());
                    newAppointment.setMOStaffID(newAppointment
                            .getIDFromName(AddAppointmentAppointmentPrefferedMO.getValue()));

                    ReceptAddAppointment.writeToFile(newAppointment);
                    validate.successfulUserCreation("Appointment Successfully Created");
                    clearFields();
                }
            } else {
                validate.detailedMsg("Invalid Input Data", "Some fields are empty." +
                        " Enter data and try again");
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void approve_appointment(MouseEvent event) {
        ValidationController validate = new ValidationController(AddAppointmentStackPane, AddAppointmentAnchorPane,
                4);
        Appointment appointment = TablePendingAppointmentList.getSelectionModel().getSelectedItem();

        Appointment editAppointment = new Appointment();
        editAppointment.getAppointmentDetailsArray(appointment.getAppointmentNo());
        String[] appointmentDetails = editAppointment.getAppointmentDetails();
        editAppointment.deleteAppointment(appointment.getAppointmentNo());

        editAppointment.setAppointmentNo(appointmentDetails[0]);
        editAppointment.setFirstName(appointmentDetails[2]);
        editAppointment.setLastName(appointmentDetails[3]);
        editAppointment.setUserName(appointmentDetails[1]);
        editAppointment.setIdNo(appointmentDetails[4]);
        editAppointment.setGender(appointmentDetails[6]);
        editAppointment.setPhoneNumber(appointmentDetails[5]);
        editAppointment.setDOB(LocalDate.parse(appointmentDetails[7]));
        editAppointment.setAddressLine1(appointmentDetails[8]);
        editAppointment.setAddressLine2(appointmentDetails[9]);
        editAppointment.setCity(appointmentDetails[10]);
        editAppointment.setMedicalOfficer(appointmentDetails[15]);
        editAppointment.setMedicalSpecialArea(appointmentDetails[17]);
        editAppointment.setBloodGroup(appointmentDetails[11]);
        editAppointment.setSymptoms(appointmentDetails[12]);
        editAppointment.setAppointmentDate(LocalDate.parse(appointmentDetails[13]));
        editAppointment.setAppointmentTime(LocalTime.parse(appointmentDetails[14]));
        editAppointment.setAppointmentRecordStatus("Approved");
        editAppointment.setMOStaffID(appointmentDetails[18]);

        ReceptAddAppointment.writeToFile(editAppointment);
        validate.detailedMsg("Appointment Updated", "Selected Appointment No"
                        +appointment.getAppointmentNo()+" was set as Approved\n" +
                        "Appointment and it will moved to the Approved category."
                );
    }


    @FXML
    void copyID(MouseEvent event) {
        Appointment appointment = TablePendingAppointmentList.getSelectionModel().getSelectedItem();

        String copyText = appointment.getAppointmentNo();
        final Clipboard clipboard = Clipboard.getSystemClipboard();
        final ClipboardContent content = new ClipboardContent();
        content.putString(copyText);
        clipboard.setContent(content);

        ValidationController copyMsg = new ValidationController(AddAppointmentStackPane, AddAppointmentAnchorPane,
                4);
        copyMsg.detailedMsg("Appointment ID Copied", "Selected Appointment ID (" + copyText +
                ") was copied to the clipboard\n" +
                "now you use it in Edit, View Appointment Tabs");
        EditAppointmentID.setText(copyText);
        ViewAppointmentID.setText(copyText);
    }

    @FXML
    void initialize() {
        // combo-box items for gender at add appointment
        AddAppointmentPatientGender.getItems().add("Male");
        AddAppointmentPatientGender.getItems().add("Female");

        // combo-box items for blood-group status at add appointment
        AddAppointemntPatientBloodGroup.getItems().add("A+");
        AddAppointemntPatientBloodGroup.getItems().add("A-");
        AddAppointemntPatientBloodGroup.getItems().add("B+");
        AddAppointemntPatientBloodGroup.getItems().add("B-");
        AddAppointemntPatientBloodGroup.getItems().add("O+");
        AddAppointemntPatientBloodGroup.getItems().add("O-");
        AddAppointemntPatientBloodGroup.getItems().add("AB+");
        AddAppointemntPatientBloodGroup.getItems().add("AB-");

        // add medial officer special area to combo-box
        AdReference.readItem(AddAppointmentSpecialMO, 0);

        // combo-box items for AppointmentRecordStatus
        AddAppointmentAppointmentRecordStatus.getItems().add("Pending");
        AddAppointmentAppointmentRecordStatus.getItems().add("Approved");

        // initial value of appointment ID is disable
        AddAppointmentAppointmentNumber.setDisable(true);

        // Selecting medical Officer is disable until selecting speciality area
        boolean disable = !AddAppointmentAppointmentPrefferedMO.isDisabled();
        AddAppointmentAppointmentPrefferedMO.setDisable(disable);

        // initialize data to table
        TableAppointmentID.setCellValueFactory(new PropertyValueFactory<>("appointmentNo"));
        TableFirstName.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        TableLastName.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        TablePatientNIC.setCellValueFactory(new PropertyValueFactory<>("idNo"));
        TablePhoneNumber.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
        TableGender.setCellValueFactory(new PropertyValueFactory<>("gender"));
        TableDate.setCellValueFactory(new PropertyValueFactory<>("appointmentDate"));
        TableTime.setCellValueFactory(new PropertyValueFactory<>("appointmentTime"));
        TableStatus.setCellValueFactory(new PropertyValueFactory<>("appointmentRecordStatus"));

        // add appointment to the table which are belongs to this login user medical officer
        Appointment tableAppointment = new Appointment();
        tableAppointment.getPendingAppointmentList("Pending");
        ObservableList<Appointment> appointmentList = FXCollections.observableArrayList(tableAppointment.getApprovedAppointments());
        TablePendingAppointmentList.setItems(appointmentList);

        // selecting first item of the table
        TablePendingAppointmentList.getSelectionModel().selectFirst();

        // Wrap the ObservableList in a FilteredList (initially display all data)
        FilteredList<Appointment> filteredData = new FilteredList<>(appointmentList, b -> true);

                // 2. Set the  filter Predicate whenever the filter change
                SearchBoxPending.textProperty().addListener((observable, oldValue, newValue) -> {
                    filteredData.setPredicate( appointment -> {

                        // if filter text is empty, display all appointments
                        if (newValue == null || newValue.isEmpty()){
                            return true;
                        }

                        //  Compare first name and last name of every person with filter text
                        String lowerCaseFilter = newValue.toLowerCase();

                        if (appointment.getFirstName().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                            return true; // filter matches first name
                        }
                        else if (appointment.getLastName().toLowerCase().indexOf(lowerCaseFilter) != -1){
                            return true;
                        }
                        else if (appointment.getAppointmentNo().toLowerCase().indexOf(lowerCaseFilter) != -1){
                            return true;
                        }
                        else if (appointment.getIdNo().toUpperCase().contains(lowerCaseFilter)){
                            return true;
                        }
                        else if (appointment.getPhoneNumber().toUpperCase().contains(lowerCaseFilter)){
                            return true;
                        }
                        return false;
                    });
                });

                // 3. Wrap the FilteredList in a SortedList
                SortedList<Appointment> sortedData = new SortedList<>(filteredData);

                // 4. Bind the SortedList comparator to the TableView comparator.
                //      Otherwise, sorting the TableView would have no effect.
                sortedData.comparatorProperty().bind(TablePendingAppointmentList.comparatorProperty());

                // 5. Add sorted (and filtered) data to the table.
                TablePendingAppointmentList.setItems(sortedData);


    }

    public void clearFields() {
        AddAppointmentPatientFirstname.clear();
        AddAppointmentPatientLastname.clear();
        AddAppointmentPatientUserName.clear();
        AddAppointmentPatientIDNum.clear();
        AddAppointmentPatientGender.getSelectionModel().clearSelection();
        AddAppointmentPatientPhoneNumber.clear();
        AddAppointmentPatientDOB.getEditor().clear();
        AddAppointmentPatientAddressLine1.clear();
        AddAppointmentPatientAddressLine2.clear();
        AddAppointemntPatientBloodGroup.getSelectionModel().clearSelection();
        AddAppointmentSymptoms.clear();
        AddAppointmentAppointmentDate.getEditor().clear();
        AddAppointmentAppointmentNumber.clear();
        AddAppointmentAppointmentTime.getEditor().clear();
        AddAppointmentAppointmentPrefferedMO.getSelectionModel().clearSelection();
        AddAppointmentAppointmentRecordStatus.getSelectionModel().clearSelection();
        AddAppointmentCity.clear();
        AddAppointmentSpecialMO.getSelectionModel().clearSelection();
        ViewAppointmentID.clear();
        EditAppointmentID.clear();
    }

    @FXML
    void Edit_Appointment(MouseEvent event) throws IOException {
        ValidationController appointmentValidation = new ValidationController(AddAppointmentStackPane,
                AddAppointmentAnchorPane, 4);
        if(appointmentValidation.ValidNotEmpty(EditAppointmentID)){
            if (appointmentValidation.validateAppointmentID(EditAppointmentID)) {
                AppointmentIDGlobal = EditAppointmentID.getText().trim();
                Parent appointmentPane = FXMLLoader.load(getClass()
                        .getResource("/sample/view/RecepEditAppointment.fxml"));
                EditAppointmentBorderPane.setCenter(appointmentPane);
                clearFields();
            }
        }
    }
    @FXML
    void View_Appointment(MouseEvent event) throws IOException {
        ValidationController appointmentValidation = new ValidationController(AddAppointmentStackPane,
                AddAppointmentAnchorPane, 4);
        if(appointmentValidation.ValidNotEmpty(ViewAppointmentID)){
            if (appointmentValidation.validateAppointmentID(ViewAppointmentID)) {
                AppointmentIDGlobal = ViewAppointmentID.getText().trim();
                Parent appointmentPane = FXMLLoader.load(getClass().getResource("/sample/view/RecepViewAppointment.fxml"));
                ViewAppointmentBorderPane.setCenter(appointmentPane);
                clearFields();
            }
        }
    }

    @FXML
    void selectingMO(ActionEvent event) {
        if(AddAppointmentAppointmentPrefferedMO.isDisabled()){
            AddAppointmentAppointmentPrefferedMO.setDisable(false);
        }
        AddAppointmentAppointmentPrefferedMO.getSelectionModel().clearSelection();
        AddAppointmentAppointmentPrefferedMO.getItems().clear();
        PrefMedicalOfficer.MOList(AddAppointmentSpecialMO.getValue(), AddAppointmentAppointmentPrefferedMO);
    }

    @FXML
    void app_status(ActionEvent event) {
        if(AddAppointmentAppointmentRecordStatus.getValue() == "Approved"){
            AddAppointmentAppointmentNumber.setDisable(false);
            AddAppointmentAppointmentNumber.setText(RandomID.getUniqueId());
        } else {
            AddAppointmentAppointmentNumber.clear();
            AddAppointmentAppointmentNumber.setDisable(true);
        }
    }
}
