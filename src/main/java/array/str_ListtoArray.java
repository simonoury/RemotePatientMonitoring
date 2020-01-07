package array;

import java.util.ArrayList;
public class str_ListtoArray {
    public static double[] str_ListtoArray(ArrayList<String> list)
    {
        double[] array = new double[list.size()];
        int i = 0;
        for (String strTemp : list) {
            strTemp = strTemp.replace(".", "");
            strTemp = strTemp.replace(":", "");
            array[i++] = Double.parseDouble(strTemp);
        }
        return array;
    }
}
