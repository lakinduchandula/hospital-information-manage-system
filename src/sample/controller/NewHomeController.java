package sample.controller;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
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
import sample.model.LastLogin;

public class NewHomeController {

    private ArrayList<String> lastLogin;

    public void setLastLogin(ArrayList<String> lastLogin) {
        this.lastLogin = lastLogin;
    }

    public ArrayList<String> getLastLogin() {
        return lastLogin;
    }

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label AdDashHomeDate;

    @FXML
    private Label AdDashHomeTime;

    @FXML
    private Label AdDashHomeRecep;

    @FXML
    private Label AdDashHomeMO;

    @FXML
    private Label AdDashHomePatient;

    @FXML
    private Label AdDashHomeComplaint;

    @FXML
    private Label AdDashHomeAppointment;

    @FXML
    private LineChart<String, Integer> AppointmentChart;

    @FXML
    private CategoryAxis AppX;

    @FXML
    private NumberAxis AppY;

    @FXML
    private BarChart<String, Integer> ComplaintChart;

    @FXML
    private CategoryAxis CompX;

    @FXML
    private NumberAxis CompY;

    @FXML
    private Label AdDashHomeLastUsername1;

    @FXML
    private Label AdDashHomeLastUsermode1;

    @FXML
    private Label AdDashHomeLastDate1;

    @FXML
    private Label AdDashHomeLastTime1;

    @FXML
    private Label AdDashHomeLastUsername2;

    @FXML
    private Label AdDashHomeLastUsermode2;

    @FXML
    private Label AdDashHomeLastDate2;

    @FXML
    private Label AdDashHomeLastTime2;

    @FXML
    private Label AdDashHomeLastUsername3;

    @FXML
    private Label AdDashHomeLastUsermode3;

    @FXML
    private Label AdDashHomeLastDate3;

    @FXML
    private Label AdDashHomeLastTime3;

    @FXML
    private Label AdDashHomeLastUsername4;

    @FXML
    private Label AdDashHomeLastUsermode4;

    @FXML
    private Label AdDashHomeLastDate4;

    @FXML
    private Label AdDashHomeLastTime4;

    @FXML
    void initialize() throws IOException {
        // time and day
        realTimeGenerate();
        realDateGenerate();

        HomeDetails adminHomeDetails = new HomeDetails();
        adminHomeDetails.textReader();
        int[] detailCount = adminHomeDetails.getHomeDetailCount();

        AdDashHomeMO.setText(String.format("%d",detailCount[2]));
        AdDashHomeComplaint.setText(String.format("%d",detailCount[4]));
        AdDashHomeAppointment.setText(String.format("%d",detailCount[3]));
        AdDashHomePatient.setText(String.format("%d",detailCount[1]));
        AdDashHomeRecep.setText(String.format("%d",detailCount[0]));

        // instantiation of Analytics class
        Analytics adminHome = new Analytics();

        // appointment chart start
        XYChart.Series appointment = new XYChart.Series();
        adminHome.AppointmentCalculations(); // call method to calculate appointment analytics

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

        // add user last login details
        setLastLogin(LastLogin.getLastLogin());

        // Last user 1
        AdDashHomeLastUsermode1.setText(getLastLogin().get(0));
        AdDashHomeLastUsername1.setText(getLastLogin().get(1));
        AdDashHomeLastDate1.setText(getLastLogin().get(2));
        AdDashHomeLastTime1.setText(getLastLogin().get(3));
        // Last user 2
        AdDashHomeLastUsermode2.setText(getLastLogin().get(4));
        AdDashHomeLastUsername2.setText(getLastLogin().get(5));
        AdDashHomeLastDate2.setText(getLastLogin().get(6));
        AdDashHomeLastTime2.setText(getLastLogin().get(7));
        // Last user 3
        AdDashHomeLastUsermode3.setText(getLastLogin().get(8));
        AdDashHomeLastUsername3.setText(getLastLogin().get(9));
        AdDashHomeLastDate3.setText(getLastLogin().get(10));
        AdDashHomeLastTime3.setText(getLastLogin().get(11));
        // Last user 4
        AdDashHomeLastUsermode4.setText(getLastLogin().get(12));
        AdDashHomeLastUsername4.setText(getLastLogin().get(13));
        AdDashHomeLastDate4.setText(getLastLogin().get(14));
        AdDashHomeLastTime4.setText(getLastLogin().get(15));

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
