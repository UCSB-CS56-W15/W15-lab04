package edu.ucsb.cs56.w15.drawings.emorozova.advanced;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AnimatedPictureViewer {

    private DrawPanel panel = new DrawPanel();
    
    Thread anim;   
    
    private int x = 200;
    private int y = 200;

    private int x2 = 200;
    private int y2 = 200;
    
    private int dx = 5;

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

          // Draw the Ipod
          g2.setColor(Color.black);
          StripedLighthouse test = new StripedLighthouse(100, 200, 70, 160);
          g2.draw(test);

	  // Draw wave
	  g2.setColor(Color.blue);
	  Wave w = new Wave(x + 20, y-20, 350, 20);
	  g2.draw(w);

	  Wave w2 = new Wave(x2, y2-10, 350, 20);
	  g2.draw(w2);

	  Wave w3 = new Wave(x+20, y, 350, 20);
	  g2.draw(w3);
       }
    }
    
    class Animation extends Thread {
      public void run() {
        try {
          while (true) {
            // Bounce off the walls

	       if (x >= 200) { dx = -1; }
	       if (x <= 150) { dx = 1; }

	       
            
	       x += dx;   
	       x2 += (-1*dx);
	      

	      
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
