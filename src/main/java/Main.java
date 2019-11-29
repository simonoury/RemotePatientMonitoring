import javax.swing.*;

public class Main {
    public static void main (String[] args){
        JFrame frame = new JFrame();
        frame.setSize(1500, 1000);
        frame.setVisible(true);
        frame.setJMenuBar(new Menu());
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

}
