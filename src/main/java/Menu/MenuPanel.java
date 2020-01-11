package Menu;

import Model.Patient;

import javax.swing.*;
import java.awt.*;

public class MenuPanel extends JPanel {
    //Declaration of panels
    private GridLayout grid;
    private JPanel menuPanel;
    private TabsMenu tabs;

    public MenuPanel(){
        grid=new GridLayout(1,1);
        tabs=new TabsMenu();
        menuPanel =new JPanel();

        menuPanel.setLayout(grid);
        menuPanel.setBackground(Color.black);
        menuPanel.add(tabs.getTabbedPanel());

    }

    public JPanel getMenuPanel() {

        return menuPanel;
    }

    public void Update(){
        tabs.Update();
    }


}
