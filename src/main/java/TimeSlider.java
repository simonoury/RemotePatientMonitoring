import javax.swing.*;
import java.awt.*;

public class TimeSlider extends JPanel {
    private JSlider slider;
    private JPanel control;

    public TimeSlider() {
        control = new JPanel();
        control.setLayout(new GridLayout(2,1));
        JLabel label = new JLabel("Time:");
        slider = new JSlider(1,36);
        control.add(label);
        control.add(slider);
        add(control);
    }
    public int getSliderVal() {
        return(slider.getValue());
    }
}
