package edu.ucsb.cs56.w15.drawings.eshong.advanced;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AnimatedPictureViewer {

    private DrawPanel panel = new DrawPanel();
    
    private Domino d = new Domino(100, 100, 100, 200);
    
    Thread anim;   
    
    private int x = 100;
    private int y = 100;
    private int w = 100;
    private int h = 200;
    
    private int dx = 5;
    private int dy = 3;
    private int dw = 10;
    private int dh = 20;

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

          // Draw the Domino
          g2.setColor(Color.BLACK);

          Domino test = new Domino(x, y, w, h);
          g2.draw(test);
       }
    }
    
    class Animation extends Thread {
      public void run() {
        try {
          while (true) {
            // Bounce off the walls

            if (x >= 200) { dx = -5; }
            if (x <= 50) { dx = 5; }
            
	    if (y >= 250) { dy = -3; }
	    if (y <= 20) { dy = 3; }

	    if (w >= 100) { dw = -10; }
	    if (w <= 10) { dw = 10; }

	    if (h >= 200) { dh = -20; }
	    if (h <= 20) { dh = 20; }

            x += dx;              
	    y += dy;
	    w += dw;
	    h += dh;
  
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
