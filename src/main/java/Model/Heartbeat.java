package Model;

public class Heartbeat {
    private double[] xdata;
    private double[] ydata;

    // constructor
    Heartbeat(double[][] data)
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
