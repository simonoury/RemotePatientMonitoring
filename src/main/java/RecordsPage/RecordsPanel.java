package RecordsPage;

import javax.swing.*;
import java.awt.Dimension;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.util.stream.IntStream;

public class RecordsPanel extends JPanel {
    private JPanel patientProfile;
    private JPanel recordedvalues;
    private JPanel averagevalues;
    private JPanel info;
    private JPanel time, heartrate, bloodpressure, bodytemperature, respiratoryrate;
    private JPanel heartrateaverage, bloodpressureaverage, bodytemperatureaverage, respiratoryrateaverage;
    private int timevalues[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    private int heartratevalues[] = {69, 74, 56, 84, 95, 115, 78, 68, 70, 71};
    private int bloodpressurevalues [] = {118, 119, 118, 119, 120, 121, 120, 119, 118, 118};
    private double bodytemperaturevalues [] = {37.1, 37.2, 37.2, 37.3, 38.5, 38.0, 37.9, 37.6, 37.3, 37.1};
    private int respiratoryratevalues [] = {14, 15, 14, 16, 18, 17, 16, 15, 14, 14};

    public RecordsPanel (){
        //instantiate JPanels
        patientProfile = new JPanel();
        recordedvalues = new JPanel();
        averagevalues = new JPanel();
        time = new JPanel();
        heartrate = new JPanel();
        bloodpressure = new JPanel();
        bodytemperature = new JPanel();
        respiratoryrate = new JPanel();
        info = new JPanel();
        heartrateaverage = new JPanel();
        bloodpressureaverage= new JPanel();
        bodytemperatureaverage= new JPanel();
        respiratoryrateaverage= new JPanel();

        //Fill info Jlabel
        info.setLayout(new GridLayout(3, 1));
        JLabel name = new JLabel("<html> <h2>Martin Holloway </h2>");
        JLabel id = new JLabel("Patient id: 0001 ");
        JLabel age = new JLabel("Age: 27 years old");
        info.add(name);
        info.add(id);
        info.add(age);
        info.setSize(new Dimension(160, 50));

        recordedvalues.setLayout((new GridLayout(1, 5)));

        //fill in table with values from array
        time.setLayout(new GridLayout(11, 1));
        time.setPreferredSize(new Dimension(50, 150));
        time.add(new JLabel("<html> <h4> Time:  </h4>"));
        for (int timevalue : timevalues) {
            time.add(new JLabel(String.valueOf(timevalue)+" h"));
        }
        recordedvalues.add(time);

        heartrate.setLayout(new GridLayout(11, 1));
        heartrate.add(new JLabel("<html> <h4> HR:  </h4>"));
        for (int heartratevalue : heartratevalues) {
            heartrate.add(new JLabel(String.valueOf(heartratevalue)));
        }
        recordedvalues.add(heartrate);

        bloodpressure.setLayout(new GridLayout(11, 1));
        bloodpressure.add(new JLabel("<html> <h4> BP:  </h4>"));
        for (int bloodpressurevalue : bloodpressurevalues) {
            bloodpressure.add(new JLabel(String.valueOf(bloodpressurevalue)));
        }
        recordedvalues.add(bloodpressure);

        bodytemperature.setLayout(new GridLayout(11, 1));
        bodytemperature.add(new JLabel("<html> <h4> BT:  </h4>"));
        for (double bodytemperaturevalue : bodytemperaturevalues) {
            bodytemperature.add(new JLabel(String.valueOf(bodytemperaturevalue)));
        }
        recordedvalues.add(bodytemperature);

        respiratoryrate.setLayout(new GridLayout(11, 1));
        respiratoryrate.add(new JLabel("<html> <h4> RR:  </h4>"));
        for (int respiratoryratevalue : respiratoryratevalues) {
            respiratoryrate.add(new JLabel(String.valueOf(respiratoryratevalue)));
        }
        recordedvalues.add(respiratoryrate);

        //calculate and fill in average values
        averagevalues.setLayout(new GridLayout(5, 1));
        averagevalues.add(new JLabel("<html> <h4> Average Values:  </h4>"));

        double avgheartrate;
        avgheartrate = IntStream.of(heartratevalues).sum()/heartratevalues.length;
        heartrateaverage.add(new JLabel("Heart Rate average value:"));
        heartrateaverage.add(new JLabel(String.valueOf(avgheartrate)));
        averagevalues.add(heartrateaverage);

        double avgbloodpressure;
        avgbloodpressure = IntStream.of(bloodpressurevalues).sum()/bloodpressurevalues.length;
        bloodpressureaverage.add(new JLabel("Blood Pressure average value:"));
        bloodpressureaverage.add(new JLabel(String.valueOf(avgbloodpressure)));
        averagevalues.add(bloodpressureaverage);

        double avgbodytemperature;
        double sum = 0; //as IntStream.of().sum() does not work for double values
        for (double val : bodytemperaturevalues) {
            sum = sum + val;
        }
        avgbodytemperature = sum/bodytemperaturevalues.length;
        bodytemperatureaverage.add(new JLabel("Body Temperature average value:"));
        bodytemperatureaverage.add(new JLabel(String.valueOf(avgbodytemperature)));
        averagevalues.add(bodytemperatureaverage);

        double avgrespiratoryrate;
        avgrespiratoryrate = IntStream.of(respiratoryratevalues).sum()/respiratoryratevalues.length;
        respiratoryrateaverage.add(new JLabel("Respiratory Rate average value:"));
        respiratoryrateaverage.add(new JLabel(String.valueOf(avgrespiratoryrate)));
        averagevalues.add(respiratoryrateaverage);


        //set dimensions of jpanels
        info.setPreferredSize(new Dimension(500, 75));
        info.setVisible(true);
        recordedvalues.setPreferredSize(new Dimension(525, 400));
        recordedvalues.setVisible(true);
        recordedvalues.setBorder(new MatteBorder(2, 0, 2, 0, Color.BLACK) );
        averagevalues.setPreferredSize(new Dimension(540, 150));
        averagevalues.setVisible(true);

        patientProfile.setPreferredSize(new Dimension(550, 645));
        patientProfile.setVisible(true);

        //add JPanels to main Panel patientProgfile
        patientProfile.add(info);
        patientProfile.add(recordedvalues);
        patientProfile.add(averagevalues);

        patientProfile.setBorder(new MatteBorder(2, 2, 2, 2, Color.BLACK) );

    }

    public JPanel getPatientProfileRecords() {return patientProfile;}
}
