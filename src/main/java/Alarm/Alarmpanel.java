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
    private double data_HR[], data_RR[], data_BP[], data_BT[];
    private Alarm heartrate, bloodpressure, bodytemperature, respiratoryrate;
    private JPanel ecg, valuesPanel;
    Patient patient;

    public Alarmpanel(Patient p) {
        ecg = new JPanel();
        valuesPanel = new JPanel();
        patient = p;

        ecg.setBackground(Color.black);

        //Array of values to be replaced with database values

        data_HR = getdata_HR();
        data_BP = getdata_BP();
        //data_DBP=getdata_DBP();
        data_BT = getdata_BT();
        data_RR = getdata_RR();

        //calling the alarm
        heartrate = new Alarm(patient, 50, 100, 45, 120, data_HR);
        bloodpressure = new Alarm(patient, 115, 120, 108, 139, data_BP);
        //d_bloodpressure = new Alarm(patient, 78, 80, 75, 89, data_DBP);
        bodytemperature = new Alarm(patient, 36.5, 37.5, 35.5, 39, data_BT);
        respiratoryrate = new Alarm(patient, 13, 18, 12, 25, data_RR);

        final int[] j = {0};
        ActionListener taskPerformer = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                valuesPanel.add(ecg);
                if (data_HR[j[0] + 1] == data_HR[j[0]]) {
                    heartrate.addText(data_HR[j[0]]);
                    valuesPanel.add(heartrate.getAlarm(data_HR[j[0]]));
                }
                if (data_BP[j[0] + 1] == data_BP[j[0]]) {
                    bloodpressure.addText(data_BP[j[0]]);
                    valuesPanel.add(bloodpressure.getAlarm(data_BP[j[0]]));
                }
                if (data_BT[j[0] + 1] == data_BT[j[0]]) {
                    bodytemperature.addText(data_BT[j[0]]);
                    valuesPanel.add(bodytemperature.getAlarm(data_BT[j[0]]));
                }
                if (data_RR[j[0] + 1] == data_RR[j[0]]) {
                    respiratoryrate.addText(data_RR[j[0]]);
                    valuesPanel.add(respiratoryrate.getAlarm(data_RR[j[0]]));
                    ;
                } else {
                    heartrate.addText(data_HR[j[0] + 1]);
                    bloodpressure.addText(data_BP[j[0] + 1]);
                    bodytemperature.addText(data_BT[j[0] + 1]);
                    respiratoryrate.addText(data_RR[j[0] + 1]);

                    valuesPanel.add(heartrate.getAlarm(data_HR[j[0] + 1]));
                    valuesPanel.add(bodytemperature.getAlarm(data_BT[j[0] + 1]));
                    valuesPanel.add(bloodpressure.getAlarm(data_BP[j[0] + 1]));
                    valuesPanel.add(respiratoryrate.getAlarm(data_RR[j[0] + 1]));
                    ;

                }
                j[0] = j[0] + 20;
            }
        };
        Timer t = new Timer(1000, taskPerformer);
        t.start();


        valuesPanel.setLayout(new GridLayout(5, 1));
        valuesPanel.setPreferredSize(new Dimension(200, 640));
        valuesPanel.setBackground(Color.black);
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

    protected double[] getdata_time() {
        return patient.getTimedata();
    }

    public JPanel getValuesPanel() {
        return valuesPanel;
    }

    public void Update(){


               /* for(int i=0;i<data_HR.length;i++) {
                    valuesPanel.add(ecg);
                    valuesPanel.add(heartrate.getAlarm(data_HR[i]));
                    valuesPanel.add(bodytemperature.getAlarm(data_BT[i]));
                    valuesPanel.add(bloodpressure.getAlarm(data_BP[i]));
                    valuesPanel.add(respiratoryrate.getAlarm(data_RR[i]));
                }*/



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
