import javax.swing.*;
import java.awt.*;
import java.awt.Graphics;

public class BlankBoard extends JPanel {
    private JPanel mainpanel;
    private JPanel graphECG;
    private SinWave sinwave;

    public BlankBoard(){
        mainpanel = new JPanel();
        graphECG = new JPanel();
        sinwave = new SinWave();
        JLabel label1 = new JLabel("ECG:");

        mainpanel.setLayout(new GridLayout(1, 1));
        graphECG.setLayout(new GridLayout(5,1));


        //JLabel label1 = new JLabel("ECG:");
        //graphECG.add(label1);
        graphECG.add(label1);
        graphECG.add(sinwave);

        mainpanel.add(graphECG);
    }

    public JPanel getMainpanel() {
        return mainpanel;
    }
}

