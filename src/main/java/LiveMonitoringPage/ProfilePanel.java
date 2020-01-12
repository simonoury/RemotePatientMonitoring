package LiveMonitoringPage;

import Database.DBConnect;
import Model.Patient;

import javax.swing.*;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class ProfilePanel extends JPanel {
    //Declaration of Panels
    private JPanel patientProfile;
    private JPanel info, heartrate, bodytemp, bloodpress, resprate;
    DBConnect database;
    private Patient patient;

    //Sample values to be replaced with database values
    private int normalvalues[] = {60, 37, 14, 110, 70};

    private ResultSet res;
    private String request;
    String familyname;
    String surname;
    String admdate;
    String idno;
    private Connection conn;

    public ProfilePanel(Patient p) {
        patient = p;
        database = new DBConnect();

        familyname = patient.getFamilyname();
        surname = patient.getGivenname();
        admdate = patient.getDate();
        idno = patient.getId();

        double data_HR[] = getdata_HR();
        double data_BP[] = getdata_BP();
        double data_BT[] = getdata_BT();
        double data_RR[] = getdata_RR();

        //Instantiation of panels
        patientProfile = new JPanel();
        info = new JPanel();

        //Layout of PatientProfile
        patientProfile.setLayout(new GridLayout(10, 1));
        patientProfile.setBorder(new MatteBorder(2, 2, 2, 2, Color.WHITE));


        JLabel namelabel = new JLabel("<html> <font color=white> Name: ");
        JLabel idlabel = new JLabel("<html> <font color=white>ID ");
        JLabel datelabel = new JLabel("<html> <font color=white>Admission Date ");
        JLabel name = new JLabel("<html> <font color=white>" + familyname + " " + "<html> <font color=white>" + surname);
        JLabel id = new JLabel("<html> <font color=white>" + idno);
        JLabel date = new JLabel("<html> <font color=white>" + admdate);

        //Vital Signs Panels and Layouts
        heartrate = new JPanel();
        heartrate.setLayout(new GridLayout(1, 2));
        bodytemp = new JPanel();
        bodytemp.setLayout(new GridLayout(1, 2));
        resprate = new JPanel();
        resprate.setLayout(new GridLayout(1, 2));
        bloodpress = new JPanel();
        bloodpress.setLayout(new GridLayout(1, 2));

        //Add values to info + 5 Vital Signs Panel *to be replaced with database fetched values*
        info.setLayout(new GridLayout(3, 2));
        info.add(namelabel);
        info.add(name);
        info.add(idlabel);
        info.add(id);
        info.add(datelabel);
        info.add(date);

        heartrate.add(new JLabel("<html> <h4> <font color=white> Heart Rate  </h4>"));
        heartrate.add(new JLabel("<html> <font color=white>" + String.valueOf(data_HR[1]) + " bpm", SwingConstants.LEFT));

        bodytemp.add(new JLabel("<html> <h4> <font color=white> Body Temperature  </h4>", SwingConstants.LEFT));
        bodytemp.add(new JLabel("<html> <font color=white>" + data_BT[1] + " °C"));


        resprate.add(new JLabel("<html> <h4>  <font color=white> Respiratory Rate: </h4>"));
        resprate.add(new JLabel(("<html> <font color=white>" + data_RR[1]) + " breaths/min"));

        bloodpress.add(new JLabel("<html> <h4> <font color=white> Blood Pressure:   </h4>"));
        bloodpress.add(new JLabel(("<html> <font color=white>" + data_BP[1]) + "/" + normalvalues[4] + " mmHg (systolic/diastolic)"));

        info.setBackground(Color.black);
        heartrate.setBackground(Color.black);
        bodytemp.setBackground(Color.black);
        resprate.setBackground(Color.black);
        bloodpress.setBackground(Color.black);

        //Add all information to patientProfile Panel
        patientProfile.add(info);
        patientProfile.add(heartrate);
        patientProfile.add(bodytemp);
        patientProfile.add(resprate);
        patientProfile.add(bloodpress);
        patientProfile.setBackground(Color.black);


        patientProfile.setPreferredSize(new Dimension(300, 640));


    }

        public JPanel getPatientProfile() {
        return patientProfile;
    }


    protected double[] getdata_HR() {
        return patient.getHRdata();
    }

    protected double[] getdata_BP() {
        return patient.getBPdata();
    }

    protected double[] getdata_BT() {
        return patient.getBTdata();
    }

    protected double[] getdata_RR() {
        return patient.getRRdata();
    }
}