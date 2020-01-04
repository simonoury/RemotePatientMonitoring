package LiveMonitoringPage;

import Model.Patient;

import javax.swing.*;
import java.awt.*;

public class LiveMonitoringPageView {
    private ProfilePanel profilePanel;
    private VitalSignsPanel profileGraph;
    private JPanel page,page_sub;
    public LiveMonitoringPageView(Patient patient)  {
        profilePanel=new ProfilePanel(patient);
        profileGraph = new VitalSignsPanel(patient);
        page=new JPanel();
        page_sub=new JPanel();

        page.setPreferredSize(new Dimension(1400,650));
        //page.setLayout(new GridLayout(1,2));
        page.add(profilePanel.getPatientProfile());
        page.add(profileGraph.getMainPanel());


    }

    public JPanel getPage() {
        return page;
    }

    public void Update()
    {
        profileGraph.Update();
    }

}