import Alarm.AlarmPanel;

import javax.swing.*;
import java.awt.*;

public class BlankBoard extends JPanel {
    private JPanel mainpanel;
    AlarmPanel alarmpanel=new AlarmPanel();
    GridLayout gridmain;
    public BlankBoard(){
        mainpanel= new JPanel();
        gridmain=new GridLayout(5,2);

        mainpanel.setLayout(gridmain);
        mainpanel.add(alarmpanel.getpanel());

    }

    public JPanel getMainPanel() {
        return mainpanel;
    }
}
