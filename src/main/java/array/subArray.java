package array;

import java.util.Arrays;
    public class subArray {
        public static double[] subArray(double[] array, int beg, int end) {
            return Arrays.copyOfRange(array, beg, end + 1);
        }
}
