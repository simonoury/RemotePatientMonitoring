package Model;

public class Respiratoryrate {
    private double[] xdata;
    private double[] ydata;

    // constructor
    Respiratoryrate(double[][] data)
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

    public double[] get_value(int locator) {
        return new double[] {xdata[locator], ydata[locator]};
    }
}
