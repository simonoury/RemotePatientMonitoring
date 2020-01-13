package Model;

public class Bodytemperature {
    private double[] xdata;
    private double[] ydata;

    // constructor
    Bodytemperature(double[][] data)
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

    public void Augment(int locator)
    {

        for(int i=locator; i<ydata.length-10; i++)
        {
            ydata[i]++;
        }

    }
    public void Decrement(int locator)
    {
        for(int i=locator; i<ydata.length-10; i++)
        {
            ydata[i]--;
        }
    }
}
