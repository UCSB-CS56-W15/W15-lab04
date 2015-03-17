package edu.ucsb.cs56.w15.drawings.jazariethach.advanced;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import edu.ucsb.cs56.w15.drawings.utilities.ShapeTransforms;

public class AnimatedPictureViewer {

    private DrawPanel panel = new DrawPanel();
    
    private SunWithGlasses s = new SunWithGlasses(100, 100, 50, 50);
    
    Thread anim;   
    
    private int x = 100;
    private int y = 100;
    private int r = 50;
    private int r2 = 50;
    private double roll =  Math.PI/4.0;
    private int dx = 10;
    private int dr = 25;

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

          // Draw the Sun
          g2.setColor(Color.RED);
          SunWithGlasses s1 = new SunWithGlasses(x, y, r, r2);

	   
	Shape s2 = ShapeTransforms.rotatedCopyOf(s1, roll);
	g2.setColor(new Color(0xaaa027));
	g2.draw(s2);
	       
  
       }
    }
    
    class Animation extends Thread {
      public void run() {
        try {
          while (true) {
            // Bounce off the walls

	      if (x >= 590) { dx = -10;}
	      if (x <= 70) { dx = 10;}
            
            x += dx;               
	    roll -= dr;
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
