import javax.swing.*;
import java.awt.*;


public class BlankBoard extends JPanel {
    private JPanel mainpanel;

    private GridLayout grid;

    public BlankBoard(){
        mainpanel = new JPanel();
        grid=new GridLayout(1,1);


        mainpanel.setLayout(grid);


    }

    public JPanel getMainpanel() {
        return mainpanel;
    }
}

