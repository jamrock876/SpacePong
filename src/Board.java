/**
 * Created by Trevaughn Daley on 3/12/14.
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Board extends JPanel implements KeyListener, ActionListener {
    Timer time;
    Ball ball;
    Player player;
    Computer comp;
    Image background;
    ImageIcon icon;

    public Board(){
        ball = new Ball();
        player = new Player(10, 10);
        comp =  new Computer(this, 687, 250);
        time = new Timer(50, this);
        icon = new ImageIcon("./res/images/PongBackground.png");
        background = icon.getImage();
        time.start();

        this.addKeyListener(this);
        this.setFocusable(true);
    }

    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(background, 0, 0, null);
        g.setColor(Color.YELLOW);
        g.drawLine(720/2, 0, 720/2, 420);
        g.setColor(Color.WHITE);
        g2d.setFont(new Font("Sherif", Font.BOLD, 36));
        g2d.drawString(Integer.toString(ball.getCompScore()), 310, 50);
        g2d.drawString(Integer.toString(ball.getPlayerScore()), 390, 50);
        player.paint(g);
        comp.paint(g);
        ball.paint(g);
    }

    public void actionPerformed(ActionEvent e){
        try {
            player.update();
            comp.update();
            ball.checkCollisionPlayer(player);
            ball.checkCollisionComp(comp);
            ball.update();
            repaint();
        }catch (java.lang.Exception e2){
            System.out.println(e2);
        }
    }

    public int getBallY(){
        return ball.getY();
    }

    public void keyPressed(KeyEvent e){
        if (e.getKeyCode() == KeyEvent.VK_UP){
            player.setYVelocity(-4);
            player.setBottom(true);
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN){
            player.setYVelocity(4);
            player.setTop(true);
        }

    }

    public void keyReleased(KeyEvent e){
        if (e.getKeyCode() == KeyEvent.VK_UP){
            player.setYVelocity(0);
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN){
            player.setYVelocity(0);
        }
    }

    public void keyTyped(KeyEvent e){

    }
}