package Alarm;

import Database.DBConnect;
import Model.Patient;

import javax.swing.*;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.GregorianCalendar;


public class Alarmpanel {
    private double data_HR, data_RR, data_BP, data_BT;
    private Alarm heartrate, bloodpressure, bodytemperature, respiratoryrate;
    private JPanel ecg, valuesPanel;
    Patient patient;
    private JLabel[] alarms = new JLabel[5];

    public Alarmpanel(Patient p) {
        ecg = new JPanel();
        valuesPanel = new JPanel();
        valuesPanel.setBackground(Color.BLACK);
        patient = p;

        ecg.setBackground(Color.black);

        //fetch data from Patient class
        data_HR = getdata_HR();
        data_BP = getdata_BP();
        //data_DBP=getdata_DBP();
        data_BT = getdata_BT();
        data_RR = getdata_RR();

        //calling the alarm
        for(int i=0; i<5; i++) {
            alarms[i] = new JLabel();
            alarms[i].setVerticalAlignment(JLabel.CENTER);
        }
        alarms[1].setText("<html><h2><font color=white>"+data_HR+"</font></h2>");
        alarms[3].setText("<html><h2><font color=white>"+data_BP+"</font></h2>");
        alarms[2].setText("<html><h2><font color=white>"+data_BT+"</font></h2>");
        alarms[4].setText("<html><h2><font color=white>"+data_RR+"</font></h2>");



        for (JLabel alarm : alarms)
        {
            valuesPanel.add(alarm);
        }
        //valuesPanel.add(ecg);
        valuesPanel.setLayout(new GridLayout(5, 1));
        valuesPanel.setPreferredSize(new Dimension(200, 640));
        valuesPanel.setBackground(Color.black);
        valuesPanel.setBorder(new MatteBorder(2, 2, 2, 2, Color.BLACK));

    }


    protected double getdata_HR() {
        return patient.getHrcurrent();
    }

    protected double getdata_BP() {
        return patient.getDBpcurrent();
    }

    protected double getdata_BT() {
        return patient.getBtcurrent();
    }

    protected double getdata_RR() {
        return patient.getRrcurrent();
    }

    protected double[] getdata_time() {
        return patient.getTimedata();
    }

    public JPanel getValuesPanel() {
        return valuesPanel;
    }

    public Alarm getHeartrate() {
        return heartrate;
    }

    public Alarm getBloodpressure() {
        return bloodpressure;
    }

    public Alarm getRespiratoryrate() {
        return respiratoryrate;
    }

    public Alarm getBodytemperature() {
        return bodytemperature;
    }

    public void Update(){
        data_HR = getdata_HR();
        data_BP = getdata_BP();
        //data_DBP=getdata_DBP();
        data_BT = getdata_BT();
        data_RR = getdata_RR();

        //calling the alarm
        for(int i=0; i<alarms.length; i++) {
            alarms[i] = new JLabel();
            alarms[i].setVerticalAlignment(JLabel.CENTER);
            alarms[i].setOpaque(true);
        }
        alarms[1].setText("<html><h2><font color=white>"+data_HR+"</font></h2>");
        alarms[3].setText("<html><h2><font color=white>"+data_BP+"</font></h2>");
        alarms[2].setText("<html><h2><font color=white>"+data_BT+"</font></h2>");
        alarms[4].setText("<html><h2><font color=white>"+data_RR+"</font></h2>");

        System.out.println("dataHR" +data_HR);
        if(data_HR<80 || data_HR>120) {alarms[1].setBackground(Color.RED);}
        else if (data_HR<50||data_HR>100) {alarms[1].setBackground(Color.ORANGE);}
        else {alarms[1].setBackground(Color.BLACK);
        System.out.println("no");}
        if(data_BP<108 || data_BP>139) {alarms[2].setBackground(Color.RED);}
        else if (data_BP<115||data_BP>120) {alarms[2].setBackground(Color.ORANGE);}
        else {alarms[2].setBackground(Color.BLACK);};
        if(data_BT<35.5 || data_BT>39) {alarms[3].setBackground(Color.RED);}
        else if (data_BT<36.5||data_BT>37.5) {alarms[3].setBackground(Color.ORANGE);}
        else {alarms[3].setBackground(Color.BLACK);};
        if(data_RR<25 || data_RR>12) {alarms[4].setBackground(Color.RED);}
        else if (data_RR<13||data_RR>18) {alarms[4].setBackground(Color.ORANGE);}
        else {alarms[4].setBackground(Color.BLACK);};
        ecg.setBackground(Color.BLACK);

        // heartrate = new Alarm(patient, 50, 100, 45, 120, data_HR);
        // bloodpressure = new Alarm(patient, 115, 120, 108, 139, data_BP);
        //d_bloodpressure = new Alarm(patient, 78, 80, 75, 89, data_DBP);
        //bodytemperature = new Alarm(patient, 36.5, 37.5, 35.5, 39, data_BT);
        //respiratoryrate = new Alarm(patient, 13, 18, 12, 25, data_RR);


        //valuesPanel.add(ecg);
        valuesPanel.setLayout(new GridLayout(5, 1));
        valuesPanel.setPreferredSize(new Dimension(200, 640));
        valuesPanel.setBorder(new MatteBorder(2, 2, 2, 2, Color.BLACK));
        valuesPanel.removeAll();
        for (JLabel alarm : alarms)
        {
            valuesPanel.add(alarm);
        }
        alarms[0].setBackground(Color.BLACK);
        valuesPanel.repaint();



    }
}
