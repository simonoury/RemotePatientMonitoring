package LiveData;

import javax.swing.*;

public class LiveMonitoringPage  {
    private ProfilePanel profilePanel;
    private VitalSignsBoard profileGraph;
    private JPanel page,page_sub;
    public LiveMonitoringPage(){
        profilePanel=new ProfilePanel();
        profileGraph = new VitalSignsBoard();
        page=new JPanel();
        page_sub=new JPanel();

        page_sub.add(profilePanel.getProfile());
        page.add(page_sub);

    }

    public JPanel getPage() {
        return page;
    }
}
