import javax.swing.*;
import java.awt.*;
import java.sql.Time;

public class Clock {
    private JPanel clock_panel;
    public Time time;
    private JLabel tlabel;
    public Clock(){
        clock_panel=new JPanel();
        clock_panel.setLayout(new GridLayout(1,1));
        Clock clock= new Clock();
        tlabel= new JLabel(String.valueOf(time.getTime()));
        tlabel.setVisible(true);
        clock_panel.add(tlabel);

    }

    public JPanel getClock_panel() {
        return clock_panel;
    }
}
