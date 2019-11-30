package Alarm;


public class HRalarm extends Alarm {
    int[] values={1,23,455,32,82,55,3};

    public HRalarm(int warning_bound_low,int warning_bound_high,int danger_bound_low, int danger_bound_high, int[]values){
        super(65,100,60,120,values);
    }

}
