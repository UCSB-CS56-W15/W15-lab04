package edu.ucsb.cs56.w15.drawings.ecarnohan.advanced;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AnimatedPictureViewer {

    private DrawPanel panel = new DrawPanel();
    
    private Turtle turtle = new Turtle(100, 100, 100, 150);
    
    Thread anim;   
    
    private int x = 100;
    private int y = 100;
    
    private int dx = 5;

    
    public static void main (String[] args) {
      new AnimatedPictureViewer().go();
    }

    public void go() {
      JFrame frame = new JFrame();
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      frame.getContentPane().add(panel);
      frame.setSize(680,480);
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

         // make window with white background
	g2.setColor(Color.WHITE);
	g2.fillRect(0,0,this.getWidth(), this.getHeight());

          // Draw the Turtle
	if(dx == -5)
	    g2.setColor(new Color(0x9900AA));
	else if (dx == 5)
	    g2.setColor(new Color(0x337733));

          TurtleWithDetails jeff = new TurtleWithDetails(x, y, 200, 150);
	  Stroke thick = new BasicStroke(4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);
	  g2.setStroke(thick);
          g2.draw(jeff);
       }
    }
    
    class Animation extends Thread {
      public void run() {
        try {
          while (true) {
            // Bounce off the walls

            if (x >= 400) { 
		dx = -5;
	    }
            if (x <= 50) {
		dx = 5; }

            
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
