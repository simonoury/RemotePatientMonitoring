package Model;

public class Bloodpressure {
    private double[] xdata;
    private double[] ydata;

    // constructor
    Bloodpressure(double[][] data)
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
        System.out.println(ydata[locator]+1);
        for(int i=locator; i<ydata.length; i++)
        {

            ydata[i]++;
        }
    }
    public void Decrement(int locator)
    {
        for(int i=locator; i<ydata.length; i++)
        {
            ydata[i]--;
        }
    }
}
