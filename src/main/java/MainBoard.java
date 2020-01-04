import javax.swing.*;
import java.awt.*;

import Menu.*;
import Model.Patient;

public class MainBoard extends JPanel {
    //Declare panels
    private JPanel mainPanel;
    private MenuPanel menuPanel;
    private GridLayout grid;


    public MainBoard(){
        //Instantiation of Panels
        mainPanel = new JPanel();
        menuPanel =new MenuPanel();

        //Grid Layout
        grid=new GridLayout(1,1);
        mainPanel.setLayout(grid);

        //Adding panels to mainpanel
        mainPanel.add(menuPanel.getMenuPanel());

    }

    public JPanel getMainPanel() {

        return mainPanel;
    }

    public void Update()
    {
        menuPanel.Update();
    }



}

