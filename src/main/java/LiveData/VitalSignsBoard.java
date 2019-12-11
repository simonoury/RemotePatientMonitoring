package LiveData;

import org.knowm.xchart.QuickChart;
import org.knowm.xchart.XChartPanel;
import org.knowm.xchart.XYChart;
import org.knowm.xchart.internal.chartpart.Chart;
import javax.swing.*;
import java.awt.*;

public class VitalSignsBoard extends JPanel {

    // FIELDS

    // panels
    JPanel mainPanel;
    JPanel ecgPanel;
    JPanel hrPanel;
    JPanel tempPanel;
    JPanel bpPanel;
    JPanel rrPanel;

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
    public VitalSignsBoard() {

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

        // add chart panels to main panel
        mainPanel.setLayout(new GridLayout(5, 2));
        this.mainPanel.add(ecgPanel, 0,0);
        this.mainPanel.add(hrPanel,1,0);
        this.mainPanel.add(tempPanel, 2, 0);
        this.mainPanel.add(bpPanel, 3, 0);
        this.mainPanel.add(rrPanel,4,0);
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
