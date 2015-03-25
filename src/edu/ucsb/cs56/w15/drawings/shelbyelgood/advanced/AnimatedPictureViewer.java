package edu.ucsb.cs56.w15.drawings.shelbyelgood.advanced;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AnimatedPictureViewer {

    private DrawPanel panel = new DrawPanel();
    
    private CupWithStraw cup = new CupWithStraw(200, 200, 50, 100);
    
    Thread anim;   
    
    private int x = 100;
    private int y = 250;
    private int h = 200;    

    private int dx = 5;
    private int dh = 5;

    public static void main (String[] args) {
      new AnimatedPictureViewer().go();
    }

    public void go() {
      JFrame frame = new JFrame();
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      frame.getContentPane().add(panel);
      frame.setSize(600,400);
      frame.setVisible(true);
      
      frame.getContentPane().addMouseListener(new MouseAdapter() {
        public void mouseEntered(MouseEvent e){
        System.out.println("Mouse Entered");
          anim = new Animation();
          anim.start();
        }

        public void mouseExited(MouseEvent e){        
          System.out.println("Mouse Exited");
          // Kill the animation thread
          anim.interrupt();
          while (anim.isAlive()){}
          anim = null;         
          panel.repaint();        
        }
      });
      
    }

    class DrawPanel extends JPanel {
       public void paintComponent(Graphics g) {

        Graphics2D g2 = (Graphics2D) g;

          // Clear the panel first
          g2.setColor(Color.white);
          g2.fillRect(0,0,this.getWidth(), this.getHeight());

          // Draw the Cup
          g2.setColor(Color.RED);
          CupWithStraw test = new CupWithStraw(x, y, 60, h);
          g2.draw(test);
       }
    }
    
    class Animation extends Thread {
      public void run() {
        try {
          while (true) {
            // Bounce off the walls

            if (x >= 350) { dx = -5; }
            if (x <= 50) { dx = 5; }

	    if(h>=150) { dh = -5; }
	    if(h<=20) {dh = 5; }
            
            x += dx;
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
