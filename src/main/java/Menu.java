import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends JMenuBar implements ActionListener {
    JMenu menu;
    JMenuItem item;
    JMenuItem item2;

    public Menu(){
        menu = new JMenu("The menu");
        item = new JMenuItem ("Patient 1");
        item2 = new JMenuItem("Patient 2");
        item.addActionListener(this);
        add(menu);          //Add the JMenu to the JMenuBar
        menu.add(item);     //Add the JMenuItem to the JMenu
        menu.add(item2);
    }
    @Override
    public void actionPerformed(ActionEvent actionEvent) {

    }
}
