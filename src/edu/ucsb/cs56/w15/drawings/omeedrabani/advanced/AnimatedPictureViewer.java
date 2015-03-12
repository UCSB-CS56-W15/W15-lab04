package edu.ucsb.cs56.w15.drawings.omeedrabani.advanced;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AnimatedPictureViewer {

    private DrawPanel panel = new DrawPanel();
    
    private Clock clock = new Clock(100, 100, 100);
    private GrandfatherClock grandfatherClock = new GrandfatherClock(0, 0, 100);
    
    Thread anim;   
    
    private int x = 200;
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

	  // Draw the GrandfatherClock
	  g2.setColor(Color.BLACK);
	  GrandfatherClock test2 = new GrandfatherClock(x-200, y-100, 200);
	  g2.draw(test2);
       }
    }
    
    class Animation extends Thread {
      public void run() {
        try {
          while (true) {

	      
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
	      else if (moveUp){
		  dx = 0;
		  dy = -5;
	      }
	      else { // Failsafe
		  dx = 0;
		  dy = 0;
	      } 
	      
	      // Upper Left Corner Boundary
	      if (x <= 205 && y <= 105) { moveRight = true; moveUp = false;}
	      // Upper Right Corner Boundary
	      if (y <= 105 && x >= 525) { moveDown = true; moveRight = false; }
	      // Lower Right Corner Boundary
	      if (y >= 341 && x >= 525) { moveLeft = true; moveDown = false; }
	      // Lower Left Corner Boundary
	      if (y >= 341 && x <= 205) { moveUp = true; moveLeft = false;}
	      
	      
            x += dx;
	    y += dy;
            panel.repaint();
	    if (moveRight)
		Thread.sleep(10);
	    else if (moveDown)
		Thread.sleep(25);
	    else if (moveLeft)
		Thread.sleep(40);
	    else if (moveUp)
		Thread.sleep(55);	   
	    else // Failsafe
		Thread.sleep(100);

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
