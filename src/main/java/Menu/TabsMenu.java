package Menu;

import javax.swing.*;
import java.awt.*;

public class TabsMenu extends JTabbedPane {
    private JTabbedPane tabbedPane;
    private JPanel patient1,patient2,empty;
    private JPanel tabsPanel;
    private DropDownMenu dropdown,dropdown2;

    public TabsMenu(){
        //Declaration of Panels
        patient1=new JPanel();
        patient2=new JPanel();
        tabsPanel=new JPanel();
        empty =new JPanel();

        //Instantiate the drop-down menu
        dropdown=new DropDownMenu();
        dropdown2=new DropDownMenu();

        //Panel for patient 1
        patient1.setLayout(new GridLayout(2,1));
        patient1.add(dropdown.getOptions());
        patient1.add(dropdown.getSelectedPanel());

        //Panel for patient 2
        patient2.setLayout(new GridLayout(2,1));
        patient2.add(dropdown2.getOptions());
        patient2.add(dropdown2.getSelectedPanel());

        //Tabs Menu
        tabbedPane = new JTabbedPane();
        tabbedPane.addTab("Patient 1",null, patient1,"Patient 1");
        tabbedPane.setSelectedIndex(0);
        tabbedPane.addTab("Patient 2",null, patient2,"Patient 2");

        tabbedPane.setPreferredSize(new Dimension(1450, 900));
        tabbedPane.setVisible(true);


    }

    public JTabbedPane getTabbedPane() {
        return tabbedPane;
    }
}

