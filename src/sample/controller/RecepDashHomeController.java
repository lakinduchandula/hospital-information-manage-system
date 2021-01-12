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

public class RecepDashHomeController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label AdDashHomeDate;

    @FXML
    private Label AdDashHomeTime;

    @FXML
    private Label RecepDashHomeRecep;

    @FXML
    private Label RecepDashHomeMO;

    @FXML
    private Label RecepDashHomePatient;

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
    private Label RecepDashHomeAppointment;

    @FXML
    private Label RecepDashHomeComplaints;

    @FXML
    private Label RecepDashHomePendingApp;

    @FXML
    private Label RecepDashHomeApproveApp;

    @FXML
    private Label RecepDashHomeCompApp;

    @FXML
    private Label RecepDashHomeUndoneComp;

    @FXML
    void initialize() {
        // time and day
        realTimeGenerate();
        realDateGenerate();

        HomeDetails adminHomeDetails = new HomeDetails();
        adminHomeDetails.textReader();
        int[] detailCount = adminHomeDetails.getHomeDetailCount();

        RecepDashHomeMO.setText(String.format("%d",detailCount[2]));
        RecepDashHomeComplaints.setText(String.format("%d",detailCount[4]));
        RecepDashHomeAppointment.setText(String.format("%d",detailCount[3]));
        RecepDashHomePatient.setText(String.format("%d",detailCount[1]));
        RecepDashHomeRecep.setText(String.format("%d",detailCount[0]));

        // instantiation of Analytics class
        Analytics adminHome = new Analytics();

        // appointment chart start
        XYChart.Series appointment = new XYChart.Series();
        adminHome.AppointmentCalculations(); // call method to calculate appointment analytics
        adminHome.CombineAppointmentComplaint();

        // fill the graph with details
        appointment.getData().add(new XYChart.Data("January", adminHome.getAppointmentByMonth()[0]));
        appointment.getData().add(new XYChart.Data("February", adminHome.getAppointmentByMonth()[1]));
        appointment.getData().add(new XYChart.Data("March", adminHome.getAppointmentByMonth()[2]));
        appointment.getData().add(new XYChart.Data("April", adminHome.getAppointmentByMonth()[3]));
        appointment.getData().add(new XYChart.Data("May", adminHome.getAppointmentByMonth()[4]));
        appointment.getData().add(new XYChart.Data("June", adminHome.getAppointmentByMonth()[5]));
        appointment.getData().add(new XYChart.Data("July", adminHome.getAppointmentByMonth()[6]));
        appointment.getData().add(new XYChart.Data("August", adminHome.getAppointmentByMonth()[7]));
        appointment.getData().add(new XYChart.Data("September", adminHome.getAppointmentByMonth()[8]));
        appointment.getData().add(new XYChart.Data("October", adminHome.getAppointmentByMonth()[9]));
        appointment.getData().add(new XYChart.Data("November", adminHome.getAppointmentByMonth()[10]));
        appointment.getData().add(new XYChart.Data("December", adminHome.getAppointmentByMonth()[11]));

        // plot graph with above details
//        AppointmentChart.setStyle("CHART_COLOR_1: #0000FF ;");
//        AppointmentChart.setStyle("-fx-background-color: white ");
        AppointmentChart.getData().addAll(appointment);


        XYChart.Series complaint = new XYChart.Series<>();
        adminHome.ComplaintCalculations(); // call method to calculate complaint analytics

        complaint.getData().add(new XYChart.Data<>("January", adminHome.getComplaintsByMonth()[0]));
        complaint.getData().add(new XYChart.Data<>("February", adminHome.getComplaintsByMonth()[1]));
        complaint.getData().add(new XYChart.Data<>("March", adminHome.getComplaintsByMonth()[2]));
        complaint.getData().add(new XYChart.Data<>("April", adminHome.getComplaintsByMonth()[3]));
        complaint.getData().add(new XYChart.Data<>("May", adminHome.getComplaintsByMonth()[4]));
        complaint.getData().add(new XYChart.Data<>("June", adminHome.getComplaintsByMonth()[5]));
        complaint.getData().add(new XYChart.Data<>("July", adminHome.getComplaintsByMonth()[6]));
        complaint.getData().add(new XYChart.Data<>("August", adminHome.getComplaintsByMonth()[7]));
        complaint.getData().add(new XYChart.Data<>("September", adminHome.getComplaintsByMonth()[8]));
        complaint.getData().add(new XYChart.Data<>("October", adminHome.getComplaintsByMonth()[9]));
        complaint.getData().add(new XYChart.Data<>("November", adminHome.getComplaintsByMonth()[10]));
        complaint.getData().add(new XYChart.Data<>("December", adminHome.getComplaintsByMonth()[11]));

        // plot graph with above details
        ComplaintChart.getData().addAll(complaint);

        RecepDashHomePendingApp.setText(String.valueOf(adminHome.getAppointmentTypePlusComplaint()[0]));
        RecepDashHomeApproveApp.setText(String.valueOf(adminHome.getAppointmentTypePlusComplaint()[1]));
        RecepDashHomeCompApp.setText(String.valueOf(adminHome.getAppointmentTypePlusComplaint()[2]));
        RecepDashHomeUndoneComp.setText(String.valueOf(adminHome.getAppointmentTypePlusComplaint()[3]));
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
