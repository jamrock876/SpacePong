/**
 * Created by Trevaughn Daley on 3/12/14.
 */
import java.awt.Graphics;
import java.awt.Color;

public class Player {

    private int y, x;
    private int velocity;
    public final int HEIGHT = 50;
    public final int WIDTH = 20;
    private boolean bottom = false;
    private boolean top = false;

    public Player(int startX, int startY){
        this.x = startX;
        this.y = startY;
        this.velocity = 0;
    }

    public void update(){

        if ( y + HEIGHT >= 410 && bottom == false){	// need to fix to different resolotions
            velocity = 0;
        }
        if ( y + HEIGHT >= 410 && bottom == true){	// need to fix to different resolotions
            bottom = false;
        }
        if (y <= 10 && top == false){
            velocity = 0;
        }
        if (y <= 10 && top == true){
            top = false;
        }

        y = y + velocity;
    }

    public void setYVelocity(int speed){
        this.velocity = speed;
    }


    public void paint(Graphics g){
        g.setColor(Color.WHITE);
        g.fillRect(x,y, WIDTH,HEIGHT);
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    public int getHeight(){
        return HEIGHT;
    }

    public int getWidth(){
        return WIDTH;
    }

    public void setBottom(boolean value){
        this.bottom = value;
    }

    public void setTop(boolean value){
        this.top = value;
    }
}