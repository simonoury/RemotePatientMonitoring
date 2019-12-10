import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DropDownMenu extends JMenuBar implements ActionListener {
    //DECLARE CLASS FOR GRAPH
    JMenuBar menubar;
    JMenu menu;
    JMenuItem item;
    JMenuItem item2;
    private JRootPane rootPane;
    private JPanel main;

    public DropDownMenu (){
        //instantiate CLASS FOR GRAPH
        JRootPane rootPane = new JRootPane();
        rootPane.getContentPane();
        main=new JPanel();
        menubar=new JMenuBar();
        menu = new JMenu("Go to: ");
        item = new JMenuItem ("Live Data");
        item2 = new JMenuItem("Profile");
        item.addActionListener(this);
        //Add the JMenu to the JMenuBar
        menu.add(item);     //Add the JMenuItem to the JMenu
        menu.add(item2);
        menubar.add(menu) ;
        rootPane.setJMenuBar(menubar);
        main.add(rootPane);
    }
    @Override
    public void actionPerformed(ActionEvent actionEvent) {

    }

    public JMenuBar getMenubar() {
        return menubar;
    }

    public JPanel getmenu() {
        return main;
    }
}



