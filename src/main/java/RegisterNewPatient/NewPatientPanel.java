package RegisterNewPatient;

import javax.swing.*;
import java.awt.*;

public class NewPatientPanel extends JPanel {
    private String name;
    private int age;
    private TextField textField;
    private JButton submit;


    public NewPatientPanel(){

        textField=new TextField();
        submit=new JButton("Submit!");
        add(textField);
        add(submit);


    }

}
