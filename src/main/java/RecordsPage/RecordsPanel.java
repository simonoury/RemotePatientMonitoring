package RecordsPage;

import javax.swing.*;
import java.awt.*;

public class RecordsPanel extends JPanel {
    private JPanel patientProfile;
    private JPanel info, time, heartrate, bloodpressure, bodytemperature, respiratoryrate;

    public RecordsPanel (){
        //instantiate JPane;s
        patientProfile = new JPanel();
        info = new JPanel();

        //Fill info Jlabel
        info.setLayout(new GridLayout(2, 1));
        JLabel name = new JLabel("<html> <h2>Martin Holloway </h2>");
        JLabel id = new JLabel("Patient id: 0001 ");
        info.add(name);
        info.add(id);

        
    }

}
