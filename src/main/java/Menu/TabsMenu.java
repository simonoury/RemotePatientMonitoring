package Menu;

import Model.Patient;

import javax.swing.*;
import java.awt.*;

public class TabsMenu{
    //Declaration of variables
    private JTabbedPane tabbedPanel;
    private JPanel patient1,patient2;
    private DropDownMenu dropdown,dropdown2;

    public TabsMenu() {
        //Instantiation of Panels
        patient1=new JPanel();
        patient2=new JPanel();

        //Instantiate the drop-down menu
        dropdown=new DropDownMenu(1);
        dropdown2=new DropDownMenu(2);

        //Panel for patient 1
        patient1.setLayout(new FlowLayout());
        patient1.add(dropdown.getOptions());
        patient1.add(dropdown.getSelectedPanel());

        //Panel for patient 2
        patient2.setLayout(new FlowLayout());
        patient2.add(dropdown2.getOptions());
        patient2.add(dropdown2.getSelectedPanel());


        //Tabs Menu
        tabbedPanel = new JTabbedPane();
        tabbedPanel.addTab("Patient 1",null, patient1,"Patient 1");
        tabbedPanel.setSelectedIndex(0);
        tabbedPanel.addTab("Patient 2",null, patient2,"Patient 2");

        tabbedPanel.setPreferredSize(new Dimension(1450, 925));
        tabbedPanel.setVisible(true);
    }

    public JTabbedPane getTabbedPanel() {
        return tabbedPanel;
    }

    public void Update()
    {
        dropdown.Update();
    }
}

