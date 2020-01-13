package RecordsPage;

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
    private JPanel time, heartrate, bloodpressure, bodytemperature, respiratoryrate, diastolicpressure;
    private JPanel heartrateaverage, bloodpressureaverage, bodytemperatureaverage, respiratoryrateaverage, diastolicpressureaverage;
    int locator = 0;
    private Patient patient;


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

        //Average JPanels
        heartrateaverage = new JPanel();
        bloodpressureaverage= new JPanel();
        bodytemperatureaverage= new JPanel();
        respiratoryrateaverage= new JPanel();

        //creates am array with the data in PostegreSQL
        double data_HR [] = getdata_HR();
        double data_BP [] = getdata_BP();
        double data_DBP [] = getdata_DBP();
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
        JLabel name = new JLabel("<html> <h2> <font color=white>"+patient.getFamilyname() + " " + patient.getGivenname()+ "</font> </html>");
        JLabel id = new JLabel("<html><font color=white>Patient id: " + patient.getId()+"</font> </html>");
        JLabel age = new JLabel("<html><font color=white>Age: 27 years old </font> </html>");

        info.add(name);
        info.add(id);
        info.add(age);
        info.setSize(new Dimension(160, 50));


        recordedvalues.setLayout((new GridLayout(1, 5)));

        //fill in table with values from array
        double timevalues [] = {data_time[1],data_time[150], data_time[300], data_time[503], data_time[650], data_time[800], data_time[953], data_time[1100], data_time[1450], data_time[1800] };
        time.setLayout(new GridLayout(11, 1));
        time.add(new JLabel("<html><h4> <font color=white>  Time:   </font></h4>"));
        for (double timevalue : timevalues) { //for loop feeds in the values to the JPanel
            time.add(new JLabel("<html> <font color=white>"+String.valueOf(timevalue)+" ms </font> </html>"));
        }
        recordedvalues.add(time);


        double heartratevalues [] = {data_HR[1],data_HR[150], data_HR[300], data_HR[503], data_HR[650], data_HR[800], data_HR[953], data_HR[1100], data_HR[1450], data_HR[1800] };
        heartrate.setLayout(new GridLayout(11, 1));
        heartrate.add(new JLabel("<html> <h4><font color=white> HR:  </font> </h4>"));
        for (double heartratevalue : heartratevalues) {
            heartrate.add(new JLabel("<html><font color=white>"+String.valueOf(heartratevalue)+"</font></html>"));
        }
        recordedvalues.add(heartrate);



        double bloodpressurevalues [] = {data_BP[1],data_BP[150], data_BP[300], data_BP[503], data_BP[650], data_BP[800], data_BP[953], data_BP[1100], data_BP[1450], data_BP[1800] };
        double diastolicpressurevalues [] = {data_DBP[1],data_DBP[150], data_DBP[300], data_DBP[503], data_DBP[650], data_DBP[800], data_DBP[953], data_DBP[1100], data_DBP[1450], data_DBP[1800] };
        bloodpressure.setLayout(new GridLayout(11, 1));
        bloodpressure.add(new JLabel("<html><h4><font color=white>  SBP/DBP:  </font> </h4>"));
        for (int i = 0; i < bloodpressurevalues.length; i++) {
            bloodpressure.add(new JLabel("<html><font color=white>"+ String.valueOf(bloodpressurevalues[i])+"/" +String.valueOf(diastolicpressurevalues[i]) +"</font></html>"));
        }
        recordedvalues.add(bloodpressure);

        double bodytemperaturevalues [] = {data_BT[1],data_BT[150], data_BT[300], data_BT[503], data_BT[650], data_BT[800], data_BT[953], data_BT[1100], data_BT[1503], data_BT[1800] };
        bodytemperature.setLayout(new GridLayout(11, 1));
        bodytemperature.add(new JLabel("<html> <h4><font color=white>  BT:  </font></h4>"));
        for (double bodytemperaturevalue : bodytemperaturevalues) {
            bodytemperature.add(new JLabel("<html><font color=white>"+String.valueOf(bodytemperaturevalue)+"</font> </html>"));
        }
        recordedvalues.add(bodytemperature);

        double respiratoryratevalues [] = {data_RR[1],data_RR[150], data_RR[300], data_RR[503], data_RR[650], data_RR[800], data_RR[953], data_RR[1100], data_RR[1503], data_RR[1800] };
        respiratoryrate.setLayout(new GridLayout(11, 1));
        respiratoryrate.add(new JLabel("<html><h4><font color=white>  RR:  <font color=white></h4>"));
        for (double respiratoryratevalue : respiratoryratevalues) {
            respiratoryrate.add(new JLabel("<html><h4><font color=white>"+String.valueOf(respiratoryratevalue)+"</font> </h4></html>"));
        }
        recordedvalues.add(respiratoryrate);


        //calculate and fill in average values
        averagevalues.setLayout(new GridLayout(5, 1));
        averagevalues.add(new JLabel("<html><h4><font color=white>  Average Values:  </font></h4> "));

        double avgheartrate;
        double sum = 0;
        for (double val : heartratevalues){
            sum = sum + val; //finds the average
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
        double avgdiastolicpressure;
        sum = 0;
        for (double val : diastolicpressurevalues){
            sum = sum + val;
        }
        avgdiastolicpressure = sum/diastolicpressurevalues.length;
        bloodpressureaverage.add(new JLabel("<html><font color=white>Blood Pressure average value: </font>"));
        bloodpressureaverage.add(new JLabel("<html><font color=white>"+String.valueOf(avgbloodpressure)+"/"+String.valueOf(avgdiastolicpressure)+"</font> </html>"));
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
        recordedvalues.setBorder(new MatteBorder(2, 0, 2, 0, Color.WHITE) );
        averagevalues.setPreferredSize(new Dimension(540, 150));
        averagevalues.setVisible(true);

        patientProfile.setPreferredSize(new Dimension(550, 645));
        patientProfile.setVisible(true);

        //add JPanels to main Panel patientProfile
        patientProfile.add(info);
        patientProfile.add(recordedvalues);
        patientProfile.add(averagevalues);

        patientProfile.setBorder(new MatteBorder(2, 2, 2, 2, Color.WHITE) );
        patientProfile.setBackground(Color.black);

    }

    //functions used to get data from class Patient
    protected double[] getdata_HR() {
        return patient.getHRdata();
    }
    protected double[] getdata_BP() {
        return patient.getBPdata();
    }
    protected double[] getdata_DBP() {
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

    public JPanel getPatientProfileRecords() {return patientProfile;}
}
