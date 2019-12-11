package LiveData;

import javax.swing.*;
import java.awt.*;

public class LiveMonitoringPage  {
    private ProfilePanel profilePanel;
    private VitalSignsBoard profileGraph;
    private JPanel page,page_sub;
    public LiveMonitoringPage(){
        profilePanel=new ProfilePanel();
        profileGraph = new VitalSignsBoard();
        page=new JPanel();
        page_sub=new JPanel();

        page.setLayout(new GridLayout(1,2));
        page.add(profilePanel.getProfile());
        page.add(profileGraph.getMainPanel());

    }

    public JPanel getPage() {
        return page;
    }
}