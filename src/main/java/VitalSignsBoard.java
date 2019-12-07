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
    XYChart bpChart;
    XYChart rrChart;

    // data for sine wave
    double phase = 0;
    double[][] data = getSineData(phase);

    // METHODS

    // constructor method
    VitalSignsBoard() {

        // create charts
        ecgChart = QuickChart.getChart("ECG", "Time /s", "Voltage /mV", "sine", data[0], data[1]);
        hrChart = QuickChart.getChart("Heart Rate", "Time /s", "Rate /BPM", "sine", data[0], data[1]);
        tempChart = QuickChart.getChart("Surface Body Temperature", "Time /s", "Temperature /C", "sine", data[0], data[1]);
        bpChart = QuickChart.getChart("Blood Pressure", "Time /s", "Pressure /mmHg", "sine", data[0], data[1]);
        rrChart = QuickChart.getChart("Respiratory Rate", "Time /s", "Rate /BrPM", "sine", data[0], data[1]);


        // create panels
        mainPanel = new JPanel();
        ecgPanel = new XChartPanel(ecgChart);
        hrPanel = new XChartPanel(hrChart);
        tempPanel = new XChartPanel(tempChart);
        bpPanel = new XChartPanel(bpChart);
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

}
