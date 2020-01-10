package RecordsPage;

import Model.Patient;
import javax.swing.*;
import java.awt.Dimension;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.util.stream.IntStream;

public class RecordsPanel extends JPanel {
    //seeversion
    private JPanel patientProfile;
    private JPanel recordedvalues;
    private JPanel averagevalues;
    private JPanel info;
    private JPanel time, heartrate, bloodpressure, bodytemperature, respiratoryrate;
    private JPanel heartrateaverage, bloodpressureaverage, bodytemperatureaverage, respiratoryrateaverage;
    int locator = 0;
    private Patient patient;

    private int timevalues[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    //private double heartratevalues[] = {118, 119, 118, 119, 120, 121, 120, 119, 119, 118};
    //private int bloodpressurevalues [] = {118, 119, 118, 119, 120, 121, 120, 119, 119, 118};
    //private double bodytemperaturevalues [] = {37.1, 37.2, 37.2, 37.3, 38.5, 38.0, 37.9, 37.6, 37.3, 37.1};
    //private int respiratoryratevalues [] = {14, 15, 14, 16, 18, 17, 16, 15, 14, 14};


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
        info = new JPanel();
        heartrateaverage = new JPanel();
        bloodpressureaverage= new JPanel();
        bodytemperatureaverage= new JPanel();
        respiratoryrateaverage= new JPanel();

        double phase = 0;
        double data_HR [] = getdata_HR();
        double data_BP [] = getdata_BP();
        double data_BT [] = getdata_BT();
        double data_RR [] = getdata_RR();
        double data_time [] = getdata_time();


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
        time.setBackground(Color.black);

        //Fill info Jlabel
        info.setLayout(new GridLayout(3, 1));
        JLabel name = new JLabel("<html> <font color=white>"+patient.getFamilyname() + " " + patient.getGivenname()+ "</font> </html>");
        JLabel id = new JLabel("<html><font color=white>Patient id: " + patient.getId()+"</font> </html>");
        JLabel age = new JLabel("<html><font color=white>Age: 27 years old </font> </html>");

        info.add(name);
        info.add(id);
        info.add(age);
        info.setSize(new Dimension(160, 50));


        recordedvalues.setLayout((new GridLayout(1, 5)));

        //fill in table with values from array -------------------------------------------------------------------------

        time.setLayout(new GridLayout(11, 1));
        time.setPreferredSize(new Dimension(50, 150));
        time.add(new JLabel("<html><h4> <font color=white>  Time:   </font></h4>"));
        for (int timevalue : timevalues) {
            time.add(new JLabel("<html> <font color=white>"+String.valueOf(timevalue)+" h </font> </html>"));
        }
        recordedvalues.add(time);


        data_HR = getdata_HR();
        double heartratevalues [] = {data_HR[1],data_HR[100], data_HR[220], data_HR[300], data_HR[520], data_HR[600], data_HR[800], data_HR[1000], data_HR[1250], data_HR[1500] };
        heartrate.setLayout(new GridLayout(11, 1));
        heartrate.add(new JLabel("<html> <h4><font color=white> HR:  </font> </h4>"));
        for (double heartratevalue : heartratevalues) {
            heartrate.add(new JLabel("<html><font color=white>"+String.valueOf(heartratevalue)+"</font></html>"));
        }
        recordedvalues.add(heartrate);


        data_BP = getdata_BP();
        double bloodpressurevalues [] = {data_BP[1],data_BP[100], data_BP[220], data_BP[300], data_BP[520], data_BP[600], data_BP[800], data_BP[1000], data_BP[1250], data_BP[1500] };
        bloodpressure.setLayout(new GridLayout(11, 1));
        bloodpressure.add(new JLabel("<html><h4><font color=white>  BP:  </font> </h4>"));
        for (double bloodpressurevalue : bloodpressurevalues) {
            bloodpressure.add(new JLabel("<html><font color=white>"+ String.valueOf(bloodpressurevalue)+"</font></html>"));
        }
        recordedvalues.add(bloodpressure);

        data_BT = getdata_BT();
        double bodytemperaturevalues [] = {data_BT[1],data_BT[100], data_BT[220], data_BT[300], data_BT[520], data_BT[600], data_BT[800], data_BT[1000], data_BT[1250], data_BT[1500] };
        bodytemperature.setLayout(new GridLayout(11, 1));
        bodytemperature.add(new JLabel("<html> <h4><font color=white>  BT:  </font></h4>"));
        for (double bodytemperaturevalue : bodytemperaturevalues) {
            bodytemperature.add(new JLabel("<html><font color=white>"+String.valueOf(bodytemperaturevalue)+"</font> </html>"));
        }
        recordedvalues.add(bodytemperature);

        data_RR = getdata_RR();
        double respiratoryratevalues [] = {data_RR[1],data_RR[100], data_RR[220], data_RR[300], data_RR[520], data_RR[600], data_RR[800], data_RR[1000], data_RR[1250], data_RR[1500] };
        respiratoryrate.setLayout(new GridLayout(11, 1));
        respiratoryrate.add(new JLabel("<html><h4><font color=white>  RR:  <font color=white></h4>"));
        for (double respiratoryratevalue : respiratoryratevalues) {
            respiratoryrate.add(new JLabel("<html><h4><font color=white>"+String.valueOf(respiratoryratevalue)+"</font> </h4></html>"));
        }
        recordedvalues.add(respiratoryrate);


        //calculate and fill in average values -------------------------------------------------------------------------
        averagevalues.setLayout(new GridLayout(5, 1));
        averagevalues.add(new JLabel("<html><h4><font color=white>  Average Values:  </font></h4> "));

        double avgheartrate;
        double sum = 0;
        for (double val : heartratevalues){
            sum = sum + val;
        }
        avgheartrate = sum/heartratevalues.length;
        heartrateaverage.add(new JLabel("<html><font color=white> Heart Rate average value: </font>"));
        heartrateaverage.add(new JLabel("<html><font color=white>"+String.valueOf(avgheartrate)+"</font> </html>"));
        averagevalues.add(heartrateaverage);

        double avgbloodpressure;
        sum = 0;
        for (double val : bloodpressurevalues){
            sum = sum + val;
        }
        avgbloodpressure = sum/bloodpressurevalues.length;
        bloodpressureaverage.add(new JLabel("<html><font color=white>Blood Pressure average value: </font>"));
        bloodpressureaverage.add(new JLabel("<html><font color=white>"+String.valueOf(avgbloodpressure)+"</font> </html>"));
        averagevalues.add(bloodpressureaverage);

        double avgbodytemperature;
        sum = 0; //as IntStream.of().sum() does not work for double values
        for (double val : bodytemperaturevalues) {
            sum = sum + val;
        }
        avgbodytemperature = sum/bodytemperaturevalues.length;
        bodytemperatureaverage.add(new JLabel("<html><font color=white>Body Temperature average value:</font>"));
        bodytemperatureaverage.add(new JLabel("<html><font color=white>"+String.valueOf(avgbodytemperature)+"</font> </html>"));
        averagevalues.add(bodytemperatureaverage);

        double avgrespiratoryrate;
        sum = 0;
        for (double val : respiratoryratevalues){
            sum = sum + val;
        }
        avgrespiratoryrate = sum/respiratoryratevalues.length;
        respiratoryrateaverage.add(new JLabel("<html><font color=white>Respiratory Rate average value:</font>"));
        respiratoryrateaverage.add(new JLabel("<html><font color=white>"+String.valueOf(avgrespiratoryrate)+"</font> </html>"));
        averagevalues.add(respiratoryrateaverage);


        //set dimensions of jpanels
        info.setPreferredSize(new Dimension(500, 75));
        info.setVisible(true);
        recordedvalues.setPreferredSize(new Dimension(525, 400));
        recordedvalues.setVisible(true);
        recordedvalues.setBorder(new MatteBorder(2, 0, 2, 0, Color.BLACK) );
        averagevalues.setPreferredSize(new Dimension(540, 150));
        averagevalues.setVisible(true);

        patientProfile.setPreferredSize(new Dimension(550, 645));
        patientProfile.setVisible(true);

        //add JPanels to main Panel patientProgfile
        patientProfile.add(info);
        patientProfile.add(recordedvalues);
        patientProfile.add(averagevalues);

        patientProfile.setBorder(new MatteBorder(2, 2, 2, 2, Color.BLACK) );
        patientProfile.setBackground(Color.black);

    }

    protected double[] getdata_HR() {
        return patient.getHRdata();
    }
    protected double[] getdata_BP() {
        return patient.getBPdata();
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

    public JPanel getPatientProfileRecords() {return patientProfile;}
}
