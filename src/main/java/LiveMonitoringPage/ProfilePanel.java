package LiveMonitoringPage;

import javax.swing.*;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.sql.*;

public class ProfilePanel extends JPanel  {
    //Declaration of Panels
    private JPanel patientProfile;
    private JPanel info, heartrate,bodytemp,bloodpress,resprate;

    //Sample values to be replaced with database values
    private int normalvalues[]={60,37,14,110,70};

    private ResultSet res;
    private String requete;
    String familyname;

    public ProfilePanel() {
        try {
            // Registers the driver
            Class.forName("org.postgresql.Driver");
            Connection conn = DriverManager.getConnection("jdbc:postgresql://hjcqaohuagengm:6ca336e996e214db564e5871a756e3cf5567db550d0e033f903225c7da2ee5f7@ec2-46-137-113-157.eu-west-1.compute.amazonaws.com:5432/d9reln7n11dkvn?sslmode=require");
            requete = "SELECT * FROM patients";
            Statement stmt = conn.createStatement();
            res = stmt.executeQuery(requete);

            while (res.next()){
                familyname=res.getString("familyname");
                System.out.println(familyname);

            }
            stmt.close();

        } catch (Exception e) {
            System.err.println("Got an exception! ");
            //System.err.println(e.toString());

        }

        //Instantiation of panels
        patientProfile =new JPanel();
        info = new JPanel();

        //Layout of PatientProfile
        patientProfile.setLayout(new GridLayout(10,1));
        patientProfile.setBorder(new MatteBorder(2, 2, 2, 2, Color.BLACK) );


        JLabel name= new JLabel(familyname);
        JLabel id=new JLabel("Patient id: 0001 ");

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



    }


    public JPanel getPatientProfile() {
        return patientProfile;
    }

}