import Alarm.AlarmPanel;

import javax.swing.*;
import java.awt.*;

public class BlankBoard extends JPanel {
    private JPanel mainpanel;
    AlarmPanel alarmpanel=new AlarmPanel();
    public BlankBoard(){
        mainpanel.add(alarmpanel);

    }

    public JPanel getMainpanel() {
        return mainpanel;
    }
}
