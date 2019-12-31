package LiveMonitoringPage;

import org.knowm.xchart.QuickChart;
import org.knowm.xchart.XChartPanel;
import org.knowm.xchart.XYChart;

import javax.swing.*;
import java.awt.*;

public class VitalSignsPanel extends JPanel {

    // FIELDS

    // panels
    JPanel mainPanel;
    JPanel ecgPanel;
    JPanel hrPanel;
    JPanel tempPanel;
    JPanel bpPanel;
    JPanel rrPanel;
    JPanel titles;
    JPanel chartPanel;

    // charts
    XYChart ecgChart;
    XYChart hrChart;
    XYChart tempChart;
    XYChart bpsChart;
    XYChart bpdChart;
    XYChart rrChart;

    // data for sine wave
    double phase = 0;
    double[][] data_ECG = getECGData(phase);
    double[][] data_HR = getHRData(phase);
    double[][] data_temp = getTempData();
    double[][] data_BPS =  getBPSData();
    double[][] data_BPD =  getBPDData();
    double[][] data = getSineData(phase);

    // METHODS

    // constructor method
    public VitalSignsPanel() {

        // create charts
        ecgChart = QuickChart.getChart("ECG", "Time /s", "Voltage /mV", "sine", data_ECG[0], data_ECG[1]);
        hrChart = QuickChart.getChart("Heart Rate", "Time /s", "Rate /BPM", "sine", data_HR[0], data_HR[1]);
        tempChart = QuickChart.getChart("Surface Body Temperature", "Time /s", "Temperature /C", "sine", data_temp[0], data_temp[1]);
        bpsChart = QuickChart.getChart("Systolic Blood Pressure", "Time /s", "Pressure /mmHg", "sine", data_BPS[0], data_BPS[1]);
        //bpdChart = QuickChart.getChart("Systolic Blood Pressure", "Time /s", "Pressure /mmHg", "sine", data_BPD[0], data_BPD[1]);
        rrChart = QuickChart.getChart("Respiratory Rate", "Time /s", "Rate /BrPM", "sine", data[0], data[1]);


        // create panels
        mainPanel = new JPanel();
        ecgPanel = new XChartPanel(ecgChart);
        hrPanel = new XChartPanel(hrChart);
        tempPanel = new XChartPanel(tempChart);
        bpPanel = new XChartPanel(bpsChart);
        rrPanel = new XChartPanel(rrChart);
        titles=new JPanel();
        chartPanel=new JPanel();

        titles.setLayout(new GridLayout(5,1));
        titles.add(new JLabel("<html> <h2>ECG </h2> <html>"));
        titles.add(new JLabel("<html> <h2>Heart Rate: </h2> <html>"));
        titles.add(new JLabel("<html> <h2>Body Temperature: </h2> <html>"));
        titles.add(new JLabel("<html> <h2>Blood Pressure: </h2> <html>"));
        titles.add(new JLabel("<html> <h2>Respiratory Rate: </h2> <html>"));
        titles.setPreferredSize(new Dimension (150,640));

        // add chart panels to main panel

        chartPanel.setLayout(new GridLayout(5, 2));
        chartPanel.add(ecgPanel);
        chartPanel.add(hrPanel);
        chartPanel.add(tempPanel);
        chartPanel.add(bpPanel);
        chartPanel.add(rrPanel);
        chartPanel.setPreferredSize(new Dimension (750,640));

        // mainPanel.setLayout(new GridLayout(1,2));
        mainPanel.add(titles);
        mainPanel.add(chartPanel);
        mainPanel.validate();


    }

    // get main panel method
    public JPanel getMainPanel() {
        return mainPanel;
    }

    // get sine data method

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

    protected static double[][] getBPSData() {
        double[] xData = new double[100];
        double[] yData = new double[100];
        for (int i = 0; i < xData.length; i++) {
            double time = i;
            xData[i] = time;
            yData[i] = 120;
        }
        return new double[][] { xData, yData};
    }

    protected static double[][] getBPDData() {
        double[] xData = new double[100];
        double[] yData = new double[100];
        for (int i = 0; i < xData.length; i++) {
            double time = i;
            xData[i] = time;
            yData[i] = 80;
        }
        return new double[][] { xData, yData};
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
            double radians = phase + (2 * Math.PI / xData.length * i);
            xData[i] = radians;
            yData[i] = Math.sin(6*radians);
        }
        return new double[][] { xData, yData };
    }

}
