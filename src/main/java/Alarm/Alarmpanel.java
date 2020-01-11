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
    private double heartratevalues[], data_HR[],data_RR[],data_BP[],data_BT[];
    private double bloodpressurevalues[] = {118, 119, 118, 119, 120, 121, 120, 119, 119, 118, 118, 119, 118, 119, 120, 121, 120, 119, 119, 118, 118, 119, 118, 119, 120, 121, 120, 119, 119, 118, 118, 119, 118, 119, 120, 121, 120, 119, 119, 118, 118, 119, 118, 119, 120, 121, 120, 119, 119, 118};
    private Alarm heartrate, bloodpressure, bodytemperature, respiratoryrate;
    private JPanel ecg, valuesPanel;
    Patient patient;

    public Alarmpanel(Patient p) {
        ecg = new JPanel();
        valuesPanel = new JPanel();
        patient = p;

        //Array of values to be replaced with database values

        data_HR = getdata_HR();
        data_BP=getdata_BP();
        data_BT=getdata_BT();
        data_RR=getdata_RR();


        //double heartratevalues [] = {data_HR[1],data_HR[100], data_HR[220], data_HR[300], data_HR[520], data_HR[600], data_HR[800], data_HR[1000], data_HR[1250], data_HR[1500] };

        //calling the alarm
        for(int i=0;i<data_HR.length;i++) {
            heartrate = new Alarm(patient, 3, 69, 50, 43, data_HR[i]);
            System.out.println(data_HR[i] + "\n");
            bloodpressure = new Alarm(patient, 3, 50, 5, 120, data_BP[i]);
            bodytemperature = new Alarm(patient, 3, 44, 5, 100, data_BT[i]);
            respiratoryrate = new Alarm(patient, 3, 44, 5, 100, data_RR[i]);
            valuesPanel.add(ecg);
            valuesPanel.add(heartrate.getAlarm(data_HR));
            valuesPanel.add(bodytemperature.getAlarm(data_BT));
            valuesPanel.add(bloodpressure.getAlarm(data_BP));
            valuesPanel.add(respiratoryrate.getAlarm(data_RR));
        }


            valuesPanel.setLayout(new GridLayout(5, 1));
            valuesPanel.setPreferredSize(new Dimension(100, 640));
            valuesPanel.setBorder(new MatteBorder(2, 2, 2, 2, Color.BLACK));






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
    public JPanel getValuesPanel () {
        return valuesPanel;
    }



}
/*
        ActionListener taskPerformer = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {

                //Index of array is current time:
                heartrate.getAlarm(heartratevalues[CurrentTime()]).removeAll();
                bloodpressure.getAlarm(heartratevalues[CurrentTime()]).removeAll();
                respiratoryrate.getAlarm(heartratevalues[CurrentTime()]).removeAll();
                bodytemperature.getAlarm(heartratevalues[CurrentTime()]).removeAll();

                heartrate.getAlarm(heartratevalues[CurrentTime()]).setOpaque(false);
                respiratoryrate.getAlarm(heartratevalues[CurrentTime()]).setOpaque(false);
                bloodpressure.getAlarm(heartratevalues[CurrentTime()]).setOpaque(false);
                bodytemperature.getAlarm(heartratevalues[CurrentTime()]).setOpaque(false);

                heartrate.addText("<html> <h2> "+toString().valueOf(heartratevalues[CurrentTime()])+"</h2> </html>");
                bloodpressure.addText("<html> <h2>"+toString().valueOf(bloodpressurevalues[CurrentTime()])+"</h2> </html>");
                respiratoryrate.addText("<html> <h2>"+toString().valueOf(heartratevalues[CurrentTime()])+"</h2> </html>");
                bodytemperature.addText("<html> <h2>"+toString().valueOf(heartratevalues[CurrentTime()])+"</h2> </html>");

                valuesPanel.add(ecg);
                valuesPanel.add(heartrate.getAlarm(heartratevalues[CurrentTime()]));
                valuesPanel.add(bodytemperature.getAlarm(heartratevalues[CurrentTime()]));
                valuesPanel.add(bloodpressure.getAlarm(heartratevalues[CurrentTime()]));
                valuesPanel.add(respiratoryrate.getAlarm(heartratevalues[CurrentTime()]));

            }
        };
        Timer t = new Timer(1000, taskPerformer);
        t.start();
    }
    public int CurrentTime(){
        Calendar cal = new GregorianCalendar();
        int second = cal.get(Calendar.SECOND);
        int min = cal.get(Calendar.MINUTE);
        int hour = cal.get(Calendar.HOUR);
        //heartrateLabel.setText(s);
        return second;

    }



}*/
