import javax.swing.*;
import java.awt.*;

public class BlankBoard extends JPanel {
    private JPanel mainpanel;
    private GridLayout gridmain;
    private Clock clock;

    public BlankBoard(){
        mainpanel= new JPanel();
        gridmain=new GridLayout(2,2);
        mainpanel.setLayout(gridmain);
        //.add(clock.getClock_panel());
        mainpanel.add(new JPanel());
        mainpanel.add(new JPanel());


    }

    public JPanel getMainpanel() {
        return mainpanel;
    }
}
