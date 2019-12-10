import javax.swing.*;
import java.awt.*;
import java.awt.Graphics;
import javax.swing.JComponent;

public class BlankBoard extends JPanel {
    private JPanel mainpanel;
  private VitalSignsBoard board;
   
    private JPanel graphECG;
    private JPanel graphData;
    private SinWave sinwave;
    private PlotData plot;
    private TimeSlider t_slider;
   private MenuBoard menuBoard;
    private GridLayout grid;

    public BlankBoard(){
        mainpanel = new JPanel();
        graphECG = new JPanel();
        graphData = new JPanel();
        sinwave = new SinWave();
        t_slider = new TimeSlider();
        plot = new PlotData();
      VitalSignsBoard board = new VitalSignsBoard();


        JLabel label1 = new JLabel("ECG:");
        JLabel label2 = new JLabel("Data:");
        
        grid=new GridLayout(1,1);
        menuBoard=new MenuBoard();
        mainpanel.setLayout(grid);
        mainpanel.add(menuBoard.getHeader());


        mainpanel.setLayout(new GridLayout(2, 1));
        graphECG.setLayout(new GridLayout(3,1));
        graphData.setLayout(new GridLayout(2, 1));


        //JLabel label1 = new JLabel("ECG:");
        //graphECG.add(label1);
        graphECG.add(label1);
        graphECG.add(t_slider);
        graphECG.add(sinwave);


        graphData.add(label2);
        graphData.add(plot);

        mainpanel.add(graphECG);
        mainpanel.add(graphData);
      mainpanel.add(board.getmainpanel());
    }

    public JPanel getMainpanel() {
        return mainpanel;
    }
}

