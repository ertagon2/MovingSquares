import javax.swing.*;
import java.awt.*;

public class Application {
    private Application() {
        //create a JFrame window
        JFrame frame = new JFrame("Moving Squares");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //add a JPanel
        GamePanel gamePanel = new GamePanel();
        frame.add(gamePanel);
        //pack the window around the content
        frame.pack();
        //center
        frame.setLocationRelativeTo(null);
        //set minimum size
        frame.setMinimumSize(new Dimension(40, 80));
        frame.setVisible(true);
        //create and start the thread
        //more info on why in GamePanel constructor
        new Thread(gamePanel).start();
    }

    public static void main(String args[]){
        new Application();
    }
}
