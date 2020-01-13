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
    public void augment(int locator){
        for (int i=locator; i<ydata.length; i++)
        {
            ydata[i] = ydata[i]+1;
        }
    }
    public void decrement(int locator){
        for (int i=locator; i<ydata.length; i++)
        {
            ydata[i] = ydata[i]-1;
        }
    }
}
