package Alarm;


import javax.swing.*;
import java.awt.*;

public class AlarmPanel extends JPanel {
    private JPanel alarmpanel= new JPanel();
    private FlowLayout grid;
    private JLabel label=new JLabel();
    private JLabel label2 =new JLabel();
    int[] HR_values={110,110};
    private Alarm HR_alarm=new Alarm(65,100,60,120,HR_values);
    private Alarm RR_alarm=new Alarm(35,80,25,100,HR_values);



    public AlarmPanel(){
        grid=new FlowLayout();
        alarmpanel.setLayout(grid);

        label.setText("Heart Rate:");
        label.setOpaque(true);
        alarmpanel.add(label);
        HR_alarm.getAlarm().setOpaque(true);
        alarmpanel.add(HR_alarm.getAlarm());

        label2.setText("Respiratory Rate:");
        label2.setOpaque(true);
        alarmpanel.add(label2);
        RR_alarm.getAlarm().setOpaque(true);
        alarmpanel.add(RR_alarm.getAlarm());




    }

    public JPanel getpanel(){
        return alarmpanel;
    }

}
