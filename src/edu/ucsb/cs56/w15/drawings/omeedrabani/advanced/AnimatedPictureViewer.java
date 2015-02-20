package edu.ucsb.cs56.w15.drawings.omeedrabani.advanced;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AnimatedPictureViewer {

    private DrawPanel panel = new DrawPanel();
    
    private Clock clock = new Clock(100, 100, 100);
    
    Thread anim;   
    
    private int x = 100;
    private int y = 100;
    
    private int dx = 5;
    private int dy = 0;
    private boolean moveRight = true;
    private boolean moveLeft = false;
    private boolean moveUp = false;
    private boolean moveDown = false;

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

          // Draw the Clock
          g2.setColor(Color.BLUE);
          Clock test = new Clock(x, y, 100);
          g2.draw(test);
       }
    }
    
    class Animation extends Thread {
      public void run() {
        try {
          while (true) {
            // Bounce off the walls
	      
	      if (moveRight) {
		  dx = 5;
		  dy = 0;
	      }
	      else if (moveDown) {
		  dx = 0;
		  dy = 5;
	      }
	      else if (moveLeft) {
		  dx = -5;
		  dy = 0;
	      }
	      else {
		  dx = 0;
		  dy = -5;
	      }
	      
	      // Need to fix these boundaries.
	      if (x >= 540 && y <= 100) { moveLeft = false; moveDown = true; }
	      if (x <= 100 && y <= 100) { moveRight = true; moveUp = false;}
		  if (y >= 300 && x >= 540) { }
		  if (y <= 100 && x <= 100) { dx = 0; dy = -5; }
	      
	      
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
