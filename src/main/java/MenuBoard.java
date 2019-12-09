import javax.swing.*;
import java.awt.*;

public class MenuBoard extends JPanel {
    private GridLayout grid;
    private JPanel header;
    private JLabel title;

    public MenuBoard(){
        grid=new GridLayout(1,1);
        header=new JPanel();
        header.setLayout(grid);
        header.setBackground(Color.gray);

        title=new JLabel();
        title.setText("Remote Patient Monitoring");


        header.add(title);


    }


    public JPanel getHeader() {
        return header;
    }
}
