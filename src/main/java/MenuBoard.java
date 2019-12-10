import javax.swing.*;
import javax.swing.border.MatteBorder;
import java.awt.*;

public class MenuBoard extends JPanel {
    private GridLayout grid;
    private JPanel header;
    private JLabel title;
    private TabsMenu tabs;
    private JPanel empty;

    public MenuBoard(){
        grid=new GridLayout(1,1);
        tabs=new TabsMenu();
        header=new JPanel();
        empty=new JPanel();

        header.setLayout(grid);
        //header.setBackground(Color.gray);


        //title=new JLabel();
        //title.setText("Hello!");


       // header.add(title);
        //header.add(empty);
        //header.add(tabs.getTabsPanel());


        header.add(tabs.getTabbedPane());

    }

    public JPanel getHeader() {
        return header;
    }
}
