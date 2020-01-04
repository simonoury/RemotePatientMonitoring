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
    private int locator=0;

    public Patient(int i)
    {
        ArrayList<String> xdata_list = new ArrayList<String>();
        ArrayList<Double> ydata_list = new ArrayList<Double>();


        DBConnect database = new DBConnect();
        try {
            //Requests & Execution (SQL)
            String request = "select ecg_xdata, ecg_ydata from graphofpatient inner join patients on(patients.id=graphofpatient.patientid)\n" +
                    "                             inner join graphs on(graphs.id=graphofpatient.graphid)\n" +
                    "where patientid="+i+";"; //could have any SQL command
            Statement stmt = database.getconnection().createStatement(); //what executes command
            ResultSet res = stmt.executeQuery(request);  //what executes command
            //reads through column of table
            while (res.next()) {
                Array xdata_temp = res.getArray("ecg_xdata"); // put result of request in a string
                Array ydata_temp = res.getArray("ecg_ydata"); // put result of request in a string
                for (String strTemp : (String[]) xdata_temp.getArray()) {
                    xdata_list.add(strTemp);
                }
                for (Double strTemp : (Double[]) ydata_temp.getArray()) {
                    ydata_list.add(strTemp);
                }
                System.out.println(xdata_list.size());


            }
            stmt.close();
        } catch (Exception e) {
            System.err.println("Got an exception! ");
            System.err.println(e.toString());
        }

        double[] xdata = str_ListtoArray(xdata_list);
        double[] ydata = dou_ListtoArray(ydata_list);
        int start = 0;

        ecg = new ECG(new double[][]{xdata, ydata});
    }

    public double[][] getsnippet(int locator)
    {
        //System.out.println(Arrays.toString(subArray(ecg.get_xdata(), locator, locator+99)));
        return(new double[][]{subArray(ecg.get_xdata(), locator, locator+99), subArray(ecg.get_ydata(), locator, (locator++)+99)});
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
