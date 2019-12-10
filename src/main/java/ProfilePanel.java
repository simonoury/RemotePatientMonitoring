import com.sun.org.apache.xpath.internal.operations.Gt;
import org.knowm.xchart.QuickChart;
import org.knowm.xchart.XChartPanel;
import org.knowm.xchart.XYChart;

import javax.swing.*;
import javax.swing.border.MatteBorder;
import java.awt.*;

public class ProfilePanel extends JPanel {
    private JPanel profile,heartrate,bodytemp,bloodpress,resprate, ecg;
    private GridLayout grid;
    private JLabel title,name,id,hr,bt,rr,bp ;
    private int normalvalues[]={60,37,14,110,70};

    // panels
    JPanel ecgPanel;
    JPanel hrPanel;
    JPanel tempPanel;
    JPanel bpPanel;
    JPanel rrPanel;

    // charts
    XYChart ecgChart;
    XYChart hrChart;
    XYChart tempChart;
    XYChart bpChart;
    XYChart rrChart;

    // data for sine wave
    double phase = 0;
    double[][] data_ECG = getECGData(phase);
    double[][] data_HR = getHRData(phase);
    double[][] data_temp = getTempData();
    double[][] data_BR =  getBPData();
    double[][] data = getSineData(phase);



    public ProfilePanel(){
        profile=new JPanel();
        grid=new GridLayout(7,2,2,2);
        profile.setBorder( new MatteBorder(2, 2, 2, 2, Color.BLACK) );
        profile.setLayout(grid);


        JLabel title=new JLabel("<html><h1> Patient Profile </h1>");
        JLabel name= new JLabel("<html> <h2>Martin Holloway</h2>   Patient id: 0001 ");
        //JLabel id=new JLabel("Patient id: 0001 ");

        ecgChart = QuickChart.getChart(" ", " ", "mV", " ", data_ECG[0], data_ECG[1]);
        ecgPanel = new XChartPanel(ecgChart);
        tempChart = QuickChart.getChart(" ", " ", "C", " ", data_temp[0], data_temp[1]);
        tempPanel = new XChartPanel(tempChart);

        heartrate=new JPanel();
        heartrate.setLayout(new GridLayout(1,1));
        bodytemp=new JPanel();
        bodytemp.setLayout(new GridLayout(1,3));
        resprate=new JPanel();
        resprate.setLayout(new GridLayout(1,3));
        bloodpress=new JPanel();
        bloodpress.setLayout(new GridLayout(1,3));
        ecg=new JPanel();
        ecg.setLayout(new GridLayout(1,3));



        heartrate.add(new JLabel("<html> <h4> Heart Rate:  </h4>"));
        heartrate.add(new JLabel(String.valueOf(normalvalues[1])+" bpm", SwingConstants.LEFT));


        bodytemp.add(new JLabel("<html> <h4> Body Temperature:  </h4>", SwingConstants.LEFT));
        bodytemp.add(new JLabel(normalvalues[1]+ " °C"));
        bodytemp.add(tempPanel, 2, 2);


        resprate.add(new JLabel("<html> <h4>Respiratory Rate: </h4>"));
        resprate.add(new JLabel((normalvalues[2])+ " breaths/min"));

        bloodpress.add(new JLabel("<html> <h4>Blood Pressure:   </h4>"));
        bloodpress.add(new JLabel((normalvalues[3])+" mmHg (systolic pressure)  "+normalvalues[4]+ " mmHg (diastolic pressure)"));

        ecg.add(new JLabel("<html> <h4>ECG:   </h4>"));
        ecg.add(ecgPanel, 1,1);
        //


        profile.add(title);
        profile.add(name);
        //profile.add(id);
        profile.add(heartrate);
        profile.add(bodytemp);
        profile.add(resprate);
        profile.add(bloodpress);
        profile.add(ecg);


        profile.setPreferredSize(new Dimension(1400, 700));

    }

    public JPanel getProfile() {
        return profile;
    }


    protected static double[][] getSineData(double phase) {
        double[] xData = new double[100];
        double[] yData = new double[100];
        for (int i = 0; i < xData.length; i++) {
            double radians = phase + (2 * Math.PI / xData.length * i);
            xData[i] = radians;
            yData[i] = Math.sin(radians);
        }
        return new double[][] { xData, yData };
    }

    protected static double[][] getTempData() {
        double[] xData = new double[100];
        double[] yData = new double[100];
        for (int i = 0; i < xData.length; i++) {
            double time = i;
            xData[i] = time;
            yData[i] = 37.3;
        }
        return new double[][] { xData, yData };
    }

    protected static double[][] getBPData() {
        double[] xData = new double[100];
        double[] yData = new double[100];
        for (int i = 0; i < xData.length; i++) {
            double time = i;
            xData[i] = time;
            yData[i] = 120;
        }
        return new double[][] { xData, yData };
    }

    protected static double[][] getECGData(double phase) {
        double[] xData = new double[100];
        double[] yData = new double[100];
        for (int i = 0; i < xData.length; i++) {
            double radians = phase + (4 * Math.PI / xData.length * i);
            xData[i] = radians;
            yData[i] = Math.sin(radians);
        }
        return new double[][] { xData, yData };
    }

    protected static double[][] getHRData(double phase) {
        double[] xData = new double[100];
        double[] yData = new double[100];
        for (int i = 0; i < xData.length; i++) {
            double radians = phase + (10 * Math.PI / xData.length * i);
            xData[i] = radians;
            yData[i] = Math.sin(radians)*Math.sin(radians);
        }
        return new double[][] { xData, yData };
    }
}