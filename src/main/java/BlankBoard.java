import javax.swing.*;
import java.awt.*;
import java.awt.Graphics;

public class BlankBoard extends JPanel {
    private JPanel mainpanel;
    private JPanel graphECG;
    private JPanel graphData;
    private SinWave sinwave;
    private PlotData plot;

    public BlankBoard(){
        mainpanel = new JPanel();
        graphECG = new JPanel();
        graphData = new JPanel();
        sinwave = new SinWave();
        plot = new PlotData();
        JLabel label1 = new JLabel("ECG:");
        JLabel label2 = new JLabel("Data:");


        mainpanel.setLayout(new GridLayout(2, 1));
        graphECG.setLayout(new GridLayout(2,1));
        graphData.setLayout(new GridLayout(2, 1));


        //JLabel label1 = new JLabel("ECG:");
        //graphECG.add(label1);
        graphECG.add(label1);
        graphECG.add(sinwave);

        graphData.add(label2);
        graphData.add(plot);

        mainpanel.add(graphECG);
        mainpanel.add(graphData);
    }

    public JPanel getMainpanel() {
        return mainpanel;
    }
}

