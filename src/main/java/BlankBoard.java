import javax.swing.*;
import java.awt.*;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComponent;

public class BlankBoard extends JPanel {
    private JPanel mainpanel;
    private JPanel graphECG;
    private JPanel graphData;
    private SinWave sinwave;
    private PlotData plot;
    private TimeSlider t_slider;
    private JButton refresh;

    public BlankBoard(){
        mainpanel = new JPanel();
        graphECG = new JPanel();
        graphData = new JPanel();
        sinwave = new SinWave();
        t_slider = new TimeSlider();
        plot = new PlotData();

        JLabel label1 = new JLabel("ECG:");
        JLabel label2 = new JLabel("Data:");

        refresh = new JButton("Apply");

        mainpanel.setLayout(new GridLayout(2, 1));
        graphECG.setLayout(new GridLayout(3,1));
        graphData.setLayout(new GridLayout(2, 1));

        //JLabel label1 = new JLabel("ECG:");
        //graphECG.add(label1);
        graphECG.add(label1);
        graphECG.add(sinwave);

        graphData.add(label2);
        graphData.add(t_slider);
        graphData.add(plot);
        graphData.add(refresh);

        refresh.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                graphData.remove(plot);
                //plot = new PlotData();
                //graphData.add(plot);
                plot.repaint();
                System.out.println("BlankBoard: "+t_slider.getSliderVal());
                //System.out.println("Plot data: "+plot.getslidervalue());

            }
        });

        System.out.println("BlankBoard2___: "+t_slider.getSliderVal());
        mainpanel.add(graphECG);
        mainpanel.add(graphData);

    }

    public JPanel getMainpanel() {
        return mainpanel;
    }
}

