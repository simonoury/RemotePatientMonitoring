import javax.swing.*;
import java.awt.*;

public class TabsMenu extends JTabbedPane {
    private JTabbedPane tabbedPane;
    private JPanel patient,patient2;
    private JPanel tabsPanel;
    private DropDownMenu dropdown;
    private ProfilePanel profilePanel;

    public TabsMenu(){
        patient=new JPanel();
        patient2=new JPanel();
        tabsPanel=new JPanel();
        dropdown=new DropDownMenu();
        profilePanel=new ProfilePanel();
        patient.add(dropdown.getmenu());
        patient.add(profilePanel.getProfile());

        tabbedPane = new JTabbedPane();
        tabbedPane.addTab("Patient 1",null, patient,"Patient 1");
        tabbedPane.setSelectedIndex(0);
        tabbedPane.addTab("Patient 2",null, patient2,"Patient 2");

        tabbedPane.setPreferredSize(new Dimension(1500, 900));
        tabbedPane.setVisible(true);
        tabsPanel.add(tabbedPane,BorderLayout.WEST);

    }

    public JTabbedPane getTabbedPane() {
        return tabbedPane;
    }

    public JPanel getTabsPanel() {
        return tabsPanel;
    }
}

