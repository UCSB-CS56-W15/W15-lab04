package edu.ucsb.cs56.w15.drawings.jordannguyen.advanced;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AnimatedPictureViewer {

    private DrawPanel panel = new DrawPanel();
    
    Thread anim;   
    
    private int x = 20;
    private int y = 20;
    
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

          // Draw the doors
	  
          g2.setColor(Color.RED);
          BathroomDoors doors = new BathroomDoors(x, y, 100,200,20);
          g2.draw(doors);
       }
    }
    
    class Animation extends Thread {
      public void run() {
        try {
          while (true) {
	  
	      // bounce off walls in a rectangle formation
	      while (x < 400 && y == 20) {
		  dx = 5;
		  x += dx;
		  panel.repaint();
		  Thread.sleep(50);
	      }

	      while (x >= 400 && y < 220) {
		  dy = 5;
		  y += dy;
		  panel.repaint();
		  Thread.sleep(50);
	      }

	      while (x > 20 && y >= 220) {
		  dx = -5;
		  x += dx;
		  panel.repaint();
		  Thread.sleep(50);
	      }

	      while (x == 20 && y > 20) {
		  dy = -5;
		  y += dy;
		  panel.repaint();
		  Thread.sleep(50);
	      }
	      

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
