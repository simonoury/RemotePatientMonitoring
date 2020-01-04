package RecordsPage;

import Model.Patient;

import javax.swing.*;
import java.awt.*;

public class RecordsPageView {
    private RecordsPanel recordsPanel;
    private JPanel recordspage;

    public RecordsPageView(Patient patient){
        recordsPanel = new RecordsPanel();
        recordspage = new JPanel();

        recordspage.setPreferredSize(new Dimension(1400, 650));
        recordspage.add(recordsPanel.getPatientProfileRecords());
    }
    public JPanel getRecordspage(){return recordspage;}
}
