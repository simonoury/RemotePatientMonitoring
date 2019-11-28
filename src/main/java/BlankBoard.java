import javax.swing.*;
import java.awt.*;

public class BlankBoard {
    private JPanel mainpanel;

    public static void main (String[] args){
        JPanel mainpanel;
        JButton button;
        mainpanel=new JPanel();
        button=new JButton("test");
        mainpanel.add(button);
        JFrame frame = new JFrame();
        frame.setSize(1500, 1000);
        frame.setVisible(true);
        frame.setJMenuBar(new Menu());
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }
    public JPanel getMainpanel(){
        return mainpanel; }

}
