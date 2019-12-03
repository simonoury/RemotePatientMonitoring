import javax.swing.*;
import java.awt.*;

public class ProfilePanel extends JPanel {
    private JPanel profile,heartrate,bodytemp,bloodpress,resprate;
    private GridLayout grid;
    private JLabel title,name,id,hr,bt,rr,bp ;
    private int normalvalues[]={60, 37,14,110,70};



    public ProfilePanel(){
        profile=new JPanel();
        grid=new GridLayout(8,1);
        profile.setLayout(grid);


        JLabel title=new JLabel("<html><h1> Patient Profile </h1>");
        JLabel name= new JLabel("<html> <h3>Martin Holloway</h3>");
        JLabel id=new JLabel("Patient id: 0001 ");

        heartrate=new JPanel();
        bodytemp=new JPanel();
        resprate=new JPanel();
        bloodpress=new JPanel();

        JLabel hr= new JLabel("Heart Rate: ");
        JLabel bt= new JLabel("Body Temperature: ");
        JLabel rr= new JLabel("Respiratory Rate: ");
        JLabel bp= new JLabel("Blood Pressure: ");


        profile.add(title);
        profile.add(name);
        profile.add(id);
        heartrate.add(hr);
        String.valueOf(normalvalues[1]);
        heartrate.add(new JTextField(String.valueOf(normalvalues[1])));
        bodytemp.add(bt);
        bloodpress.add(bp);
        resprate.add(rr);
        profile.add(heartrate);
        profile.add(bodytemp);
        profile.add(bloodpress);
        profile.add(resprate);

    }

    public JPanel getProfile() {
        return profile;
    }
}
