import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

public class GamePanel extends JPanel implements Runnable{

    //set JPanel size
    private static final Dimension DESIRED_SIZE = new Dimension(600,600);
    @Override
    public Dimension getPreferredSize(){
        return DESIRED_SIZE;
    }

    //constructor
    GamePanel(){
        //Thread initialization moved to main() to eliminate freezing
        //https://stackoverflow.com/questions/54217876/why-does-my-java-application-randomly-freeze-after-start/54218108#54218108
    }

    private ArrayList <Rect> rect=new ArrayList<>();
    public void run(){
        for(int i=0; i<15; i++){
            rect.add(new Rect());
        }

        while(true){
            for(Rect rect:rect){
                rect.move(this);
            }
            repaint();
            try{Thread.sleep(30);}
            catch(InterruptedException e){/**/};
        }
    }

    public void paint(Graphics g){
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setColor(Color.white);
        g2d.fillRect(0,0,getWidth(),getHeight());
        for(Rect rect:rect) {
            g2d.setColor(Color.black);
            g2d.fillRect(rect.getXcord()-1, rect.getYcord()-1, rect.getWidth()+2, rect.getHeight()+2);
            g2d.setColor(rect.getRGB());
            g2d.fillRect(rect.getXcord(), rect.getYcord(), rect.getWidth(), rect.getHeight());
        }
    }
}
