package RecordsPage;

import Alarm.Alarm;
import Model.Patient;
import javax.swing.*;
import java.awt.Dimension;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.util.stream.IntStream;

public class RecordsPanel extends JPanel {
    private JPanel patientProfile;
    private JPanel recordedvalues;
    private JPanel averagevalues;
    private JPanel info;
    private JPanel time, heartrate, bloodpressure,dbloodpressure, bodytemperature, respiratoryrate;
    private JPanel heartrateaverage, bloodpressureaverage,Dbloodpressureaverage, bodytemperatureaverage, respiratoryrateaverage;
    private double avgheartrate,avgbloodpressure,avgDbloodpressure,avgbodytemperature,avgrespiratoryrate;
    int locator = 0;
    private Patient patient;
    private double[] heartratevalues,bloodpressurevalues,bodytemperaturevalues,respiratoryratevalues,Dbloodpressurevalues;

    public RecordsPanel (Patient p){
        patient = p;
        //instantiate JPanels
        patientProfile = new JPanel();
        recordedvalues = new JPanel();
        averagevalues = new JPanel();
        time = new JPanel();
        heartrate = new JPanel();
        bloodpressure = new JPanel();
        bodytemperature = new JPanel();
        respiratoryrate = new JPanel();
        dbloodpressure=new JPanel();
        info = new JPanel();
        heartrateaverage = new JPanel();
        bloodpressureaverage= new JPanel();
        bodytemperatureaverage= new JPanel();
        respiratoryrateaverage= new JPanel();
        Dbloodpressureaverage=new JPanel();

        double phase = 0;
        double data_HR [] = getdata_HR();
        double data_BP [] = getdata_BP();
        double data_BT [] = getdata_BT();
        double data_RR [] = getdata_RR();
        double data_time [] = getdata_time();
        double data_DBP []= getdata_DBP();

        heartratevalues = new double[]{data_HR[1],data_HR[150], data_HR[300], data_HR[503], data_HR[650], data_HR[800], data_HR[953], data_HR[1100], data_HR[1450], data_HR[1800] };
        bloodpressurevalues=new double[] {data_BP[1],data_BP[150], data_BP[300], data_BP[503], data_BP[650], data_BP[800], data_BP[953], data_BP[1100], data_BP[1450], data_BP[1800] };
        bodytemperaturevalues = new double[]{data_BT[1],data_BT[150], data_BT[300], data_BT[503], data_BT[650], data_BT[800], data_BT[953], data_BT[1100], data_BT[1503], data_BT[1800] };
        respiratoryratevalues= new double[]{data_RR[1],data_RR[150], data_RR[300], data_RR[503], data_RR[650], data_RR[800], data_RR[953], data_RR[1100], data_RR[1503], data_RR[1800] };
        Dbloodpressurevalues=new double[]{data_DBP[1],data_DBP[150], data_DBP[300], data_DBP[503], data_DBP[650], data_DBP[800], data_DBP[953], data_DBP[1100], data_DBP[1450], data_DBP[1800] };


        //Colors
        info.setBackground(Color.black);
        recordedvalues.setBackground(Color.black);
        averagevalues.setBackground(Color.black);
        heartrate.setBackground(Color.black);
        bloodpressure.setBackground(Color.black);
        bodytemperature.setBackground(Color.black);
        respiratoryrate.setBackground(Color.black);
        heartrateaverage.setBackground(Color.black);
        bloodpressureaverage.setBackground(Color.black);
        bodytemperatureaverage.setBackground(Color.black);
        respiratoryrateaverage.setBackground(Color.black);
        dbloodpressure.setBackground(Color.black);
        Dbloodpressureaverage.setBackground(Color.black);
        time.setBackground(Color.black);

        //Fill info Jlabel
        info.setLayout(new GridLayout(3, 1));
        JLabel name = new JLabel("<html> <h2> <font color=white>"+patient.getFamilyname() + " " + patient.getGivenname()+ "</font> </html>");
        JLabel id = new JLabel("<html><font color=white>Patient id: " + patient.getId()+"</font> </html>");
        JLabel age = new JLabel("<html><font color=white>Age: 27 years old </font> </html>");

        info.add(name);
        info.add(id);
        info.add(age);
        info.setSize(new Dimension(160, 50));


        recordedvalues.setLayout((new GridLayout(1, 6)));

        //fill in table with values from array -------------------------------------------------------------------------

        double timevalues [] = {data_time[1],data_time[150], data_time[300], data_time[503], data_time[650], data_time[800], data_time[953], data_time[1100], data_time[1450], data_time[1800] };
        time.setLayout(new GridLayout(11, 1));
        time.add(new JLabel("<html><h4> <font color=white>  Time:   </font></h4>"));
        for (double timevalue : timevalues) {
            time.add(new JLabel("<html> <font color=white>"+String.valueOf(timevalue)+" ms </font> </html>"));
        }
        recordedvalues.add(time);

        //HR
        heartrate.setLayout(new GridLayout(11, 1));
        heartrate.add(new JLabel("<html> <h4><font color=white> HR:  </font> </h4>"));
        for (double heartratevalue : heartratevalues) {
            if(heartratevalue > 120 || heartratevalue < 45){
                heartrate.add(new JLabel("<html><font color=red>"+String.valueOf(heartratevalue)+"</font></html>"));
            }
            else if((heartratevalue> 100 && heartratevalue < 120) || (heartratevalue < 50 && heartratevalue > 45)){
                heartrate.add(new JLabel("<html><font color=orange>" + String.valueOf(heartratevalue) + "</font></html>"));
            }
            else{
                heartrate.add(new JLabel("<html><font color=green>" + String.valueOf(heartratevalue) + "</font></html>"));
            }
        }
        recordedvalues.add(heartrate);


        //SBP
        bloodpressure.setLayout(new GridLayout(11, 1));
        bloodpressure.add(new JLabel("<html><h4><font color=white>  BP (s):  </font> </h4>"));
        for (double bloodpressurevalue : bloodpressurevalues) {
            if(bloodpressurevalue > 139 || bloodpressurevalue < 108){
                bloodpressure.add(new JLabel("<html><font color=red>"+String.valueOf(bloodpressurevalue)+"</font></html>"));
            }
            else if((bloodpressurevalue> 120 && bloodpressurevalue < 139) || (bloodpressurevalue < 115 && bloodpressurevalue > 108)){
                bloodpressure.add(new JLabel("<html><font color=orange>" + String.valueOf(bloodpressurevalue) + "</font></html>"));
            }
            else{
                bloodpressure.add(new JLabel("<html><font color=green>" + String.valueOf(bloodpressurevalue) + "</font></html>"));
            }
        }
        recordedvalues.add(bloodpressure);

        //DBP
        dbloodpressure.setLayout(new GridLayout(11, 1));
        dbloodpressure.add(new JLabel("<html><h4><font color=white>  BP (d):  </font> </h4>"));
        for (double dbloodpressurevalue : Dbloodpressurevalues) {
            if(dbloodpressurevalue > 90 || dbloodpressurevalue < 75){
                dbloodpressure.add(new JLabel("<html><font color=red>"+String.valueOf(dbloodpressurevalue)+"</font></html>"));
            }
            else if((dbloodpressurevalue> 84 && dbloodpressurevalue < 88) || (dbloodpressurevalue < 78 && dbloodpressurevalue > 75)){
                dbloodpressure.add(new JLabel("<html><font color=orange>" + String.valueOf(dbloodpressurevalue) + "</font></html>"));
            }
            else{
                dbloodpressure.add(new JLabel("<html><font color=green>" + String.valueOf(dbloodpressurevalue) + "</font></html>"));
            }
        }
        recordedvalues.add(dbloodpressure);


        //BT
        data_BT = getdata_BT();
        bodytemperature.setLayout(new GridLayout(11, 1));
        bodytemperature.add(new JLabel("<html> <h4><font color=white>  BT:  </font></h4>"));
        for (double bodytemperaturevalue : bodytemperaturevalues) {
            if(bodytemperaturevalue > 39 || bodytemperaturevalue < 35.5){
               bodytemperature.add(new JLabel("<html><font color=red>"+String.valueOf(bodytemperaturevalue)+"</font></html>"));
            }
            else if((bodytemperaturevalue> 37.4 && bodytemperaturevalue < 39) || (bodytemperaturevalue < 36.6 && bodytemperaturevalue > 35.5)){
                bodytemperature.add(new JLabel("<html><font color=orange>" + String.valueOf(bodytemperaturevalue) + "</font></html>"));
            }
            else{
                bodytemperature.add(new JLabel("<html><font color=green>" + String.valueOf(bodytemperaturevalue) + "</font></html>"));
            }
        }
        recordedvalues.add(bodytemperature);

        //RR
        data_RR = getdata_RR();
        respiratoryrate.setLayout(new GridLayout(11, 1));
        respiratoryrate.add(new JLabel("<html><h4><font color=white>  RR:  <font color=white></h4>"));
        for (double respiratoryratevalue : respiratoryratevalues) {
            if(respiratoryratevalue> 25 || respiratoryratevalue < 11){
                respiratoryrate.add(new JLabel("<html><font color=red>"+String.valueOf(respiratoryratevalue)+"</font></html>"));
            }
            else if((respiratoryratevalue> 18 && respiratoryratevalue < 25) || (respiratoryratevalue < 14 && respiratoryratevalue > 12)){
                respiratoryrate.add(new JLabel("<html><font color=orange>" + String.valueOf(respiratoryratevalue) + "</font></html>"));
            }
            else{
                respiratoryrate.add(new JLabel("<html><font color=green>" + String.valueOf(respiratoryratevalue) + "</font></html>"));
            }
        }
        recordedvalues.add(respiratoryrate);


        //calculate and fill in average values -------------------------------------------------------------------------
        averagevalues.setLayout(new GridLayout(6, 1));
        averagevalues.add(new JLabel("<html><h4><font color=white>  Average Values:  </font></h4> "));

        //Average HR
        double sum = 0;
        for (double val : heartratevalues){
            sum = sum + val;
        }
        avgheartrate = sum/heartratevalues.length;
        heartrateaverage.add(new JLabel("<html><font color=white> Heart Rate average value: </font>"));
        heartrateaverage.add(new JLabel("<html><font color=white>"+String.valueOf(avgheartrate)+"</font> </html>"));
        averagevalues.add(heartrateaverage);

        //Average of BP
        sum = 0;
        for (double val : bloodpressurevalues){
            sum = sum + val;
        }
        avgbloodpressure = sum/bloodpressurevalues.length;
        bloodpressureaverage.add(new JLabel("<html><font color=white>Systolic Blood Pressure average value: </font>"));
        bloodpressureaverage.add(new JLabel("<html><font color=white>"+String.valueOf(avgbloodpressure)+"</font> </html>"));
        averagevalues.add(bloodpressureaverage);

        //Average of DBP
        sum = 0;
        for (double val : Dbloodpressurevalues){
            sum = sum + val;
        }
        avgDbloodpressure = sum/Dbloodpressurevalues.length;
        Dbloodpressureaverage.add(new JLabel("<html><font color=white> Diastolic Blood Pressure average value: </font>"));
        Dbloodpressureaverage.add(new JLabel("<html><font color=white>"+String.valueOf(avgDbloodpressure)+"</font> </html>"));
        averagevalues.add(Dbloodpressureaverage);

        //Average of BT
        sum = 0; //as IntStream.of().sum() does not work for double values
        for (double val : bodytemperaturevalues) {
            sum = sum + val;
        }
        avgbodytemperature = sum/bodytemperaturevalues.length;
        bodytemperatureaverage.add(new JLabel("<html><font color=white>Body Temperature average value:</font>"));
        bodytemperatureaverage.add(new JLabel("<html><font color=white>"+String.valueOf(avgbodytemperature)+"</font> </html>"));
        averagevalues.add(bodytemperatureaverage);

        //Average of RR
        sum = 0;
        for (double val : respiratoryratevalues){
            sum = sum + val;
        }
        avgrespiratoryrate = sum/respiratoryratevalues.length;
        respiratoryrateaverage.add(new JLabel("<html><font color=white>Respiratory Rate average value:</font>"));
        respiratoryrateaverage.add(new JLabel("<html><font color=white>"+String.valueOf(avgrespiratoryrate)+"</font> </html>"));
        averagevalues.add(respiratoryrateaverage);


        //set dimensions & layouts of Jpanels
        info.setPreferredSize(new Dimension(500, 75));
        info.setVisible(true);
        recordedvalues.setPreferredSize(new Dimension(600, 400));
        recordedvalues.setVisible(true);
        recordedvalues.setBorder(new MatteBorder(2, 0, 2, 0, Color.WHITE) );
        averagevalues.setPreferredSize(new Dimension(600, 150));
        averagevalues.setVisible(true);


        //add JPanels to main Panel patientProfile
        patientProfile.add(info);
        patientProfile.add(recordedvalues);
        patientProfile.add(averagevalues);

        //Patient Records Panel layout
        patientProfile.setPreferredSize(new Dimension(600, 645));
        patientProfile.setVisible(true);
        patientProfile.setBorder(new MatteBorder(2, 2, 2, 2, Color.WHITE) );
        patientProfile.setBackground(Color.black);

    }

    protected double[] getdata_HR() {
        return patient.getHRdata();
    }
    protected double[] getdata_BP() {
        return patient.getBPdata();
    }
    protected double[] getdata_DBP(){
       return patient.getDBPdata();
    }
    protected double[] getdata_BT() {
        return patient.getBTdata();
    }
    protected double[] getdata_RR() {
        return patient.getRRdata();
    }
    protected double[] getdata_time(){
        return patient.getTimedata();
    }

    public double getAvgheartrate(){return avgheartrate;};

    public double getAvgrespiratoryrate() {
        return avgrespiratoryrate;
    }

    public double getAvgbloodpressure() {
        return avgbloodpressure;
    }

    public double getAvgbodytemperature() {
        return avgbodytemperature;
    }

    public JPanel getPatientProfileRecords() {return patientProfile;}
}
