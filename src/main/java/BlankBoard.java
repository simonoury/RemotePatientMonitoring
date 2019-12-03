import javax.swing.*;
import java.awt.*;

public class BlankBoard extends JPanel {
    ProfilePanel profilePanel=new ProfilePanel();
    private JPanel mainpanel;
    GridLayout gridmain;
    public BlankBoard(){
        mainpanel= new JPanel();
        gridmain=new GridLayout(5,2);

        mainpanel.setLayout(gridmain);
        mainpanel.add(profilePanel.getProfile());
    }

    public JPanel getMainpanel() {
        return mainpanel;
    }
}
