package Alarm;


import javax.swing.*;
import java.awt.*;

public class AlarmPanel extends JPanel {
    private JPanel alarmpanel= new JPanel();
    private GridLayout grid;
    private JLabel label = new JLabel();

    public AlarmPanel(){
        grid=new GridLayout(4,2);
        alarmpanel.setLayout(grid);

        label.setText("Warning");
        alarmpanel.add(label);

    }

}
