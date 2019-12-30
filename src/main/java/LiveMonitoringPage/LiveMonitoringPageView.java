package LiveMonitoringPage;

import javax.swing.*;
import java.awt.*;

public class LiveMonitoringPageView {
    private ProfilePanel profilePanel;
    private VitalSignsPanel profileGraph;
    private JPanel page,page_sub;
    public LiveMonitoringPageView(){
        profilePanel=new ProfilePanel();
        profileGraph = new VitalSignsPanel();
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
}