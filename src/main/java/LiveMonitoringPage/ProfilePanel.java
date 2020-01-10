package LiveMonitoringPage;

import Database.DBConnect;
import Model.Patient;
import sun.font.CharToGlyphMapper;

import javax.swing.*;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class ProfilePanel extends JPanel  {
    //Declaration of Panels
    private JPanel patientProfile;
    private JPanel info, heartrate,bodytemp,bloodpress,resprate;
    DBConnect database;
    private Patient patient;

    //Sample values to be replaced with database values
    private int normalvalues[]={60,37,14,110,70};

    private ResultSet res;
    private String request;
    String familyname;
    String surname;
    private Connection conn;

    public ProfilePanel(Patient p) {
        patient = p;
        database=new DBConnect();

        familyname = patient.getFamilyname();
        surname = patient.getGivenname();

        //Instantiation of panels
        patientProfile =new JPanel();
        info = new JPanel();

        //Layout of PatientProfile
        patientProfile.setLayout(new GridLayout(10,1));
        patientProfile.setBorder(new MatteBorder(2, 2, 2, 2, Color.white) );
        patientProfile.setBackground(Color.black);


        JLabel name= new JLabel("<html> <font color=white>"+familyname + " " + surname+"</font> </html>");
        JLabel id=new JLabel("<html> <font color=white> Patient id: " + patient.getId()+"</font> </html>");

        //Vital Signs Panels and Layouts
        heartrate=new JPanel();
        heartrate.setLayout(new GridLayout(1,2));
        bodytemp=new JPanel();
        bodytemp.setLayout(new GridLayout(1,2));
        resprate=new JPanel();
        resprate.setLayout(new GridLayout(1,2));
        bloodpress=new JPanel();
        bloodpress.setLayout(new GridLayout(1,2));

        //Panel backgrounds
        info.setBackground(Color.black);
        heartrate.setBackground(Color.black);
        bodytemp.setBackground(Color.black);
        resprate.setBackground(Color.black);
        bloodpress.setBackground(Color.black);


        //Add values to info + 5 Vital Signs Panel *to be replaced with database fetched values*
        info.setLayout(new GridLayout(2, 1));
        info.add(name);
        info.add(id);

        heartrate.add(new JLabel("<html> <h4> <font color=white>Heart Rate:  </font></h4>"));
        heartrate.add(new JLabel("<html> <h4> <font color=white>"+ String.valueOf(normalvalues[1])+" bpm </font></h4>", SwingConstants.LEFT));

        bodytemp.add(new JLabel("<html> <h4><font color=white> Body Temperature:  </font></h4>", SwingConstants.LEFT));
        bodytemp.add(new JLabel("<html> <h4> <font color=white>"+normalvalues[1]+ " °C</font></h4>"));


        resprate.add(new JLabel("<html> <h4><font color=white>Respiratory Rate: </font></h4>"));
        resprate.add(new JLabel(("<html> <h4> <font color=white>"+normalvalues[2])+ " breaths/min</font></h4>"));

        bloodpress.add(new JLabel("<html> <h4><font color=white>Blood Pressure:   </font></h4>"));
        bloodpress.add(new JLabel("<html> <h4> <font color=white>"+normalvalues[3]+" mmHg (systolic pressure)  "+normalvalues[4]+ " mmHg (diastolic pressure)</font></h4>"));

        //Add all information to patientProfile Panel
        patientProfile.add(info);
        patientProfile.add(heartrate);
        patientProfile.add(bodytemp);
        patientProfile.add(resprate);
        patientProfile.add(bloodpress);


        patientProfile.setPreferredSize(new Dimension(300,640));



    }


    public JPanel getPatientProfile() {
        return patientProfile;
    }

}