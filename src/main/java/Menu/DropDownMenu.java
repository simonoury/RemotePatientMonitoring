package Menu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import LiveMonitoringPage.*;
import Model.Patient;
import RecordsPage.RecordsPageView;

public class DropDownMenu extends JComboBox implements ActionListener {
    //Declaration of drop-down menu
    private JComboBox<String> options;

    //Patient
    Patient patient;

    //Declaration of Panel, Labels & string
    private JPanel selectedPanel; //panel stores the correct page


    //Declaration of classes corresponding to pages
    private LiveMonitoringPageView liveMonitoringPageView;
    private RecordsPageView recordsPageView;

    public DropDownMenu()  {
        //Instantiation of variabless
        options=new JComboBox<String>();
        patient = new Patient();
        liveMonitoringPageView =new LiveMonitoringPageView(patient);
        recordsPageView = new RecordsPageView(patient);
        selectedPanel=new JPanel();


        //Naming options of drop-down menu
        options.addItem("Live Monitoring");
        options.addItem("Records");

        //Setting default panel to Live-Monitoring Page
        selectedPanel.add(liveMonitoringPageView.getPage());

        //Action Listener to select options in menu
        options.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JComboBox<String> combo = (JComboBox<String>) e.getSource();
                String selectedoption = (String) combo.getSelectedItem();


                if (selectedoption.equals("Live Monitoring")) {
                    //Refresh page
                    selectedPanel.removeAll();
                    selectedPanel.updateUI();
                    //add page on panel
                    selectedPanel.add(liveMonitoringPageView.getPage());
                    selectedPanel.setBackground(Color.black);


                }
                else if (selectedoption.equals("Records")) {
                    //Refresh page
                    selectedPanel.removeAll();
                    selectedPanel.updateUI();
                    //add page on panel
                    selectedPanel.add(recordsPageView.getRecordspage());
                    selectedPanel.setBackground(Color.black);

                }
            }
        });

    }

    public DropDownMenu(int PatientID)  {
        //Instantiation of variabless
        options=new JComboBox<String>();
        patient = new Patient(PatientID);
        liveMonitoringPageView =new LiveMonitoringPageView(patient);
        recordsPageView = new RecordsPageView(patient);
        selectedPanel=new JPanel();

        //Naming options of drop-down menu
        options.addItem("Live Monitoring");
        options.addItem("Records");

        //Setting default panel to Live-Monitoring Page
        selectedPanel.add(liveMonitoringPageView.getPage());

        //Action Listener to select options in menu
        options.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JComboBox<String> combo = (JComboBox<String>) e.getSource();
                String selectedoption = (String) combo.getSelectedItem();

                if (selectedoption.equals("Live Monitoring")) {
                    //Refresh page
                    selectedPanel.removeAll();
                    selectedPanel.updateUI();
                    //add page on panel
                    selectedPanel.add(liveMonitoringPageView.getPage());

                    selectedPanel.setBackground(Color.black);
                }
                else if (selectedoption.equals("Records")) {
                    //Refresh page
                    selectedPanel.removeAll();
                    selectedPanel.updateUI();
                    //add page on panel
                    selectedPanel.add(recordsPageView.getRecordspage());
                    selectedPanel.setBackground(Color.black);

                }
            }
        });

    }

    public JComboBox<String> getOptions() {

        return options;
    }

    public JPanel getSelectedPanel() {

        return selectedPanel;
    }

    public void Update()
    {
        liveMonitoringPageView.Update();
    }

}