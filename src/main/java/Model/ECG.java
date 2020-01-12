package Model;

import java.util.Arrays;

public class ECG {
    private double[] xdata;
    private double[] ydata;

    // constructor
    ECG(double[][] data)
    {
        xdata = data[0];
        System.out.println(Arrays.toString(xdata));
        ydata = data[1];
    }
    public double[] get_xdata()
    {
        return xdata;
    }

    public double[] get_ydata()
    {
        return ydata;
    }
}
