import javax.swing.*;
import java.awt.*;

public class BlankBoard extends JPanel {
    private JPanel mainpanel;
    private GridLayout gridmain;

    public BlankBoard(){
        mainpanel= new JPanel();
        gridmain=new GridLayout(2,2);

        mainpanel.setLayout(gridmain);

        mainpanel.add(new JPanel());
        mainpanel.add(new JPanel());


    }

    public JPanel getMainpanel() {
        return mainpanel;
    }
}
