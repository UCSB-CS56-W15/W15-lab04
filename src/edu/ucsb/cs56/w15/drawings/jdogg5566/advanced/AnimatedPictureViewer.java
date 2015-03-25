package edu.ucsb.cs56.w15.drawings.jdogg5566.advanced;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;


/**
A class that utilizes the Sweatshirt.java class and creates an animation with it. Currently, the animation moves up, down, left, and right, and also changes color as it moves.

 */

public class AnimatedPictureViewer {

    private DrawPanel panel = new DrawPanel();
    
    private Sweatshirt sweatshirt= new Sweatshirt(100, 100, 120, 80);
    
    Thread anim;   
    
    private int x = 100;
    private int y = 100;
    
    private int dx = 5;
    private int dy = 5;

    public static void main (String[] args) {
      new AnimatedPictureViewer().go();
    }

    public void go() {
      JFrame frame = new JFrame();
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      frame.getContentPane().add(panel);
      frame.setSize(640,480);
      frame.setVisible(true);
      
      frame.getContentPane().addMouseListener(new MouseAdapter() {
        public void mouseEntered(MouseEvent e){
        System.out.println("mouse entered");
          anim = new Animation();
          anim.start();
        }

        public void mouseExited(MouseEvent e){        
          System.out.println("Mouse exited");
          // Kill the animation thread
          anim.interrupt();
          while (anim.isAlive()){}
          anim = null;         
          panel.repaint();        
        }
      });
      
    } // go()

    class DrawPanel extends JPanel {
       public void paintComponent(Graphics g) {

        Graphics2D g2 = (Graphics2D) g;

         // Clear the panel first
          g2.setColor(Color.white);
          g2.fillRect(0,0,this.getWidth(), this.getHeight());

          // Declare instance of random to designate random color
          Random rand = new Random();
          // Draw the sweatshirt

          // Set color to color with random r g b values
          g2.setColor(new Color(rand.nextFloat(),rand.nextFloat(),rand.nextFloat()));
          Sweatshirt test = new Sweatshirt(x, y, 200, 120);
          g2.fill(test);
          g2.draw(test);
       }
    }
    
    class Animation extends Thread {
      public void run() {
        try {
          while (true) {
            // Bounce off the walls

            if (x >= 400) { dx = -5; }

            if (x <= 50) { dx = 5; }
            if (y >= 350) { dy = -5; }
            if (y <= 50) { dy = 5; }
            
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
