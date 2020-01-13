package RecordsPage;

import Model.Patient;


import javax.swing.*;
import java.awt.*;

public class RecordsPageView {
    private RecordsPanel recordsPanel;
    private JPanel recordspage;


    public RecordsPageView(Patient patient){
        recordsPanel = new RecordsPanel(patient);
        recordspage = new JPanel();

        recordspage.setPreferredSize(new Dimension(1400, 750));
        recordspage.setBackground(Color.black);
        recordspage.add(recordsPanel.getPatientProfileRecords());

    }
    public JPanel getRecordspage(){return recordspage;}
}
