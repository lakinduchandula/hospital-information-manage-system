package sample.model;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalTime;

public class LogFile {
    private String usermode;
    private String username;
    private LocalDate loginDate;
    private LocalTime localTime;

    public LogFile(){

    }

    public LogFile(String usermode, String username, LocalDate loginDate, LocalTime localTime){
        this.setUsermode(usermode);
        this.setUsername(username);
        this.setLoginDate(loginDate);
        this.setLoginTime(localTime);
    }

    public void setUsermode(String usermode){
        this.usermode = usermode;
    }

    public String getUsermode(){
        return usermode;
    }

    public void setUsername(String username){
        this.username = username;
    }

    public String getUserName(){
        return username;
    }

    public LocalDate getLoginDate() {
        return loginDate;
    }

    public LocalTime getLocalTime(){
        return localTime;
    }

    public void setLoginTime(LocalTime loginTime){
        this.localTime = loginTime;
    }

    public void setLoginDate(LocalDate loginDate){
        this.loginDate = loginDate;
    }

    public String toString(){
        return String.format("%s,%s,%s,%s", getUsermode(), getUserName(), getLoginDate(), getLocalTime());
    }

    public void addLog(){
        try {
            FileWriter writer = new FileWriter("src/sample/data/Log.txt", true);
            PrintWriter printWriter = new PrintWriter(writer);
            printWriter.println(toString());
            printWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
