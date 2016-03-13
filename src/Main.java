/**
 * Created by Trevaughn Daley on 3/12/14.
 */
import java.awt.*;
import javax.swing.*;

public class Main extends JFrame {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Space Pong");
        frame.setPreferredSize(new Dimension(720, 440));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setTitle("Space Pong");
        frame.add(new Board());
        frame.pack();
        frame.setVisible(true);
    }

}