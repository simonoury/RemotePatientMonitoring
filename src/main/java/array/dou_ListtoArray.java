package array;

import java.util.ArrayList;

public class dou_ListtoArray {
    public static double[] dou_ListtoArray(ArrayList<Double> list)
    {
        double[] array = new double[list.size()];
        int i = 0;
        for (Double douTemp : list) {
            array[i++] = douTemp;
        }
        return array;
    }
}
