package Model;

import Database.DBConnect;

import java.sql.Array;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


import static array.dou_ListtoArray.dou_ListtoArray;
import static array.str_ListtoArray.str_ListtoArray;
import static array.subArray.subArray;

public class Patient {
    private int id;
    private String givenname;
    private String familyname;
    private ECG ecg;
    private Heartbeat heartbeat;
    private int locator=0;

    public Patient(int i)
    {
        ArrayList<String> ECGxdata_list = new ArrayList<String>();
        ArrayList<Double> ECGydata_list = new ArrayList<Double>();
        ArrayList<Double> Heartbeatxdata_list = new ArrayList<Double>();
        ArrayList<Double> Heartbeatydata_list = new ArrayList<Double>();


        DBConnect database = new DBConnect();
        try {
            //Requests & Execution (SQL)
            String request = "select * from graphofpatient inner join patients on(patients.id=graphofpatient.patientid)\n" +
                    "                             inner join graphs on(graphs.id=graphofpatient.graphid)\n" +
                      "                             inner join heartbeatgraphs on(heartbeatgraphs.id=graphofpatient.graphid)\n "+
                                                 "where patientid="+i+";"; //could have any SQL command
            Statement stmt = database.getconnection().createStatement(); //what executes command
            ResultSet res = stmt.executeQuery(request);  //what executes command
            //reads through column of table
            while (res.next()) {
                Array ECGxdata_temp = res.getArray("ecg_xdata"); // put result of request in a string
                Array ECGydata_temp = res.getArray("ecg_ydata"); // put result of request in a string
                Array Heartbeatxdata_temp = res.getArray("heartbeat_xdata"); // put result of request in a string
                Array Heartbeatydata_temp = res.getArray("heartbeat_ydata"); // put result of request in a string
                String givenname_temp = res.getString("givenname");
                String familyanme_temp = res.getString("familyname");                    System.out.println("test");
                System.out.println("test");


                for (String strTemp : (String[]) ECGxdata_temp.getArray()) {
                    ECGxdata_list.add(strTemp);
                }
                for (Double douTemp : (Double[]) ECGydata_temp.getArray()) {
                    ECGydata_list.add(douTemp);
                }
                for (Double douTemp : (Double[]) Heartbeatxdata_temp.getArray()) {
                    Heartbeatxdata_list.add(douTemp);
                }
                for (Double douTemp : (Double[]) Heartbeatydata_temp.getArray()) {
                    Heartbeatydata_list.add(douTemp);
                }
                givenname = givenname_temp;
                familyname = familyanme_temp;

                System.out.println(givenname);


            }
            stmt.close();
        } catch (Exception e) {
            System.err.println("Got an exception! ");
            System.err.println(e.toString());
        }

        double[] xdata = str_ListtoArray(ECGxdata_list);
        double[] ydata = dou_ListtoArray(ECGydata_list);
        ecg = new ECG(new double[][]{xdata, ydata});

        xdata = dou_ListtoArray(Heartbeatxdata_list);
        ydata = dou_ListtoArray(Heartbeatydata_list);
        heartbeat = new Heartbeat(new double[][]{xdata, ydata});
    }

    //Accessors
    public double[][] ECGgetsnippet(int locator)
    {
        //System.out.println(Arrays.toString(subArray(ecg.get_xdata(), locator, locator+99)));
        return(new double[][]{subArray(ecg.get_xdata(), locator, locator+99), subArray(ecg.get_ydata(), locator, (locator++)+99)});
    }
    public double[][] Heartbeatgetsnippet(int locator)
    {
        //System.out.println(Arrays.toString(subArray(ecg.get_xdata(), locator, locator+99)));
        return(new double[][]{subArray(heartbeat.get_xdata(), locator, locator+99), subArray(heartbeat.get_ydata(), locator, (locator++)+99)});
    }


    public String getGivenname()
    {
        return givenname;
    }

    public String getFamilyname()
    {
        return familyname;
    }

    public double[] minmaxECG(){
        double min=0;
        double max=0;
        for (double douTemp : ecg.get_ydata()) {
            if (douTemp<min)
            {
                min = douTemp;
            }
            else if (douTemp>max)
            {
                max = douTemp;
            }
        }
        return new double[]{min, max};
    }
}
