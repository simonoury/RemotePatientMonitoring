package Alarm;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Alarm {
    private int warning_bound_low;
    private int warning_bound_high;
    private int danger_bound_low;
    private int danger_bound_high;

    private int[] values;
    private JLabel alarm;
    private JPanel alarmcontainer;
    private Timer timer;
    private int count;

    public Alarm(int warning_bound_low,int warning_bound_high,int danger_bound_low, int danger_bound_high, int[]values) {
        this.warning_bound_low = warning_bound_low;
        this.warning_bound_high = warning_bound_high;
        this.danger_bound_low = danger_bound_low;
        this.danger_bound_high = danger_bound_high;
        this.values = values;

        alarm = new JLabel();
        alarmcontainer = new JPanel();

        timer=new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(count%2==0)
                    alarmcontainer.setBackground(Color.red);
                else
                    alarmcontainer.setBackground(Color.white);
                count++;

            }
        });

        for (int element : values) {
            alarm.setText(String.valueOf(element));
            alarm.setHorizontalAlignment(0);
            alarmcontainer.add(alarm);

            if (element > danger_bound_high || element < danger_bound_low) {
                timer.start();
            }
            if ((element > warning_bound_high && element < danger_bound_high) || (element < warning_bound_low && element > danger_bound_low)) {

                alarmcontainer.setBackground(Color.yellow);
            } else {

                alarmcontainer.setBackground(Color.green);
            }
            alarm.setVisible(true);

        }
    }
    public JPanel getAlarm(){
        return alarmcontainer;
    }
    public JPanel addText(String text){
        alarmcontainer.add(new JLabel(text));
        return alarmcontainer;
    }

}