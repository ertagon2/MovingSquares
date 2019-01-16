import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Rect{
    //properties
    private int width=30, height=30;
    private Color rgb;
    //movement
    private int xCord, yCord;
    private int xVector, yVector;
    private int xSlope, ySlope;

    public Rect(){
        Random rand = new Random();
        //random color
        int r, g, b;
        r=rand.nextInt(256);
        g=rand.nextInt(256);
        b=rand.nextInt(256);
        rgb= new Color(r, g, b);

        //random spawn position
        xCord=rand.nextInt(600-width);
        yCord=rand.nextInt(600-height);

        //direction
        do{
            xVector=rand.nextInt(3) - 1;
            yVector=rand.nextInt(3) - 1;
        }while(xVector==0 && yVector==0);

        //slope
        do{
            xSlope=rand.nextInt(3);
            ySlope=rand.nextInt(3);
        }while(xSlope==0 || ySlope==0);
        xVector*=xSlope;
        yVector*=ySlope;
    }


    public void move(JPanel parent){
        int jpWidth=parent.getWidth();
        int jpHeight=parent.getHeight();

        //if stuck outside because of resize
        if ( ((xCord+width)>jpWidth+1) || ((yCord+height)>jpHeight+1) ){
            Random rand = new Random();
            xCord=rand.nextInt(jpWidth-width-2)+1;
            yCord=rand.nextInt(jpHeight-height-2)+1;
            return;
        }

        //bounce
        if((xCord>=jpWidth-width) || (xCord<=0)){
            bounceX();
        }
        if((yCord>=jpHeight-height) || (yCord<=0)) {
            bounceY();
        }
        //move
        xCord+=xVector;
        yCord+=yVector;
    }

    public void bounceX(){
        xVector*=-1;
    }

    public void bounceY(){
        yVector*=-1;
    }

    public Color getRGB() {
        return rgb;
    }

    public int getXcord() {
        return xCord;
    }

    public int getYcord() {
        return yCord;
    }

    public int getWidth(){
        return width;
    }

    public int getHeight(){
        return height;
    }
}
