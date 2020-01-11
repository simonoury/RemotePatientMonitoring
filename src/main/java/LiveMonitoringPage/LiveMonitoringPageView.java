package LiveMonitoringPage;

import Alarm.Alarmpanel;
import Model.Patient;

import javax.swing.*;
import java.awt.*;

public class LiveMonitoringPageView {
    private ProfilePanel profilePanel;
    private VitalSignsPanel profileGraph;
    private JPanel page,page_sub;
    private Alarmpanel alarmPanel;
    public LiveMonitoringPageView(Patient patient)  {
        profilePanel=new ProfilePanel(patient);
        profileGraph = new VitalSignsPanel(patient);
        alarmPanel=new Alarmpanel(patient);
        page=new JPanel();
        page_sub=new JPanel();

        page.setPreferredSize(new Dimension(1400,650));
        page.setBackground(Color.black);
        page.add(profilePanel.getPatientProfile());
        page.add(profileGraph.getMainPanel());
        page.add(alarmPanel.getValuesPanel());


    }

    public JPanel getPage() {
        return page;
    }

    public void Update()
    {
        profileGraph.Update();
    }

}