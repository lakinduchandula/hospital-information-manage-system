package sample.controller;

import java.net.URL;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.ResourceBundle;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.chart.*;
import javafx.scene.control.Label;
import javafx.util.Duration;
import sample.model.Analytics;
import sample.model.HomeDetails;
import sample.model.UserEditDelete;

public class PatientDashHomeController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label AdDashHomeDate;

    @FXML
    private Label AdDashHomeTime;

    @FXML
    private Label RecepDashHomePatient;

    @FXML
    private Label PatientDashHomeRecep;

    @FXML
    private Label PatientDashHomeMO;

    @FXML
    private LineChart<?, ?> AppointmentChart;

    @FXML
    private CategoryAxis AppX;

    @FXML
    private NumberAxis AppY;

    @FXML
    private BarChart<?, ?> ComplaintChart;

    @FXML
    private CategoryAxis CompX;

    @FXML
    private NumberAxis CompY;

    @FXML
    private Label PatientDashHomeAppointment;

    @FXML
    private Label PatientDashHomeComplaints;

    @FXML
    private Label PatientDashHomePendingApp;

    @FXML
    private Label PatientDashHomeApproveApp;

    @FXML
    private Label PatientDashHomeCompApp;

    @FXML
    private Label PatientDashHomeUndoneComp;

    @FXML
    void initialize() {
        // time and day
        realTimeGenerate();
        realDateGenerate();

        // display sample details about the system ex-: how many doctors, receptionist that system have
        HomeDetails PatientHomeDetails = new HomeDetails();
        PatientHomeDetails.textReader();
        int[] detailCount = PatientHomeDetails.getHomeDetailCount();

        PatientDashHomeMO.setText(String.format("%d",detailCount[2])); // how many doctors
        PatientDashHomeRecep.setText(String.format("%d",detailCount[0])); // receptionist that system have

        // instantiation of Analytics class
        Analytics patientHome = new Analytics();

        // call and instantiation for get user specific details
        UserEditDelete newEditProfile = new UserEditDelete(1);
        newEditProfile.UserEdit(LoginController.currentUser);
        String[] PatientDetails = newEditProfile.getUserDetailArray();

        // appointment chart start
        XYChart.Series appointment = new XYChart.Series();

        // call method to calculate appointment analytics
        patientHome.AppointmentSpecificToPatient(PatientDetails[16]);
        // call method to check status for specific appointment
        patientHome.AppointmentStatusSpecificPatient(PatientDetails[16]);

        // fill the graph with details
        appointment.getData().add(new XYChart.Data("January", patientHome.getAppointmentSpecificPatient()[0]));
        appointment.getData().add(new XYChart.Data("February", patientHome.getAppointmentSpecificPatient()[1]));
        appointment.getData().add(new XYChart.Data("March", patientHome.getAppointmentSpecificPatient()[2]));
        appointment.getData().add(new XYChart.Data("April", patientHome.getAppointmentSpecificPatient()[3]));
        appointment.getData().add(new XYChart.Data("May", patientHome.getAppointmentSpecificPatient()[4]));
        appointment.getData().add(new XYChart.Data("June", patientHome.getAppointmentSpecificPatient()[5]));
        appointment.getData().add(new XYChart.Data("July", patientHome.getAppointmentSpecificPatient()[6]));
        appointment.getData().add(new XYChart.Data("August", patientHome.getAppointmentSpecificPatient()[7]));
        appointment.getData().add(new XYChart.Data("September", patientHome.getAppointmentSpecificPatient()[8]));
        appointment.getData().add(new XYChart.Data("October", patientHome.getAppointmentSpecificPatient()[9]));
        appointment.getData().add(new XYChart.Data("November", patientHome.getAppointmentSpecificPatient()[10]));
        appointment.getData().add(new XYChart.Data("December", patientHome.getAppointmentSpecificPatient()[11]));

        AppointmentChart.getData().addAll(appointment);


        XYChart.Series complaint = new XYChart.Series<>();
        patientHome.ComplaintSpecificPatient(PatientDetails[16]); // call method to calculate complaint analytics

        complaint.getData().add(new XYChart.Data<>("January", patientHome.getComplaintSpecificPatient()[0]));
        complaint.getData().add(new XYChart.Data<>("February", patientHome.getComplaintSpecificPatient()[1]));
        complaint.getData().add(new XYChart.Data<>("March", patientHome.getComplaintSpecificPatient()[2]));
        complaint.getData().add(new XYChart.Data<>("April", patientHome.getComplaintSpecificPatient()[3]));
        complaint.getData().add(new XYChart.Data<>("May", patientHome.getComplaintSpecificPatient()[4]));
        complaint.getData().add(new XYChart.Data<>("June", patientHome.getComplaintSpecificPatient()[5]));
        complaint.getData().add(new XYChart.Data<>("July", patientHome.getComplaintSpecificPatient()[6]));
        complaint.getData().add(new XYChart.Data<>("August", patientHome.getComplaintSpecificPatient()[7]));
        complaint.getData().add(new XYChart.Data<>("September", patientHome.getComplaintSpecificPatient()[8]));
        complaint.getData().add(new XYChart.Data<>("October", patientHome.getComplaintSpecificPatient()[9]));
        complaint.getData().add(new XYChart.Data<>("November", patientHome.getComplaintSpecificPatient()[10]));
        complaint.getData().add(new XYChart.Data<>("December", patientHome.getComplaintSpecificPatient()[11]));

        // plot graph with above details
        ComplaintChart.getData().addAll(complaint);

        // update the count of various data
        PatientDashHomeAppointment.setText(String.valueOf(patientHome.getAppointmentSpecificPatient()[12]));
        PatientDashHomeComplaints.setText(String.valueOf(patientHome.getComplaintSpecificPatient()[13]));
        PatientDashHomeUndoneComp.setText(String.valueOf(patientHome.getComplaintSpecificPatient()[12]));
        PatientDashHomePendingApp.setText(String.valueOf(patientHome.getAppointmentStatusSpecificPatient()[0]));
        PatientDashHomeApproveApp.setText(String.valueOf(patientHome.getAppointmentStatusSpecificPatient()[1]));
        PatientDashHomeCompApp.setText(String.valueOf(patientHome.getAppointmentStatusSpecificPatient()[2]));

    }

    public void realTimeGenerate(){
        Timeline clock = new Timeline(new KeyFrame(Duration.ZERO, e -> {
            LocalTime currentTime = LocalTime.now();
            AdDashHomeTime.setText(currentTime.getHour() + ":" + currentTime.getMinute() + ":"
                    + currentTime.getSecond());
        }),
                new KeyFrame(Duration.seconds(1))
        );
        clock.setCycleCount(Animation.INDEFINITE);
        clock.play();
    }

    public void realDateGenerate(){
        LocalDate day = LocalDate.now(); // or myDatePicker.getValue()
        DateTimeFormatter format = DateTimeFormatter.ofPattern("EEEE", Locale.getDefault());
//        System.out.println(day.format(format));
        AdDashHomeDate.setText(day.format(format));
    }
}
