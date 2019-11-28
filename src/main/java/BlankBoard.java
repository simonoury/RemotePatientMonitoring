import javax.swing.*;
import java.awt.*;

public class BlankBoard {
    static GraphicsConfiguration gc;

    public static void main (String[] args){
        JFrame frame = new JFrame(gc);
        frame.setSize(1500, 1000);
        frame.setVisible(true);
        frame.setJMenuBar(new Menu());
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
