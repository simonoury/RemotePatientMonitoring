package Alarm;

import javax.swing.*;
import java.awt.*;


public class HRalarm{
    int[] values={1,23,455,32,82,55,3};
    JLabel alarm;
    JPanel alarmcontainer;
    private String state;
    private Timer animator;

    public HRalarm(){
        alarm=new JLabel();
        alarmcontainer=new JPanel();
        alarm.setPreferredSize(new Dimension(40,25));



        for (int element:values){
            alarm.setText(String.valueOf(element));
            alarm.setHorizontalAlignment(0);

            if(element>120 || element<60){
                state="danger";
                alarm.setBackground(Color.red);
            }
            if(element>100 || element<65){
                state="warning";
                alarm.setBackground(Color.yellow);
            }
            else {
                state = "safe";
                alarm.setBackground(Color.green);
            }


            alarm.setVisible(true);

        }

    }
    public JLabel getAlarm(){
        return alarm;
    }
    public String returnstate(){
        return state;
    }


}
