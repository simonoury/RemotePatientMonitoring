package Model;

public class Systolicpressure {
    private double[] xdata;
    private double[] ydata;

    // constructor
    Systolicpressure(double[][] data)
    {
        xdata = data[0];
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
