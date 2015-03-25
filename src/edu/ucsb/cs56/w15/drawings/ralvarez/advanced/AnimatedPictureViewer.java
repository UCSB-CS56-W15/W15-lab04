package edu.ucsb.cs56.w15.drawings.ralvarez.advanced;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import edu.ucsb.cs56.w15.drawings.utilities.ShapeTransforms;


public class AnimatedPictureViewer {

    private DrawPanel panel = new DrawPanel();
    

    Thread anim;   
    
    private int x = 100;
    private int y = 100;
    
    private int dx = 10;

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
        System.out.println("Mouse entered");
	anim = new Animation(); //give the thread anim the job Animation to do 
	anim.start(); //start the thread
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

          // Draw Superman
          g2.setColor(Color.RED);
          Superman Kent  = new Superman(x, y, 100, 150);
	  Shape SPFly = ShapeTransforms.rotatedCopyOf(Kent, Math.PI/2.0);
	  
	  g2.draw(SPFly);
       }
    }
    
      class Animation extends Thread { //Job to give to anim which animates
      public void run() {
        try {
          while (true) {
            // Bounce off the walls

	      //if (x >= 400) { dx = -5; }
	      //if (x <= 50) { dx = 5; }
	      if (x>= 640) {x= -150;}

            
            x += dx;                
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
