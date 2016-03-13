/**
 * Created by Trevaughn Daley on 3/12/14.
 */
import java.awt.Graphics;
import java.awt.Color;

public class Computer {

    private int y, x;
    private int yVelocity;
    public final int HEIGHT = 50;
    public final int WIDTH = 20;
    boolean bottom = false;
    Board field;

    public Computer(Board board, int startX, int startY){
        this.x = startX;
        this.y = startY;
        this.yVelocity = 0;
        this.field = board;
    }

    public void update(){

        if (field.getBallY() < this.y){
            yVelocity = -5;
        }
        if (field.getBallY() > this.y){
            yVelocity = 5;
        }

        y = y + yVelocity;
    }

    public void setYVelocity(int speed){
        this.yVelocity = speed;
    }


    public void paint(Graphics g){
        g.setColor(Color.WHITE);
        g.fillRect(x,y, WIDTH,HEIGHT);
    }

    public int getX(){
        return x - WIDTH;
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
}