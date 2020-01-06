package LiveMonitoringPage;

import Model.Patient;
import org.knowm.xchart.QuickChart;
import org.knowm.xchart.XChartPanel;
import org.knowm.xchart.XYChart;

import javax.swing.*;
import java.awt.*;

import java.util.Arrays;

//delete 3


public class VitalSignsPanel extends JPanel {

    // FIELDS


    int locator = 0;
    Patient patient;
    // Model


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

    //minmax
    double[] minmaxECG;


    // METHODS

    // constructor method
    public VitalSignsPanel(Patient p) {

        //create patient
        patient = p;

        // data for sine wave
        double phase = 0;
        double[][] data_ECG = getECGData(locator);
        double[][] data_HR = getHRData(phase);
        double[][] data_temp = getTempData();
        double[][] data_BPS =  getBPSData();
        double[][] data_BPD =  getBPDData();
        double[][] data = getSineData(phase);

        // min max info
        double[] minmaxECG = patient.minmaxECG();

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
        this.mainPanel.add(ecgPanel);
        this.mainPanel.add(hrPanel);
        this.mainPanel.add(tempPanel);
        this.mainPanel.add(bpPanel);
        this.mainPanel.add(rrPanel);
        mainPanel.setPreferredSize(new Dimension (900,640));
        mainPanel.validate();
        mainPanel.setVisible(true);










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

    protected double[][] getECGData(int locator) {

        return patient.ECGgetsnippet(locator);
    }

    protected double[][] getHRData(double phase) {
        return patient.Heartbeatgetsnippet(locator);
    }

    public void updatePanel(){
        System.out.println("updated " + patient.getGivenname());
        double[][] data_ECG = getECGData(++locator);
        double[] minmaxECG = patient.minmaxECG();
        ecgChart = QuickChart.getChart("ECG", "Time /s", "Voltage /mV", "sine", data_ECG[0], data_ECG[1]);
        ecgPanel = new XChartPanel(ecgChart);
        ecgChart.addSeries("minmax", new double[]{data_ECG[0][0],data_ECG[0][1]}, minmaxECG);
        JPanel ecgPanel2 = new XChartPanel(ecgChart);
        double[][] data_Heartbeat = getHRData(locator);
        hrChart = QuickChart.getChart("Heart Rate", "Time /s", "Rate /BPM", "sine", data_Heartbeat[0], data_Heartbeat[1]);
        hrPanel = new XChartPanel(hrChart);
        JPanel hrPanel2 = new XChartPanel(hrChart);

        mainPanel.removeAll();
        mainPanel.add(ecgPanel);
        mainPanel.add(hrPanel);
        mainPanel.add(tempPanel);
        mainPanel.add(bpPanel);
        mainPanel.add(rrPanel);


        //JPanel mainPanel_test = new JPanel();
        //JFrame f = new JFrame();
        //f = new JFrame("panel");
        //f.add(ecgPanel);
        //f.setSize(300, 300);

        //f.show();





    }

    public void Update()
    {
        updatePanel();
    }



}

