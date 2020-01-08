package LiveMonitoringPage;

import Database.DBConnect;
import Model.Patient;

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
        patientProfile.setBorder(new MatteBorder(2, 2, 2, 2, Color.BLACK) );


        JLabel name= new JLabel(familyname + " " + surname);
        JLabel id=new JLabel("Patient id: " + patient.getId());

        //Vital Signs Panels and Layouts
        heartrate=new JPanel();
        heartrate.setLayout(new GridLayout(1,2));
        bodytemp=new JPanel();
        bodytemp.setLayout(new GridLayout(1,2));
        resprate=new JPanel();
        resprate.setLayout(new GridLayout(1,2));
        bloodpress=new JPanel();
        bloodpress.setLayout(new GridLayout(1,2));

        //Add values to info + 5 Vital Signs Panel *to be replaced with database fetched values*
        info.setLayout(new GridLayout(2, 1));
        info.add(name);
        info.add(id);

        heartrate.add(new JLabel("<html> <h4> Heart Rate:  </h4>"));
        heartrate.add(new JLabel(String.valueOf(normalvalues[1])+" bpm", SwingConstants.LEFT));

        bodytemp.add(new JLabel("<html> <h4> Body Temperature:  </h4>", SwingConstants.LEFT));
        bodytemp.add(new JLabel(normalvalues[1]+ " °C"));


        resprate.add(new JLabel("<html> <h4>Respiratory Rate: </h4>"));
        resprate.add(new JLabel((normalvalues[2])+ " breaths/min"));

        bloodpress.add(new JLabel("<html> <h4>Blood Pressure:   </h4>"));
        bloodpress.add(new JLabel((normalvalues[3])+" mmHg (systolic pressure)  "+normalvalues[4]+ " mmHg (diastolic pressure)"));

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