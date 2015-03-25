package edu.ucsb.cs56.w15.drawings.weiers.advanced;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

/**
    AnimatedPictureViewer
    Based upon the outline of the AnimatedPictureViewer.java
    made by andrewberls

    This class draws two power outlets; one poweroutlet bounces
    up and down, while the other bounces left and right

    @author William Eiers
    @version for CS56, W15, UCSB, 03/01/2015
*/

public class AnimatedPictureViewer {

    private DrawPanel panel = new DrawPanel();
    
    Thread anim;   
    
    private int x = 100;
    private int y = 100;
    
    private int dx = 5;
    private int dy = -2;
    
    // for random color
    private Random rand = new Random();

    public static void main (String[] args) {
      new AnimatedPictureViewer().go();
    }

    public void go() {
      JFrame frame = new JFrame();
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      frame.getContentPane().add(panel);
      frame.setSize(640,480);
      frame.setVisible(true);
      // clicking the mouse button starts te animation; wont stop until
      // the application is closed
      frame.getContentPane().addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e){
                anim = new Animation();
                anim.start();
            }
      });
      
    } // go()

    class DrawPanel extends JPanel {
       public void paintComponent(Graphics g) {

        Graphics2D g2 = (Graphics2D) g;

         // Clear the panel first
          g2.setColor(Color.white);
          g2.fillRect(0,0,this.getWidth(), this.getHeight());

          // Draw two power outlet, one going up and down, other goind left/right
          // with a randomized color each time
          g2.setColor(new Color(rand.nextInt(255),rand.nextInt(255),rand.nextInt(255)));
          PowerOutletWithGround outlet = new PowerOutletWithGround(300,y,60,90);
          PowerOutletWithGround outlet2 = new PowerOutletWithGround(x, 200, 60,90);
          g2.draw(outlet);
          g2.draw(outlet2);
       }
    }
    
    class Animation extends Thread {
      public void run() {
        try {
          while (true) {
            // Bounce off the walls
            // both up and down, including corners
            if (x >= 600) { dx = -5; }
            if (x <= 20) { dx = 3; }
            if (y <= 20) { dy = 3; }
            if (y >= 300) { dy = -3; }
            // change the velocities of the outlets
            x += dx;                
            y += dy;
            panel.repaint();
            Thread.sleep(50);
          }
        } catch(Exception ex) {
          if (ex instanceof InterruptedException) {
            // Do nothing - expected on mouseExited
          } else {
            ex.printStackTrace();
            System.exit(1);
          }
        }
      }
    }
    
}
