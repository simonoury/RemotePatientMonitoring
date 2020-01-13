package Alarm;

import Model.Patient;

import javax.swing.*;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Alarmpanel {
    private double data_HR;
    private double data_RR;
    private double data_BP;
    private double data_BT;
    private  double data_HR_next;
    private double data_RR_next;
    private double data_BP_next;
    private double data_BT_next;
    private JPanel heartrate, bloodpressure, bodytemperature, respiratoryrate;
    private JPanel ecg, valuesPanel;
    Patient patient;
    JLabel label;
    JLabel label2;
    JLabel label3;
    JLabel label4;

    public Alarmpanel(Patient p) {
        ecg = new JPanel();
        valuesPanel = new JPanel();
        valuesPanel.setLayout(new GridLayout(5, 5));
        patient = p;

        ecg.setBackground(Color.black);

        //Array of values to be replaced with database values

        data_HR = getdata_HR();
        data_BP = getdata_BP();
        //data_DBP=getdata_DBP();
        data_BT = getdata_BT();
        data_RR = getdata_RR();

        //calling the alarm
        JLabel label = new JLabel();
        //label.setVerticalAlignment(JLabel.CENTER);
        label.setText("<html><h2><font color=white>"+String.valueOf(patient.getHrcurrent())+"</font></h2>");
        heartrate = new JPanel();
        heartrate.add(label);
        heartrate.setBackground(Color.BLACK);
        valuesPanel.add(heartrate);
        label.setText("<html><h2><font color=white>"+String.valueOf(patient.getBpcurrent())+"</font></h2>");
        bloodpressure = new JPanel();
        bloodpressure.add(label);
        bloodpressure.setBackground(Color.BLACK);
        valuesPanel.add(bloodpressure);
        label.setText("<html><h2><font color=white>"+String.valueOf(patient.getBtcurrent())+"</font></h2>");
        bodytemperature = new JPanel();
        bodytemperature.add(label);
        bodytemperature.setBackground(Color.BLACK);
        valuesPanel.add(bodytemperature);
        label.setText("<html><h2><font color=white>"+String.valueOf(patient.getRrcurrent())+"</font></h2>");
        respiratoryrate = new JPanel();
        respiratoryrate.add(label);
        respiratoryrate.setBackground(Color.BLACK);
        valuesPanel.add(respiratoryrate);
        valuesPanel.setPreferredSize(new Dimension(200, 640));
        valuesPanel.setBackground(Color.black);
        valuesPanel.setBorder(new MatteBorder(2, 2, 2, 2, Color.BLACK));
        data_HR = patient.getHrcurrent();
        data_BP = patient.getBpcurrent();
        data_BT = patient.getBtcurrent();
        data_RR = patient.getRrcurrent();

    }


    protected double getdata_HR() {
        return patient.getHrcurrent();
    }

    protected double getdata_BP() {
        return patient.getBpcurrent();
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

    public void Update() {
        label = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();
        label4 = new JLabel();
        label.setText("<html><h2><font color=white>"+patient.getHrcurrent()+"</font></h2>");
        label2.setText("<html><h2><font color=white>"+patient.getBpcurrent()+"</font></h2>");
        label3.setText("<html><h2><font color=white>"+patient.getBtcurrent()+"</font></h2>");
        label4.setText("<html><h2><font color=white>"+patient.getRrcurrent()+"</font></h2>");
        heartrate = new JPanel();
        heartrate.add(label);
        if(patient.getHrcurrent()<45 || patient.getHrcurrent()>120)
        {
            heartrate.setBackground(Color.RED);
        }
        else if(patient.getHrcurrent()<50 || patient.getHrcurrent()>100)
        {
            heartrate.setBackground(Color.ORANGE);
        }
        else
        {
            heartrate.setBackground(Color.BLACK);
        }
        bloodpressure = new JPanel();
        bloodpressure.add(label2);
        if(patient.getBpcurrent()<108 || patient.getBpcurrent()>139)
        {
            bloodpressure.setBackground(Color.RED);
        }
        else if(patient.getBpcurrent()<115 || patient.getBpcurrent()>120)
        {
            bloodpressure.setBackground(Color.ORANGE);
        }
        else
        {
            bloodpressure.setBackground(Color.BLACK);
        }
        bodytemperature = new JPanel();
        bodytemperature.add(label3);
        if(patient.getBtcurrent()<35.5 || patient.getBtcurrent()>39)
        {
            bodytemperature.setBackground(Color.RED);
        }
        else if(patient.getHrcurrent()<36.5 || patient.getHrcurrent()>37.5)
        {
            bodytemperature.setBackground(Color.ORANGE);
        }
        else
        {
            bodytemperature.setBackground(Color.BLACK);
        }
        respiratoryrate = new JPanel();
        respiratoryrate.add(label4);
        if(patient.getRrcurrent()<12 || patient.getRrcurrent()>25)
        {
            respiratoryrate.setBackground(Color.RED);
        }
        else if(patient.getRrcurrent()<13 || patient.getRrcurrent()>18)
        {
            respiratoryrate.setBackground(Color.ORANGE);
        }
        else
        {
            respiratoryrate.setBackground(Color.BLACK);
        }
        valuesPanel.removeAll();
        valuesPanel.add(ecg);
        valuesPanel.add(respiratoryrate);
        valuesPanel.add(bodytemperature);
        valuesPanel.add(bloodpressure);
        valuesPanel.add(heartrate);
        valuesPanel.setPreferredSize(new Dimension(200, 640));
        valuesPanel.setBackground(Color.black);
        valuesPanel.setBorder(new MatteBorder(2, 2, 2, 2, Color.BLACK));


    }
}


