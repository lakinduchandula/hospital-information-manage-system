package sample.model;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class LastLogin {
    public static ArrayList<String> getLastLogin() throws IOException {
        ArrayList<String> list = new ArrayList<String>();
        ArrayList<String> returnArray = new ArrayList<String>();
        FileInputStream in = new FileInputStream("src/sample/data/Log.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(in));

        String strLine = "", tmp;
        while ((tmp = br.readLine()) != null) {
            //strLine =tmp+"\n"+strLine;
            list.add(tmp);
        }
        String[] userLoginDetails = new String[4];
        String[] timeArray = new String[2];
        if (list.size() > 5) {
            for (int i = list.size() - 1; i >= (list.size() - 5); i--) {
                userLoginDetails = list.get(i).split(",");
                returnArray.add(userLoginDetails[0]);
                returnArray.add(userLoginDetails[1]);
                returnArray.add(userLoginDetails[2]);
                timeArray = userLoginDetails[3].split("\\.");
                returnArray.add(timeArray[0]);
            }
        } else {
            for (int i = 0; i < 5; i++) {
                userLoginDetails = list.get(i).split(",");
                returnArray.add(userLoginDetails[0]);
                returnArray.add(userLoginDetails[1]);
                returnArray.add(userLoginDetails[2]);
                timeArray = userLoginDetails[3].split("\\.");
                returnArray.add(timeArray[0]);
            }

        }
        return returnArray;
    }
}


