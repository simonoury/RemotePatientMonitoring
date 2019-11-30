import java.awt.*;
import javax.swing.JPanel;

public class PlotData extends JPanel {

    protected void paintComponent (Graphics g){
        int[] x = new int[36];
        int[] y = new int[36];

        int x_fill = 10;
        int y_fill = 100;

        for (int i = 0; i<x.length; i++){
            x[i] = x_fill;
            x_fill = x_fill +10;
        }

        for (int i = 0; i<y.length; i++){
            y[i] = y_fill;
            y_fill = y_fill-2;
        }
        /*
        for (int i_ = 0; i_<36; i_++){
            System.out.println(x[i_]);
            System.out.println(y[i_]);
        }
        */

        super.paintComponent(g);

        int length = x.length;

        //x and y axis
        g.drawLine(10, 100, 380, 100);
        g.drawLine(10, 0, 10, 100);

        g.drawString("T", 390, 115);

        //y arrow
        g.drawLine(380, 100, 370, 90);
        g.drawLine(380, 100, 370, 110);

        //x arrow
        g.drawLine(10, 0, 0, 10);
        g.drawLine(10, 0, 20, 10);

        //Draws Curb
        for (int i = 0; i < (length-1); i++){
            g.setColor(Color.red);
            g.drawLine(x[i], y[i], x[i+1], y[i+1]);
        }

    }
}
