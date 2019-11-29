import Alarm.AlarmPanel;

import javax.swing.*;

public class Main {
    public static void main (String[] args){
        BlankBoard board=new BlankBoard();
        JFrame frame = new JFrame("Remote Patient Monitoring");
        frame.setSize(1500, 1000);
        frame.add(board);
        frame.setVisible(true);
        frame.setJMenuBar(new Menu());
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

}
