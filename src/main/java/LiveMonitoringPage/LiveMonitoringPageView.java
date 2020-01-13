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

    public LiveMonitoringPageView() {
        profilePanel=new ProfilePanel();
        profileGraph = new VitalSignsPanel();

        page=new JPanel();
        page_sub=new JPanel();

        page.setPreferredSize(new Dimension(1400,650));
        page.setBackground(Color.black);
        page.add(profilePanel.getPatientProfile());
        page.add(profileGraph.getMainPanel());
    }
    public LiveMonitoringPageView(Patient patient)  {
        profilePanel=new ProfilePanel(patient);
        profileGraph = new VitalSignsPanel(patient);

        page=new JPanel();
        page_sub=new JPanel();

        page.setPreferredSize(new Dimension(1400,650));
        page.setBackground(Color.black);
        page.add(profilePanel.getPatientProfile());
        page.add(profileGraph.getMainPanel());


    }

    public JPanel getPage() {
        return page;
    }

    public void Update()
    {
        profileGraph.Update();
        profilePanel.Update();
    }

    public void Augment()
    {
        profileGraph.Augment();
    }

    public void Decrement()
    {
        profileGraph.Decrement();
    }

}