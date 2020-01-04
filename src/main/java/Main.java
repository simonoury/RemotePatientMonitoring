

import javax.swing.*;



public class Main {



    public static void main(String[] args) throws InterruptedException {

        //Add Board to Frame

        MainBoard board=new MainBoard();
        JFrame frame = new JFrame("Remote Patient Monitoring");
        frame.setSize(1450, 925);
        frame.setVisible(true);
        frame.add(board.getMainPanel());
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        while (true) {
            Thread.sleep(1);
            board.Update();
            frame.add(board.getMainPanel());
            frame.repaint();
        }





    }

}


