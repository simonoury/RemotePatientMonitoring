package Menu;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DropDownMenu extends JComboBox implements ActionListener {
    private JComboBox<String> options;

    private JPanel selectedPanel;
    private JPanel livemonitor; //replace with panel with profile +
    private JPanel records; //replace with panel RECORDS

    private JLabel label1,label2;
    private String selection;

    public DropDownMenu(){
        options=new JComboBox<String>();
        options.addItem("Live Monitoring");
        options.addItem("Records");

        livemonitor=new JPanel();
        records= new JPanel();

        label1=new JLabel("Live Monitoring");
        label1.setVisible(true);
        livemonitor.add(label1);

        label2=new JLabel("Records");
        label2.setVisible(true);
        records.add(label2);

        selectedPanel=new JPanel();
        selectedPanel.add(livemonitor);
        options.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JComboBox<String> combo = (JComboBox<String>) e.getSource();
                String selectedoption = (String) combo.getSelectedItem();

                if (selectedoption.equals("Live Monitoring")) {
                    System.out.println("Live Monitoring");

                    selectedPanel.removeAll();
                    selectedPanel.updateUI();
                    selectedPanel.add(livemonitor);
                    selection=selectedoption;
                    //System.out.println(selection);
                }
                else if (selectedoption.equals("Records")) {
                    selectedPanel.removeAll();
                    selectedPanel.updateUI();
                    selectedPanel.add(records);
                    System.out.println("Records");
                    selection=selectedoption;

                }
            }
        });
    }

    public String getSelection() {
        return selection;
    }

    public JComboBox<String> getOptions() {
        return options;
    }

    public JPanel getSelectedPanel() {
        return selectedPanel;
    }
}




