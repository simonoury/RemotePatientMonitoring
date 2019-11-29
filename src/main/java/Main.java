import javax.swing.*;

public class Main {
    public static void main (String[] args){
        BlankBoard board=new BlankBoard();
        JFrame frame = new JFrame("Remote Patient Monitoring");
        frame.setSize(1450, 9250);
        frame.add(board.getMainpanel());
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

}
