import javax.swing.*;
import javax.swing.border.MatteBorder;
import java.awt.*;

public class MenuBoard extends JPanel {
    private GridLayout grid;
    private JPanel header;
    private JLabel title;
    private TabsMenu tabs;

    public MenuBoard(){
        grid=new GridLayout(5,1);
        tabs=new TabsMenu();
        header=new JPanel();
        //header.setLayout(grid);
        header.setBorder( new MatteBorder(2, 2, 2, 2, Color.BLACK) );
        //header.setBackground(Color.gray);


        title=new JLabel();
        title.setText("Hello!");


        header.add(title, BorderLayout.WEST);
        header.add(tabs.getTabsPanel());

        //header.add(tabs.getTabbedPane());
    }


    public JPanel getHeader() {
        return header;
    }
}
