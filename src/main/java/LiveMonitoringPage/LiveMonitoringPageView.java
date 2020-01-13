package LiveMonitoringPage;

import Alarm.Alarmpanel;
import Model.Patient;

import javax.swing.*;
import java.awt.*;

public class LiveMonitoringPageView {
    //Instantiate the  panels that will be used
    private ProfilePanel profilePanel;
    private VitalSignsPanel profileGraph;

    private JPanel page;
    private Alarmpanel alarmPanel;

    public LiveMonitoringPageView(Patient patient)  {
        profilePanel=new ProfilePanel(patient); //create profilePanel from ProfilePanel
        profileGraph = new VitalSignsPanel(patient); //create profileGraphs from VitalSignsPanel

        page=new JPanel();

        page.setPreferredSize(new Dimension(1400,650));
        page.setBackground(Color.black);
        page.add(profilePanel.getPatientProfile()); //add both panes to the main panel page
        page.add(profileGraph.getMainPanel());


    }

    public JPanel getPage() {
        return page;
    }

    //updates the panels to repaint current values
    public void Update()
    {
        profileGraph.Update();
        profilePanel.Update();
    }

}