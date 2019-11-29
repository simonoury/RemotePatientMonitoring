package Alarm;


import javax.swing.*;
import java.awt.*;

public class AlarmPanel extends JPanel {
    private JPanel alarmpanel= new JPanel();
    private FlowLayout grid;
    private JLabel label = new JLabel();
    private HRalarm alarm=new HRalarm();


    public AlarmPanel(){
        grid=new FlowLayout();
        alarmpanel.setLayout(grid);

        label.setText("Heart Rate:");
        label.setOpaque(true);
        alarmpanel.add(label);
        alarm.getAlarm().setOpaque(true);
        alarmpanel.add(alarm.getAlarm());




    }

    public JPanel getpanel(){
        return alarmpanel;
    }

}
