package LiveMonitoringPage;

import Alarm.Alarmpanel;
import Model.Patient;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.awt.Color.black;

public class LiveMonitoringPageView {
    //Instantiate the  panels that will be used
    private ProfilePanel profilePanel;
    private VitalSignsPanel profileGraph;

    private JPanel page;
    private Alarmpanel alarmPanel;

    public LiveMonitoringPageView(Patient patient)  {
        profilePanel=new ProfilePanel(patient); //create profilePanel from ProfilePanel
        profileGraph = new VitalSignsPanel(patient); //create profileGraphs from VitalSignsPanel

        page=new JPanel();

        page.setPreferredSize(new Dimension(1450,650));
        page.setBackground(black);
        JButton augment, decrement;
        augment = new JButton("+1");
        augment.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                Augment();
            }
        });
        decrement = new JButton("-1");
        decrement.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                Decrement();
            }
        });
        GridLayout grid;
        grid=new GridLayout(2, 1);
        JPanel buttons = new JPanel(grid);
        buttons.setBackground(black);


        buttons.add(augment);
        buttons.add(decrement);
        page.add(buttons);
        page.add(profilePanel.getPatientProfile()); //add both panes to the main panel page

        page.add(profileGraph.getMainPanel());


    }

    public JPanel getPage() {
        return page;
    }

    //updates the panels to repaint current values
    public void Update()
    {
        profileGraph.Update();
        profilePanel.Update();
    }

    public void Augment(){
        profileGraph.Augment();
    }

    public  void Decrement() {
        profileGraph.Decrement();
    }

}