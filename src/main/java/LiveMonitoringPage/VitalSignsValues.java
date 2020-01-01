package LiveMonitoringPage;

import Alarm.Alarm;

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
    private Alarm heartrate,bloodpressure,bodytemperature,respiratoryrate;
    private JPanel ecg,valuesPanel;

    public VitalSignsValues(){
        ecg=new JPanel();
        valuesPanel=new JPanel();
        heartrate=new Alarm(3,69,50,95,heartratevalues);
        bloodpressure=new Alarm(3,50,5,120,heartratevalues);
        bodytemperature=new Alarm(3,44,5,100,heartratevalues);
        respiratoryrate=new Alarm(3,44,5,100,heartratevalues);

        valuesPanel.setLayout(new GridLayout(5,1));

        ActionListener taskPerformer = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {

                heartrate.addText("<html> <h2> "+toString().valueOf(heartratevalues[CurrentTime()])+"</h2> </html>");
                bloodpressure.addText("<html> <h2>"+toString().valueOf(bloodpressurevalues[CurrentTime()])+"</h2> </html>");
                respiratoryrate.addText("<html> <h2>"+toString().valueOf(heartratevalues[CurrentTime()])+"</h2> </html>");
                bodytemperature.addText("<html> <h2>"+toString().valueOf(heartratevalues[CurrentTime()])+"</h2> </html>");


                heartrate.getAlarm().setOpaque(true);
                bloodpressure.getAlarm().setOpaque(true);
                respiratoryrate.getAlarm().setOpaque(true);
                bodytemperature.getAlarm().setOpaque(true);

                valuesPanel.add(heartrate.getAlarm());
                valuesPanel.add(heartrate.getAlarm());
                valuesPanel.add(bodytemperature.getAlarm());
                valuesPanel.add(bloodpressure.getAlarm());
                valuesPanel.add(respiratoryrate.getAlarm());
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
