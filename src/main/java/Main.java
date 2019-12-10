import javax.swing.*;


public class Main {

    public static void main(String[] args) throws InterruptedException {
        BlankBoard board=new BlankBoard();
        JFrame frame = new JFrame("Remote Patient Monitoring");
        frame.setSize(1450, 925);
        frame.add(board.getMainpanel());

        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }
}

