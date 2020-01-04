package LiveMonitoringPage;

import Model.Patient;
import org.knowm.xchart.QuickChart;
import org.knowm.xchart.XChartPanel;
import org.knowm.xchart.XYChart;

import javax.swing.*;
import java.awt.*;
import array.*;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import javax.swing.SwingWorker;

//delete 3
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.knowm.xchart.QuickChart;
import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.XYChart;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

public class VitalSignsPanel extends JPanel {

    // FIELDS


    int locator = 0;
    Patient patient = new Patient(2);
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

    // data for sine wave
    double phase = 0;
    double[][] data_ECG = getECGData(locator);
    double[][] data_HR = getHRData(phase);
    double[][] data_temp = getTempData();
    double[][] data_BPS =  getBPSData();
    double[][] data_BPD =  getBPDData();
    double[][] data = getSineData(phase);

    // min max info
    double[] minmaxECG= patient.minmaxECG();
    // METHODS

    // constructor method
    public VitalSignsPanel() {

;



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

        return patient.getsnippet(locator);
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

    public void updatePanel(){
        double[][] data_ECG = getECGData(++locator);
        ecgChart = QuickChart.getChart("ECG", "Time /s", "Voltage /mV", "sine", data_ECG[0], data_ECG[1]);
        ecgPanel = new XChartPanel(ecgChart);
        ecgChart.addSeries("minmax", minmaxECG, new double[]{data_ECG[0][0],data_ECG[0][0]});
        JPanel ecgPanel2 = new XChartPanel(ecgChart);
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

