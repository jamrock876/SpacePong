/**
 * Created by Trevaughn Daley on 3/12/14.
 */
import java.awt.*;
import java.util.*;
import sun.audio.*;
import java.io.*;


public class Ball{

    private int x, y;
    private int xVelocity, yVelocity;
    private final int SIZE = 20;
    boolean collisionPlayer = false;
    boolean collisionComp = false;
    private int compScore = 0;
    private int playerScore = 0;
    Random rand = new Random();
    String pong_sound = "./res/audios/pong_sound.wav";
    int collission_count = 0;

    public Ball(){
        this.x = 360;
        this.y = rand.nextInt(210)+1;
        this.xVelocity = 5;
        this.yVelocity = 5;
    }

    public void update()throws InterruptedException{

        if (collission_count == 5){
            collission_count = 0;
            xVelocity++;
            yVelocity++;
        }
        //test for scoring, has the ball past the opponent? and the physics of the ball
        if (x < 15){
            playerScore++;
            Thread.sleep(1000);
            this.x = 360;
            this.y = rand.nextInt(210)+1;
            this.xVelocity = -5;
            this.yVelocity = 5;

            xVelocity = -xVelocity;

        }
        if (x + SIZE > 720){
            compScore++;
            Thread.sleep(1000);
            this.x = 360;
            this.y = rand.nextInt(210)+1;
            this.xVelocity = 5;
            this.yVelocity = 5;

            xVelocity = -xVelocity;

        }
        //control the physics of the y movement of the ball
        if (y < 10)
            yVelocity = -yVelocity;
        if (y + SIZE > 410)
            yVelocity = -yVelocity;

        if (collisionPlayer == true){
            xVelocity = -xVelocity;
            collisionPlayer = false;
        }
        if (collisionComp == true){
            xVelocity = -xVelocity;
            collisionComp = false;
        }

        x = x + xVelocity;
        y = y + yVelocity;
    }

    public void paint(Graphics g){
        g.setColor(Color.LIGHT_GRAY);
        g.fillOval (x,y, SIZE,SIZE);
    }

    public void playSound(String sound)throws Exception{
        InputStream in = new FileInputStream(sound);
        AudioStream audiostream = new AudioStream(in);
        AudioPlayer.player.start(audiostream);
    }

    public int getY(){
        return y;
    }

    public int getCompScore(){
        return compScore;
    }

    public int getPlayerScore(){
        return playerScore;
    }

    public void checkCollisionPlayer(Player player)throws Exception{
        if ((this.x > player.getX()) && (this.x < player.getX() + player.getWidth())){
            if ((this.y > player.getY()) && (this.y < player.getY() + player.getHeight())){
                collisionPlayer = true;
                collission_count++;
                System.out.println("player Collision");
                playSound(pong_sound);
            }
        }
    }

    public void checkCollisionComp(Computer comp)throws Exception{
        if ((this.x + SIZE - 10 < comp.getX() + comp.getWidth()) && (this.x + SIZE - 10 > comp.getX())){
            if ((this.y + SIZE - 10 < comp.getY() + comp.getHeight()) && (this.y + SIZE - 10 > comp.getY())){
                collisionComp = true;
                collission_count++;
                System.out.println("Computer Collision");
                playSound(pong_sound);
            }
        }
    }
}
