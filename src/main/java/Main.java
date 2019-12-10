import javax.swing.*;
import org.jfree.chart.*;
import org.knowm.xchart.QuickChart;
import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.XChartPanel;
import org.knowm.xchart.XYChart;

public class Main {

    public static void main(String[] args) throws InterruptedException {
    public static void main (String[] args){
        BlankBoard board=new BlankBoard();
        JFrame frame = new JFrame("Remote Patient Monitoring");
        frame.setSize(1450, 9250);
        frame.add(board.getMainpanel());

        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }
}

