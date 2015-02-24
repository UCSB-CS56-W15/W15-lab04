package edu.ucsb.cs56.w15.drawings.isaacstaugaard.advanced;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AnimatedPictureViewer {

    private DrawPanel panel = new DrawPanel();
    
    private BasketballHoop basketballHoop = new BasketballHoop(100, 100, 100, 100);
    
    Thread anim;   
    
    private int x = 100;
    private int y = 100;
    
    private int dx = 5;
    private int dy = 5;

    private int R = 0;
    private int G = 0;
    private int B = 255;
    private Color rgb = new Color(R, G, B);

    /*    public void redBlueColor() {           Use a random function -- do this eventually
	if (B > 100) {B = B - 1; R = 0;}
	else if (B <= 100) { B = 0; G = 255;}
	rgb = new Color(R, G, B);
	}*/
    
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

          // Draw the Basketball Hoop
	  
          g2.setColor(Color.ORANGE);
	  Stroke thick = new BasicStroke (4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);       
	  g2.setStroke(thick);
          BasketballHoop practice = new BasketballHoop(x, y, 125, 125);
          g2.draw(practice);
	  if(x >= 250 && y >= 130){
	      g2.setColor(rgb);
	      g2.draw(practice);
	  }
	  if(x >= 250 && y < 130){
	      g2.setColor(Color.BLACK);
	      g2.draw(practice);
	  }
	  if(x < 250 && y >= 130){
	      g2.setColor(Color.GREEN);
	      g2.draw(practice);
	  }
       }
    }
    
    class Animation extends Thread {
      public void run() {
        try {
          while (true) {
            // Bounce off the walls

	    if (x >= 480) { dx = -5;}
	    if (x <= 30) { dx = 5; }
            if (y >= 300) {dy = -5; }
	    if (y <= 20) {dy = 5; }
 
	    panel.getGraphics().setColor(rgb);

	    y += dy;
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
