package Alarm;


import Model.Patient;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Alarm {
    private int warning_bound_low;
    private int warning_bound_high;
    private int danger_bound_low;
    private int danger_bound_high;
    Patient patient;

    private double[] values;
    private double value;
    private JLabel alarm;
    private JPanel alarmcontainer;
    private Timer timer;
    private int count;

    public Alarm(Patient p, int warning_bound_low, int warning_bound_high, int danger_bound_low, int danger_bound_high, double[] values, double value) {
        this.patient=p;
        this.values=values;
        this.value=value;
        this.warning_bound_low = warning_bound_low;
        this.warning_bound_high = warning_bound_high;
        this.danger_bound_low = danger_bound_low;
        this.danger_bound_high = danger_bound_high;
        this.values = values;

        alarm = new JLabel();
        alarmcontainer = new JPanel();
        alarmcontainer.setOpaque(true);

        timer=new Timer(1, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(count%2==0)
                    alarmcontainer.setBackground(Color.red);
                else
                    alarmcontainer.setBackground(Color.white);
                count++;

            }
        });

        for(int i=0;i<values.length;i++){

            if (values[i] > danger_bound_high || values[i] < danger_bound_low) {
                alarmcontainer.setBackground(Color.red);
                alarm.setVisible(true);
            }
            if ((values[i] > warning_bound_high && values[i] < danger_bound_high) || (values[i] < warning_bound_low && values[i] > danger_bound_low)) {

                alarmcontainer.setBackground(Color.yellow);
                alarm.setVisible(true);
            } else {

                alarmcontainer.setBackground(Color.green);
                alarm.setVisible(true);
            }
            alarmcontainer.add(new JLabel(String.valueOf(getValue(i))));
            alarmcontainer.updateUI();
        }
    }

    public JPanel getAlarm(double[] values){

        for(int i=0;i<values.length;i++){

            if (values[i] > danger_bound_high || values[i] < danger_bound_low) {
                alarmcontainer.setBackground(Color.red);
                alarm.setVisible(true);
            }
            if ((values[i] > warning_bound_high && values[i] < danger_bound_high) || (values[i] < warning_bound_low && values[i] > danger_bound_low)) {

                alarmcontainer.setBackground(Color.yellow);
                alarm.setVisible(true);
            } else {

                alarmcontainer.setBackground(Color.green);
                alarm.setVisible(true);
            }
            alarmcontainer.add(new JLabel(String.valueOf(values[i])));
            alarmcontainer.updateUI();
        }
        return alarmcontainer;
    }


    public JPanel addText(double value){
        alarmcontainer.updateUI();
        alarmcontainer.add(new JLabel(String.valueOf(value)));
        return alarmcontainer;
    }

    public double getValue(int i){
       return values[i];
    }

    public void update(){
        alarmcontainer.removeAll();
        getAlarm(values);
    }

}