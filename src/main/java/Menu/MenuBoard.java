package Menu;

import javax.swing.*;
import javax.swing.border.MatteBorder;
import java.awt.*;

public class MenuBoard extends JPanel {
    private GridLayout grid;
    private JPanel menuBoard;
    private JLabel title;
    private TabsMenu tabs;
    private JPanel empty;

    public MenuBoard(){
        grid=new GridLayout(2,1);
        tabs=new TabsMenu();
        menuBoard=new JPanel();
        empty=new JPanel();

        menuBoard.setLayout(grid);
        menuBoard.add(tabs.getTabbedPane());

    }

    public JPanel getMenuBoard() {
        return menuBoard;
    }
}
