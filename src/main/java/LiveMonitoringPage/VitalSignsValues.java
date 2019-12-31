package LiveMonitoringPage;

import javax.swing.*;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class VitalSignsValues {
    private int heartratevalues[] = {69, 74, 56, 84, 95, 115, 78, 68, 70, 71,95, 115, 78, 68, 70, 71,95, 115, 78, 68, 70, 71,95, 115, 78, 68, 70, 71,95, 115, 78, 68, 70, 71,78, 68, 70, 71,95, 115, 78, 68, 70, 71,95, 115, 78, 68, 70, 71,95, 115, 78, 68, 70, 71,69, 74, 56, 84, 95, 115, 78, 68, 70, 71,95, 115, 78, 68, 70,69, 74, 56, 84, 95, 115, 78, 68, 70, 71,95, 115, 78, 68, 70,69, 74, 56, 84, 95, 115, 78, 68, 70, 71,95, 115, 78, 68, 70,69, 74, 56, 84, 95, 115, 78, 68, 70, 71,95, 115, 78, 68, 70};
    private int bloodpressurevalues [] = {118, 119, 118, 119, 120, 121, 120, 119, 119, 118,118, 119, 118, 119, 120, 121, 120, 119, 119, 118,118, 119, 118, 119, 120, 121, 120, 119, 119, 118,118, 119, 118, 119, 120, 121, 120, 119, 119, 118,118, 119, 118, 119, 120, 121, 120, 119, 119, 118};
    private JPanel ecg,heartrate,bloodpressure,bodytemperature,respiratoryrate,valuesPanel;
    private JLabel heartrateLabel,bloodpressureLabel,bodytemperatureLabel,respiratoryrateLabel;

    public VitalSignsValues(){
        ecg=new JPanel();
        heartrate = new JPanel();
        bloodpressure = new JPanel();
        bodytemperature = new JPanel();
        respiratoryrate = new JPanel();
        valuesPanel=new JPanel();
        heartrateLabel=new JLabel();
        bloodpressureLabel=new JLabel();
        bodytemperatureLabel=new JLabel();
        respiratoryrateLabel=new JLabel();
        valuesPanel.setLayout(new GridLayout(5,1));

        ActionListener taskPerformer = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {

                ecg.add(new JLabel());
                heartrateLabel.setText("<html> <h2> "+toString().valueOf(heartratevalues[CurrentTime()])+"</h2> </html>");
                heartrate.add(heartrateLabel);
                bloodpressureLabel.setText("<html> <h2>"+toString().valueOf(bloodpressurevalues[CurrentTime()])+"</h2> </html>");
                bloodpressure.add(bloodpressureLabel);
                respiratoryrateLabel.setText("<html> <h2>"+toString().valueOf(heartratevalues[CurrentTime()])+"</h2> </html>");
                respiratoryrate.add(respiratoryrateLabel);
                bodytemperatureLabel.setText("<html> <h2>"+toString().valueOf(heartratevalues[CurrentTime()])+"</h2> </html>");
                bodytemperature.add(bodytemperatureLabel);




                bodytemperature.setBorder(new MatteBorder(2, 2, 2, 2, Color.BLACK) );
                ecg.setBorder(new MatteBorder(2, 2, 2, 2, Color.BLACK) );
                respiratoryrate.setBorder(new MatteBorder(2, 2, 2, 2, Color.BLACK) );
                bloodpressure.setBorder(new MatteBorder(2, 2, 2, 2, Color.BLACK) );
                heartrate.setBorder(new MatteBorder(2, 2, 2, 2, Color.BLACK) );

                valuesPanel.add(ecg);
                valuesPanel.add(heartrate);
                valuesPanel.add(bodytemperature);
                valuesPanel.add(bloodpressure);
                valuesPanel.add(respiratoryrate);
                valuesPanel.setPreferredSize(new Dimension(100,640));
                valuesPanel.setBorder(new MatteBorder(2, 2, 2, 2, Color.BLACK) );
            }
        };
        Timer t = new Timer(1000, taskPerformer);
        t.start();




    }
    public int CurrentTime(){
        Calendar cal = new GregorianCalendar();
        int second = cal.get(Calendar.SECOND);
        int min = cal.get(Calendar.MINUTE);
        int hour = cal.get(Calendar.HOUR);
        //heartrateLabel.setText(s);
        return second;

    }


        public JPanel getValuesPanel () {
            return valuesPanel;
        }
    }
