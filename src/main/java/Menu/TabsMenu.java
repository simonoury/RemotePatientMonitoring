package Menu;

import Model.Patient;

import javax.swing.*;
import java.awt.*;

public class TabsMenu{
    //Declaration of variables
    private JTabbedPane tabbedPanel;
    private JPanel patient1,patient2;
    private JPanel patients[] = new JPanel[10];
    private DropDownMenu dropdown,dropdown2;
    private DropDownMenu[] dropDownMenu = new DropDownMenu[10];

    public TabsMenu() {
        //Instantiation of Panels
        patient1=new JPanel();
        patient2=new JPanel();

        //Instantiate the drop-down menu
        dropdown=new DropDownMenu(10);
        dropdown2=new DropDownMenu(2);

        dropDownMenu[0] = new DropDownMenu(1);
        dropDownMenu[1] = new DropDownMenu(2);
        dropDownMenu[2] = new DropDownMenu(3);
        dropDownMenu[3] = new DropDownMenu(4);
        dropDownMenu[4] = new DropDownMenu(5);
        dropDownMenu[5] = new DropDownMenu(6);
        dropDownMenu[6] = new DropDownMenu(7);
        dropDownMenu[7] = new DropDownMenu(8);
        dropDownMenu[8] = new DropDownMenu(9);
        dropDownMenu[9] = new DropDownMenu(10);

        //Panel for patient 1
        patient1.setLayout(new FlowLayout());
        patient1.add(dropdown.getOptions());
        patient1.add(dropdown.getSelectedPanel());

        //Panel for patient 2
        patient2.setLayout(new FlowLayout());
        patient2.add(dropdown2.getOptions());
        patient2.add(dropdown2.getSelectedPanel());

        for (int i=0; i<patients.length; i++)
        {
            patients[i] = new JPanel();
            patients[i].setLayout(new FlowLayout());
            patients[i].add(dropDownMenu[i].getOptions());
            patients[i].add(dropDownMenu[i].getSelectedPanel());
        }


        //Tabs Menu
        tabbedPanel = new JTabbedPane();

        for (int i=0; i<10; i++)
        {
            tabbedPanel.addTab("Patient "+(i+1), null, patients[i], "Patient "+(i+1));
        }
        tabbedPanel.setSelectedIndex(0);
        tabbedPanel.setPreferredSize(new Dimension(1450, 925));
        tabbedPanel.setVisible(true);
    }

    public JTabbedPane getTabbedPanel() {
        return tabbedPanel;
    }

    public void Update()
    {
        int index = tabbedPanel.getSelectedIndex();
        dropDownMenu[index].Update();
    }
}

