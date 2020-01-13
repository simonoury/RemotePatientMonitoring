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
        JButton yaugment, ydecrement, xaugment, xdecrement;
        yaugment = new JButton("y+1");
        yaugment.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                Augment();
            }
        });
        ydecrement = new JButton("y-1");
        ydecrement.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                Decrement();
            }
        });
        xaugment = new JButton("n+1");
        xaugment.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                ZoomOut();
            }
        });
        xdecrement = new JButton("n-1");
        xdecrement.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                ZoomIn();
            }
        });

        GridLayout grid;
        grid=new GridLayout(4, 1);
        JPanel buttons = new JPanel(grid);
        buttons.setBackground(black);


        buttons.add(yaugment);
        buttons.add(ydecrement);
        buttons.add(xaugment);
    buttons.add(xdecrement);
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

    public void ZoomOut() {profileGraph.Zoomout();}

    public void ZoomIn(){profileGraph.ZoomIn();}

}