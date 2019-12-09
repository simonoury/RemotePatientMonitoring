import javax.swing.*;
import java.awt.*;

public class BlankBoard extends JPanel {
    private JPanel mainpanel;
    private MenuBoard menuBoard;


    public BlankBoard(){
        mainpanel=new JPanel();
        menuBoard=new MenuBoard();


        mainpanel.add(menuBoard.getHeader());


    }

    public JPanel getMainpanel() {
        return mainpanel;
    }
}
